package com.xemss.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // TODO: 06.10.2017 operate with fragment 
        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment) 
                getFragmentManager().findFragmentById(R.id.detail_fragment);

        // TODO: 06.10.2017 get from intent what was clicked 
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        // TODO: 06.10.2017 show fragment with data 
        workoutDetailFragment.setWorkoutId(workoutId);
    }
}
