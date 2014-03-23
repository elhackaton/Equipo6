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
		setContentView(R.layout.activity_scan);
	}

	void initializeScanner() {
		scanner = (ZXingFragment) getSupportFragmentManager().findFragmentById(
				R.id.scanner);
		scanner.setDecodeCallback(new DecodeCallback() {
			@Override
			public void handleBarcode(Result result, Bitmap arg1, float arg2) {
				if (!paused) {
					try {
						pause();
						int sku = Integer.parseInt((result.getText()));
						showProductDetails(sku);
					} catch (NumberFormatException nfe) {
						logError(nfe.getMessage());
					}
				}
				scanner.restartScanningIn(500);
			}
		});
	}

	void showProductDetails(int sku) {
		Intent intent = new Intent(getApplicationContext(),
				DetailsActivity.class);
		intent.putExtra(DetailsActivity.PARAMETER_SKU, sku);
		startActivity(intent);
	}

	void pause() {
		paused = true;
	}

	void resume() {
		paused = false;
	}

	@Override
	public void onResume() {
		super.onResume();

		if (isFirstTime) {
			showMessage("Initializing scanner!");

			initializeScanner();
			isFirstTime = false;
		} else {
			resume();
		}
	}
}