package com.example.penugasanpgpbacara32;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Deklarasi EditText, TextView, dan Button
    EditText input1, input2;
    TextView result;
    Button btnMultiply, btnDivide, btnSubtract, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi Views sesuai dengan ID di activity_main.xml
        input1 = findViewById(R.id.input1);        // Sesuai dengan ID input pertama di XML
        input2 = findViewById(R.id.input2);        // Sesuai dengan ID input kedua di XML
        result = findViewById(R.id.result);        // Sesuai dengan ID result (hasil) di XML
        btnMultiply = findViewById(R.id.btnMultiply); // Tombol kali
        btnDivide = findViewById(R.id.btnDivide);     // Tombol bagi
        btnSubtract = findViewById(R.id.btnSubtract); // Tombol kurang
        btnAdd = findViewById(R.id.btnAdd);           // Tombol tambah

        // Set OnClickListener untuk tombol perkalian
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("multiply");
            }
        });

        // Set OnClickListener untuk tombol pembagian
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("divide");
            }
        });

        // Set OnClickListener untuk tombol pengurangan
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("subtract");
            }
        });

        // Set OnClickListener untuk tombol penjumlahan
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("add");
            }
        });
    }

    // Method untuk melakukan perhitungan
    private void calculateResult(String operation) {
        String input1Text = input1.getText().toString();
        String input2Text = input2.getText().toString();

        // Cek jika input tidak kosong
        if (input1Text.isEmpty() || input2Text.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        // Konversi input ke tipe double
        double num1 = Double.parseDouble(input1Text);
        double num2 = Double.parseDouble(input2Text);
        double calculatedResult = 0;

        // Lakukan operasi sesuai tombol yang ditekan
        switch (operation) {
            case "multiply":
                calculatedResult = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    calculatedResult = num1 / num2;
                } else {
                    Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case "subtract":
                calculatedResult = num1 - num2;
                break;
            case "add":
                calculatedResult = num1 + num2;
                break;
        }

        // Tampilkan hasil pada TextView
        result.setText("Hasil: " + calculatedResult);
    }
}
