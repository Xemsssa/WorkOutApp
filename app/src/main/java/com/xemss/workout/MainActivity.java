package com.xemss.workout;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: 05.10.2017 find fragment for activity 
//        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_fragment);

//        fragment.setWorkoutId(1);
    }

    @Override
    public void itemClicked(long id) {
        // TODO: 06.10.2017 check if tablet
        View fragmentContainer = findViewById(R.id.frame_layout);
        if (fragmentContainer !=  null){
            // TODO: 06.10.2017 create new fragment
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
            // TODO: 06.10.2017 Get access to operate with fragment
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            // TODO: 06.10.2017 get needed detaill
            workoutDetailFragment.setWorkoutId(id);

//      // TODO: 06.10.2017 replace default layout with detail of selected item
            fragmentTransaction.replace(R.id.frame_layout, workoutDetailFragment);
            // TODO: 06.10.2017 backtrack
            fragmentTransaction.addToBackStack(null);
//      // TODO: 06.10.2017 update fragment with animation
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}
