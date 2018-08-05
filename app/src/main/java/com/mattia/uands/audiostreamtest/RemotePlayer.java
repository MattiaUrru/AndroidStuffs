/*
   RemotePlayer - Mattia Urru

   Used to play audio from a remote source (eg. an Icecast/Shoutcast server)

   Requires
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />


 */


package com.mattia.uands.audiostreamtest;

import android.media.MediaPlayer;
import android.media.AudioManager;
import java.io.IOException;
import android.util.Log;


public class RemotePlayer {

    private PlayerThread t_play;

    //Player Thread class
    private class PlayerThread extends Thread {

        private String source_url;
        private MediaPlayer mp;

        public PlayerThread( String url ) {
            mp = new MediaPlayer();
            source_url = url;
        }

        @Override
        public void run() {

            try {
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mp.setDataSource(source_url);

                mp.prepare();
                mp.start();
            } catch(IOException e) {
                Log.e("PLAYER","Unable to play source");
                System.exit(-1);
            }
        }

    }

    public RemotePlayer( String url ) { t_play = new PlayerThread(url); }

    public void play() { t_play.start(); }

    public void stop() { t_play.interrupt(); }
}
