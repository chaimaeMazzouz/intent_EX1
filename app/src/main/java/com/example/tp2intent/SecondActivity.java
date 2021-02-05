package com.example.tp2intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button btnRetour;
    TextView tvRecu;
    EditText etReponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvRecu=findViewById(R.id.tvMessageRecuFromMain);
        btnRetour=findViewById(R.id.btnRetour);
        etReponse=findViewById(R.id.etMessage2);
        Intent t=getIntent();
        String msg=t.getStringExtra("msg1");
        tvRecu.setText("Received message : "+msg);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("response",etReponse.getText().toString());
                setResult(RESULT_OK, result);
                finish();
            }
        });


    }
}
