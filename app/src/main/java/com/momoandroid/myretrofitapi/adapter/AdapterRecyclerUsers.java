package com.momoandroid.myretrofitapi.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.momoandroid.myretrofitapi.R;
import com.momoandroid.myretrofitapi.databinding.RecyclerviewItemUserBinding;
import com.momoandroid.myretrofitapi.models.User;
import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerUsers extends RecyclerView.Adapter<AdapterRecyclerUsers.ViewHolder> {
    private List<User> modelArrayList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.recyclerview_item_user, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = modelArrayList.get(position);
        holder.binding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public void setList(List<User> models) {
        this.modelArrayList = models;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerviewItemUserBinding binding;

        public ViewHolder(@NonNull RecyclerviewItemUserBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}




