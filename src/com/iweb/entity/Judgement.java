package com.iweb.entity;

/**
 * Created by admin on 2017/4/26.
 */
public class Judgement {
    private int id;
    private String question;
    private String answer;

    public Judgement(){
        super();
    }

    public Judgement(int id, String question, String answer) {
        super();
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public int getQid() {
        return id;
    }
    public void setQid(int qid) {
        this.id = qid;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
