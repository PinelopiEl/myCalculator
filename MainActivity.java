package com.freesoft.mycalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_display;
    Button btn_plus;
    Button btn_erase;
    Button btn_mul;
    Button btn_division;
    Button btn_mc;
    double memory;
    boolean isResult = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_display = (TextView) findViewById(R.id.txt_display);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_erase = (Button) findViewById(R.id.btn_erase);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_division = (Button) findViewById(R.id.btn_division);
        btn_mc = (Button) findViewById(R.id.btn_mc);

    }

    public void onClick_Mc(View view) {
        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            memory = 0.0;
        }
    }

    public void onClick_Mr(View view) {

        txt_display.setText(Double.toString(memory));
    }

    public void onClick_Mplus(View view) {
        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            calculate();
            str = txt_display.getText().toString();
            double a = Double.parseDouble(str);
            memory = memory + a;
        }
    }

    public void onClick_Mminus(View view) {
        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            calculate();
            str = txt_display.getText().toString();
            double a = Double.parseDouble(str);
            memory = memory - a;
        }
    }


    //numbers
    public void onClick_Zero(View view) {

        if(isResult) {
            txt_display.setText("0");
        }else{txt_display.setText(txt_display.getText() + "0");}
    }

    public void onClick_Three(View view) {
        if(isResult) {
            txt_display.setText("3");
        }else{txt_display.setText(txt_display.getText() + "3");}
    }

    public void onClick_Two(View view) {
        if(isResult) {
            txt_display.setText("2");
        }else{txt_display.setText(txt_display.getText() + "2");}
    }

    public void onClick_One(View view) {
        if(isResult) {
            txt_display.setText("1");
        }else{txt_display.setText(txt_display.getText() + "1");}
    }

    public void onClick_Six(View view) {
        if(isResult) {
            txt_display.setText("6");
        }else{txt_display.setText(txt_display.getText() + "6");}
    }

    public void onClick_Five(View view) {
        if(isResult) {
            txt_display.setText("5");
        }else{txt_display.setText(txt_display.getText() + "5");}
    }

    public void onClick_Four(View view) {
        if(isResult) {
            txt_display.setText("4");
        }else{txt_display.setText(txt_display.getText() + "4");}
    }

    public void onClick_Nine(View view) {
        if(isResult) {
            txt_display.setText("9");
        }else{txt_display.setText(txt_display.getText() + "9");}
    }

    public void onClick_Eight(View view) {
        if(isResult) {
            txt_display.setText("9");
        }else{txt_display.setText(txt_display.getText() + "9");}
    }

    public void onClick_Seven(View view) {
        if(isResult) {
            txt_display.setText("7");
        }else{txt_display.setText(txt_display.getText() + "7");}
    }
    //end of numbers

    public void onClick_Percent(View view) {

        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            calculate();
            str = txt_display.getText().toString();
            double a = Double.parseDouble(str);
            double result = a / 100;
            txt_display.setText(Double.toString(result));
        }
    }

    public void onClick_C(View view) {
        txt_display.setText("");
    }

    public void onClick_ce(View view) {
        txt_display.setText("");
    }

    public void onClick_Erase(View view) {

        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
            txt_display.setText(str);
        }
    }

    //operations
    public void onClick_Division(View view) {
        calculate();
        addOperator("/");
    }

    public void onClick_minus(View view) {
        calculate();
        addOperator("-");
    }

    public void onClick_Plus(View view) {
        calculate();
        addOperator("+");
    }

    public void onClick_mul(View view) {
        calculate();
        addOperator("*");
    }

    public void onClick_Equal(View view) {
        calculate();
    }

    //end of operations
    public void onClick_Root(View view) {

        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            calculate();
            str = txt_display.getText().toString();
            double a = Double.parseDouble(str);
            if (a >= 0) {
                double result = Math.sqrt(a);
                txt_display.setText(Double.toString(result));
            }
        }
    }

    public void onClick_X2(View view) {

        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            calculate();
            str = txt_display.getText().toString();
            double a = Double.parseDouble(str);
            double result = Math.pow(a, 2);
            txt_display.setText(Double.toString(result));
        }
    }

    public void onClick_x3(View view) {

        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            calculate();
            str = txt_display.getText().toString();
            double a = Double.parseDouble(str);
            double result = Math.pow(a, 3);
            txt_display.setText(Double.toString(result));
        }
    }

    public void onClick_OneDivX(View view) {

        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            calculate();
            str = txt_display.getText().toString();
            double a = Double.parseDouble(str);
            if (a != 0) {
                double result = 1 / a;
                txt_display.setText(Double.toString(result));
            }
        }
    }

    public void onClick_PlusMin(View view) {

        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            double a = Double.parseDouble(str);
            txt_display.setText(Double.toString(-a));
        }
    }

    public void onClick_Coma(View view) {

        String str = txt_display.getText().toString();
        String[] array = str.split("[+,-,*,/]");
        if(!array[array.length-1].contains(".")){
            txt_display.setText(txt_display.getText() + ".");
        }
    }

    //utility functions
    private void addOperator(String operator) {

        String str = txt_display.getText().toString();
        if (str.length() > 0) {
            txt_display.setText(txt_display.getText() + operator);
        }

    }

    public void calculate() {

        String str = txt_display.getText().toString();
        if (str.contains("+")) {
            try {
                String[] array = str.split("\\+");
                if (array.length == 2) {
                    double a = Double.parseDouble(array[0]);
                    double b = Double.parseDouble(array[1]);
                    double result = a + b;
                    String temp = Double.toString(result);
                    txt_display.setText(eliminateDoteZero(temp));
                }
            }catch (Exception e){}
        } else if (str.contains("-")) {
            try {
                String[] array = str.split("\\-");
                if (array.length == 2) {
                    double a = Double.parseDouble(array[0]);
                    double b = Double.parseDouble(array[1]);
                    double result = a - b;
                    String temp =Double.toString(result);
                    txt_display.setText(eliminateDoteZero(temp));
                }
            } catch (Exception e) {

            }

        } else if (str.contains("/")) {
            try{
                String[] array = str.split("/");
                if (array.length == 2) {
                    double a = Double.parseDouble(array[0]);
                    double b = Double.parseDouble(array[1]);
                    if (b != 0) {
                        double result = a / b;
                        String temp =Double.toString(result);
                        txt_display.setText(eliminateDoteZero(temp));
                    }
                }
            }catch(Exception e){

                }
            }
         else if (str.contains("*")) {
            try {
                String[] array = str.split("/");
                if (array.length == 2) {
                    double a = Double.parseDouble(array[0]);
                    double b = Double.parseDouble(array[1]);
                    if (b != 0) {
                        double result = a / b;
                        String temp =Double.toString(result);
                        txt_display.setText(eliminateDoteZero(temp));
                    }
                }
            }catch (Exception e){

            }
        }
        isResult = true;
    }
    public String eliminateDoteZero(String temp){
        if(temp.endsWith(".0")){
            temp = temp.substring(0,temp.length()-2);
        }return temp;
    }

}