package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    SharedPreferences sharePref;

    private static final String TAG_PREFERENCES = MainActivity2.class.getSimpleName();
    protected static final String TAG_KEY_MESSAGE = "MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvMsg2 = (TextView) findViewById(R.id.tvMsg2);
        btEnviar2 = (Button) findViewById(R.id.btEnviar2);
        etMsg2 = (EditText) findViewById(R.id.etMsg2);

        String mensagem = getIntent().getStringExtra("MESSAGE1");

        sharePref = this.getSharedPreferences(TAG_PREFERENCES, Context.MODE_PRIVATE);

        tvMsg2.setText(mensagem);
        etMsg2.setText("");

        btEnviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = etMsg2.getText().toString();

                funcoes.salvarDados(sharePref, TAG_KEY_MESSAGE, mensagem);

                Bundle res = new Bundle();
                res.putString(TAG_KEY_MESSAGE, mensagem);

                Intent i = new Intent();
                i.putExtras(res);

                setResult(RESULT_OK, i);

                finish();
            }
        });
    }

    @Override
    protected  void onResume() {
        super.onResume();

        tvMsg2.setText(funcoes.recuperarDados(sharePref, TAG_KEY_MESSAGE));
    }

}