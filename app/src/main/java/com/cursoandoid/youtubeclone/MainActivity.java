package com.cursoandoid.youtubeclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView youTubePlayerView;
    private static final String GOOGLE_API_KEY = "AIzaSyBPoptUKU5sX8Ef7Xi0PDv_RX-HxZ5xk4I";

    private YouTubePlayer.PlaybackEventListener playbackEventListener;
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {
                Toast.makeText(MainActivity.this,
                        "Video carregando !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLoaded(String s) {
                Toast.makeText(MainActivity.this,
                        "Video carregado !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdStarted() {
                Toast.makeText(MainActivity.this,
                        "Propaganda iniciou !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(MainActivity.this,
                        "Video esta começando !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onVideoEnded() {
                Toast.makeText(MainActivity.this,
                        "Video chegou ao final !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {
                Toast.makeText(MainActivity.this,
                        "Erro ao recuperar eventos de carregamento !",
                        Toast.LENGTH_LONG).show();
            }
        };

        playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(MainActivity.this,
                        "Video execultando !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPaused() {
                Toast.makeText(MainActivity.this,
                        "Video pausado !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopped() {
                Toast.makeText(MainActivity.this,
                        "Video parado !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onBuffering(boolean b) {
                Toast.makeText(MainActivity.this,
                        "Video pre-carregando !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSeekTo(int i) {
                Toast.makeText(MainActivity.this,
                        "Movimentando Seekbar !",
                        Toast.LENGTH_LONG).show();
            }
        };
        youTubePlayerView = findViewById(R.id.viewYoutubePlayer);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean foiRestaurado) {
        Toast.makeText(this,
                "Sucesso ao execultar o player!",
                Toast.LENGTH_LONG).show();
        //youTubePlayer.loadVideo("HB_r9wn49Gc");
        Log.i("estado_player", "estado:" + foiRestaurado);
       // youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        if (!foiRestaurado) {
           // youTubePlayer.cueVideo("p9VR8KbmzEE");
            youTubePlayer.cuePlaylist("PLWz5rJ2EKKc9Ev7YfhQs3mlGh-tWKib_4");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,
                "Erro!" + youTubeInitializationResult.toString(),
                Toast.LENGTH_LONG).show();
    }
}