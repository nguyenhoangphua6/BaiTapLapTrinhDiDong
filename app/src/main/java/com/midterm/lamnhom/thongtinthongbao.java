package com.midterm.lamnhom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.midterm.lamnhom.model.KhaiBao;
import com.midterm.lamnhom.model.LichSu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class thongtinthongbao extends AppCompatActivity {

    EditText edname,edcccd,eddiachi,edsdt;
    CheckBox cbnam,cbcamket;

    EditText eddiadiem,edthoigian,edphuongtien;
    Boolean gioitinh,camket, cket;
    String name,cccd,diachi,sdt,diadiem,thoigian,phuongtien;
    Button Gui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinthongbao);

        // phan khai bao
        edname = findViewById(R.id.edname);
        edcccd = findViewById(R.id.edcccd);
        eddiachi = findViewById(R.id.eddiachi);
        edsdt = findViewById(R.id.edsdt);
        cbnam = findViewById(R.id.cbnam);
        cbcamket = findViewById(R.id.cbcamket);

        //xong phan khai bao
        // phan lich su
        eddiadiem =findViewById(R.id.eddiadiem);
        edthoigian= findViewById(R.id.edtime);
        edphuongtien = findViewById(R.id.edphuongtien);


        //xong phan lich su
        Gui = findViewById(R.id.btngui);
        Gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                name = edname.getText().toString();
                cccd= edcccd.getText().toString();
                diachi=eddiachi.getText().toString();
                sdt= edsdt.getText().toString();
                if(cbnam.isChecked()){
                    gioitinh=true;
                }
                else {
                    gioitinh=false;
                }
                if(cbcamket.isChecked()){
                    camket=true;
                }
                else {
                    camket=false;
                }


                diadiem = eddiadiem.getText().toString();
                thoigian= edthoigian.getText().toString();
                phuongtien=edphuongtien.getText().toString();

                Log.d("DATA", name+" / " +gioitinh+" / " +cccd+" / " +diachi+" / " +camket+" / " +sdt);

                writeNewKhaiBao(name,gioitinh,cccd,diachi,camket,sdt);
                writeNewLichSu(cccd,diadiem,thoigian,phuongtien);
                eddiadiem.setText("");
                edphuongtien.setText("");
                edthoigian.setText("");
                cbcamket.setChecked(false);
            }
        });

    }
    public void writeNewKhaiBao( String name, boolean sex, String cccd, String adress, boolean camKet,String sdt) {
/*        String key = "kb"+cccd;
        KhaiBao khaibao = new KhaiBao(name,sex,cccd,adress,camKet,sdt);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://hotrocovid-e94d3-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference().child(key);
        myRef.setValue(khaibao);*/
        String key = "kb-"+cccd;
        KhaiBao khaibao = new KhaiBao(name,sex,cccd,adress,camKet,sdt);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://hotrocovid-e94d3-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("listkb").child(key);
        myRef.setValue(khaibao);

    }

    public void writeNewLichSu(String cccd, String diaDiem, String thoiGian, String phuongTien){
/*        String key = "ls"+cccd;
        LichSu lichSu = new LichSu(cccd, diaDiem,thoiGian,phuongTien);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://hotrocovid-e94d3-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference().child(key);
        myRef.setValue(lichSu);*/
        String t = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        t = sdf.format(new Date());

        String key = "ls-"+cccd  + "-" + t;
        LichSu lichSu = new LichSu(cccd, diaDiem,phuongTien ,thoiGian);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://hotrocovid-e94d3-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("listls").child(key);
        myRef.setValue(lichSu);

    }

}