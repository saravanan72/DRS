package com.vamosys.drs.view.util;

import android.app.Activity;

import com.vamosys.drs.R;

public class SnackAlert {
    String text = "";
    Activity activity;

    public SnackAlert(Activity activity, String text) {
        this.activity = activity;
        this.text = text;
    }


    public void success() {
        /*TTSnackAlert.builder()
                .setActivity(activity)
                .setText(text)
                .setDuration(TTSnackAlert.LENGTH_LONG)
                .setActionText(activity.getString(R.string.dialog_ok_txt))
                .success()
                .show();*/
    }

    public void error() {
       /* TTSnackAlert.builder()
                .setActivity(activity)
                .setText(text)
                .setDuration(TTSnackAlert.LENGTH_LONG)
                .setActionText(activity.getString(R.string.dialog_ok_txt))
                .error()
                .show();*/
    }
}
