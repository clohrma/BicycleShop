package com.zybooks.bicycleshop.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.bicycleshop.R;
import com.zybooks.bicycleshop.entities.Part;

import java.util.List;

public class PartAdapter extends RecyclerView.Adapter<PartAdapter.PartViewHolder> {


    class PartViewHolder extends RecyclerView.ViewHolder {
        private final TextView partName;
        private final TextView partPrice;

        private PartViewHolder(View itemView) {
            super(itemView);
            partName = itemView.findViewById(R.id.partNameTextView);
            partPrice = itemView.findViewById(R.id.partPriceTextView);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                final Part current = mParts.get(position);
                Intent intent = new Intent(context, PartDetail.class);
                intent.putExtra("id", current.getPartID());
                intent.putExtra("name", current.getPartName());
                intent.putExtra("price", current.getPartPrice());
                intent.putExtra("prodID", current.getProductID());
                context.startActivity(intent);
            });
        }
    }

    private List<Part> mParts;
    private final Context context;
    private final LayoutInflater mInflater;

    public PartAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.part_list_item, parent, false);
        return new PartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartViewHolder holder, int position) {
        if (mParts != null) {
            Part current = mParts.get(position);
            String name = current.getPartName();
            double price = current.getPartPrice();
            holder.partName.setText(name);
            holder.partPrice.setText(String.valueOf(price));
        } else {
            holder.partName.setText("No part name.");
            holder.partPrice.setText("No part price.");
        }
    }

    public void setParts(List<Part> parts) {
        mParts = parts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mParts.size();
    }
}