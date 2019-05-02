package com.example.kerjayuk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class updateprofile extends AppCompatActivity {
    private Button buttonSubmit;
    private EditText ednama;
    private EditText edjk;
    private EditText edpendidikan;
    private EditText edalamat;
    private EditText edkontak;
    private DBDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);buttonSubmit = (Button) findViewById(R.id.btnsave);
        ednama = (EditText) findViewById(R.id.etnama);
        edjk = (EditText) findViewById(R.id.etjeniskelamin);
        edpendidikan = (EditText) findViewById(R.id.etpendidikan);
        edalamat= (EditText) findViewById(R.id.etalamat);
        edkontak= (EditText) findViewById(R.id.etkontak);


        dataSource = new DBDataSource(this);


        dataSource.open();
    }


    public void saveKlik(View v) {
        String inama = null;
        String ijk = null;
        String ipendidikan = null;
        String ialamat = null;
        String ikontak = null;
        @SuppressWarnings("unused")

        Profil profil = null;
        if(ednama.getText()!=null && edjk.getText()!=null && edpendidikan.getText()!=null && edalamat.getText()!=null
                && edkontak.getText()!=null)
        {
            inama = ednama.getText().toString();
            ijk = edjk.getText().toString();
            ipendidikan = edpendidikan.getText().toString();
            ialamat = edalamat.getText().toString();
            ikontak = edkontak.getText().toString();
        }

        switch(v.getId())
        {
            case R.id.btnsave:
                profil = dataSource.createProfil(inama,ijk,ipendidikan,ialamat,ikontak);

                Toast.makeText(this, "Update Success", Toast.LENGTH_LONG).show();
                break;
        }

    }

    public void cancelKlik(View v){
        Intent i = new Intent(getApplicationContext(),ProfileFragment.class);
        startActivity(i);
    }
}
