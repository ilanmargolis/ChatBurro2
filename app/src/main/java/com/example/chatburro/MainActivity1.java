package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = editText.getText().toString();
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtra("MENSAGEM", mensagem);

                startActivity(intent);
            }
        });
    }
}