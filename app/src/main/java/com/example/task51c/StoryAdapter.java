package com.example.task51c;

import android.content.Context;
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

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    Context context;
    List<Story> storyList;
    private OnStoryListener mOnStoryListener;

    public StoryAdapter(Context context, List<Story> storyList, OnStoryListener onStoryListener) {
        this.context = context;
        this.storyList = storyList;
        this.mOnStoryListener = onStoryListener;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_stories, parent, false);
        return new StoryViewHolder(itemView, mOnStoryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
          holder.storyImageView.setImageResource(storyList.get(position).getImage());
//        holder.storyImageView.setImageResource(storyList.get(position).getImage());
//        holder.storyTitleTextView.setText(storyList.get(position).getTitle());
//        holder.storyBodyTextView.setText(storyList.get(position).getBody());


    }

    @Override
    public int getItemCount() {

        return storyList.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView storyImageView;
//        TextView storyTitleTextView, storyBodyTextView;
        OnStoryListener onStoryListener;
        public StoryViewHolder(@NonNull View itemView, OnStoryListener onStoryListener) {
            super(itemView);
            storyImageView = itemView.findViewById(R.id.topStoryImage);
//            storyBodyTextView = itemView.findViewById(R.id.StoryBodyTextView);
//            storyTitleTextView = itemView.findViewById(R.id.StoryTitleTextView);
            this.onStoryListener = onStoryListener;
            itemView.setOnClickListener(this);




        }

        @Override
        public void onClick(View view) {
            onStoryListener.onStoryClick(getAdapterPosition());
        }
    }

    public interface OnStoryListener{
        void onStoryClick(int position);
    }
}
