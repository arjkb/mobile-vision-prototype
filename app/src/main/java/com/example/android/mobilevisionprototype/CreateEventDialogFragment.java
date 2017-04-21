package com.example.android.mobilevisionprototype;


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
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Blah!")
                .setTitle("Blah Title")
                .setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getContext(), "Positive press!", Toast.LENGTH_SHORT);
                        Log.v(TAG, "Positive press!");
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getContext(), "Negative press!", Toast.LENGTH_SHORT);
                        Log.v(TAG, "Negative press!");
                    }
                });

        return builder.create();
    }
}
