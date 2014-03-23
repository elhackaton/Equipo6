package com.hackaton.carrot;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.elhackaton.carrot.R;
import com.hackaton.carrot.db.CarrotDataBase;

public class ProductDataActivity extends CarrotActivity implements
		OnClickListener {
	protected final static String PARAMETER_CONTENTS = "contents";

	private CarrotDataBase mDatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productdata);

		Button moreInfoButton = (Button) findViewById(R.id.activity_productdata_button_moreinfo);
		moreInfoButton.setOnClickListener(this);

		String contents = getIntent().getStringExtra(PARAMETER_CONTENTS);

		// Query database.
		mDatabase = new CarrotDataBase(getBaseContext());

		int code = mDatabase.getDangerousFromProduct(contents);
		showProductInfo(code);
	}

	void showProductInfo(int code) {
		// Sets product image.
		ImageView productImage = (ImageView) findViewById(R.id.activity_productdata_image_product);
		//productImage.setImageResource(resId);

		// Sets product type.
		int typeRes = -1;

		switch (code) {
		case 0:
			typeRes = R.drawable.nonocivo;
			break;
		case 1:
			typeRes = R.drawable.sospechoso;
			break;
		case 2:
			typeRes = R.drawable.nocivo;
			break;
		}

		ImageView productType = (ImageView) findViewById(R.id.activity_productdata_image_type);
		if (typeRes >= 0) {
			productType.setImageResource(typeRes);
		} else {
			productType.setVisibility(ImageView.INVISIBLE);
		}
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.activity_productdata_button_moreinfo:
			moreInfo();
			break;
		default:
			break;
		}
	}

	public void moreInfo() {

	}
}
