package com.example.dell.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends YouTubeBaseActivity {

    private static final String TAG = "MainActivity";

    YouTubePlayerView mYouTubePlayerView;

    Button answer1, answer2, answer3, answer4, buttonPlay;

    TextView score, question;

    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    private Questions mQuestions = new Questions();

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;
    private int count = 0;

    //Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: Starting.");

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done Initializing.");
                List<String> videoList = new ArrayList<>();
                videoList.add("IHNzOHi8sJs");
                videoList.add("iwd8N6K-sLk");
                videoList.add("x6QA3m58DQw");
                videoList.add("nM0xDI5R50E");
                videoList.add("MBdVXkSdhwU");
                videoList.add("nM0xDI5R50E");
                videoList.add("VvXVuWwAG90");
                videoList.add("FD2mik4V5EE");
                videoList.add("RyVS7R9PN6U");
                videoList.add("YwN-CN9EjTg");
                youTubePlayer.loadVideos(videoList);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed to Initialize.");
            }
        };
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Initialing YouTube Player.");
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializedListener);

            }
        });

        //r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);

        score.setText("Score:" + mScore);
        //updateQuestion(r.nextInt(mQuestionsLength));
        updateQuestion(count);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() != mAnswer) {
                    gameOver();
                }
                if (answer1.getText() == mAnswer) {
                    mScore += 10;
                    score.setText("Score:" + mScore);
                    if (mScore == 100) {
                        over();
                    } else {
                        count++;
                        updateQuestion(count);
                    }
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2.getText() != mAnswer) {
                    gameOver();
                }
                if (answer2.getText() == mAnswer) {
                    mScore += 10;
                    score.setText("Score:" + mScore);
                    if (mScore == 100) {
                        over();
                    } else {
                        count++;
                        updateQuestion(count);
                    }
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3.getText() != mAnswer) {
                    gameOver();
                }
                if (answer3.getText() == mAnswer) {
                    mScore += 10;
                    score.setText("Score:" + mScore);
                    if (mScore == 100) {
                        over();
                    } else {
                        count++;
                        updateQuestion(count);
                    }
                }
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4.getText() != mAnswer) {
                    gameOver();
                }
                if (answer4.getText() == mAnswer) {
                    mScore += 10;
                    score.setText("Score:" + mScore);
                    if (mScore == 100) {
                        over();
                    } else {
                        count++;
                        updateQuestion(count);
                    }
                }
            }
        });
    }

    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                startActivity(new Intent(getApplicationContext(),
                                        MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void over() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Congratulations! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("Play Again",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                startActivity(new Intent(getApplicationContext(),
                                        MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
