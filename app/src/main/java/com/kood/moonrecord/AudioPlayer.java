package com.kood.moonrecord;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mPlayer;
    private int currentPosition;

    public void play(Context context){
        stop();//prevents the creation of multiple instances of MediaPlayer
        // if the user clicks the Play button twice

        mPlayer = MediaPlayer.create(context,R.raw.one_small_step);
        mPlayer.setOnCompletionListener(mp -> {
            stop();//as the file has finished playing
            //releases your hold on the MediaPlayer instance as soon as you no longer need it.

        });//To enforce keep exactly one MediaPlayer around
        // and keep it around only as long as it is playing something
        /*if(currentPosition != 0){
            mPlayer.seekTo(currentPosition);
            mPlayer.start();
        }*/
        mPlayer.start();
    }
    public void pause(){
        if(mPlayer!=null){
            currentPosition= mPlayer.getCurrentPosition();
            mPlayer.pause();
        }
    }
    public void stop(){
        if(mPlayer!=null){
            mPlayer.release();
            mPlayer=null;
        }

    }/*Destruction is an aggressive interpretation of “stop”,
         but there is good reason to be aggressive.
         MediaPlayer will hold on to the audio decoder hardware and other system resources
         until you call release().
         These resources are shared across all apps.
         The MediaPlayer class includes a stop() method.
         It puts your MediaPlayer instance in a stopped state,
         from which it can eventually be restarted.
         However, in simple audio playback,
         it is better citizenship to destroy the instance with release()
         and then recreate it later*/
}
