package com.xemss.workout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StopwatchFragment extends Fragment implements View.OnClickListener{
    // TODO: 06.10.2017 create var
    private int seconds = 0;
    private boolean isRunning;
    private boolean wasRunning;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_stopwatch);
        // TODO: 06.10.2017 check if we have saved state
        if (savedInstanceState != null) {
           seconds = savedInstanceState.getInt("seconds");
           isRunning = savedInstanceState.getBoolean("isRunning");
           wasRunning = savedInstanceState.getBoolean("wasRunning");

           if (wasRunning) {
               isRunning = true;
           }
        }

//        runTimer();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(inflate);

        // TODO: 06.10.2017 get views
        Button btnStart = (Button) inflate.findViewById(R.id.btnStart);
        Button btnStop = (Button) inflate.findViewById(R.id.btnStop);
        Button btnReset = (Button) inflate.findViewById(R.id.btnReset);

        // TODO: 06.10.2017 set on listeners
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        return inflate;
    }

    private void runTimer(View view) {
        final TextView timerView = (TextView) view.findViewById(R.id.timerView);
//        TextView timerView = (TextView) getFragmentManager().findFragmentById(R.id.timerView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                timerView.setText(time);

                if (isRunning) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = true;
        isRunning = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(wasRunning) {
            isRunning = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("isRunning", isRunning);
        outState.putBoolean("wasRunning", wasRunning);
    }

    // TODO: 06.10.2017 start count 
    public void startCount(View view) {
//        seconds = 0;
        isRunning = true;
    }

    // TODO: 06.10.2017 stop 
    public void stopCount(View view) {
        isRunning = false;
    }

    // TODO: 06.10.2017 if reset button click 
    public void resetCount(View view) {
        isRunning = false;
        seconds = 0;
    }

    // TODO: 06.10.2017 implement click listener 
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                startCount(v);
                break;
            case R.id.btnStop:
                stopCount(v);
                break;
            case R.id.btnReset:
                resetCount(v);
                break;
        }
    }
}
