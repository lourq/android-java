package com.example.project_1;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Item> list;
    private OnItemClickListener mItemClickListener;

    void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView t1;
        TextView t2;

        ViewHolder(View v) {
            super(v);
            img = (ImageView) v.findViewById(R.id.img1);
            t1 = (TextView) v.findViewById(R.id.t1);
            t2 = (TextView) v.findViewById(R.id.t2);

        }
    }

    RecyclerAdapter(List<Item> data) {
        list = data;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = list.get(position);
        holder.t1.setText(item.getName());
        holder.t2.setText("$" + item.getPrice());
        holder.img.setImageResource(item.getImageId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Item> list = new ArrayList<>();

        list.add(new Item("Porsche 911 Turbo S" , 230.401  , R.drawable.porsche));
        list.add(new Item("Potato" , 3  , R.drawable.potato));
        list.add(new Item("12 baliv" , 123445565656.1  , R.drawable.hw));

        RecyclerView rv = findViewById(R.id.my_recycler_view);

        rv.setHasFixedSize(true);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        RecyclerView.Adapter a = new RecyclerAdapter(list);

        rv.setAdapter(a);
    }

    private String[] getDataSet() {
        int rowCount = 50;
        String[] mDataSet = new String[rowCount];
        for (int i = 0; i < rowCount; i++) {
            mDataSet[i] = "пункт №" + i;
        }
        return mDataSet;
    }
}