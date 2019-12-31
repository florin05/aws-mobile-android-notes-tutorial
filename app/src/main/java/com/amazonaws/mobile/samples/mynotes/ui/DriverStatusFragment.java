package com.amazonaws.mobile.samples.mynotes.ui;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amazonaws.mobile.samples.mynotes.R;
import com.amazonaws.mobile.samples.mynotes.viewmodels.DriverStatusViewModel;

public class DriverStatusFragment extends Fragment {
        DriverStatusViewModel viewModel;

        @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_detail, container, false);

        final TextView statusTextField = view.findViewById(R.id.status_text);


        viewModel = ViewModelProviders.of(this).get(DriverStatusViewModel.class);
        // Observe the view model values.  Once we receive the value, enable the field.
 /*       viewModel.getStatus().observe(this, (DriverStatusInfo statusInfo) -> {
            statusTextField.setText(statusInfo.getStatus().getLabel());
        });*/
/*
        viewModel.getContent().observe(this, (String content) -> {
            contentField.setText(content);
            contentField.setEnabled(true);
        });
*/

        // If this is a new note, create the note, then enable the fields.  Otherwise just load the fields
        // - the fields are received via observables
      /*  if (noteId == null) {
            viewModel.create("", "", (Note result) -> {
                titleField.setEnabled(true);
                contentField.setEnabled(true);
            });
        } else {
            viewModel.setNoteId(noteId);
        }*/

/*        TextWatcher saveHandler = new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override public void afterTextChanged(Editable s) {
                String title = titleField.getText().toString();
                String content = contentField.getText().toString();
                viewModel.update(title, content);
            }
        };

        titleField.addTextChangedListener(saveHandler);
        contentField.addTextChangedListener(saveHandler);*/

        return view;
    }
}
