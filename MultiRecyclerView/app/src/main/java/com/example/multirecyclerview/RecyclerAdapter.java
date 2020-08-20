package com.example.multirecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter {

    private enum ItemType {
        HEADER,
        SWITCH,
        TEXT
    }

    public class ItemData {
        public ItemType type;
        public String title;
        public String subTitle;

        ItemData(ItemType type, String title, String subTitle) {
            this.type = type;
            this.title = title;
            this.subTitle = subTitle;
        }
    }

    private Context context;
    private List<ItemData> items;

    public RecyclerAdapter(Context context) {
        this.context = context;

        items = new ArrayList<ItemData>();
        items.add(new ItemData(ItemType.HEADER, "Items with a choice", ""));
        items.add(new ItemData(ItemType.SWITCH, "Your Choice", ""));
        items.add(new ItemData(ItemType.TEXT, "Item 1", "1"));
        items.add(new ItemData(ItemType.TEXT, "Item 2", "2"));
        items.add(new ItemData(ItemType.TEXT, "Item 3", "3"));
        items.add(new ItemData(ItemType.TEXT, "Item 4", "4"));
        items.add(new ItemData(ItemType.TEXT, "Mandatory", ""));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ItemType.HEADER.ordinal()) {
            return new HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.header_layout, parent, false));
        } else if (viewType == ItemType.SWITCH.ordinal()) {
            return new SwitchViewHolder(LayoutInflater.from(context).inflate(R.layout.switch_layout, parent, false));
        } else {
            return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false), context);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ItemData data = items.get(position);
        ((IRecyclerViewHolder) holder).setData(data);

        if (data.type == ItemType.HEADER) {
            HeaderViewHolder h = (HeaderViewHolder) holder;
            h.tvHeader.setText(data.title);
        } else if (data.type == ItemType.SWITCH) {
            SwitchViewHolder h = (SwitchViewHolder) holder;
            h.swToggle.setText(data.title);
        } else {
            ListViewHolder h = (ListViewHolder) holder;
            h.tvTitle.setText(data.title);
            h.tvSubtitle.setText(data.subTitle);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).type.ordinal();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
