package com.xemss.workout;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        } else {
            // TODO: 06.10.2017 didn't work transaction
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
//        StopwatchFragment stopwatchFragment = new com.xemss.workout.StopwatchFragment();

            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, stopwatchFragment);
//        fragmentTransaction.replace(R.id.frame_layout, com.xemss.workout.StopwatchFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        // TODO: 05.10.2017 get data from activity
        View view = getView();
        if (view != null) {
            TextView title = view.findViewById(R.id.textTitle);
            TextView desc = view.findViewById(R.id.textDesc);

            Workout workout = Workout.workouts[(int) workoutId];

            // TODO: 05.10.2017 set text to needed workout
            title.setText(workout.getName());
            desc.setText(workout.getDesc());
        }
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong("workoutId", workoutId);
    }
}