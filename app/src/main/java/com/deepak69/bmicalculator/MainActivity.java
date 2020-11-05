package com.deepak69.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight, height;
        TextView btnresulttext,txtinter,txtinter1;
        Button btnren, result;

        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);

        btnresulttext = (TextView) findViewById(R.id.btnresult);
        txtinter = (TextView) findViewById(R.id.txtinter);
        txtinter1 = (TextView) findViewById(R.id.txtinter1);

        btnren = (Button) findViewById(R.id.btnren);
        result = (Button) findViewById(R.id.result);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweg = weight.getText().toString();
                String strhei = height.getText().toString();
                if (strweg.equals("")) {
                    weight.setError("Please enter your weight");
                    weight.requestFocus();
                    return ;
                }
                if (strhei.equals("")) {
                    height.setError("Please enter your height");
                    height.requestFocus();
                    return ;
                }
                float weightValue = Float.parseFloat(strweg);
                float heightValue = Float.parseFloat(strhei) / 100;

                float BMI= CalculateBMI(weightValue,heightValue);
                txtinter1.setText(interpreteBMI(BMI));
                txtinter.setText("BMI= "+BMI);
            }
        });
        btnren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                weight.setText("");
                txtinter.setText("");
                txtinter1.setText("");


            }
        });
    }


        public float CalculateBMI(float weightValue,float heightValue) {

            return  weightValue / (heightValue * heightValue);

        }
        public String interpreteBMI(float bmi) {
            if (bmi < 16) {
                return "Severely Under Weight";
            } else if (bmi < 18.5) {
                return "Under Weight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                return "Normal Weight";
            } else if (bmi >= 25 && bmi <= 29.9) {
                return "Overweight";
            } else {
                return "Obesity";
            }
        }

}
