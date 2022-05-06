package com.example.task51c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StoryAdapter.OnStoryListener, MainStoriesAdapter.OnMainStoryListener {

    List<Story> storyList = new ArrayList<>();
    Integer[] images = {R.drawable.beer, R.drawable.puppy, R.drawable.circus, R.drawable.construction, R.drawable.scomo, R.drawable.ukraine, R.drawable.energy, R.drawable.reciept};
    String[] titles = {"Beer Festival!", "Puppies for Adoption!", "Circus Tickets Sale!", "Handymen in Demand!", "What did he say!?", "Live Updates!", "See how you can save $$", "Government Refunds!"};
    String[] bodys = {"Beer Festival comes to Melbourne July 11th!", "Dozens of puppies up for Adoption in Geelong!", "The Circus is Here!", "Big spike in need to tradesmen", "Premier spoke this morning and what was that he said!? ", "Live updates from the field!", "Learn how you can save hundreds on your energy bills!", "Government refunding to speed up economic recovery!"};

    RecyclerView recylerView, mainStoriesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<images.length; i++)
        {
            Story story = new Story(titles[i], bodys[i], i, images[i]);
            storyList.add(story);
        }


//        Fragment fragment;
//        fragment = new NewsFragment();
//
//

        recylerView = findViewById(R.id.TopStoriesRecyclerView);
        StoryAdapter storyAdapter = new StoryAdapter(getApplicationContext(), storyList, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recylerView.setLayoutManager(layoutManager);
        recylerView.setAdapter(storyAdapter);

        mainStoriesRecyclerView = findViewById(R.id.mainStoryRecyclerView);
        MainStoriesAdapter mainStoriesAdapter = new MainStoriesAdapter(storyList, getApplicationContext(), this);

        RecyclerView.LayoutManager mainstoryLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mainStoriesRecyclerView.setLayoutManager(mainstoryLayoutManager);
        mainStoriesRecyclerView.setAdapter(mainStoriesAdapter);


    }

    @Override
    public void onStoryClick(int position) {
        Toast.makeText(this, "you clicked a view", Toast.LENGTH_SHORT).show();
        Fragment fragment = null;
        switch(position)
        {
            case 0:
                fragment = new beer_fragment();
                break;
            case 1:
                fragment = new puppy_fragment();
                break;
            case 2:
                fragment = new circus_fragment();
                break;
            case 3:
                fragment = new construction_fragment();
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment).commit();

    }

    @Override
    public void onMainStoryClick(int position) {
        Fragment fragment = null;
        switch(position)
        {
            case 0:
                fragment = new beer_fragment();
                break;
            case 1:
                fragment = new puppy_fragment();
                break;
            case 2:
                fragment = new circus_fragment();
                break;
            case 3:
                fragment = new construction_fragment();
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment).commit();
    }
}