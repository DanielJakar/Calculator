package android.course.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Proerties:
    private TextView tvResult;
    private String lastOp = "=";
    private double firstOperand = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void ClickEqual(View view) {
        double firstOp = firstOperand;
        double secOp = getCurrentOperand();
        Double result = 0.0;

        //Switch:
        switch (lastOp){
            case "/":
                result = firstOp / secOp;
                break;
            case "x":
                result = firstOp * secOp;
                break;
            case "+":
                result = firstOp + secOp;
                break;
            case "-":
                result = firstOp - secOp;
                break;
        }

        lastOp = "=";
        tvResult.setText(result.toString());

    }

    public void operatorAction(View view) {
        // 1
        Button op = (Button) view;
        lastOp = op.getText().toString();

        //2) remember the operand
        firstOperand = getCurrentOperand();

        //3) clear the text:
        tvResult.setText("0");
    }

    public void numberTapped(View view) {
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        if (getTvResult().equals("0")){
            tvResult.setText(buttonText);
        }
        else
            tvResult.setText(getTvResult() + buttonText);

    }

    @NonNull
    private String getTvResult() {
        return tvResult.getText().toString();
    }

    private Double getCurrentOperand (){
        try {
            return Double.valueOf(getTvResult());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
