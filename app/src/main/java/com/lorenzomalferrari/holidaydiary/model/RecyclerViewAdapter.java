package com.lorenzomalferrari.holidaydiary.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context myContext;
    private List<Travel> myData;

    public RecyclerViewAdapter(Context myContext, List<Travel> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        view = myInflater.inflate(R.layout.card_view_item_travel,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.travel_title.setText(myData.get(position).getTitle());
        holder.travel_img.setImageResource(myData.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView travel_title;
        ImageView travel_img;

        public MyViewHolder(View itemView) {
            super(itemView);

            travel_title = (TextView) itemView.findViewById(R.id.travel_title_id);
            travel_img = (ImageView) itemView.findViewById(R.id.travel_img_id);
        }
    }
}
