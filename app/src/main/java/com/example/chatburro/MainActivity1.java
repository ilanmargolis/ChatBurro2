package com.example.chatburro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.stetho.Stetho;

public class MainActivity1 extends AppCompatActivity {

    TextView tvMsg1;
    EditText etMsg1;
    Button btEnviar1;

    SharedPreferences sharePref;

    private static final String TAG_PREFERENCES = MainActivity1.class.getSimpleName();
    protected static final String TAG_KEY_MESSAGE = "MESSAGE1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        tvMsg1 = (TextView) findViewById(R.id.tvMsg1);
        btEnviar1 = (Button) findViewById(R.id.btEnviar1);
        etMsg1 = (EditText) findViewById(R.id.etMsg1);

        Stetho.initializeWithDefaults(this);

        sharePref = this.getSharedPreferences(TAG_PREFERENCES, Context.MODE_PRIVATE);

        btEnviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = etMsg1.getText().toString();

                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtra("MESSAGE1", mensagem);

                funcoes.salvarDados(sharePref, TAG_KEY_MESSAGE, mensagem);

                startActivityForResult(intent, 90);

                etMsg1.setText("");
            }
        });
    }

    @Override
    protected  void onResume() {
        super.onResume();

        tvMsg1.setText(funcoes.recuperarDados(sharePref, TAG_KEY_MESSAGE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 90 && resultCode == RESULT_OK) {
            tvMsg1.setText(data.getStringExtra(MainActivity2.TAG_KEY_MESSAGE));
        }
    }
}