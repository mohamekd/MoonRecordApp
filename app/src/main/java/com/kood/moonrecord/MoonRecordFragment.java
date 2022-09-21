package com.kood.moonrecord;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MoonRecordFragment extends Fragment {
    private Button playAudioBtn;
    //private Button pauseAudioBtn;
    private Button stopAudioBtn;

    private AudioPlayer mAudioPlayer = new AudioPlayer();;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);//Keep in mind, If your activity is destroyed because the OS needs to reclaim memory,
        // then all your retained fragments are destroyed too

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_moon_record,null,false);
        playAudioBtn = v.findViewById(R.id.play_audio_btn);
        playAudioBtn.setOnClickListener(v1 -> {
            mAudioPlayer.play(getActivity());
        });
//        pauseAudioBtn = v.findViewById(R.id.pause_audio_btn);
//        pauseAudioBtn.setOnClickListener(v1 -> {
//            mAudioPlayer.pause();
//        });
        stopAudioBtn = v.findViewById(R.id.stop_audio_btn);
        stopAudioBtn.setOnClickListener(v1 -> {
            mAudioPlayer.stop();
        });
        return v;
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        mAudioPlayer.pause();
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAudioPlayer.stop();//prevent the MediaPlayer from continuing playback
        // after the fragment has been destroyed
    }
}
