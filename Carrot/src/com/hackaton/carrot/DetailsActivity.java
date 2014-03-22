package com.hackaton.carrot;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends CarrotActivity {
	protected final static String PARAMETER_SKU = "sku";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		int sku = getIntent().getIntExtra(PARAMETER_SKU, -1);

		// TODO
		// Query database. Servicio????

		// Fill data.
		TextView skuLabel = (TextView) findViewById(R.id.sku_label);
		skuLabel.setText("SKU: " + String.valueOf(sku));
	}
}
