package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button add;
    private TextView answer,portfolioLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");

        num1 = (EditText)findViewById(R.id.editTextNumberSigned);
        num2 = (EditText)findViewById(R.id.editTextNumberSigned2);
        add = (Button) findViewById(R.id.button);
        answer = (TextView) findViewById(R.id.textView);
        portfolioLink = (TextView) findViewById(R.id.textView2);
        portfolioLink.setMovementMethod(LinkMovementMethod.getInstance());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number1 = Integer.parseInt(num1.getText().toString());
                    int number2 = Integer.parseInt(num2.getText().toString());
                    int sum = number1 + number2;
                    answer.setText("The Answer is "+String.valueOf(sum));
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Something Went Wrong.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onNewActivity(View v)
    {
        // launch new Page
        Intent i = new Intent(this, SettingsActivity.class);
        i.putExtra("COOL", "Hello");
        startActivity(i);
    }
}