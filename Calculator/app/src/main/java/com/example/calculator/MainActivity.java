package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculator.databinding.ActivityMainBinding;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;



public class MainActivity extends AppCompatActivity {

    boolean lastDigit = false;
    boolean stateError = false;
    boolean lastdot = false;

    public ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText("");
                binding.output.setText("");
                lastdot = false;
                lastDigit = false;
                stateError = false;

            }
        });

        binding.equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqual();
            }
        });
    }

    public void onOperatorClick(View view){
        if(!stateError && lastDigit)
        {
            binding.input.append(((Button)view).getText().toString());
            lastdot = false;
            lastDigit = false;
            onEqual();
        }
    }

    public void onEqual(){
        if(lastDigit && !stateError){
            String txt = binding.input.getText().toString();

            if(txt.contains("÷")){
                txt = txt.replace("÷", "/");
            }else if(txt.contains("×")){
                txt = txt.replace("×", "*");
            }else if(txt.contains("−")){
                txt = txt.replace("−", "-");
            }


            Expression exp = new ExpressionBuilder(txt).build();

            try{
                String op = String.valueOf(exp.evaluate());
                binding.output.setText(op);
            }catch (ArithmeticException e){

                binding.output.setText("error");
                stateError = true;
                lastDigit = false;

            }
        }

    }

    public void onDigitClick(View view){
        if (stateError)
        {
            binding.input.setText(((Button)view).getText());
            stateError = false;
        }
        else
        {
            binding.input.append(((Button)view).getText().toString());
        }
        lastDigit = true;

        onEqual();
    }

    public void onBackspaceClick(View view){
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                binding.input.setText("");
                lastdot = false;
                lastDigit = false;
                stateError = false;

                return false;
            }
        });

        if(!binding.input.getText().toString().equals("")){
            String backspace = binding.input.getText().toString();
            backspace = backspace.substring(0, backspace.length() - 1);
            binding.input.setText(backspace);

            if(backspace.endsWith("÷") || backspace.endsWith("+") || backspace.endsWith("−") || backspace.endsWith("×") || backspace.endsWith("(") || backspace.endsWith(")") || backspace.endsWith(".")){
                lastDigit = false;
                lastdot = false;
            }else {
                lastDigit = true;
            }
            //onEqual();
        }
    }
}