package com.example.kutuphane_uygulamam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class kitap_turleri extends AppCompatActivity {

    private String[] ulkeler =
            {"Kitap", "Bilim", "Popüler Bilim", "Mühendislik","Matematik",
                    "Bilim Tarihi ve Felsefesi", "Tubitak Kitapları", "Çevre Bilim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_turleri);

        ListView listemiz=(ListView) findViewById(R.id.liste);

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);

        listemiz.setAdapter(veriAdaptoru);

        Button anasayfa=(Button) findViewById(R.id.anasayfa);
        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(kitap_turleri.this, MainActivity.class);
                startActivity(a);
            }
        });
    }
}
