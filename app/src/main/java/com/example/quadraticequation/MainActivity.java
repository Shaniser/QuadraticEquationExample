package com.example.quadraticequation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.calculate).setOnClickListener(v -> {
            try {
                solveEquation();
            } catch (Exception e) {
                ((TextView) findViewById(R.id.result)).setText("Ошибка");
            }
        });
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
    public void solveEquation() {
        double a = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_c)).getText().toString());
        TextView result = (TextView) findViewById(R.id.result);
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result.setText("X - любое");
                } else {
                    result.setText("Некорректное условие");
                }
            } else {
                result.setText("" + (-c / b));
            }
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                result.setText("Корней нет");
            } else {
                double result1 = (-b + Math.sqrt(d)) / (2 * a);
                double result2 = (-b - Math.sqrt(d)) / (2 * a);
                if (result1 == result2) {
                    result.setText("" + result1);
                } else {
                    result.setText(result1 + ", " + result2);
                }
            }
        }
    }
}