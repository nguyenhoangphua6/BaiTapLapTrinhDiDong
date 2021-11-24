package com.midterm.lamnhom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.midterm.lamnhom.databinding.ActivityKqtimKiemBinding;
import com.midterm.lamnhom.model.LichSu;

public class KQTimKiem extends AppCompatActivity {
    private ActivityKqtimKiemBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityKqtimKiemBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        Intent ls = getIntent();
        // Không được thay đỏi dòng nay
        LichSu his = (LichSu) ls.getSerializableExtra("his");

        binding.kqLsDiChuyen.setText( his.toString() );
        binding.kqCCCD.setText(his.getCccd());
      //  binding.kqDcThuongTru.setText(his.getDiaDiem());
        binding.kqCCCD.setText( his.getCccd());
    }
}