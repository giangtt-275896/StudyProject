package com.example.demoroomdata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.demorecycleview.R;
import com.example.demoroomdata.data.Items;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder>{

    private Context mContext;
    private List<Items> mListItem;
    private LayoutInflater mLayoutInflater;
    private RoomViewHolder mViewHolder;
    private View mConvertView;

    public RoomAdapter(Context context, List<Items> list) {
        this.mContext = context;
        this.mListItem = list;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(mContext);
        mConvertView = mLayoutInflater.inflate(R.layout.room_database_item, parent, false);
        mViewHolder = new RoomViewHolder(mConvertView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.tvName.setText(mListItem.get(position).getName());
        holder.tvQuantity.setText(Integer.toString(mListItem.get(position).getQuantity()));
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvQuantity;
        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_room_database_name);
            tvQuantity = itemView.findViewById(R.id.tv_room_database_quantity);
        }
    }
}
