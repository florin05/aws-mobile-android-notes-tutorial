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
package com.amazonaws.mobile.samples.mynotes.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amazonaws.mobile.samples.mynotes.Injection;
import com.amazonaws.mobile.samples.mynotes.NotesApp;
import com.amazonaws.mobile.samples.mynotes.R;
import com.amazonaws.mobile.samples.mynotes.databinding.ActivityNoteListBinding;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatus;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatusInfo;
import com.amazonaws.mobile.samples.mynotes.models.Note;
import com.amazonaws.mobile.samples.mynotes.services.AnalyticsService;
import com.amazonaws.mobile.samples.mynotes.viewmodels.NoteListViewModel;

import java.util.HashMap;

public class NoteListActivity extends AppCompatActivity {
    /**
     * If the device is running in two-pane mode, then this is set to true.  In two-pane mode,
     * the UI is a side-by-side, with the list on the left and the details on the right.  In one
     * pane mode, the list and details are separate pages.
     */
    private boolean twoPane = false;
    private DriverStatusInfo driverStatus;
    private ActivityNoteListBinding  binding;

    /**
     * The view model
     */
    private NoteListViewModel viewModel;

    /**
     * The analytics service
     */
    private AnalyticsService analyticsService = Injection.getAnalyticsService();

    Location gpslocation = null;
    LocationManager locationManager;

    private static final int GPS_TIME_INTERVAL_MS = 30000; //
    private static final int GPS_DISTANCE_METERS= 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("DEBUGGING--------", System.currentTimeMillis() + " NoteListActivity.onCreate");
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(NoteListViewModel.class);
        setContentView(R.layout.activity_note_list);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_note_list);
        binding.setDriverStatusInfo(driverStatus);

        if (findViewById(R.id.note_detail_container) != null) twoPane = true;

        // Configure the action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getTitle());


        final TextView statusTextField = findViewById(R.id.status_text);
        final Button statusChangeButton = findViewById(R.id.status_change_button);
        //viewModel.readDriverStatus();

        // Observe the view model values.  Once we receive the value, enable the field.
        viewModel.getStatus().observe(this, (DriverStatusInfo statusInfo) -> {
            driverStatus = statusInfo;
            binding.setDriverStatusInfo(driverStatus);
            statusTextField.setText(statusInfo.getStatus().getLabel());
            statusChangeButton.setText(statusInfo.getStatus().getStatusChangeLabel());
        });

        statusChangeButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                viewModel.changeStatus(driverStatus.getStatus() == DriverStatus.AVAILALBLE ? DriverStatus.UNAVAILABLE : DriverStatus.AVAILALBLE);
            }
        });

        // Add an item click handler to the floating action button for adding a note
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((View v) -> loadNoteDetailFragment("new"));

        // Create the adapter that will be used to load items into the recycler view
        final NoteListAdapter adapter = new NoteListAdapter((Note item) -> loadNoteDetailFragment(item.getNoteId()));


        // note_list.setAdapter(adapter);

        // Ensure the note list is updated whenever the repository is updated
        // viewModel.getNotesList().observe(this, adapter::submitList);

        if (checkSelfPermission( android.Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED) {
           this.setupLocationUpdates();
        } else {
            requestPermissions(
                    new String[] { android.Manifest.permission.ACCESS_FINE_LOCATION },
                    555);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        HashMap<String,String> attributes = new HashMap<>();
        attributes.put("twoPane", twoPane ? "true" : "false");
        analyticsService.recordEvent("NoteListActivity", attributes, null);
    }

    /**
     * Loads the note details the right way, depending on if this is two-pane mode.
     *
     * @param noteId the ID of the note to load
     */
    private void loadNoteDetailFragment(String noteId) {
        if (twoPane) {
            Fragment fragment = new NoteDetailFragment();
            Bundle arguments = new Bundle();
            arguments.putString(NotesApp.ITEM_ID, noteId);
            fragment.setArguments(arguments);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.note_detail_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, NoteDetailActivity.class);
            intent.putExtra(NotesApp.ITEM_ID, noteId);
            startActivity(intent);
        }
    }

    private LocationListener gpsListener;

    private void setupLocationUpdates() {
        setupLocationListener();
        if (checkSelfPermission( android.Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED){
            if(locationManager==null){
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            }

            if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        GPS_TIME_INTERVAL_MS, GPS_DISTANCE_METERS, gpsListener);
            }
        }
    }
    void updateCoordinates(Location location) {
        Log.d("DEBUGGING------", System.currentTimeMillis() + "calling update coordinates, lat: " + (gpslocation != null? gpslocation.getLatitude():"") + " new lat:" + location.getLatitude()  );
        gpslocation = location;
        viewModel.changeCoordinates( (LifecycleOwner) this, location.getLatitude(), location.getLongitude());
    }
    private void setupLocationListener() {

        if (gpsListener == null) {
            gpsListener = new LocationListener(  ){
                public void onLocationChanged(Location location) {
                    // update location
                    // locationManager.removeUpdates(GPSListener); // remove this listener

                    if (gpslocation == null ||
                            gpslocation.getLatitude() != location.getLatitude() ||
                            gpslocation.getLongitude() != gpslocation.getLongitude() ) {
                        updateCoordinates(location);
                    }
                }
                public void onProviderDisabled(String provider) {}
                public void onProviderEnabled(String provider) {}
                public void onStatusChanged(String provider, int status, Bundle extras) {}
            };
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super
                .onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

        if (requestCode == 555) {

            // Checking whether user granted the permission or not.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                this.setupLocationUpdates();
            }
        }
    }

/*
   for frequently getting current position then above object value set to 0 for both you will get continues location but it drown the battery
*/

}
