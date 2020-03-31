package com.example.randomlist.userview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.randomlist.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView userImage;
    public TextView userName;
    public TextView userAddress;
    public TextView userAge;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userImage = itemView.findViewById(R.id.user_image);
        userName = itemView.findViewById(R.id.user_name);
        userAddress = itemView.findViewById(R.id.user_address);
        userAge = itemView.findViewById(R.id.user_age);
    }
}
