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

public class TextEnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_enter);

        final EditText qrText=(EditText) findViewById(R.id.editText);
        Button generate=(Button) findViewById(R.id.generate);

        int maxLength = 75;
        qrText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
        generate.setOnClickListener(new View.OnClickListener() {
            String result;
            @Override
            public void onClick(View v) {

                result = qrText.getText().toString();
                Intent i = new Intent(TextEnterActivity.this, QrGeneratorDisplayActivity.class);
                i.putExtra("gn", result);
                i.putExtra("type", Contents.Type.TEXT);
                startActivity(i);
            }

        });
    }
}
