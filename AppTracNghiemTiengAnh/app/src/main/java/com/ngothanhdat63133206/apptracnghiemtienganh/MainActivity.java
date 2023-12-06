package com.ngothanhdat63133206.apptracnghiemtienganh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    TextView tvLoad;
    Button bntStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Khởi tạo DatabaseHelper trong onCreate của activity
        //dbHelper = new DatabaseHelper(this);

        //Thêm câu hỏi mới vào CSDL
        //Question newQuestion = new Question("Nội dung câu hỏi", "Câu trả lời");
        //dbHelper.addQuestion(newQuestion);

        // Lấy danh sách câu hỏi từ CSDL
        //List<Question> questionList = dbHelper.getAllQuestions();
        //for (Question question : questionList) {
         //   tvLoad.setText("Question", TextView.BufferType.valueOf("ID: " + question.getId() + ", Question: " + question.getQuestionText() + ", Answer: " + question.getAnswer()));
        //}

        // Xóa một câu hỏi từ CSDL
        //int questionIdToDelete = 1; // ID của câu hỏi cần xóa
        //dbHelper.deleteQuestion(questionIdToDelete);

        // Cập nhật thông tin của một câu hỏi trong CSDL
        //int questionIdToUpdate = 2; // ID của câu hỏi cần cập nhật
        //Question updatedQuestion = new Question("Nội dung câu hỏi đã cập nhật", "Câu trả lời mới");
        //updatedQuestion.setId(questionIdToUpdate);
        //dbHelper.updateQuestion(updatedQuestion);
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, StartScreen.class));
            }
        },100);
    }
}