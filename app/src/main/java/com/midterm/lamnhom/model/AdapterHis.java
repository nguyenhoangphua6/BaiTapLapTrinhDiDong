package com.midterm.lamnhom.model;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.midterm.lamnhom.KQTimKiem;
import com.midterm.lamnhom.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class AdapterHis extends RecyclerView.Adapter< AdapterHis.ViewHolder> implements Filterable, Serializable {

    ArrayList<LichSu> listlichsu;
    ArrayList<LichSu> listSearch;
    Context context;

    public AdapterHis(ArrayList<LichSu> listls, Context context) {
        this.listlichsu = listls;
        this.context = context;
        this.listSearch= listls;
    }


    @NonNull
    @Override
    public AdapterHis.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate( R.layout.cardhoso,parent,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHis.ViewHolder holder, int position) {

        LichSu his  = new LichSu();

        his =   listlichsu.get(position);

        holder.cccd.setText(his.getCccd());
        holder.diachi.setText( his.getDiaDiem());
        holder.time.setText( his.getThoiGian());

        LichSu finalHis = his;
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClicKGotoDetail(finalHis);

            }
        });

    }

    private void   OnClicKGotoDetail( LichSu his){

        Intent intent= new Intent(context, KQTimKiem.class);
        intent.putExtra("his", his);    // Không được thay đỏi dòng nay
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return listlichsu.size();
    }



    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                List<LichSu> listFiltered= new ArrayList<LichSu>();
                if(charString.isEmpty())
                {
                    listFiltered.addAll(listSearch);
                }
                else {
                    for(LichSu c : listSearch)
                    {
                        if(c.getDiaDiem().toLowerCase().contains(charString.toLowerCase()))
                        {
                            listFiltered.add(c);
                        }
                    }
                }
                FilterResults results=new FilterResults();
                results.values=listFiltered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listlichsu=(ArrayList<LichSu>)filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView cccd, time, diachi;
        private ConstraintLayout layout;

        public ViewHolder(View view) {
            super(view);
            cccd = view.findViewById( R.id.tv_CCCD);
            diachi = view.findViewById(R.id.tv_DiaDiem);
            time = view.findViewById(R.id.tv_Time);
            layout = view.findViewById((R.id.layout_click));


        }
    }
}