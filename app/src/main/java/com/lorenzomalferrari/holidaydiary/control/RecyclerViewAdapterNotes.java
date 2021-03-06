package com.lorenzomalferrari.holidaydiary.control;
// Android library
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
// My library
import com.lorenzomalferrari.holidaydiary.view.activity.NoteActivity;
import com.lorenzomalferrari.holidaydiary.R;
import com.lorenzomalferrari.holidaydiary.model.Note;
// Java library
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lorenzo Malferrari - Website: www.lorenzomalferrari.com
 */
public class RecyclerViewAdapterNotes extends RecyclerView.Adapter<RecyclerViewAdapterNotes.MyViewHolder>  {

    private Context context;
    private List<Note> myData;

    public RecyclerViewAdapterNotes(Context context, List<Note> myData) {
        this.context = context;
        this.myData = myData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater myLayoutInflater = LayoutInflater.from(context);
        view = myLayoutInflater.inflate(R.layout.card_view_item_note,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.title.setText(myData.get(position).getTitle());
        holder.data.setText(myData.get(position).getCreation_data().toString());

        // Set click listener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NoteActivity.class);

                // formatoo la data per visualizzarla dd/mm/yyyy hh:mm:ss
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                //Ottengo la data dal db
                Date date = myData.get(position).getCreation_data();
                //
                String strDate = simpleDateFormat.format(date);
                // Passing data to the note activity
                intent.putExtra("Title",myData.get(position).getTitle());
                intent.putExtra("Data",strDate);
                intent.putExtra("Description",myData.get(position).getDescription());
                // start activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, data;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.note_title_id);
            data = itemView.findViewById(R.id.note_data_id);
            cardView = itemView.findViewById(R.id.cardviewNote_id);
        }
    }
}
