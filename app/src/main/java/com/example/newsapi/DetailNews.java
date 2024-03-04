package com.example.newsapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.newsapi.databinding.FragmentDetailNewsBinding;
import com.squareup.picasso.Picasso;


public class DetailNews extends Fragment {

    Bundle bundle;

    FragmentDetailNewsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_detail_news, container, false);
        binding = FragmentDetailNewsBinding.inflate(inflater, container, false);

//        tv_author = view.findViewById(R.id.td_author);
//        tv_content = view.findViewById(R.id.td_content);
//        tv_Description = view.findViewById(R.id.td_description);
//        tv_name = view.findViewById(R.id.td_name);
//        tv_title = view.findViewById(R.id.td_title);
//        tv_published = view.findViewById(R.id.td_published);
//        img = view.findViewById(R.id.td_imageView);

        bundle = getArguments();

        binding.tdAuthor.setText(bundle.getString("author"));
        binding.tdContent.setText(bundle.getString("content"));
        binding.tdName.setText(bundle.getString("name"));
        binding.tdTitle.setText("title");
        binding.tdDescription.setText("description");
        binding.tdPublished.setText(bundle.getString("published"));
        Picasso.get().load(bundle.getString("image")).into(binding.tdImageView);


        return binding.getRoot();
    }
}