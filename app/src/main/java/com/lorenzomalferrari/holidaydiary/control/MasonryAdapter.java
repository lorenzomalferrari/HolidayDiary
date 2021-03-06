package com.lorenzomalferrari.holidaydiary.control;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lorenzomalferrari.holidaydiary.R;
/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {

    private Context context;

    //lista delle immagini
    int[] imgList = {
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.nine,
        R.drawable.ten,

        R.drawable.travel_1,
        R.drawable.bicifiori,

        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.nine,
        R.drawable.ten,

        R.drawable.travel_1,
        R.drawable.bicifiori
    };

    //Descrizione delle img
    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten","bb_0010","dsc_0001","dsc_0025"};

    /**
     * Costruttore
     * Inizializzazione del contesto
     * @param context
     */
    public MasonryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item_picture, parent, false);
        MasonryView masonryView = new MasonryView(layoutView);
        return masonryView;
    }

    @Override
    public void onBindViewHolder(MasonryView holder, int position) {
        holder.imageView.setImageResource(imgList[position]);
    }

    /**
     * Lunghezza basata sulle immagini poichè l'immagine può non avere una descrizione
     * @return int che rappresenta il numero di immagini nella lista
     */
    @Override
    public int getItemCount() {
        return imgList.length;
    }

    /**
     * Classe che rappresenta gli elementi che andranno visualizzati nella galleria di immagini
     */
    class MasonryView extends RecyclerView.ViewHolder {
        //
        ImageView imageView;

        public MasonryView(View itemView) {
            super(itemView);
            //inizializzazione dell'attributo
            imageView = itemView.findViewById(R.id.picture_img_id);
        }
    }
}
