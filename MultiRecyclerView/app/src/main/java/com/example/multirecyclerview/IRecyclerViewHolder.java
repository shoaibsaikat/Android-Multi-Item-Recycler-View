package com.example.multirecyclerview;

import android.content.Context;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public interface IRecyclerViewHolder {
    void setData(RecyclerAdapter.ItemData data);
    RecyclerAdapter.ItemData getData();
}

class ListViewHolder extends RecyclerView.ViewHolder implements IRecyclerViewHolder, View.OnClickListener {

    public TextView tvTitle;
    public TextView tvSubtitle;

    private Context context;
    private RecyclerAdapter.ItemData data;

    public ListViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvSubtitle = itemView.findViewById(R.id.tvSubTitle);
        this.context = context;

        itemView.setOnClickListener(this);
    }

    @Override
    public void setData(RecyclerAdapter.ItemData data) {
        this.data = data;
    }

    @Override
    public RecyclerAdapter.ItemData getData() {
        return data;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, data.title, Toast.LENGTH_SHORT).show();
    }
}

class SwitchViewHolder extends RecyclerView.ViewHolder implements IRecyclerViewHolder {

    public Switch swToggle;

    private RecyclerAdapter.ItemData data;

    public SwitchViewHolder(@NonNull View itemView) {
        super(itemView);

        swToggle = itemView.findViewById(R.id.swToggle);
    }

    @Override
    public void setData(RecyclerAdapter.ItemData data) {
        this.data = data;
    }

    @Override
    public RecyclerAdapter.ItemData getData() {
        return data;
    }
}

class HeaderViewHolder extends RecyclerView.ViewHolder implements IRecyclerViewHolder {

    public TextView tvHeader;

    private RecyclerAdapter.ItemData data;

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);

        tvHeader = itemView.findViewById(R.id.tvHeader);
    }

    @Override
    public void setData(RecyclerAdapter.ItemData data) {
        this.data = data;
    }

    @Override
    public RecyclerAdapter.ItemData getData() {
        return data;
    }
}
