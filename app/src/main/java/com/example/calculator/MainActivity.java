package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonAdd, buttonSub, buttonDiv, buttonMulti, buttonEqual, buttonClear, buttonMod;

    double value1, value2;
    EditText screen;

    enum Calculation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        MODULO,
        NOTSELECTED,
        ERROR
    }

    Calculation calc = Calculation.NOTSELECTED;


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
        buttonMod = (Button) findViewById(R.id.buttonMod);


        screen = (EditText) findViewById(R.id.editText1);
        
        screen.setFocusable(false);
        screen.setFocusableInTouchMode(false);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              setNumber(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(9);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(0);
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
              calculate(Calculation.ADDITION);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(Calculation.SUBTRACTION);
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(Calculation.MULTIPLICATION);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(Calculation.DIVISION);
            }
        });

        buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(Calculation.MODULO);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(screen.getText().length() != 0 && calc != Calculation.ERROR) {
                    value2 = Double.parseDouble(screen.getText().toString());
                }
                switch(calc) {
                    case ADDITION:
                        screen.setText(value1 + value2 + "");
                        calc = Calculation.NOTSELECTED;
                        break;
                    case SUBTRACTION:
                        screen.setText(value1 - value2 + "");
                        calc = Calculation.NOTSELECTED;
                        break;
                    case MULTIPLICATION:
                        screen.setText(value1 * value2 + "");
                        calc = Calculation.NOTSELECTED;
                        break;
                    case DIVISION:
                        if(value2 == 0) {
                            screen.setText("Can't divide by zero");
                            calc = Calculation.ERROR;
                        } else {
                            screen.setText(value1 / value2 + "");
                            calc = Calculation.NOTSELECTED;
                        }
                        break;
                    case MODULO:
                        if(value2 == 0) {
                            screen.setText("Can't divide by Zero");
                            calc = Calculation.ERROR;
                        } else {
                            screen.setText(value1 % value2 + "");
                            calc = Calculation.NOTSELECTED;
                        }
                        break;
                    case NOTSELECTED:
                    case ERROR:
                        screen.setText("");
                        break;
                }
            }
        });

    }

    public void setNumber(int n) {
        String s = String.valueOf(n);
        if(calc == Calculation.ERROR) {
            screen.setText(s);
            calc = Calculation.NOTSELECTED;
        } else {
            screen.setText(screen.getText() + s);
        }
    }

    public void calculate(Calculation calculation) {
        if(screen.getText().length() != 0 && calc != Calculation.ERROR) {
            value1 = Double.parseDouble(screen.getText().toString());
        }
        calc = calculation;
        screen.setText("");
    }

}