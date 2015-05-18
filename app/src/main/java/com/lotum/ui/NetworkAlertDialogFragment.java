package com.lotum.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.lotum.R;

/**
 * Created by Saad on 06/05/2015.
 */
public class NetworkAlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.error_title))
                .setMessage(context.getString(R.string.netword_unavailable_message))
                .setPositiveButton(context.getString(R.string.error_ok_btn_text), null);
        return builder.create();
    }
}
