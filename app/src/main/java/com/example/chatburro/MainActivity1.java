package com.example.chatburro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity1 extends AppCompatActivity {

    TextView tvMsg1;
    EditText etMsg1;
    Button btEnviar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        tvMsg1 = (TextView) findViewById(R.id.tvMsg1);
        btEnviar1 = (Button) findViewById(R.id.btEnviar1);
        etMsg1 = (EditText) findViewById(R.id.etMsg1);

        btEnviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = etMsg1.getText().toString();

                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtra("MENSAGEM1", mensagem);

                startActivityForResult(intent, 90);

                etMsg1.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 90 && resultCode == RESULT_OK) {
            tvMsg1.setText(data.getStringExtra("MENSAGEM2"));
        }
    }
}