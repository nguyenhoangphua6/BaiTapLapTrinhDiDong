package com.midterm.lamnhom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.midterm.lamnhom.databinding.ActivitySearchBinding;
import com.midterm.lamnhom.model.AdapterHis;
import com.midterm.lamnhom.model.KhaiBao;
import com.midterm.lamnhom.model.LichSu;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {


     private FirebaseDatabase database;
    private ActivitySearchBinding binding;
    private RecyclerView recyclerView;
    private AdapterHis adapter;
    private ArrayList<LichSu> listLichsu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        View view = binding.getRoot();
        setContentView(view);


        listLichsu = new ArrayList<LichSu>();
        adapter = new AdapterHis(listLichsu, getApplicationContext());


        recyclerView = binding.rvLichSu;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getAllListLichSuRealTimeDB();


    }

    private  void getAllListLichSuRealTimeDB(){



        database = FirebaseDatabase.getInstance();
        listLichsu.clear();

        DatabaseReference  exe = database.getReference("listls");

          exe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for( DataSnapshot dataSnapshot :  snapshot.getChildren() ){
                      String t = dataSnapshot.getKey();
                      LichSu kb = new LichSu();
                      kb = dataSnapshot.getValue( LichSu.class) ;
                      listLichsu.add(kb);
                      adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                 Toast.makeText(SearchActivity.this, "Loi Roi Ba Con Oi", Toast.LENGTH_SHORT ).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}