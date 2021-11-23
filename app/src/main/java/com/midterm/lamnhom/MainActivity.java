package com.midterm.lamnhom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.midterm.lamnhom.api.ApiService;
import com.midterm.lamnhom.model.CovidVN;
import com.midterm.lamnhom.model.CovidWorld;

import java.sql.Timestamp;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvVN, tvWorld, tvNhiemBenh, tvNhiemBenhDetail,
    tvTuVong, tvTuVongDetail, tvBinhPhuc, tvBinhPhucDetail, tvUpdate,
    tvNewNhiemBenh, tvNewTuVong, tvNewBinhPhuc;
    private boolean stateCovidInfoChanged;

    private void initView() {
        tvVN = findViewById(R.id.tv_vn);
        tvNhiemBenh = findViewById(R.id.tv_nhiem_benh);
        tvTuVong = findViewById(R.id.tv_tu_vong);
        tvBinhPhuc = findViewById(R.id.tv_binh_phuc);
        tvWorld = findViewById(R.id.tv_world);
        tvNhiemBenhDetail = findViewById(R.id.tv_nhiem_benh_detail);
        tvTuVongDetail = findViewById(R.id.tv_tu_vong_detail);
        tvBinhPhucDetail = findViewById(R.id.tv_binh_phuc_detail);
        tvUpdate = findViewById(R.id.tv_update);
        tvNewNhiemBenh = findViewById(R.id.tv_new_nhiem_benh);
        tvNewTuVong = findViewById(R.id.tv_new_tu_vong);
        tvNewBinhPhuc = findViewById(R.id.tv_new_binh_phuc);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        tvVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickVN();
            }
        });

        tvWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickWorld();
            }
        });

    }

    private String GetDetailNumber(long number) {
        if(number>1000 && number<1000000) {
            return (int)(number/1000)+"K";
        } else if(number>1000000) {
            return (int)(number/1000000)+"M";
        }
        return (int)number+"";
    }

    private String TimeStampToDate(long timestamp) {
        Timestamp ts = new Timestamp(timestamp);
        Date date = new Date(ts.getTime());
//        return date.getDate()+"/"+ts.getMonth()+"/"+ts.getYear();
        return date.toString();
    }

    private void handleClickVN() {
        if(!stateCovidInfoChanged) {
            tvWorld.setBackgroundColor(Color.GRAY);
            tvWorld.setTextColor(Color.BLACK);
            tvVN.setBackgroundColor(Color.parseColor("#ffc0cb"));
            tvVN.setTextColor(Color.RED);

            ApiService.apiService.getApiCovidVN().enqueue(new Callback<CovidVN>() {
                @Override
                public void onResponse(Call<CovidVN> call, Response<CovidVN> response) {
                    Toast.makeText(MainActivity.this, "Call Api Success", Toast.LENGTH_SHORT).show();
                    CovidVN covidVN = response.body();
                    if(covidVN != null) {
                        tvNhiemBenh.setText(GetDetailNumber(covidVN.getCases()));
                        tvTuVong.setText(GetDetailNumber(covidVN.getDeaths()));
                        tvBinhPhuc.setText(GetDetailNumber(covidVN.getRecovered()));
                        tvNhiemBenhDetail.setText(covidVN.getCases()+"");
                        tvTuVongDetail.setText(covidVN.getDeaths()+"");
                        tvBinhPhucDetail.setText(covidVN.getRecovered()+"");
                        tvUpdate.setText("Updated: " + TimeStampToDate(covidVN.getUpdated()));
                        tvNewNhiemBenh.setText("+ " + covidVN.getTodayCases());
                        tvNewBinhPhuc.setText("+ " + covidVN.getTodayRecovered());
                        tvNewTuVong.setText("+ " + covidVN.getTodayDeaths());
                    }
                }

                @Override
                public void onFailure(Call<CovidVN> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Call Api Failed", Toast.LENGTH_SHORT).show();
                }
            });

            stateCovidInfoChanged = !stateCovidInfoChanged;
        }
    }

    private void handleClickWorld() {
        if(stateCovidInfoChanged) {
            tvVN.setBackgroundColor(Color.GRAY);
            tvVN.setTextColor(Color.BLACK);
            tvWorld.setBackgroundColor(Color.parseColor("#e0ffff"));
            tvWorld.setTextColor(Color.BLUE);

            ApiService.apiServiceWorld.getApiCovidWorld().enqueue(new Callback<CovidWorld>() {
                @Override
                public void onResponse(Call<CovidWorld> call, Response<CovidWorld> response) {
                    Toast.makeText(MainActivity.this, "Call Api Success", Toast.LENGTH_SHORT).show();
                    CovidWorld covidWorld = response.body();
                    if(covidWorld != null) {
                        tvNhiemBenh.setText(GetDetailNumber(covidWorld.getCases()));
                        tvTuVong.setText(GetDetailNumber(covidWorld.getDeaths()));
                        tvBinhPhuc.setText(GetDetailNumber(covidWorld.getRecovered()));
                        tvNhiemBenhDetail.setText(covidWorld.getCases()+"");
                        tvTuVongDetail.setText(covidWorld.getDeaths()+"");
                        tvBinhPhucDetail.setText(covidWorld.getRecovered()+"");
                        tvUpdate.setText("Updated: " + TimeStampToDate(covidWorld.getUpdated()));
                        tvNewNhiemBenh.setText("+ " + covidWorld.getTodayCases());
                        tvNewBinhPhuc.setText("+ " + covidWorld.getTodayRecovered());
                        tvNewTuVong.setText("+ " + covidWorld.getTodayDeaths());
                    }
                }

                @Override
                public void onFailure(Call<CovidWorld> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Call Api Failed", Toast.LENGTH_SHORT).show();
                }
            });

            stateCovidInfoChanged = !stateCovidInfoChanged;
        }
    }

    }

}