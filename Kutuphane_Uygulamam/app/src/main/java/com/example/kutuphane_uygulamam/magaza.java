package com.example.kutuphane_uygulamam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class magaza extends AppCompatActivity {

    private ListView VeriListele;
    private Button listele;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magaza);
        Button anasayfa=(Button) findViewById(R.id.anasayfa);
        VeriListele = (ListView) findViewById(R.id.urunler);
        listele=(Button) findViewById(R.id.listele);

        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(magaza.this, MainActivity.class);
                startActivity(a);
            }
        });

        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Listele();
            }
        });

    }
    public void Listele(){
        Veritabani vt = new Veritabani(magaza.this);
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(magaza.this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        VeriListele.setAdapter(adapter);
    }


    }
