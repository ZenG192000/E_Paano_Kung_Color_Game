package com.example.epaanokungcolorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private View decorView;
    int status = 0;
    RadioGroup RGD1;
    int data = 0;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer3.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer3.pause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow(). addFlags (android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if(i == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });

        TextView txtView1 = findViewById(R.id.txtView1);
        Button btnRandom = findViewById(R.id.btnRandom);
        TextView txtView2 = findViewById(R.id.txtResult2);
        TextView txtCount = findViewById(R.id.txtCount2);
        mediaPlayer = MediaPlayer.create(this, R.raw.wow_congratulations);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.talo);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.e_paano_kung);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.drum_roll);
        txtView1.setBackgroundResource(R.drawable.epaano);
        mediaPlayer3.setLooping(true);
        if(mediaPlayer3.isPlaying()) {
            mediaPlayer3.stop();
        }else {
            mediaPlayer3.start();
        }

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRandom.setEnabled(false);
                txtView2.setText("");
                mediaPlayer3.pause();
                mediaPlayer2.start();
                new CountDownTimer(10000, 50) {
                    @Override
                    public void onTick(long l) {
                        RGD1 = (RadioGroup) findViewById(R.id.RGD1);
                        Random rand = new Random();
                        status = rand.nextInt(4) + 1;
                        if (status == 1) {
                            txtView1.setBackgroundResource(R.color.pink);
                        } else if (status == 2) {
                            txtView1.setBackgroundResource(R.color.blue);
                        } else if (status == 3) {
                            txtView1.setBackgroundResource(R.color.red);
                        } else {
                            txtView1.setBackgroundResource(R.color.green);
                        }
                        data = status;

                    }

                    @Override
                    public void onFinish() {
                        txtView1.getBackground();
                        mediaPlayer2.pause();
                        if(RGD1.getCheckedRadioButtonId() == R.id.pink)
                        {
                            if(data == 1){
                                txtView2.setText("Your The Winner!");
                                mediaPlayer.start();
                            }
                            else if(data == 2){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 3){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 4){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                        }
                        else if (RGD1.getCheckedRadioButtonId() == R.id.blue)
                        {
                            if(data == 1){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 2){
                                txtView2.setText("Your The Winner!");
                                mediaPlayer.start();
                            }
                            else if(data == 3){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 4){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                        }
                        else if (RGD1.getCheckedRadioButtonId() == R.id.red)
                        {
                            if(data == 1){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 2){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 3){
                                txtView2.setText("Your The Winner!");
                                mediaPlayer.start();
                            }
                            else if(data == 4){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                        }
                        else if (RGD1.getCheckedRadioButtonId() == R.id.green)
                        {
                            if(data == 1){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 2){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 3){
                                txtView2.setText("You Lose!");
                                mediaPlayer1.start();
                            }
                            else if(data == 4){
                                txtView2.setText("Your The Winner!");
                                mediaPlayer.start();
                            }
                        }
                        new CountDownTimer(5000, 1000) {

                            public void onTick(long millisUntilFinished) {
                                txtCount.setText("Please wait...");
                            }

                            public void onFinish() {
                                txtCount.setText("");
                                txtView2.setText("");
                                btnRandom.setEnabled(true);
                                mediaPlayer3.start();
                                txtView1.setBackgroundResource(R.drawable.epaano);
                            }
                        }.start();
                    }
                }.start();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars() {
       return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
}