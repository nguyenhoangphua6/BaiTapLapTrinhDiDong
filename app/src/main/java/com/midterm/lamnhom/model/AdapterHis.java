package com.midterm.lamnhom.model;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.midterm.lamnhom.R;

import java.util.ArrayList;
import java.util.List;



public class AdapterHis extends RecyclerView.Adapter< AdapterHis.ViewHolder> implements Filterable {

    ArrayList<LichSu> listlichsu;
    ArrayList<LichSu> listSearch;
    Context context;

    public AdapterHis(ArrayList<LichSu> listlichsu, Context context) {
        this.listlichsu = listlichsu;
        this.context = context;
        this.listSearch=listlichsu;
    }


    @NonNull
    @Override
    public AdapterHis.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate( R.layout.cardhoso,parent,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHis.ViewHolder holder, int position) {

        LichSu hs = listlichsu.get(position);

        holder.cccd.setText(hs.getCccd());
        holder.diachi.setText( hs.getDiaDiem());
        holder.time.setText( hs.getThoiGian());

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
                List<LichSu> listFiltered=new ArrayList<LichSu>();
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

        public ViewHolder(View view) {
            super(view);
            cccd = view.findViewById( R.id.tv_CCCD);
            diachi = view.findViewById(R.id.tv_DiaDiem);
            time = view.findViewById(R.id.tv_Time);


        }
    }
}