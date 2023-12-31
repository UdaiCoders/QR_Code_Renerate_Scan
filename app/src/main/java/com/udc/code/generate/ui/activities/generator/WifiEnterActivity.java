package com.udc.code.generate.ui.activities.generator;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.udc.code.generate.R;
import com.udc.code.generate.generator.Contents;

public class WifiEnterActivity extends AppCompatActivity {


    private static final String[] auth = {"WEP", "WPA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_enter);


        final Spinner  spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(WifiEnterActivity.this, android.R.layout.simple_spinner_item,auth);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final EditText qrNetwork = (EditText) findViewById(R.id.editNetwork);
        final EditText qrPassword = (EditText) findViewById(R.id.editPassword);
        Button generate = (Button) findViewById(R.id.generate);

        int maxLength = 25;
        qrNetwork.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});

        int maxLength2 = 20;
        qrPassword.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength2)});


        generate.setOnClickListener(new View.OnClickListener() {
            String result;
            @Override
            public void onClick(View v) {

                if(spinner.getSelectedItemPosition()==0) {
                    result = "WEP;S:" + qrNetwork.getText().toString() + ";P:" + qrPassword.getText().toString() + ";;";
                }
                else if (spinner.getSelectedItemPosition()==1) {
                    result = "WPA;S:" + qrNetwork.getText().toString() + ";P:" + qrPassword.getText().toString() + ";;";
                }

                Intent i = new Intent(WifiEnterActivity.this, QrGeneratorDisplayActivity.class);
                i.putExtra("gn", result);
                i.putExtra("type", Contents.Type.WIFI);
                startActivity(i);
            }
        });
    }
}
