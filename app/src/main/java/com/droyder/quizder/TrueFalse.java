package com.droyder.quizder;

class TrueFalse {
    private boolean mAnswer;
    private int mQid;

    TrueFalse(int q, boolean a) {
        this.mQid = q;
        this.mAnswer = a;
    }

    int getQid() {
        return this.mQid;
    }

    boolean isAnswer() {
        return this.mAnswer;
    }
}
