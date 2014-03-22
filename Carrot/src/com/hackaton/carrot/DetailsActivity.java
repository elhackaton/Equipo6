package com.hackaton.carrot;

import com.hackaton.carrot.R;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends CarrotActivity {
    protected final static String PARAMETER_SCAN_CONTENT = "scan_content";
    protected final static String PARAMETER_SCAN_FORMAT = "scan_format";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        
        String scanContent = getIntent().getStringExtra(PARAMETER_SCAN_CONTENT);
        String scanFormat = getIntent().getStringExtra(PARAMETER_SCAN_FORMAT);
        
        // TODO
        // Query database. Servicio????
        
        // Fill data.
        TextView contentLabel = (TextView) findViewById(R.id.content_label);
        TextView formatLabel = (TextView) findViewById(R.id.format_label);
        
        contentLabel.setText(scanContent);
        formatLabel.setText(scanFormat);
    }
}
