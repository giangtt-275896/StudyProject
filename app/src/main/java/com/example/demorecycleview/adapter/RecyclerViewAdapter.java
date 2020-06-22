package com.example.demorecycleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demorecycleview.R;
import com.example.demorecycleview.data.User;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<User> mData;

    public RecyclerViewAdapter(Context context, ArrayList<User> data) {
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.rv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.tvName.setText(mData.get(position).getUserName());
        viewHolder.tvAddress.setText(mData.get(position).getUserAddress());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Create ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName;
        public TextView tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
        }
    }
}
