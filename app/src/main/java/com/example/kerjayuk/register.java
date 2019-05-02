package com.example.kerjayuk;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    DatabaseHelper db;
    EditText cpass, email, pass;
    Button bdaftar, bmasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);

        email = (EditText) findViewById(R.id.txtemail);
        pass = (EditText) findViewById(R.id.txtpass);
        cpass = (EditText) findViewById(R.id.txtcpass);

        bdaftar = (Button) findViewById(R.id.btndaftar);
        bdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = email.getText().toString();
                String s2 = pass.getText().toString();
                String s3 = cpass.getText().toString();
                if (s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields Are Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (s2.equals(s3)){
                        Boolean chkemail = db.chkemail(s1);
                        if (chkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if (insert==true){

                                bdaftar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(getApplicationContext(),"Registered Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intenta = new Intent(register.this, login.class);
                                        startActivity(intenta);
                                    }
                                });
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bmasuk = (Button) findViewById(R.id.btnmasuk);
        bmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this,login.class);
                startActivity(intent);
            }
        });
    }
}
