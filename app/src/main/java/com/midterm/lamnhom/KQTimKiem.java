package com.midterm.lamnhom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.midterm.lamnhom.databinding.ActivityKqtimKiemBinding;
import com.midterm.lamnhom.model.KhaiBao;
import com.midterm.lamnhom.model.LichSu;

public class KQTimKiem extends AppCompatActivity {

    private ActivityKqtimKiemBinding binding;
    private  LichSu his;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityKqtimKiemBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        Intent ls = getIntent();
        // Không được thay đỏi dòng nay
        his = (LichSu) ls.getSerializableExtra("his");
        binding.kqLsDiChuyen.setText( his.toString() );
        binding.kqCCCD.setText(his.getCccd());
      //  binding.kqDcThuongTru.setText(his.getDiaDiem());
        binding.kqCCCD.setText( his.getCccd());

        getKhaiBao( his.getCccd() );


      /*  if ( khaiBao.isSex() )
            binding.kqgtNam.isChecked() ;
        else
            binding.kqgtNu.isChecked();*/

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
}