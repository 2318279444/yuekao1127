package com.bawei.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.Bean.Shops;
import com.bawei.dengxianchaoyuekao20191127.R;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2019/11/27
 *@Time:10:24
 *@Description:${DESCRIPTION}
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Shops.ResultBean> slist;
    Context context;

    public MyAdapter(List<Shops.ResultBean> slist, Context context) {
        this.slist = slist;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        Glide.with(context).load(slist.get(position).getMasterPic())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)

                .into(holder.imageView);
        holder.textView.setText(slist.get(position).getCommodityName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBa.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return slist.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ima);
            textView=itemView.findViewById(R.id.tex1);
        }
    }


    public interface CallBa{
        void onClick(int position);
    }

    public CallBa callBa;

    public void setCallBa(CallBa callBa){
        this.callBa=callBa;
    }
}
