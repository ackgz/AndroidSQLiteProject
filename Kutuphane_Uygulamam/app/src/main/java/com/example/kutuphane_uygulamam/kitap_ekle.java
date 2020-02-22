package com.example.kutuphane_uygulamam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class kitap_ekle extends AppCompatActivity {

    private EditText kitapad,yazar,stok;
    private Button btnKaydet, btnListele,btnSil,btnDuzenle;
    private ListView VeriListele;
    int idBul = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_ekle);
        Button anasayfa=(Button) findViewById(R.id.anasayfa);

        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(kitap_ekle.this, MainActivity.class);
                startActivity(a);
            }
        });


        kitapad = (EditText) findViewById(R.id.kitap_adi);
        yazar = (EditText) findViewById(R.id.yazari);
        stok = (EditText) findViewById(R.id.stok);
        btnKaydet = (Button) findViewById(R.id.kaydet);
        btnListele = (Button) findViewById(R.id.listele);
        btnSil = (Button) findViewById(R.id.sil);
        btnDuzenle = (Button) findViewById(R.id.duzenle);
        VeriListele = (ListView) findViewById(R.id.veri_listele);

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gelenAd = kitapad.getText().toString();
                String gelenSoyad = yazar.getText().toString();
                String gelenTel = stok.getText().toString();

                Veritabani vt = new Veritabani(kitap_ekle.this);
                vt.VeriEkle(gelenAd, gelenSoyad, gelenTel);
            }
        });

        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Listele();
            }
        });

        btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veritabani vt = new Veritabani(kitap_ekle.this);
                vt.VeriSil(idBul);
                ListViewItem();
                Listele();
            }
        });

        btnDuzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gelenAd = kitapad.getText().toString();
                String gelenSoyad = yazar.getText().toString();
                String gelenTel = stok.getText().toString();
                Veritabani vt = new Veritabani(kitap_ekle.this);
                vt.VeriDuzenle(idBul,gelenAd,gelenSoyad,gelenTel);
                ListViewItem();
                Listele();
            }
        });

    }

        public void Listele(){
        Veritabani vt = new Veritabani(kitap_ekle.this);
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(kitap_ekle.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,list);
        VeriListele.setAdapter(adapter);
    }


    public void ListViewItem() {
        VeriListele.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = VeriListele.getItemAtPosition(position).toString();
                String[] itemBol = item.split(" - ");
                idBul = Integer.valueOf(itemBol[0].toString());
                kitapad.setText(itemBol[1].toString());
                yazar.setText(itemBol[2].toString());
                stok.setText(itemBol[3].toString());
            }
        });


    }
    }
