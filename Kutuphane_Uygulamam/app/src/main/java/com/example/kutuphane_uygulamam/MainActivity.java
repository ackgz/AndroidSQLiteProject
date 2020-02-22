package com.example.kutuphane_uygulamam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button magazabtn=(Button) findViewById(R.id.magaza);
        Button turlerbtn=(Button) findViewById(R.id.turler);
        Button ekle=(Button) findViewById(R.id.ekle);
        Button bilgi=(Button) findViewById(R.id.bilgi);

        magazabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, magaza.class);
                startActivity(a);

            }
        });


        turlerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, kitap_turleri.class);
                startActivity(a);

            }
        });


        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this, kitap_ekle.class);
                startActivity(a);
            }
        });
        bilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(MainActivity.this, bilgi.class);
                startActivity(a);
            }
        });

}
}