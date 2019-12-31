package com.amazonaws.mobile.samples.mynotes.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.amazonaws.mobile.samples.mynotes.Injection;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatus;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatusInfo;
import com.amazonaws.mobile.samples.mynotes.repository.NotesRepository;

import java.util.Date;

public class DriverStatusViewModel extends ViewModel {
    private MutableLiveData<DriverStatusInfo> mStatus;
    private MutableLiveData<Date> mLastStatusChange;
    private NotesRepository notesRepository;

    public DriverStatusViewModel() {
        this.notesRepository = Injection.getNotesRepository();
        this.mStatus = new MutableLiveData<>();
    }

/*    public void readStatus() {
        notesRepository.getDriverStatus((DriverStatusInfo status) -> {
            mStatus.postValue(status);
        });
    }*/

    public LiveData<DriverStatusInfo> getStatus() {
        return mStatus;
    }

    public synchronized void update(DriverStatus status ) {
        DriverStatusInfo newStatus = new DriverStatusInfo(status);
        notesRepository.updateDriverStatus(newStatus, (DriverStatusInfo statusInfo) -> {
            /* Do Nothing */
        });
    }
}
