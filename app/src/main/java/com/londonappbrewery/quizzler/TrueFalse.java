package com.londonappbrewery.quizzler;

public class TrueFalse {
    private boolean mAnswer;
    private int mQid;

    public TrueFalse(int q, boolean a) {
        this.mQid = q;
        this.mAnswer = a;
    }

    public int getQid() {
        return this.mQid;
    }

    public void setQid(int qid) {
        this.mQid = qid;
    }

    public boolean isAnswer() {
        return this.mAnswer;
    }

    public void setAnswer(boolean answer) {
        this.mAnswer = answer;
    }
}
