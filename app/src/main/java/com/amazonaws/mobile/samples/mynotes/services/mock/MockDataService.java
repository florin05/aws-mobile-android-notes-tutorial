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
package com.amazonaws.mobile.samples.mynotes.services.mock;

import com.amazonaws.mobile.samples.mynotes.models.DriverStatus;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatusInfo;
import com.amazonaws.mobile.samples.mynotes.models.Note;
import com.amazonaws.mobile.samples.mynotes.models.PagedListConnectionResponse;
import com.amazonaws.mobile.samples.mynotes.models.ResultCallback;
import com.amazonaws.mobile.samples.mynotes.services.DataService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * A mock data store.  This will create 30 notes so you can see the scrolling action, but
 * otherwise acts as a data service.  This should be easily rewritten to use an actual cloud API
 */
public class MockDataService implements DataService {
    private ArrayList<Note> items;
    private DriverStatusInfo status;

    public MockDataService() {
        items = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++) {
            Note item = new Note();
            item.setTitle(String.format(Locale.US, "Note %d", i));
            item.setContent(String.format(Locale.US, "Content for note %d", i));
            items.add(item);
        }

        status = new DriverStatusInfo(DriverStatus.UNAVAILABLE);
    }


    public void createDriverStatusInfo(String userName, DriverStatus status, ResultCallback<DriverStatusInfo> callback) {
        callback.onResult(this.status);
    }

    public void getDriverStatusInfo(String userName, ResultCallback<DriverStatusInfo> callback) {
        callback.onResult(this.status);
    }

    public void updateDriverStatusInfo(DriverStatusInfo status, ResultCallback<DriverStatusInfo> callback) {
        this.status = status;
        callback.onResult(this.status);
    }


}
