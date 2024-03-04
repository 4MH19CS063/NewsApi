package com.example.newsapi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder>{
    ArrayList<Articles> articlesList;

    public Adapter(ArrayList<Articles> articlesList) {
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_items,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.CustomViewHolder holder, int position) {
        holder.tv_author.setText(articlesList.get(position).getAuthor());
        holder.tv_content.setText(articlesList.get(position).getContent());
        holder.tv_name.setText("Published by "+articlesList.get(position).getSource().getName());
        holder.tv_Description.setText(articlesList.get(position).getDescription());
        holder.tv_title.setText(articlesList.get(position).getTitle());
        holder.tv_published.setText(articlesList.get(position).getPublishedAt());
        Picasso.get().load(articlesList.get(position).getUrlToImage()).into(holder.img);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new DetailNews();
//                Bundle bundle = new Bundle();
//                bundle.putString("author",articlesList.get(position).getAuthor());
//                bundle.putString("content",articlesList.get(position).getContent());
//                bundle.putString("name",articlesList.get(position).getSource().getName());
//                bundle.putString("description",articlesList.get(position).getDescription());
//                bundle.putString("title",articlesList.get(position).getTitle());
//                bundle.putString("published",articlesList.get(position).getPublishedAt());
//                bundle.putString("image",articlesList.get(position).getUrlToImage());
//                fragment.setArguments(bundle);
//                FragmentManager fm = get;
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.addToBackStack(null);
//                ft.replace(R.id.frame,fragment);
//                ft.commit();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if(articlesList==null){
            articlesList = new ArrayList<>();
        }
        return articlesList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_title;
        TextView tv_author;
        TextView tv_published;
        TextView tv_content;
        TextView tv_Description;
        ImageView img;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.txt_name);
            tv_author = itemView.findViewById(R.id.txt_author);
            tv_title = itemView.findViewById(R.id.txt_title);
            tv_content =itemView.findViewById(R.id.txt_content);
            tv_Description = itemView.findViewById(R.id.txt_description);
            tv_published = itemView.findViewById(R.id.txt_published);
            img= itemView.findViewById(R.id.imageView);
        }
    }
}
