package com.udc.code.generate.ui.activities.generator;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.udc.code.generate.R;
import com.udc.code.generate.generator.Contents;

public class MmsEnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mms_enter);


        final EditText qrMms=(EditText) findViewById(R.id.editTel);
        final EditText qrText=(EditText) findViewById(R.id.editText1);
        Button generate=(Button) findViewById(R.id.generate);

        int maxLength = 15;
        qrMms.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});

        int maxLength2 = 300;
        qrText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength2)});


        generate.setOnClickListener(new View.OnClickListener() {
            String result;
            @Override
            public void onClick(View v) {

                result = qrMms.getText().toString()+":"+qrText.getText().toString();
                Intent i = new Intent(MmsEnterActivity.this, QrGeneratorDisplayActivity.class);
                i.putExtra("gn", result);
                i.putExtra("type", Contents.Type.MMS);
                startActivity(i);
            }
        });
    }
}
