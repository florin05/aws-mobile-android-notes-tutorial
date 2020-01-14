/*
Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify,
merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.amazonaws.mobile.samples.mynotes.viewmodels;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.samples.mynotes.Injection;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatus;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatusInfo;
import com.amazonaws.mobile.samples.mynotes.models.ResultCallback;
import com.amazonaws.mobile.samples.mynotes.repository.NotesRepository;
import com.amazonaws.mobile.samples.mynotes.services.aws.AWSDataService;

import java.util.Map;


import static android.content.Context.LOCATION_SERVICE;

public class NoteListViewModel extends ViewModel {
    static final String LOGTAG = "DEBUGGING--------------";
    private MutableLiveData<DriverStatusInfo> mStatus;
    private NotesRepository notesRepository;

    private static final int GPS_TIME_INTERVAL_MS = 30000;


    public NoteListViewModel() {
        this.notesRepository = Injection.getNotesRepository();
        this.mStatus = new MutableLiveData<>();
        // mStatus.postValue(new DriverStatusInfo(DriverStatus.UNAVAILABLE));
        notesRepository.getDriverStatus((DriverStatusInfo status) -> {
            mStatus.postValue(status);
        });

    }

/*    public void readDriverStatus() {
        notesRepository.getDriverStatus((DriverStatusInfo status) -> {
            mStatus.postValue(status);
        });
    };*/


/*    public LiveData<PagedList<Note>> getNotesList() {
        return notesRepository.getPagedList();
    }*/

    public LiveData<DriverStatusInfo> getStatus() {
        return mStatus;
    }

    public synchronized void changeStatus(DriverStatus newStatus) {
        String userName = AWSDataService.loggedInUserName;
        DriverStatusInfo updatedStatus = new DriverStatusInfo(newStatus);
        updatedStatus.setUserName(userName);
        updatedStatus.setId(mStatus.getValue().getId());
        updatedStatus.setVersion(mStatus.getValue().getVersion());
        Log.d(LOGTAG, "Status posting from changeStatus value  version " + mStatus.getValue().getVersion());
        notesRepository.updateDriverStatus(updatedStatus, (DriverStatusInfo status) -> {
            mStatus.postValue(status);
        });
    }

    public synchronized void changeCoordinates(LifecycleOwner activity, Double latitude, Double longitude) {
        String userName = AWSDataService.loggedInUserName;

        MutableLiveData<DriverStatusInfo> liveStatus = this.mStatus;

        Log.d(LOGTAG, System.currentTimeMillis() + "changeCoordinates called with lat " + latitude );
        Observer statusUpdateObserver = new Observer<DriverStatusInfo>() {
            @Override
            public void onChanged(@Nullable DriverStatusInfo statusInfo) {
                if (statusInfo != null) {
                    DriverStatusInfo updatedStatus = new DriverStatusInfo(mStatus.getValue().getStatus());
                    updatedStatus.setLatitude(latitude);
                    updatedStatus.setLongitude(longitude);
                    updatedStatus.setUserName(userName);
                    updatedStatus.setId(mStatus.getValue().getId());
                    updatedStatus.setVersion(mStatus.getValue().getVersion());
                    Log.d(LOGTAG, System.currentTimeMillis() + " Status posting from changeCoordinates value  version " + mStatus.getValue().getVersion());
                    notesRepository.updateDriverStatus(updatedStatus, (DriverStatusInfo status) -> {
                        Log.d(LOGTAG, System.currentTimeMillis() + "Status changed from changeCoordinates value  version " + status.getVersion());
                        mStatus.postValue(status);
                    });
                    liveStatus.removeObserver(this);

                }

            }


        };
        mStatus.observeForever(statusUpdateObserver);
/*
        mStatus.observeForever().observe(activity, (DriverStatusInfo statusInfo) -> {
            DriverStatusInfo updatedStatus = new DriverStatusInfo(mStatus.getValue().getStatus());
            updatedStatus.setLatitude(latitude);
            updatedStatus.setLongitude(longitude);
            updatedStatus.setUserName(userName);
            updatedStatus.setId(mStatus.getValue().getId());
            updatedStatus.setVersion(mStatus.getValue().getVersion());
            notesRepository.updateDriverStatus(updatedStatus, (DriverStatusInfo status) -> {
                mStatus.postValue(status);
            });
            mStatus.removeObserver();
        });
*/

    }




}
