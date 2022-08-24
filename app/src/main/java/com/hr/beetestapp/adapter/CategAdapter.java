package com.hr.beetestapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hr.beetestapp.R;
import com.hr.beetestapp.model.Payload;

import java.util.ArrayList;

public class CategAdapter extends RecyclerView.Adapter<CategAdapter.ViewHolder> {

    private ArrayList<Payload> mData;
    private Activity mAct;
    private Context mcontext;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    ArrayList<String> mCategorias;

    // data is passed into the constructor
    public CategAdapter(Activity act, Context context, ArrayList<Payload> data, ArrayList<String> categorias) {
        this.mAct = act;
        this.mcontext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mCategorias = categorias;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_item_categ, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.myTextView.setText(mCategorias.get(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mCategorias.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        RecyclerView recyclerView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tv_cat);
            recyclerView = itemView.findViewById(R.id.lv_history);
            HistoryAdapter myAdapter = new HistoryAdapter(mAct,mcontext, mData);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mcontext);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(myAdapter);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Payload getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}