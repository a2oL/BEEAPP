package com.hr.beetestapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hr.beetestapp.DetailActivity;
import com.hr.beetestapp.R;
import com.hr.beetestapp.model.Payload;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private Activity act;
    private ArrayList<Payload> mData;
    private Context mcontext;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public HistoryAdapter(Activity act,Context context, ArrayList<Payload> data) {
        this.act = act;
        this.mcontext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_item_history, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.myTextView.setText(mData.get(position).getName());
        Glide.with(mcontext).load(mData.get(position).getImageUrl()).into(holder.image);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView image;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textView2);
            image = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mcontext, DetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("img", mData.get(getAdapterPosition()).getImageUrl());
            intent.putExtra("name", mData.get(getAdapterPosition()).getName());
            intent.putExtra("desc", mData.get(getAdapterPosition()).getDescriptions());
            mcontext.startActivity(intent);

        }
    }
}