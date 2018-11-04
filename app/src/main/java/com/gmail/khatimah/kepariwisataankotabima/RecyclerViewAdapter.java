package com.gmail.khatimah.kepariwisataankotabima;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.khatimah.kepariwisataankotabima.models.LocationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sulistiyanto on 07/12/16.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {


    private List<LocationModel> dataList;

    public RecyclerViewAdapter(List<LocationModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_view, parent, false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        holder.txtEmpName.setText(dataList.get(position).getLatutide());
        holder.txtEmpEmail.setText(dataList.get(position).getLongitude());
        holder.txtEmpPhone.setText(dataList.get(position).getImageLocationName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmpName, txtEmpEmail, txtEmpPhone;

        RecycleViewHolder(View itemView) {
            super(itemView);
            txtEmpName = (TextView) itemView.findViewById(R.id.txt_latitude);
            txtEmpEmail = (TextView) itemView.findViewById(R.id.txt_longitude);
            txtEmpPhone = (TextView) itemView.findViewById(R.id.txt_nama);
        }
    }
}