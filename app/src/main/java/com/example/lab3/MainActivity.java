package com.example.lab3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private enum Operator {none, add, minus, multiply, divide, equal}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;
    boolean requiresCleaning = true, hasDot = false;


    public void btn00click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"0");
    }

    public void btn01click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"1");
    }

    public void btn02click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"2");
    }

    public void btn03click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"3");
    }

    public void btn04click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"4");
    }

    public void btn05click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"5");
    }
    public void btn06click (View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"6");
    }
    public void btn07click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"7");
    }
    public void btn08click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"8");
    }
    public void btn09click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"9");
    }

    public void btnDotclick (View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+".");
    }
    public void btnAddclick (View view){
        optr = Operator.add;
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMinusclick (View view){
        optr = Operator.minus;
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMultiplyclick (View view){
        optr = Operator.multiply;
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnDivideclick (View view){
        optr = Operator.divide;
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnClearclick (View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText("");
        data1 = 0;
        data2 = 0;
    }

    public void btnEqualclick(View view){
        if(optr != Operator.none){
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if(optr == Operator.add){
                result = data1 + data2;
            }else if(optr == Operator.minus){
                result = data1-data2;
            }else if(optr == Operator.multiply){
                result = data1 * data2;
            }else if(optr == Operator.divide){
                result = data1/data2;
            }

            optr = Operator.none;
            data1 = result;
            if((result - (int)result ) != 0 ){
                eText.setText(String.valueOf(result));

            }else{
                eText.setText(String.valueOf((int)result));
            }
        }
    }// btnEqualclick

    /*
    public void onClickNumericalButton(View view){
        //Getting ID of pressed button
        int pressID = view.getId();

        //Getting Text obj where we display the current value
        EditText curText = (EditText)findViewById(R.id.resultEdit);

        //If we had an equal sign pressed last, standard operation is to clean
        if(optr == Operator.equal){
            optr = Operator.none;
            curText.setText("");
        }

        if(requiresCleaning){
            requiresCleaning = false;
            curText.setText("");
        }

        //Figuring out which button was pressed and updating the represented text field obj
        switch (pressID){
            case R.id.btnZero:
                curText.setText(curText.getText() + "0");
                break;
            case R.id.btn1:
                curText.setText(curText.getText() + "1");
                break;
            case R.id.btn2:
                curText.setText(curText.getText() + "2");
                break;
            case R.id.btn3:
                curText.setText(curText.getText() + "3");
                break;
            case R.id.btn4:
                curText.setText(curText.getText() + "4");
                break;
            case R.id.btn5:
                curText.setText(curText.getText() + "5");
                break;
            case R.id.btn6:
                curText.setText(curText.getText() + "6");
                break;
            case R.id.btn7:
                curText.setText(curText.getText() + "7");
                break;
            case R.id.btn8:
                curText.setText(curText.getText() + "8");
                break;
            case R.id.btn9:
                curText.setText(curText.getText() + "9");
                break;
            case R.id.btnDot:
                if(!hasDot){
                    curText.setText(curText.getText() + ".");
                    hasDot=true;
                }else{
                    //TODO Decide if we will implement a special case for when we already have a decimal point
                }

                break;
            default:
                curText.setText("Error");
                Log.d("Error", "Error: Unknown Button Presses");
                break;
        }//switch

    }//onClickNumericalButton

    public void onClickFunctionButton(View view){
        //Getting ID of pressed button
        int pressID = view.getId();

        //Getting Text obj where we display the current number value
        EditText curText = (EditText) findViewById(R.id.resultEdit);

        //Clear all regardless of context
        if(pressID == R.id.btnClear){
            optr = Operator.none;
            curText.setText("");
            data1 = 0;
            data2 = 0;
            requiresCleaning = false;
            return;
        }

        String dataText = curText.getText().toString();
        double numberVal = dataText.length() > 0 ? Double.parseDouble(dataText) : 0;

        //Checking if we have "prior data" aka sth stored in data1 that we should use
        //Having data1 != 0 is not enough, we need to know the previous operator.

        if(optr == Operator.none){
            data1 = numberVal;
            requiresCleaning = true;
            switch(pressID){
                case R.id.btnEqual:
                    optr = Operator.equal;
                    data1 = 0;
                    break;
                case R.id.btnAdd:
                    optr = Operator.add;
                    break;
                case R.id.btnMinus:
                    optr = Operator.minus;
                    break;
                case R.id.btnDivide:
                    optr = Operator.divide;
                    break;
                case R.id.btnMul:
                    optr = Operator.multiply;
                    break;

            }//switch
        }else{
            double result = 0;
            data2 = numberVal;
            switch(optr){
                case equal:
                    break;
                case none:
                    break;
                case add:
                    result = data1+data2;
                    break;
                case minus:
                    result = data1-data2;
                    break;
                case divide:
                    result = data1/data2;
                    break;
                case multiply:
                    result = data1*data2;
                    break;
            }// switch

            data1 = result;
            optr = Operator.none;
            if((result -(int)result) != 0){
                curText.setText(String.valueOf(result));
            }else{
                curText.setText(String.valueOf((int)result));
            }
        }// else




    }// onClickFunctionButton

    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }// onCreate
}// class MainActivity