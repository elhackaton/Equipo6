package com.hackaton.carrot;

import android.os.Bundle;
import android.widget.TextView;

import com.elhackaton.carrot.R;

public class ProductDataActivity extends CarrotActivity {
	protected final static String PARAMETER_CONTENTS = "contents";
	protected final static String PARAMETER_FORMAT = "format";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productdata);

		String contents = getIntent().getStringExtra(PARAMETER_CONTENTS);
		String format = getIntent().getStringExtra(PARAMETER_FORMAT);

		// TODO
		// Query database. Servicio????

		// Fill data.
		TextView contentsLabel = (TextView) findViewById(R.id.activity_productdata_contents_label);
		TextView formatLabel = (TextView) findViewById(R.id.activity_productdata_format_label);
		contentsLabel.setText("Content: " + contents);
		formatLabel.setText("Format: " + format);
	}
}
