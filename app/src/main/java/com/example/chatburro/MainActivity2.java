package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView tvMsg2;
    EditText etMsg2;
    Button btEnviar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvMsg2 = (TextView) findViewById(R.id.tvMsg2);
        btEnviar2 = (Button) findViewById(R.id.btEnviar2);
        etMsg2 = (EditText) findViewById(R.id.etMsg2);

        String mensagem = getIntent().getStringExtra("MENSAGEM1");
        tvMsg2.setText(mensagem);
        etMsg2.setText("");

        btEnviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = etMsg2.getText().toString();

                Bundle res = new Bundle();
                res.putString("MENSAGEM2", mensagem);

                Intent i = new Intent();
                i.putExtras(res);

                setResult(RESULT_OK, i);

                finish();
            }
        });
    }
}