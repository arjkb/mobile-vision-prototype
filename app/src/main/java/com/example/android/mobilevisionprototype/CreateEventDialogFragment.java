package com.example.android.mobilevisionprototype;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by akbfedora on 4/20/17.
 */

public class CreateEventDialogFragment extends DialogFragment {

    final String TAG = "CEDF";

    public interface CreateEventDialogListener  {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    CreateEventDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (CreateEventDialogListener) activity;
        } catch (ClassCastException e)  {
            throw new ClassCastException(activity.toString()
                    + " must implement CreateEventDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Blah!")
                .setTitle("Blah Title")
                .setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG, "Positive press!");
                        mListener.onDialogPositiveClick(CreateEventDialogFragment.this);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG, "Negative press!");
                        mListener.onDialogNegativeClick(CreateEventDialogFragment.this);
                    }
                });

        return builder.create();
    }
}
