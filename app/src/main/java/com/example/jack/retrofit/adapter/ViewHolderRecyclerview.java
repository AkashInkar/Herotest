package com.example.jack.retrofit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jack.retrofit.R;

public class ViewHolderRecyclerview extends RecyclerView.ViewHolder {

    TextView lbl1,lbl2;
    ImageView imageView;
    public ViewHolderRecyclerview(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.cell_image);
        lbl1 =itemView.findViewById(R.id.lblname);
        lbl2 =itemView.findViewById(R.id.lblrealname);
//        lbl3 =itemView.findViewById(R.id.lblteam);
//        lbl4 =itemView.findViewById(R.id.lblfirstappearance);
//        lbl5 =itemView.findViewById(R.id.lblcreatedb);
//        lbl6 =itemView.findViewById(R.id.lblpublisher);

    }
}
