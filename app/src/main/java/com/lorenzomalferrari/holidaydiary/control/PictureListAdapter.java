package com.lorenzomalferrari.holidaydiary.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.model.Picture;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class PictureListAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private ArrayList<Picture> picturesList;

    public PictureListAdapter(Context context, int layout, ArrayList<Picture> picturesList) {
        this.context = context;
        this.layout = layout;
        this.picturesList = picturesList;
    }

    @Override
    public int getCount() {
        return picturesList.size();
    }

    @Override
    public Object getItem(int position) {
        return picturesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);
            holder.imageView = row.findViewById(R.id.imgPicture);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Picture picture = picturesList.get(position);
        byte[] pictureImage = picture.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(pictureImage,0,pictureImage.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }

    private class ViewHolder {
        ImageView imageView;
    }
}
