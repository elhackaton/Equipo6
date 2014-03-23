package com.hackaton.carrot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.elhackaton.carrot.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends CarrotActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button scanButton = (Button) findViewById(R.id.activity_main_button_tutorial);
		scanButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.activity_main_button_tutorial:
			scan();
			break;
		default:
			break;
		}
	}

	void scan() {
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		IntentResult result = IntentIntegrator.parseActivityResult(requestCode,
				resultCode, intent);
		if (result != null) {
			String contents = result.getContents();
			String format = result.getFormatName();
			openProductDetails(contents, format);
		}
	}
	
	void openProductDetails(String contents, String format) {
		Intent intent = new Intent(getApplicationContext(), ProductDataActivity.class);
		intent.putExtra(ProductDataActivity.PARAMETER_CONTENTS, contents);
		intent.putExtra(ProductDataActivity.PARAMETER_FORMAT, format);
		startActivity(intent);
	}
}
