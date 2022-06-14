package com.example.mvvm.ui.fragment.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm.R;
import com.example.mvvm.databinding.ItemBinding;
import com.example.mvvm.domain.entity.Result;

import java.util.ArrayList;
import java.util.List;

public class AdapterHomeFragment extends RecyclerView.Adapter<AdapterHomeFragment.ViewHolder> {

    public List<Result> list = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<Result> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding binding;

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Result result) {
            binding.txtStatus.setText(result.getStatus());
            binding.txtName.setText(result.getName());
            Glide.with(binding.getRoot()).load(result.getImage()).centerCrop()
                    .into(binding.imgRickAndMorty);
        }
    }

}
