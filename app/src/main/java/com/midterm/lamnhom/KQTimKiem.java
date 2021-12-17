package com.midterm.lamnhom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.midterm.lamnhom.databinding.ActivityKqtimKiemBinding;
import com.midterm.lamnhom.model.KhaiBao;
import com.midterm.lamnhom.model.LichSu;

import java.util.ArrayList;

public class KQTimKiem extends AppCompatActivity {

    private ActivityKqtimKiemBinding binding;

    private FirebaseDatabase database;
    private  LichSu his;


    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityKqtimKiemBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);


        Intent ls = getIntent();
        // Không được thay đỏi dòng nay
        his = (LichSu) ls.getSerializableExtra("his");
        //binding.kqLsDiChuyen.setText( his.toString() );
        binding.kqCCCD.setText(his.getCccd());
      //  binding.kqDcThuongTru.setText(his.getDiaDiem());
        binding.kqCCCD.setText( his.getCccd());

        getKhaiBao( his.getCccd() );



        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        binding.lvLichSu.setAdapter(adapter);

        getAllListLichSuRealTimeDB( his.getCccd() );  // không di chuyển


    }

    private void getKhaiBao( String cccd){
        String key = "kb-" + cccd;


        final FirebaseDatabase[] db = {FirebaseDatabase.getInstance("https://hotrocovid-e94d3-default-rtdb.firebaseio.com/")};
        DatabaseReference ref = db[0].getReference("listkb").child(key);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              //  KhaiBao kb = new KhaiBao();
              //  kb = snapshot.getValue( KhaiBao.class);

                KhaiBao kb  = snapshot.getValue( KhaiBao.class);
                binding.kqDcThuongTru.setText(kb.getAdress()  );
                binding.tvKqName.setText(kb.getName());

                if ( (boolean) kb.isSex() == true )
                    binding.kqgtNam.setChecked(true) ;
                else
                    binding.kqgtNu.setChecked(true) ;

                if ( kb.isCamKet()== true){
                    binding.kqCamKet.setChecked(true) ;
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


        private  void getAllListLichSuRealTimeDB( String cccd ){



        database = FirebaseDatabase.getInstance();
        arrayList.clear();

        DatabaseReference  exe = database.getReference("listls");

        exe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for( DataSnapshot dataSnapshot :  snapshot.getChildren() ){
                    String t = dataSnapshot.getKey();
                    LichSu kb = new LichSu();
                    kb = dataSnapshot.getValue( LichSu.class) ;

                    if( kb.getCccd().equals( cccd) == true   ){
                        arrayList.add(kb.toString());
                    }

                    adapter.notifyDataSetChanged();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(KQTimKiem.this, "Loi", Toast.LENGTH_SHORT ).show();
            }
        });

    }
}