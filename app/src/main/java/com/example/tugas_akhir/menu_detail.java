package com.example.tugas_akhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class menu_detail extends AppCompatActivity {
    String id,nama,ket,foto;
    @BindView(R.id.txt_text)
    TextView txt_text;
    @BindView(R.id.txt_nama)
    TextView txt_nama;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.web)
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        ButterKnife.bind(this);
        Bundle b = getIntent().getExtras();
        id= (String) b.getCharSequence("id");
        nama= (String) b.getCharSequence("nama");
        foto= (String) b.getCharSequence("foto");
        ket= (String) b.getCharSequence("ket");

        txt_nama.setText(nama);
        txt_text.setText(ket);


        Glide.with(this)
                .load("http://192.168.1.71/tugas/foto/"+foto)
                .apply(new RequestOptions()
                        .fitCenter()
                        .error(R.drawable.ic_launcher_background))
                .into(imageView);

    }
}
