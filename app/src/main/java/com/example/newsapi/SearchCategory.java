package com.example.newsapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.newsapi.databinding.FragmentSearchCategoryBinding;

import java.util.Objects;


public class SearchCategory extends Fragment {

    String category;
    FragmentSearchCategoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//          view = inflater.inflate(R.layout.fragment_search_category, container, false);
        binding = FragmentSearchCategoryBinding.inflate(inflater, container, false);

//               view.findViewById(R.id.recyclerView);
//               progress = view.findViewById(R.id.progress);
//               tNotFound = view.findViewById(R.id.txt_error);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


//        CallApi.displayApiData(binding.recyclerView, binding.progress, "");

//        spinner = view.findViewById(R.id.spinner);
//        spinner.getBackground().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_ATOP);


        ArrayAdapter<CharSequence> spinnerArray = ArrayAdapter.createFromResource(requireContext(), R.array.news_category, android.R.layout.simple_spinner_item);
        spinnerArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(spinnerArray);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = binding.spinner.getSelectedItem().toString().toLowerCase();
                binding.progress.setVisibility(View.VISIBLE);
                CallApi.displayApiData(binding.recyclerView, binding.progress, category);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                CallApi.displayApiData(binding.recyclerView, binding.progress, "");
            }
        });
//        if(fList==null){
//            fList = new ArrayList<>();
//        }
//        adapter = new Adapter(fList);
//        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}