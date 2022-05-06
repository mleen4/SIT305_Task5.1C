package com.example.task51c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MainStoriesAdapter extends RecyclerView.Adapter<MainStoriesAdapter.MainStoryViewHolder> {
    List<Story> storyList;
    Context context;
    private OnMainStoryListener mOnMainStoryListener;

    public MainStoriesAdapter(List<Story> storyList, Context context, OnMainStoryListener onMainStoryListener) {
        this.storyList = storyList;
        this.context = context;
        this.mOnMainStoryListener = onMainStoryListener;
    }

    @NonNull
    @Override
    public MainStoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.main_stories, parent, false);
        return new MainStoryViewHolder(itemView, mOnMainStoryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainStoryViewHolder holder, int position) {
         switch(position)
        {
            case 0:
                holder.mainStoryImage1.setImageResource(storyList.get(0).getImage());
                holder.mainStoryTitle1.setText(storyList.get(0).getTitle());
                holder.mainStoryBody1.setText(storyList.get(0).getBody());
                holder.mainStoryImage2.setImageResource(storyList.get(1).getImage());
                holder.mainStoryTitle2.setText(storyList.get(1).getTitle());
                holder.mainStoryBody2.setText(storyList.get(1).getBody());
                break;
            case 1:
                holder.mainStoryImage1.setImageResource(storyList.get(2).getImage());
                holder.mainStoryTitle1.setText(storyList.get(2).getTitle());
                holder.mainStoryBody1.setText(storyList.get(2).getBody());
                holder.mainStoryImage2.setImageResource(storyList.get(3).getImage());
                holder.mainStoryTitle2.setText(storyList.get(3).getTitle());
                holder.mainStoryBody2.setText(storyList.get(3).getBody());
                break;
            case 2:
                holder.mainStoryImage1.setImageResource(storyList.get(4).getImage());
                holder.mainStoryTitle1.setText(storyList.get(4).getTitle());
                holder.mainStoryBody1.setText(storyList.get(4).getBody());
                holder.mainStoryImage2.setImageResource(storyList.get(5).getImage());
                holder.mainStoryTitle2.setText(storyList.get(5).getTitle());
                holder.mainStoryBody2.setText(storyList.get(5).getBody());
                break;
            case 3:
                holder.mainStoryImage1.setImageResource(storyList.get(6).getImage());
                holder.mainStoryTitle1.setText(storyList.get(6).getTitle());
                holder.mainStoryBody1.setText(storyList.get(6).getBody());
                holder.mainStoryImage2.setImageResource(storyList.get(7).getImage());
                holder.mainStoryTitle2.setText(storyList.get(7).getTitle());
                holder.mainStoryBody2.setText(storyList.get(7).getBody());
            break;
        }








    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MainStoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView mainStoryImage1, mainStoryImage2;
        TextView mainStoryTitle1, mainStoryTitle2, mainStoryBody1, mainStoryBody2;
        OnMainStoryListener onMainStoryListener;
        public MainStoryViewHolder(@NonNull View itemView, OnMainStoryListener onMainStoryListener) {
            super(itemView);
            mainStoryImage1 = itemView.findViewById(R.id.mainStoryImage1);
            mainStoryImage2 = itemView.findViewById(R.id.mainStoryImage2);
            mainStoryTitle1 = itemView.findViewById(R.id.mainStoryTitle1);
            mainStoryTitle2 = itemView.findViewById(R.id.mainStoryTitle2);
            mainStoryBody1 = itemView.findViewById(R.id.mainStoryBody1);
            mainStoryBody2 = itemView.findViewById(R.id.mainStoryBody2);
            this.onMainStoryListener = onMainStoryListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onMainStoryListener.onMainStoryClick(getAdapterPosition());
        }
    }

    public interface OnMainStoryListener{
        void onMainStoryClick(int position);
    }
}
