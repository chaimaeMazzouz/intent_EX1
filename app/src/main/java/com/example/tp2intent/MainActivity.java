package com.example.tp2intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSend,btnClear;
    EditText etMessage;
    TextView tvResponse;
    private static final int codeCall = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend=findViewById(R.id.btnSend);
        etMessage=findViewById(R.id.etMessage1);
        tvResponse=findViewById(R.id.tvReponseFromSecond);
        btnClear = findViewById(R.id.btnClear);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("msg1",etMessage.getText().toString());
                startActivityForResult(i,codeCall);

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMessage.setText("");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // On vérifie tout d'abord à quel intent on fait référence ici à l'aide de notre identifiant
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == codeCall) {
            // On vérifie aussi que l'opération s'est bien déroulée
            if (resultCode == RESULT_OK) {
                // On affiche le bouton qui a été choisi
                String msgRecuFrom2 = "Reponse recu :" + data.getStringExtra("response");
                tvResponse.setText(msgRecuFrom2);
            }
        }
    }

}
