package com.ngothanhdat63133206.apptracnghiemtienganh;

public class Question {
    private int id;
    private String questionText;
    private String answer;
    //Constructor

    public Question() {
    }

    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }
    //Getter, setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
