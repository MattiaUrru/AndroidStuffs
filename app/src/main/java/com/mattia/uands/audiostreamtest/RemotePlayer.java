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

public class RemotePlayer {

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

            }
        }

    }



}
