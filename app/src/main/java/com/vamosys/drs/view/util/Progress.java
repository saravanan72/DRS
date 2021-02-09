package com.vamosys.drs.view.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.vamosys.drs.R;


public class Progress {
    private final ProgressDialog progressDialog;
    private Context context;
    public Progress(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
    }

    public void showProgressDialog() {

        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(context.getString(R.string.progress_msg));
        progressDialog.show();
        progressDialog.setContentView(R.layout.custom_progress_dialog);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void cancelProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.cancel();
            }
        }
    }
}
