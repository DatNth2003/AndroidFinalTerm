package com.ngothanhdat63133206.apptracnghiemtienganh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioButton rbA, rbB, rbC, rbD;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Ánh xạ các thành phần giao diện
        questionTextView = findViewById(R.id.tvQuestion);
        rbA = findViewById(R.id.rbA);
        rbA = findViewById(R.id.rbB);
        rbA = findViewById(R.id.rbC);
        rbA = findViewById(R.id.rbD);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Load câu hỏi ban đầu
        loadQuestion();
        // Xử lý sự kiện khi người dùng nhấn nút submit
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Kiểm tra câu trả lời và điều hướng
                checkAnswer();
                // Nạp câu hỏi tiếp theo
                loadNextQuestion();
            }
        });
    }

    private void loadQuestion() {
        // Code để load câu hỏi và các câu trả lời từ cơ sở dữ liệu hoặc tệp
        // và hiển thị chúng trên giao diện
    }

    private void checkAnswer() {
        // Code để kiểm tra câu trả lời và xử lý logic
    }

    private void loadNextQuestion() {
        // Code để load câu hỏi tiếp theo sau khi người dùng chọn câu trả lời
    }
}