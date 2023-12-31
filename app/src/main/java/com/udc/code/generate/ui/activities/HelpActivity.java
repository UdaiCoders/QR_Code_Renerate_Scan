package com.udc.code.generate.ui.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import com.udc.code.generate.R;
import com.udc.code.generate.ui.helpers.ExpandableListAdapter;
import com.udc.code.generate.ui.helpers.HelpDataDump;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class HelpActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        ExpandableListAdapter expandableListAdapter;
        HelpDataDump helpDataDump = new HelpDataDump(this);

        ExpandableListView generalExpandableListView = (ExpandableListView) findViewById(R.id.generalExpandableListView);

        LinkedHashMap<String, List<String>> expandableListDetail = helpDataDump.getDataGeneral();
        List<String> expandableListTitleGeneral = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableListAdapter(this, expandableListTitleGeneral, expandableListDetail);
        generalExpandableListView.setAdapter(expandableListAdapter);

        overridePendingTransition(0, 0);

    }
    protected int getNavigationDrawerID() {
        return R.id.nav_help;
    }
}
