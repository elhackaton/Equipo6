package com.hackaton.carrot;

import zxing.library.DecodeCallback;
import zxing.library.ZXingFragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.zxing.Result;

public class ScanActivity extends CarrotActivity {
    ZXingFragment scanner;
    boolean paused, isFirstTime = true;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    void initializeScanner() {
    	scanner = (ZXingFragment) getSupportFragmentManager().findFragmentById(R.id.scanner);
        scanner.setDecodeCallback(
                new DecodeCallback() {
                    @Override
                    public void handleBarcode(Result result, Bitmap arg1, float arg2) {
                        if (!paused) {
                            try{
                                int sku = Integer.parseInt((result.getText()));
                                togglePause();
                                showProductDetails(sku);
                            } catch (NumberFormatException nfe){
                            	logError(nfe.getMessage());
                            }
                        }
                        scanner.restartScanningIn(200);
                    }
                }
        );
    }

    void togglePause() {
        paused = !paused;
    }

    void showProductDetails(int sku) {
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.putExtra(DetailsActivity.PARAMETER_SKU, sku);
        startActivity(intent);
    }
    
    @Override
    public void onResume(){
        super.onResume();
        if (paused)
            togglePause();
        if (!isFirstTime){
            initializeScanner();
        }
        else
            isFirstTime = false;
    }
}