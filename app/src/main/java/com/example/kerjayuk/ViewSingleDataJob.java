package com.example.kerjayuk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewSingleDataJob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_single_data_job);
        TextView tvnamaperusahaan = (TextView) findViewById(R.id.tv_nama_perusahaan);
        TextView tvnamapekerjaan = (TextView) findViewById(R.id.tv_nama_pekerjaan);
        TextView tvnamapendidikan = (TextView) findViewById(R.id.tv_nama_pendidikan);
        TextView tvnamalokasi = (TextView) findViewById(R.id.tv_nama_lokasi);
        TextView tvnamadurasi = (TextView) findViewById(R.id.tv_nama_durasi);
        TextView tvnamakontak = (TextView) findViewById(R.id.tv_nama_kontak);

        System.out.println("APPINVENT "+getIntent().getExtras().getString("perusahaan"));
        tvnamaperusahaan.setText("Company :"+getIntent().getExtras().getString("perusahaan"));
        tvnamapekerjaan.setText("Job :"+getIntent().getExtras().getString("pekerjaan"));
        tvnamapendidikan.setText("Education :"+getIntent().getExtras().getString("pendidikan"));
        tvnamalokasi.setText("Location :"+getIntent().getExtras().getString("lokasi"));
        tvnamadurasi.setText("Duration :"+getIntent().getExtras().getString("durasi"));
        tvnamakontak.setText("Contact :"+getIntent().getExtras().getString("kontak"));

        Button buttonOK = (Button) findViewById(R.id.bt_ok);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}