package com.example.kerjayuk;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateJob extends AppCompatActivity {
    private Button buttonSubmit;
    private EditText edPerusahaan;
    private EditText edPekerjaan;
    private EditText edPendidikan;
    private EditText edLokasi;
    private EditText edDurasi;
    private EditText edKontak;
    private DBDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);
        buttonSubmit = (Button) findViewById(R.id.button_submit);
        edPerusahaan = (EditText) findViewById(R.id.nama_perusahaan);
        edPekerjaan = (EditText) findViewById(R.id.nama_pekerjaan);
        edPendidikan = (EditText) findViewById(R.id.nama_pendidikan);
        edLokasi = (EditText) findViewById(R.id.lokasi_kerja);
        edDurasi = (EditText) findViewById(R.id.durasi_kerja);
        edKontak = (EditText) findViewById(R.id.kontak);

        dataSource = new DBDataSource(this);


        dataSource.open();
    }


    public void submitKlik(View v) {
        String iperusahaan = null;
        String ipekerjaan = null;
        String ipendidikan = null;
        String ilokasikerja = null;
        String idurasikerja = null;
        String ikontak = null;
        @SuppressWarnings("unused")

        com.example.kerjayuk.Pekerjaan pekerjaan = null;
        if(edPerusahaan.getText()!=null && edPekerjaan.getText()!=null && edPendidikan.getText()!=null && edLokasi.getText()!=null
        && edDurasi.getText()!=null && edKontak.getText()!=null)
        {
            iperusahaan = edPerusahaan.getText().toString();
            ipekerjaan = edPekerjaan.getText().toString();
            ipendidikan = edPendidikan.getText().toString();
            ilokasikerja = edLokasi.getText().toString();
            idurasikerja = edDurasi.getText().toString();
            ikontak = edKontak.getText().toString();
        }

        switch(v.getId())
        {
            case R.id.button_submit:
                pekerjaan = dataSource.createPekerjaan(iperusahaan, ipekerjaan, ipendidikan, ilokasikerja, idurasikerja, ikontak);

                Toast.makeText(this, "Input Success", Toast.LENGTH_LONG).show();
                break;
        }

    }

    public void klikBack(View v){
        Intent i= new Intent(getApplicationContext(),timeline.class);
        startActivity(i);
    }
}
