package com.example.randomlist.userview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomlist.R;
import com.example.randomlist.network.ImageRequester;

import java.util.List;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<UserModel> userList;
    private ImageRequester imageRequester;

    UserViewAdapter(List<UserModel> userList) {
        this.userList = userList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_user,
                parent, false);
        return new UserViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (userList != null && position < userList.size()) {
            UserModel product = userList.get(position);
            holder.userName.setText(product.getFname() + " " + product.getLname());
            holder.userAddress.setText(product.getCountry() + ", " + product.getCity());
            holder.userAge.setText("вік: " + Integer.toString(product.getAge()));
            imageRequester.setImageFromUrl(holder.userImage, product.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addItems(List<UserModel> userList){
        this.userList.addAll(userList);
        notifyDataSetChanged();
    }
}
