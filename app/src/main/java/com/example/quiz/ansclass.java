package com.example.quiz;

public class ansclass
{
    private int optionA,optionB,optionC,optionD,queID,ansID;
    public ansclass(int questionID,int optiona,int optionb,int optionc, int optiond,int answerID)
    {
        queID=questionID;
        optionA=optiona;
        optionB=optionb;
        optionC=optionc;
        optionD=optiond;
        ansID=answerID;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQueID() {
        return queID;
    }

    public int getAnsID() {
        return ansID;
    }
}
