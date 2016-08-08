package com.negusoft.compoundadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.adapterGroupWithHeader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SampleActivity.makeIntent(MainActivity.this, SampleActivity.SampleType.ADAPTER_GROUP_WITH_HEADER);
                startActivity(intent);
            }
        });
        findViewById(R.id.adapterGroupWithChangingData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SampleActivity.makeIntent(MainActivity.this, SampleActivity.SampleType.ADAPTER_GROUP_WITH_CHANGING_DATA);
                startActivity(intent);
            }
        });
        findViewById(R.id.adapterGroupTree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SampleActivity.makeIntent(MainActivity.this, SampleActivity.SampleType.ADAPTER_GROUP_TREE);
                startActivity(intent);
            }
        });
    }



}
