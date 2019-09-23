package com.example.uaspwpb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InputData extends AppCompatActivity {
    EditText tJudul,tDesk;
    Button btnSubmit;
    Context context;
    String judul,aksi = "Submit";
    Siswa updated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        context = this;

        aksi = getIntent().getStringExtra("UPDATE_ACTION");
        updated = getIntent().getParcelableExtra("UPDATE_INTENT");
        if(aksi==null){
            aksi = "Submit";
        }else{
            judul = updated.getJudul();
        }

        tJudul = findViewById(R.id.inputJudul);
        tDesk= findViewById(R.id.inputDesk);

        btnSubmit = findViewById(R.id.btnSubmit);
        if(aksi.equals("Update")){
            btnSubmit.setText("Update Data");
            tJudul.setText(judul);
            tJudul.setFocusable(false);
            tJudul.setText(updated.getJudul());
            tDesk.setText(updated.getDeskripsi());
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseSiswa db = new DatabaseSiswa(context);
                Siswa jalmi = new Siswa();
                String btnStatus = btnSubmit.getText().toString();
                if(btnStatus.equals("Submit Data")){
                    jalmi.setJudul(tJudul.getText().toString());
                    jalmi.setDeskripsi(tDesk.getText().toString());
                    db.insert(jalmi);
                    Intent pindah = new Intent(context,LihatData.class);
                    context.startActivity(pindah);
                }
                if(btnStatus.equals("Update Data")){
                    jalmi.setJudul(tJudul.getText().toString());
                    jalmi.setDeskripsi(tDesk.getText().toString());
                    Intent pindah = new Intent(context,LihatData.class);
                    context.startActivity(pindah);
                }

            }
        });
    }
}
