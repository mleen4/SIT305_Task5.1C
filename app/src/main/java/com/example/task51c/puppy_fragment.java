package com.example.task51c;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link puppy_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class puppy_fragment extends Fragment {

    RecyclerView puppyRecycleView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public puppy_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment puppy_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static puppy_fragment newInstance(String param1, String param2) {
        puppy_fragment fragment = new puppy_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Used this to help adding the recycler View! https://medium.com/swlh/create-recyclerview-in-android-fragment-c0f0b151125f
        View view = inflater.inflate(R.layout.fragment_puppy_fragment, container, false);

        puppyRecycleView = view.findViewById(R.id.puppyRecyclerView);
        puppyRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));


        puppyRecycleView.setAdapter(new MainStoriesAdapter(addData(), getActivity().getApplicationContext(), (MainStoriesAdapter.OnMainStoryListener) getContext()));

        return view;
    }

    private List<Story> addData()
    {
        List<Story> storyList = new ArrayList<>();

        Integer[] images = {R.drawable.beer, R.drawable.puppy, R.drawable.circus, R.drawable.construction, R.drawable.scomo, R.drawable.ukraine, R.drawable.energy, R.drawable.reciept};
        String[] titles = {"Beer Festival!", "Puppies for Adoption!", "Circus Tickets Sale!", "Handymen in Demand!", "What did he say!?", "Live Updates!", "See how you can save $$", "Government Refunds!"};
        String[] bodys = {"Beer Festival comes to Melbourne July 11th!", "Dozens of puppies up for Adoption in Geelong!", "The Circus is Here!", "Big spike in need to tradesmen", "Premier spoke this morning and what was that he said!? ", "Live updates from the field!", "Learn how you can save hundreds on your energy bills!", "Government refunding to speed up economic recovery!"};
        for(int i = 0; i<images.length; i++)
        {
            Story story = new Story(titles[i], bodys[i], i, images[i]);
            storyList.add(story);
        }

        return storyList;
    }
}