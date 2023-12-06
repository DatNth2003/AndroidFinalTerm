package com.ngothanhdat63133206.apptracnghiemtienganh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QuizDB";
    private static final String TABLE_QUESTIONS = "questions";
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER = "answer";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_QUESTIONS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_QUESTION + " TEXT,"
                + KEY_ANSWER + " TEXT" + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);
    }
    // Thêm câu hỏi mới vào CSDL
    public void addQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, question.getQuestionText());
        values.put(KEY_ANSWER, question.getAnswer());
        db.insert(TABLE_QUESTIONS, null, values);
        db.close();
    }

    // Lấy một danh sách các câu hỏi từ CSDL
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTIONS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestionText(cursor.getString(1));
                question.setAnswer(cursor.getString(2));
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return questionList;
    }

    // Xóa một câu hỏi từ CSDL
    public void deleteQuestion(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_QUESTIONS, KEY_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Cập nhật thông tin của một câu hỏi trong CSDL
    public int updateQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, question.getQuestionText());
        values.put(KEY_ANSWER, question.getAnswer());

        return db.update(TABLE_QUESTIONS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(question.getId())});
    }
}
