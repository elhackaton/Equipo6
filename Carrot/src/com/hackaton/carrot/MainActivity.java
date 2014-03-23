package com.hackaton.carrot;

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
		Intent intent = new Intent(getApplicationContext(), ScanActivity.class);
		startActivity(intent);
	}
}
