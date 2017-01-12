package com.example.lenovo.sepaltive;

/**
 * Created by Lenovo on 1/12/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 1/10/2017.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private List<ImageData.HitsBean> itemsBeanList;
    private Context context;

    public ImageAdapter(List<ImageData.HitsBean> itemsBeanList, Context context) {
        this.itemsBeanList = itemsBeanList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageData.HitsBean image = itemsBeanList.get(position);
        Picasso.with(context).load(image.getPreviewURL()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return itemsBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}