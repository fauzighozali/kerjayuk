package com.example.kerjayuk;


import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewJob extends ListActivity implements AdapterView.OnItemLongClickListener {

    private DBDataSource dataSource;

    private ArrayList<Pekerjaan> values;
    private Button editButton;
    private Button delButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_job);
        dataSource = new DBDataSource(this);
        dataSource.open();

        values = dataSource.getAllPekerjaan();

        ArrayAdapter<Pekerjaan> adapter = new ArrayAdapter<Pekerjaan>(this,
                android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);

        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setOnItemLongClickListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pekerjaan pekerjaan = (Pekerjaan) getListAdapter().getItem(position);
                switchToGetData(pekerjaan.getId());
            }
        });
    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> adapter, View v, int pos,
                                   final long id) {

        //tampilkan alert dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.view);
        dialog.setTitle("Pilih Aksi");
        dialog.show();
        final Pekerjaan p = (Pekerjaan) getListAdapter().getItem(pos);
        editButton = (Button) dialog.findViewById(R.id.button_edit_data);
        delButton = (Button) dialog.findViewById(R.id.button_delete_data);

        editButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        switchToEdit(p.getId());
                        dialog.dismiss();
                    }
                }
        );
        delButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        dataSource.deletePekerjaan(p.getId());
                        dialog.dismiss();
                        finish();
                        startActivity(getIntent());
                    }
                }
        );
        return true;
    }
    public void switchToEdit(long id)
    {
        Pekerjaan p = dataSource.getPekerjaan(id);
        Intent i = new Intent(this, EditJob.class);
        Bundle bun = new Bundle();
        bun.putLong("id", p.getId());
        bun.putString("perusahaan", p.getNamaperusahaan());
        bun.putString("pekerjaan", p.getNamapekerjaan());
        bun.putString("pendidikan", p.getNamapendidikan());
        bun.putString("lokasi", p.getNamalokasi());
        bun.putString("durasi", p.getNamadurasi());
        bun.putString("kontak", p.getNamakontak());
        i.putExtras(bun);
        finale();
        startActivity(i);
    }

    public void switchToGetData(long id) {
        Pekerjaan p = dataSource.getPekerjaan(id);
        Intent i = new Intent(this, ViewSingleDataJob.class);
        Bundle bun = new Bundle();
        bun.putLong("id", p.getId());
        bun.putString("perusahaan", p.getNamaperusahaan());
        bun.putString("pekerjaan", p.getNamapekerjaan());
        bun.putString("pendidikan", p.getNamapendidikan());
        bun.putString("lokasi", p.getNamalokasi());
        bun.putString("durasi", p.getNamadurasi());
        bun.putString("kontak", p.getNamakontak());
        i.putExtras(bun);
        dataSource.close();
        startActivity(i);
    }

    //method yang dipanggil ketika edit data selesai
    public void finale()
    {
        ViewJob.this.finish();
        dataSource.close();
    }
    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }

    public  void keMenu(View v){
        Intent i= new Intent(getApplicationContext(),timeline.class);
        startActivity(i);
    }

}
