package com.lorenzomalferrari.holidaydiary.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorenzomalferrari.holidaydiary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {


    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(R.string.home_page_title);

        ImageView imageView = view.findViewById(R.id.travel_img_id);
        TextView textView = view.findViewById(R.id.travel_title_id);
        imageView.setImageResource(R.drawable.bicifiori);
        imageView.setMaxHeight(100);
        textView.setText("Sardegna");

        TextView textViewnota = view.findViewById(R.id.note_title_id);
        textViewnota.setText("Spesa");
        TextView textViewdatanota = view.findViewById(R.id.note_data_id);
        textViewdatanota.setText("21/04/2018");

        TextView textViewnota2 = view.findViewById(R.id.note_title_id);
        textViewnota.setText("Spesa");
        TextView textViewdatanota2 = view.findViewById(R.id.note_data_id);
        textViewdatanota.setText("21/04/2018");


    }
}
