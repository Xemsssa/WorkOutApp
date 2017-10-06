package com.xemss.workout;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutListFragment extends ListFragment {
    // TODO: 05.10.2017 create interface
    static interface WorkoutListListener {
        void itemClicked(long id);
    }
    
    private WorkoutListListener listener;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // TODO: 05.10.2017 create array to save names
        String[] names = new String[Workout.workouts.length];
        
        for (int i = 0; i < names.length; i++ ) {
            // TODO: 05.10.2017 get names
            names[i] = Workout.workouts[i].getName();
        }

        // TODO: 05.10.2017 create adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                // TODO: 05.10.2017 when you use adapters in fragment
//                you need to use getContext() not "this"
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                names);

        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        this.listener = (WorkoutListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            // TODO: 05.10.2017 if item click get ID 
            listener.itemClicked(id);
        }
    }
}

