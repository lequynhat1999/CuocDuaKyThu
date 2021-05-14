package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewValue;
    ImageButton btnPlay;
    CheckBox checkBoxOne, checkBoxTwo, checkBoxThree;
    SeekBar seekBarOne, seekBarTwo, seekBarThree;
    int value = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        textViewValue.setText(value + "");

        CountDownTimer countDownTimer = new CountDownTimer(5000,10) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 2;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                if(seekBarOne.getProgress() >= seekBarOne.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Player One Win", Toast.LENGTH_SHORT).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(checkBoxOne.isChecked())
                    {
                        value += 10;
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        value -= 5;
                        Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
                    }
                    textViewValue.setText(value +"");
                    checkBoxOne.setChecked(false);
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                    enableCheckBox();

                }
                if(seekBarTwo.getProgress() >= seekBarTwo.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Player Two Win", Toast.LENGTH_SHORT).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(checkBoxTwo.isChecked())
                    {
                        value += 10;
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        value -= 5;
                        Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
                    }
                    textViewValue.setText(value +"");
                    checkBoxOne.setChecked(false);
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                    enableCheckBox();

                }
                if(seekBarThree.getProgress() >= seekBarThree.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Player Three Win", Toast.LENGTH_SHORT).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(checkBoxThree.isChecked())
                    {
                        value += 10;
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        value -= 5;
                        Toast.makeText(MainActivity.this, "You lose", Toast.LENGTH_SHORT).show();
                    }
                    textViewValue.setText(value +"");
                    checkBoxOne.setChecked(false);
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                    enableCheckBox();
                }
                seekBarOne.setProgress(seekBarOne.getProgress() + one);
                seekBarTwo.setProgress(seekBarTwo.getProgress() + two);
                seekBarThree.setProgress(seekBarThree.getProgress() + three);

            }

            @Override
            public void onFinish() {

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxOne.isChecked() || checkBoxTwo.isChecked() || checkBoxThree.isChecked())
                {
                    seekBarOne.setProgress(0);
                    seekBarTwo.setProgress(0);
                    seekBarThree.setProgress(0);

                    btnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    disableCheckBox();
                    disableSeekBar();
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui long` dat. cuoc. truoc' khi choi", Toast.LENGTH_SHORT).show();
                }

            }
        });

        checkBoxOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });

        checkBoxTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    checkBoxOne.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });

        checkBoxThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    checkBoxTwo.setChecked(false);
                    checkBoxOne.setChecked(false);
                }
            }
        });
    }

    private  void enableCheckBox()
    {
        checkBoxOne.setEnabled(true);
        checkBoxTwo.setEnabled(true);
        checkBoxThree.setEnabled(true);
    }

    private  void disableCheckBox()
    {
        checkBoxOne.setEnabled(false);
        checkBoxTwo.setEnabled(false);
        checkBoxThree.setEnabled(false);
    }

    private  void enableSeekBar()
    {
        seekBarOne.setEnabled(true);
        seekBarTwo.setEnabled(true);
        seekBarThree.setEnabled(true);
    }

    private void disableSeekBar()
    {
        seekBarOne.setEnabled(false);
        seekBarTwo.setEnabled(false);
        seekBarThree.setEnabled(false);
    }


    private void mapping(){
        textViewValue = (TextView) findViewById(R.id.textviewValue);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        checkBoxOne = (CheckBox) findViewById(R.id.checkboxOne);
        checkBoxTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        checkBoxThree = (CheckBox) findViewById(R.id.checkboxThree);
        seekBarOne = (SeekBar) findViewById(R.id.seekBarOne);
        seekBarTwo = (SeekBar) findViewById(R.id.seekBarTwo);
        seekBarThree = (SeekBar) findViewById(R.id.seekBarThree);
    }
}