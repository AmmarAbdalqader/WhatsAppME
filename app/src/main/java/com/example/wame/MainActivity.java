package com.example.wame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void goWhatsapp(View view) {
        Button button = (Button) findViewById(R.id.button);
        EditText editText = (EditText) findViewById(R.id.numInput);

        String num = editText.getText().toString();

        if (num.substring(0, 3).equals("962"))
            num = num.replace(num.substring(0, 3), "0");

        else if (num.substring(0, 4).equals("+962"))
            num = num.replace(num.substring(0, 4), "0");

        else if(num.substring(0, 5).equals("00962"))
            num = num.replace(num.substring(0, 5), "0");




        if(num.length() > 10 || num.length() < 10){
                Toast.makeText(this, "Invalid Phone number"+num, Toast.LENGTH_LONG).show();
        } else {

        int phoneNum = Integer.parseInt(num);

        String url = "https://wa.me/962" + phoneNum;
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
