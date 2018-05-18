package com.lorenzomalferrari.holidaydiary.control;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.view.TravelActivity;
import com.lorenzomalferrari.holidaydiary.model.Travel;

import java.util.List;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class RecyclerViewAdapterTravels extends RecyclerView.Adapter<RecyclerViewAdapterTravels.MyViewHolder>{

    private Context myContext;
    private List<Travel> myData;

    /**
     * Costruttore parametrico
     * @param myContext
     * @param myData
     */
    public RecyclerViewAdapterTravels(Context myContext, List<Travel> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        view = myInflater.inflate(R.layout.card_view_item_travel,parent,false);
        return new RecyclerViewAdapterTravels.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.travel_title.setText(myData.get(position).getTitle());
        holder.travel_img.setImageResource(myData.get(position).getThumbnail());

        //Set click listener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // passing data to the TravelAcitivity
                Intent intent = new Intent(myContext, TravelActivity.class);
                intent.putExtra("TravelTitle",myData.get(position).getTitle());
                intent.putExtra("Description",myData.get(position).getDescription());
                intent.putExtra("Thumbnail",myData.get(position).getThumbnail());

                // Start the Activity
                myContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView travel_title;
        ImageView travel_img;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            travel_title = itemView.findViewById(R.id.travel_title_id);
            travel_img = itemView.findViewById(R.id.travel_img_id);
            cardView = itemView.findViewById(R.id.cardview_id);
        }
    }

}
