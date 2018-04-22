package com.Siento.musicplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;
import java.util.ArrayList;

public class OnlineStream extends AppCompatActivity {
    private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
    RecyclerView recyclerView;
    SongAdapter songAdapter;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    private Handler myHandler= new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_stream);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        seekBar=(SeekBar) findViewById(R.id.seekBar2);
        SongInfo s=new SongInfo("A Sky Full of Stars","ColdPlay","https://github.com/chinmaykodag/Dump/blob/master/Songs/A%20Sky%20Full%20of%20Stars.mp3?raw=true");
        _songs.add(s);
        SongInfo s1=new SongInfo("Blood Sweat and Tears","BTS","https://github.com/chinmaykodag/Dump/blob/master/Songs/Blood%20Sweat%20&%20Tears.mp3?raw=true");
        _songs.add(s1);
        SongInfo s2=new SongInfo("Papaoutai","Stromae","https://github.com/chinmaykodag/Dump/blob/master/Songs/Papaoutai.mp3?raw=true");
        _songs.add(s2);
        SongInfo s3=new SongInfo("River Flows In You","Yiruma","https://github.com/chinmaykodag/Dump/blob/master/Songs/River%20Flows%20In%20You.mp3?raw=true");
        _songs.add(s3);
        SongInfo s4=new SongInfo("Treasure","Bruno Mars","https://github.com/chinmaykodag/Dump/blob/master/Songs/Treasure.mp3?raw=true");
        _songs.add(s4);
        SongInfo s5=new SongInfo("Castle of Glass","Linkin Park","https://github.com/chinmaykodag/Dump/blob/master/Songs/Castle%20of%20Glass.mp3?raw=true");
        _songs.add(s5);
        SongInfo s6=new SongInfo("We Are Young","Fun","https://github.com/chinmaykodag/Dump/blob/master/Songs/We%20are%20young%20ft.%20Janelle%20Monae.mp3?raw=true");
        _songs.add(s6);
        SongInfo s7=new SongInfo("Boulevard of Broken Dreams","Green Day","https://github.com/chinmaykodag/Dump/blob/master/Songs/Boulevard%20Of%20Broken%20Dreams.mp3?raw=true");
        _songs.add(s7);
        SongInfo s8=new SongInfo("Counting Stars","One Republic","https://github.com/chinmaykodag/Dump/blob/master/Songs/Counting%20Stars.mp3?raw=true");
        _songs.add(s8);
        SongInfo s9=new SongInfo("Demons","Imagine Dragons","https://github.com/chinmaykodag/Dump/blob/master/Songs/Demons.mp3?raw=true");
        _songs.add(s9);
        SongInfo s10=new SongInfo("Maps","Maroon 5","https://github.com/chinmaykodag/Dump/blob/master/Songs/Maps.mp3?raw=true");
        _songs.add(s10);
        SongInfo s11=new SongInfo("Titanium","David Guetta ft Sia","https://github.com/chinmaykodag/Dump/blob/master/Songs/Titanium.mp3?raw=true");
        _songs.add(s11);

        songAdapter = new SongAdapter(this,_songs);

        recyclerView.setAdapter(songAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        songAdapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final Button b, View view, final SongInfo obj, int position) {
                if(b.getText().equals("Stop")){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    b.setText("Play");
                }else {

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                mediaPlayer = new MediaPlayer();
                                mediaPlayer.setDataSource(obj.getSongUrl());
                                mediaPlayer.prepareAsync();
                                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mp) {
                                        mp.start();
                                        seekBar.setProgress(0);
                                        seekBar.setMax(mediaPlayer.getDuration());
                                        Log.d("Prog", "run: " + mediaPlayer.getDuration());
                                    }
                                });
                                b.setText("Stop");



                            }catch (Exception e){}
                        }

                    };
                    myHandler.postDelayed(runnable,100);

                }
            }
        });

    }
}
