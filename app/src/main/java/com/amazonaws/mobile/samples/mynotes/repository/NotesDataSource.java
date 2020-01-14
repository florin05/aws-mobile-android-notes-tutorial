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
package com.amazonaws.mobile.samples.mynotes.repository;

import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import androidx.annotation.NonNull;
import android.util.Log;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.samples.mynotes.Injection;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatus;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatusInfo;
import com.amazonaws.mobile.samples.mynotes.models.PagedListConnectionResponse;
import com.amazonaws.mobile.samples.mynotes.models.ResultCallback;
import com.amazonaws.mobile.samples.mynotes.services.DataService;
import com.amazonaws.mobile.samples.mynotes.services.aws.AWSDataService;

import java.util.Map;

/**
 * A DataSource implements a paging system for a RecyclerView.  This one uses the DataService
 * to provide a paged view into the Notes API.
 */
public class NotesDataSource  {
    private static final String TAG = "NotesDataSource";
    private DataService dataService;

    NotesDataSource(DataService dataService) {
        this.dataService = dataService;
    }


    public void getDriverStatus( @NonNull ResultCallback<DriverStatusInfo> callback) {
        try {
            dataService.getDriverStatusInfo(AWSDataService.loggedInUserName, (status) -> {
                if (status == null) {
                    dataService.createDriverStatusInfo(AWSDataService.loggedInUserName, DriverStatus.UNAVAILABLE, callback);
                } else callback.onResult(status);
            });
        } catch(Exception e) {
            Log.e(TAG, "getDriverStatus error " + e.toString());
        }
    }

    public void updateDriverStatus( DriverStatusInfo status,@NonNull ResultCallback<DriverStatusInfo> callback) {
        dataService.updateDriverStatusInfo(status, callback);
    }

}
