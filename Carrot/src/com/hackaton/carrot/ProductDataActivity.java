package com.hackaton.carrot;

import android.os.Bundle;
import android.widget.TextView;

import com.elhackaton.carrot.R;
import com.hackaton.carrot.db.CarrotDataBase;

public class ProductDataActivity extends CarrotActivity {
	protected final static String PARAMETER_CONTENTS = "contents";

	private CarrotDataBase mDatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productdata);
		
		String contents = getIntent().getStringExtra(PARAMETER_CONTENTS);
		
		// Query database.
		mDatabase = new CarrotDataBase(getBaseContext());
		
		int code = mDatabase.getDangerousFromProduct(contents);
		showProductInfo(code);
	}
	
	void showProductInfo(int code){
		TextView contentsLabel = (TextView) findViewById(R.id.activity_productdata_contents_label);
		
		String value = "Unknown";

		switch (code) {
		case -1:
			break;
		case 0:
			value = "No nocivo";
			break;
		case 1:
			value = "Sospechoso";
			break;
		case 2:
			value = "Peligroso";
			break;
		default:
			break;
		}

		contentsLabel.setText("Value: " + value);
	}
}
