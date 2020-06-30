package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonAdd, buttonSub, buttonDiv, buttonMulti, buttonEqual, buttonClear;

    double value1, value2, result;
    EditText screen;

    enum Calculation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }
    Calculation calc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMulti = (Button) findViewById(R.id.buttonMulti);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonClear = (Button) findViewById(R.id.buttonClear);


        screen = (EditText) findViewById(R.id.editText1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText() + "0");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Double.parseDouble(screen.getText().toString());
                calc = Calculation.ADDITION;
                screen.setText("");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Double.parseDouble(screen.getText().toString());
                calc = Calculation.SUBTRACTION;
                screen.setText("");
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Double.parseDouble(screen.getText().toString());
                calc = Calculation.MULTIPLICATION;
                screen.setText("");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Double.parseDouble(screen.getText().toString());
                calc = Calculation.DIVISION;
                screen.setText("");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value2 = Double.parseDouble(screen.getText().toString());
                switch(calc) {
                    case ADDITION:
                        screen.setText(value1 + value2 + "");
                        calc = null;
                        break;
                    case SUBTRACTION:
                        screen.setText(value1 - value2 + "");
                        calc = null;
                        break;
                    case MULTIPLICATION:
                        screen.setText(value1 * value2 + "");
                        calc = null;
                        break;
                    case DIVISION:
                        screen.setText(value1 / value2 + "");
                        calc = null;
                        break;
                }
            }
        });
    }
}