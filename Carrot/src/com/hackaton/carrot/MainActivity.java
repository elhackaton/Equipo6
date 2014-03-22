package com.hackaton.carrot;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.hackaton.carrot.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends CarrotActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scanButton = (Button) findViewById(R.id.scan_button);
        scanButton.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.scan_button:
			scan();
			break;
		default:
			break;
		}
	}

    void scan() {
    	/*
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        //intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);*/
    	IntentIntegrator scanIntegrator = new IntentIntegrator(this);
    	scanIntegrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	showMessage("onActivityResult ! requestCode: " + requestCode + " / resultCode: " + resultCode);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
                if (scanningResult != null) {
                	//we have a result
                	String scanContent = scanningResult.getContents();
                	String scanFormat = scanningResult.getFormatName();
                	
                    showProductDetails(scanContent, scanFormat);
                }else {
                	showErrorMessage("No scan data received!");
                }
            } else if (resultCode == RESULT_CANCELED) {
                showErrorMessage("Result cancelled.");
            } else {
                showErrorMessage("OTHER SCAN Result.");
            }
        }
    }

    void showProductDetails(String scanContent, String scanFormat) {
        Intent intent = new Intent();
        intent.putExtra(scanContent, DetailsActivity.PARAMETER_SCAN_CONTENT);
        intent.putExtra(scanFormat, DetailsActivity.PARAMETER_SCAN_FORMAT);
        startActivity(intent);
    }
}
