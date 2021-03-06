package com.droyder.quizder;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.*;
import android.widget.*;

import androidx.annotation.NonNull;


public class MainActivity extends Activity {
    int Index;
    final int PROGRESS_BAR_INCREMENT;
    ProgressBar ProgressBar;
    TextView QuestionTextView;
    TextView ScoreTextView;
    Toast ToastMessage;
    Builder alert;
    boolean lastAnswer;
    private TrueFalse[] mQuestionBank = {new TrueFalse(R.string.question_1, true), new TrueFalse(R.string.question_2, true), new TrueFalse(R.string.question_3, true), new TrueFalse(R.string.question_4, true), new TrueFalse(R.string.question_5, true), new TrueFalse(R.string.question_6, false), new TrueFalse(R.string.question_7, true), new TrueFalse(R.string.question_8, false), new TrueFalse(R.string.question_9, true), new TrueFalse(R.string.question_10, true), new TrueFalse(R.string.question_11, false), new TrueFalse(R.string.question_12, false), new TrueFalse(R.string.question_13, true)};
    int score=0;

    public MainActivity() {
        double length = this.mQuestionBank.length;
        this.PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0d / length);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            this.score = savedInstanceState.getInt("Score");
            this.Index = savedInstanceState.getInt("Index");
        } else {
            this.Index = 0;
            this.score = 0;
        }
        this.QuestionTextView = findViewById(R.id.question_text_view);
        this.ScoreTextView =  findViewById(R.id.score);
        this.ProgressBar =  findViewById(R.id.progress_bar);
        updateScore();
        this.QuestionTextView.setText(this.mQuestionBank[this.Index].getQid());
        findViewById(R.id.true_button).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Log.d("Quiz", "True Button Pressed!");
                MainActivity.this.checkAnswer(true);
                MainActivity.this.updateQuestion(view);
            }
        });
        findViewById(R.id.false_button).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Log.d("Quiz", "False Button Pressed!");
                MainActivity.this.checkAnswer(false);
                MainActivity.this.updateQuestion(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateQuestion(final View view) {
        this.Index = (this.Index + 1) % 13;
        if (this.Index == 0) {
            this.alert = new Builder(this);
            this.alert.setCancelable(false);
            this.alert.setTitle("Game Over");
            Builder builder = this.alert;
            String s = "You Scored : ";
            s+=score;
            builder.setMessage(s);
            this.alert.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.this.finish();
                }
            });
            this.alert.setNegativeButton("Replay Game", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.this.reset(view);
                }
            });
            this.alert.show();
        }
        updateScore();
        this.ProgressBar.incrementProgressBy(this.PROGRESS_BAR_INCREMENT);
        this.QuestionTextView.setText(this.mQuestionBank[this.Index].getQid());
    }

    public void undo(View view) {
        int i = this.Index;
        if (i == 0) {
            showToast("Undo Not Possible");
            return;
        }
        this.Index = (i - 1) % 13;
        this.QuestionTextView.setText(this.mQuestionBank[this.Index].getQid());
        showToast("Undo");
        this.ProgressBar.incrementProgressBy(-this.PROGRESS_BAR_INCREMENT);
        if (this.lastAnswer) {
            this.score--;
        }

    }

    public void reset(View view) {
        this.score = 0;
        this.Index = 0;
        this.QuestionTextView.setText(this.mQuestionBank[this.Index].getQid());
        showToast("Reset");
        updateScore();
        ProgressBar progressBar = this.ProgressBar;
        progressBar.incrementProgressBy(-progressBar.getProgress());
    }

    /* access modifiers changed from: private */
    public void checkAnswer(boolean userSelection) {
        boolean correctAnswer = this.mQuestionBank[this.Index].isAnswer();
        if (userSelection == correctAnswer) {
            showToast(R.string.correct_toast);
            this.score++;
            this.lastAnswer = true;
        } else {
            showToast(R.string.incorrect_toast);
            this.lastAnswer = false;
        }
    }

    public void skip(View view) {
        showToast("Question Skipped");
        updateQuestion(view);
    }

    public void showToast(String s)
    {
        Toast toast = this.ToastMessage;
        if (toast != null) {
            toast.cancel();
        }
        ToastMessage = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
        ToastMessage.show();
    }

    public void showToast(int s)
    {
        Toast toast = this.ToastMessage;
        if (toast != null) {
            toast.cancel();
        }
        ToastMessage = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
        ToastMessage.show();
    }

    public void updateScore()
    {
        TextView textView = this.ScoreTextView;
        String s = "Score : ";
        s+=score+"/13";
        textView.setText(s);
    }

    /* access modifiers changed from: protected */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("Score", this.score);
        outState.putInt("Index", this.Index);
    }
}
