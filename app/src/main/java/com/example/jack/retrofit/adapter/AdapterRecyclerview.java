package com.example.jack.retrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jack.retrofit.R;
import com.example.jack.retrofit.model.Hero;
import com.example.jack.retrofit.model.MyResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecyclerview extends RecyclerView.Adapter<ViewHolderRecyclerview>

{

    List<MyResult> herolist;
    Context context;

    String imageBase = "https://image.tmdb.org/t/p/w780";

    public AdapterRecyclerview(List<MyResult> herolist, Context context) {
        this.herolist = herolist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderRecyclerview onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.herolist,viewGroup,false);
        return new ViewHolderRecyclerview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRecyclerview holder, int position)
    {
        MyResult hero = herolist.get(position);

        holder.lbl1.setText(hero.getName());
        holder.lbl2.setText(hero.getName());


        String imageUrl = imageBase + hero.getImage();

        Picasso.with(context).load(imageUrl).into(holder.imageView);

//        holder.lbl4.setText(hero.getFirstappearance());
//        holder.lbl5.setText(hero.getCreatedby());
//        holder.lbl6.setText(hero.getPublisher());
    }

    @Override
    public int getItemCount() {
        return herolist.size();
    }
}
