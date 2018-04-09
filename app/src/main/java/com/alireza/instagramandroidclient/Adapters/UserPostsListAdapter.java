package com.alireza.instagramandroidclient.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alireza.instagramandroidclient.Models.UserPostsModels.DatumModel;
import com.alireza.instagramandroidclient.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by alireza on 4/9/18.
 */

public class UserPostsListAdapter extends RecyclerView.Adapter<UserPostsListAdapter.MyViewHolder> {


    private TextView postCaption;
    private TextView likesCountTextview;
    private TextView commentsCountTextview;
    private ImageView postImageview;


    private List<DatumModel> datumModels;

    public UserPostsListAdapter(List<DatumModel> list) {
        this.datumModels = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_post_item, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);
            postImageview = view.findViewById(R.id.post_imageview);
            postCaption = view.findViewById(R.id.post_caption_textview);
            likesCountTextview = view.findViewById(R.id.likes_count_textview);
            commentsCountTextview = view.findViewById(R.id.comments_count_textview);
        }
    }

    @Override
    public void onBindViewHolder(UserPostsListAdapter.MyViewHolder holder, int position) {
        String text =
                datumModels
                        .get(position)
                        .getCaption()
                        .getText();

        postCaption.setText(text);
        String imageURI =
                datumModels.get(position).getImages().getThumbnail().getUrl();
        Picasso.get().load(imageURI).into(postImageview);
        likesCountTextview.setText("likes: " + datumModels.get(position).getLikes().getCount());
        commentsCountTextview.setText("comments: " + datumModels.get(position).getComments().getCount());
    }

    @Override
    public int getItemCount() {
        int i = datumModels.size();
        return datumModels.size();
    }
}

