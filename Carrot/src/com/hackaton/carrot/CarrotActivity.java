package com.hackaton.carrot;

import android.app.Activity;
import android.widget.Toast;

public class CarrotActivity extends Activity {

    void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    void showErrorMessage(String msg) {
        showMessage("ERROR: " + msg);
    }
}
