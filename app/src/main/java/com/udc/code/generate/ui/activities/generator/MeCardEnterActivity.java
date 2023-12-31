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

public class MeCardEnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_card_enter);


        final EditText qrName=(EditText) findViewById(R.id.editName);
        final EditText qrPhone=(EditText) findViewById(R.id.editPhone);
        final EditText qrMail=(EditText) findViewById(R.id.editMail);
        final EditText qrStreet=(EditText) findViewById(R.id.editStreet);
        final EditText qrCity=(EditText) findViewById(R.id.editCity);
        final EditText qrPostal=(EditText) findViewById(R.id.editPostal);

        int maxLength = 75;
        qrName.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});

        int maxLength2 = 75;
        qrPhone.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength2)});

        int maxLength3 = 75;
        qrMail.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength3)});

        int maxLength4 = 75;
        qrStreet.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength4)});

        int maxLength5 = 75;
        qrCity.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength5)});

        int maxLength6 = 75;
        qrPostal.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength6)});



        Button generate=(Button) findViewById(R.id.generate);


        generate.setOnClickListener(new View.OnClickListener() {
            String result;
            @Override
            public void onClick(View v) {
                result = qrName.getText().toString()+";ADR:"+qrStreet.getText().toString()+","+qrCity.getText().toString()+","+qrPostal.getText().toString()+";TEL:"+qrPhone.getText().toString()+";EMAIL:"+qrMail.getText().toString()+";;";
                Intent i = new Intent(MeCardEnterActivity.this, QrGeneratorDisplayActivity.class);
                i.putExtra("gn", result);
                i.putExtra("type", Contents.Type.Me_Card);
                startActivity(i);
            }

        });
    }
}
