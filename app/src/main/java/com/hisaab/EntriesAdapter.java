package com.hisaab;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

import static android.R.id.message;

/**
 * Created by Lalit dhankher on 5/21/2018.
 */

public class EntriesAdapter extends RecyclerView.Adapter<EntriesAdapter.EntriesViewHolder> {

private List<String> entries;
    private Context context;
    private Dialog myDialog;
    Button bcancel;
    Button bok;

    public EntriesAdapter(List<String> entries, Context context){
        this.entries= entries;
        this.context= context;
}

    @Override
    public EntriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new EntriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EntriesViewHolder holder, int position) {
        holder.entriesView.setText(entries.get(position));


        holder.llCardContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog);
                dialog.show();
                Button bok = (Button)dialog.findViewById(R.id.bok);
                Button bcancel = (Button)dialog.findViewById(R.id.bcancel);

                bcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                return false;
            }

        });
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public class EntriesViewHolder extends RecyclerView.ViewHolder{
            TextView entriesView;
        LinearLayout llCardContainer;
        public EntriesViewHolder(View itemView) {
            super(itemView);
            entriesView = (TextView) itemView.findViewById(R.id.entriesView);
            llCardContainer = (LinearLayout) itemView.findViewById(R.id.llCardContainer);
        }
    }
}
