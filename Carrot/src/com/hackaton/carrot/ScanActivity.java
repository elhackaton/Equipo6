//package com.hackaton.carrot;
//
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ToggleButton;
//import com.google.gson.Gson;
//import com.google.zxing.Result;
//import com.googlecode.androidannotations.annotations.*;
//import com.googlecode.androidannotations.annotations.rest.RestService;
//import com.modere.rest.AuthentificationHeaderRest;
//import com.modere.rest.ProductsRest;
//import com.modere.rest.ShoppingBagRest;
//import com.modere.rest.json.*;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.web.client.RestClientException;
//import zxing.library.DecodeCallback;
//import zxing.library.ZXingFragment;
//
//import java.util.ArrayList;
//
//
///**
// * Created with IntelliJ IDEA.
// * User: Elitebook
// * Date: 3/09/13
// * Time: 11:14
// * To change this template use File | Settings | File Templates.
// */
//public class ScanActivity extends EFreeActivity {
//    ZXingFragment scanner;
//
//    boolean paused;
//
//    boolean isFirstTime = true;
//
//    private boolean flagInScanActivity;
//
//    void initializeScanner() {
//
//        scanner = (ZXingFragment) getSupportFragmentManager().findFragmentById(R.id.scanner);
//        scanner.setDecodeCallback(
//                new DecodeCallback() {
//                    @Override
//                    public void handleBarcode(Result result, Bitmap arg1, float arg2) {
//                        if (!paused) {
//                            try{
//                                int sku = Integer.parseInt((result.getText()));
//                                togglePause();
//                                loadProductBySku(sku);
//                            } catch (NumberFormatException nfe){
//                                Log.e(MODERE_TAG, "" + nfe.getMessage());
//                            }
//                        }
//                        scanner.restartScanningIn(500);
//                    }
//                }
//        );
//    }
//
//    void togglePause() {
//        paused = !paused;
//    }
//
//    void loadProductBySku(int sku) {
///*        try {
//            //showMessage("Detected sku: " + sku);
//            //Log.d(MODERE_TAG + "-------------------------", "Detected sku: " + sku);
//            authentificationHeaderRest.AddBasicAuthTemplate(productsRest.getRestTemplate());
//
//            ProductsJson product = productsRest.getEngProductsBySku(sku);
//
//            if (product != null) {
//                if (scan_bt_instant_ship.isChecked()) {
//                    instant_shipping(product);
//                } else {
//                    //Log.e("com.modere", "product found: " + product.getName());
//                    Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity_.class);
//                    intent.putExtra("product", product);
//                    intent.putExtra("from", "scan");
//
//                    startActivity(intent);
//                    ScanActivity.this.finish();
//                }
//            } else {
//                //Log.e("com.modere", "product not found");
//                showMessage(getString(R.string.error_scan_notfound));
//            }
//        } catch (RestClientException rce){
//            Log.d(MODERE_TAG, "Error in loadProductBySku: " + rce.getMessage());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            //showMessage(ex.getMessage());
//        }*/
//    }
//    
//    @Override
//    public void onResume(){
//        super.onResume();
//        if (paused)
//            togglePause();
//        if (!isFirstTime){
//            initializeScanner();
//        }
//        else
//            isFirstTime = false;
//    }
//}