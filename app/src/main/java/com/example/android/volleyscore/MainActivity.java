package com.example.android.volleyscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA,scoreTeamB,setsTeamA, setsTeamB, nsets = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment1_teamA(View view) {
        int compTeamB = scoreTeamB+1;
        if (scoreTeamA >= 24 && compTeamB <= scoreTeamA && scoreTeamB != scoreTeamA){
            scoreTeamA += 1;
            nsets+=1;
            historico();
            increment_set_teamA();
            scoreTeamA = 0;
            scoreTeamB = 0;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
        }else{
            scoreTeamA += 1;
            displayForTeamA(scoreTeamA);
        }
    }
    public void increment1_teamB(View view) {
        int compTeamA = scoreTeamA+1;
        if (scoreTeamB >= 24 && compTeamA <= scoreTeamB && scoreTeamB != scoreTeamA){
            scoreTeamB += 1;
            nsets+=1;
            historico();
            increment_set_teamB();
            scoreTeamA = 0;
            scoreTeamB = 0;
            displayForTeamA(scoreTeamB);
            displayForTeamB(scoreTeamB);
        }else{
            scoreTeamB += 1;
            displayForTeamB(scoreTeamB);
        }

    }
    public void increment_set_teamA() {
        setsTeamA += 1;
        displaySetsForTeamA();
    }
    public void increment_set_teamB() {
        setsTeamB += 1;
        displaySetsForTeamB();
    }
    public void displayForTeamA(int scoreTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.txt_teamA_points);
        scoreView.setText(String.valueOf(scoreTeamA));
    }
    public void displayForTeamB(int scoreTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.txt_teamB_points);
        scoreView.setText(String.valueOf(scoreTeamB));
    }
    public void displaySetsForTeamA() {
        TextView setView = (TextView) findViewById(R.id.txt_teamA_sets);
        setView.setText(String.valueOf(setsTeamA));
    }
    public void displaySetsForTeamB() {
        TextView setView = (TextView) findViewById(R.id.txt_teamB_sets);
        setView.setText(String.valueOf(setsTeamB));
    }
    public void restart(View view) {
        nsets=0;
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        setsTeamA = 0;
        setsTeamB = 0;
        displaySetsForTeamA();
        displaySetsForTeamB();
        historico();
        String team=getString(R.string.team);
        TextView teamAName = (TextView) findViewById(R.id.txt_hTeamAName);
        teamAName.setText(team);
        TextView teamBName = (TextView) findViewById(R.id.txt_nTeamBName);
        teamBName.setText(team);
        TextView tv = (TextView)findViewById(R.id.txtpoints);
        tv.setVisibility(View.INVISIBLE);
        TableLayout table = (TableLayout)findViewById(R.id.table);
        table.setVisibility(View.INVISIBLE);
    }

    public void historico(){
        TextView set1_teamA_points = (TextView) findViewById(R.id.txt_set1_teamA);
        TextView set1_teamB_points = (TextView) findViewById(R.id.txt_set1_teamB);
        TextView set2_teamA_points = (TextView) findViewById(R.id.txt_set2_teamA);
        TextView set2_teamB_points = (TextView) findViewById(R.id.txt_set2_teamB);
        TextView set3_teamA_points = (TextView) findViewById(R.id.txt_set3_teamA);
        TextView set3_teamB_points = (TextView) findViewById(R.id.txt_set3_teamB);
        TextView set4_teamA_points = (TextView) findViewById(R.id.txt_set4_teamA);
        TextView set4_teamB_points = (TextView) findViewById(R.id.txt_set4_teamB);
        TextView set5_teamA_points = (TextView) findViewById(R.id.txt_set5_teamA);
        TextView set5_teamB_points = (TextView) findViewById(R.id.txt_set5_teamB);
        if (nsets==1){
            set1_teamA_points.setText(String.valueOf(scoreTeamA));
            set1_teamB_points.setText(String.valueOf(scoreTeamB));
        }else if (nsets==2){
            set2_teamA_points.setText(String.valueOf(scoreTeamA));
            set2_teamB_points.setText(String.valueOf(scoreTeamB));
        }else if (nsets==3){
            set3_teamA_points.setText(String.valueOf(scoreTeamA));
            set3_teamB_points.setText(String.valueOf(scoreTeamB));
        }else if (nsets==4){
            set4_teamA_points.setText(String.valueOf(scoreTeamA));
            set4_teamB_points.setText(String.valueOf(scoreTeamB));
        }else if (nsets==5){
            set5_teamA_points.setText(String.valueOf(scoreTeamA));
            set5_teamB_points.setText(String.valueOf(scoreTeamB));
        }else if (nsets==0){
            set1_teamA_points.setText(String.valueOf(scoreTeamA));
            set1_teamB_points.setText(String.valueOf(scoreTeamB));
            set2_teamA_points.setText(String.valueOf(scoreTeamA));
            set2_teamB_points.setText(String.valueOf(scoreTeamB));
            set3_teamA_points.setText(String.valueOf(scoreTeamA));
            set3_teamB_points.setText(String.valueOf(scoreTeamB));
            set4_teamA_points.setText(String.valueOf(scoreTeamA));
            set4_teamB_points.setText(String.valueOf(scoreTeamB));
            set5_teamA_points.setText(String.valueOf(scoreTeamA));
            set5_teamB_points.setText(String.valueOf(scoreTeamB));
        }
    }
    public void history(View view){
        TextView tv = (TextView)findViewById(R.id.txtpoints);
        tv.setVisibility(View.VISIBLE);
        TableLayout table = (TableLayout)findViewById(R.id.table);
        table.setVisibility(View.VISIBLE);

        //Get and set TeamA name on table
        EditText editTextTeamA = (EditText) findViewById(R.id.etxt_teamA_name);
        String teamA = String.valueOf(editTextTeamA.getText());
        TextView teamAName = (TextView) findViewById(R.id.txt_hTeamAName);
        teamAName.setText(teamA);

        //Get and set TeamB name on table
        EditText editTextTeamB = (EditText) findViewById(R.id.etxt_teamB_name);
        String teamB = String.valueOf(editTextTeamB.getText());
        TextView teamBName = (TextView) findViewById(R.id.txt_nTeamBName);
        teamBName.setText(teamB);


    }
}