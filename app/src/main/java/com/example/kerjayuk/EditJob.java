package com.example.kerjayuk;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditJob extends Activity implements View.OnClickListener {

    private DBDataSource dataSource;

    private long id;
    private String iperusahaan;
    private String ipekerjaan;
    private String ipendidikan;
    private String ilokasi;
    private String idurasi;
    private String ikontak;

    private EditText edPerusahaan;
    private EditText edPekerjaan;
    private EditText edPendidikan;
    private EditText edLokasi;
    private EditText edDurasi;
    private EditText edKontak;

    private TextView txId;

    private Button btnSave;
    private Button btnCancel;

    private Pekerjaan pekerjaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_job);
        edPerusahaan = (EditText) findViewById(R.id.editText_perusahaan);
        edPekerjaan = (EditText) findViewById(R.id.editText_pekerjaan);
        edPendidikan = (EditText) findViewById(R.id.editText_pendidikan);
        edLokasi = (EditText) findViewById(R.id.editText_lokasi);
        edDurasi = (EditText) findViewById(R.id.editText_durasi);
        edKontak = (EditText) findViewById(R.id.editText_kontak);
        txId = (TextView) findViewById(R.id.text_id_pekerjaan);
        dataSource = new DBDataSource(this);
        dataSource.open();
        Bundle bun = this.getIntent().getExtras();
        id = bun.getLong("id");
        iperusahaan = bun.getString("perusahaan");
        ipekerjaan = bun.getString("pekerjaan");
        ipendidikan = bun.getString("pendidikan");
        ilokasi = bun.getString("lokasi");
        idurasi = bun.getString("durasi");
        ikontak = bun.getString("kontak");
        txId.append(String.valueOf(id));
        edPerusahaan.setText(iperusahaan);
        edPekerjaan.setText(ipekerjaan);
        edPendidikan.setText(ipendidikan);
        edLokasi.setText(ilokasi);
        edDurasi.setText(idurasi);
        edKontak.setText(ikontak);

        btnSave = (Button) findViewById(R.id.button_save_update);
        btnSave.setOnClickListener(this);
        btnCancel = (Button) findViewById(R.id.button_cancel_update);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.button_save_update :
                pekerjaan = new Pekerjaan();
                pekerjaan.setNamaperusahaan(edPerusahaan.getText().toString());
                pekerjaan.setNamapekerjaan(edPekerjaan.getText().toString());
                pekerjaan.setNamapendidikan(edPendidikan.getText().toString());
                pekerjaan.setNamalokasi(edLokasi.getText().toString());
                pekerjaan.setNamadurasi(edDurasi.getText().toString());
                pekerjaan.setNamakontak(edKontak.getText().toString());
                pekerjaan.setId(id);
                dataSource.updatePekerjaan(pekerjaan);
                Intent i = new Intent(this, ViewJob.class);
                startActivity(i);
                EditJob.this.finish();
                dataSource.close();
                break;
            case R.id.button_cancel_update :
                finish();
                dataSource.close();
                break;
        }
    }
}
