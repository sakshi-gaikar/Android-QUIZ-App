package com.example.quiz;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView optionA, optionB, optionC, optionD;
    private TextView queno, que, score;
    private TextView check1, check2;
    int currentindex;
    int mscore = 0;
    int qn = 1;
    ProgressBar progressBar;

    int currentque, currentoptionA, currentoptionB, currentoptionC, currentoptionD;

    private ansclass[] quebank = new ansclass[]
            {

                    new ansclass(R.string.que1, R.string.que1_A, R.string.que1_B, R.string.que1_C, R.string.que1_D, R.string.ans_1),
                    new ansclass(R.string.que2, R.string.que2_A, R.string.que2_B, R.string.que2_C, R.string.que2_D, R.string.ans_2),
                    new ansclass(R.string.que3, R.string.que3_A, R.string.que3_B, R.string.que3_C, R.string.que3_D, R.string.ans_3),
                    new ansclass(R.string.que4, R.string.que4_A, R.string.que4_B, R.string.que4_C, R.string.que4_D, R.string.ans_4),
                    new ansclass(R.string.que5, R.string.que5_A, R.string.que5_B, R.string.que5_C, R.string.que5_D, R.string.ans_5),
                    new ansclass(R.string.que6, R.string.que6_A, R.string.que6_B, R.string.que6_C, R.string.que6_D, R.string.ans_6),
                    new ansclass(R.string.que7, R.string.que7_A, R.string.que7_B, R.string.que7_C, R.string.que7_D, R.string.ans_7),
                    new ansclass(R.string.que8, R.string.que8_A, R.string.que8_B, R.string.que8_C, R.string.que8_D, R.string.ans_8),
                    new ansclass(R.string.que9, R.string.que9_A, R.string.que9_B, R.string.que9_C, R.string.que9_D, R.string.ans_9),
                    new ansclass(R.string.que10, R.string.que10_A, R.string.que10_B, R.string.que10_C, R.string.que10_D, R.string.ans_10),


            };
    final int PROGRESS_BAR = (int) Math.ceil(100 / quebank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        que = findViewById(R.id.question);
        score = findViewById(R.id.score);
        queno = findViewById(R.id.questionNumber);

        check1 = findViewById(R.id.selectedOption);
        check2 = findViewById(R.id.correctOption);
        progressBar = findViewById(R.id.progress_bar);

        currentque = quebank[currentindex].getQueID();
        que.setText(currentque);

        currentoptionA = quebank[currentindex].getOptionA();
        optionA.setText(currentoptionA);
        currentoptionB = quebank[currentindex].getOptionB();
        optionB.setText(currentoptionB);
        currentoptionC = quebank[currentindex].getOptionC();
        optionC.setText(currentoptionC);
        currentoptionD = quebank[currentindex].getOptionD();
        optionD.setText(currentoptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentoptionA);
                updateQuestion();
            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentoptionB);
                updateQuestion();

            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentoptionC);
                updateQuestion();

            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentoptionD);
                updateQuestion();

            }
        });


    }

    private void checkAnswer(int userselection) {
        int correctanswer = quebank[currentindex].getAnsID();
        check1.setText(userselection);
        check2.setText(correctanswer);

        String m = check1.getText().toString().trim();
        String n = check2.getText().toString().trim();

        if (m.equals(n)) {
            Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            mscore = mscore + 1;
        } else {
            Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateQuestion() {
        currentindex = (currentindex + 1) % quebank.length;
        if (currentindex==0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Quiz over");
            alert.setCancelable(false);
            alert.setMessage("view score:" + mscore + "points");
            alert.setPositiveButton("close application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore = 0;
                    qn = 1;
                    progressBar.setProgress(0);
                    score.setText("score" + mscore + "/" + quebank.length);
                    queno.setText(qn + "/" + quebank.length + "Question");
                }
            });
            alert.show();
        }

        currentque = quebank[currentindex].getQueID();
        que.setText(currentque);
        currentoptionA = quebank[currentindex].getOptionA();
        optionA.setText(currentoptionA);
        currentoptionB = quebank[currentindex].getOptionB();
        optionB.setText(currentoptionB);
        currentoptionC = quebank[currentindex].getOptionC();
        optionC.setText(currentoptionC);
        currentoptionD = quebank[currentindex].getOptionD();
        optionD.setText(currentoptionD);

        qn = qn + 1;
        if (qn <= quebank.length) {
            queno.setText(qn + "/" + quebank.length + "Question");
        }
        score.setText("score" + mscore + "/" + quebank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);

    }
}