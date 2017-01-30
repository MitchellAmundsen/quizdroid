package edu.washington.amundm.quizdroid;

public class Question {

    public String q;
    public String a1;
    public String a2;
    public String a3;
    public String a4;

    public String response;
    public String correct;

    Question(){
        q = "Sample Question";
        a1 = "Answer1";
        a2 = "Answer2";
        a3 = "Answer3";
        a4 = "Answer4";

        correct = a3;
    }

    public void response(String r){
        response = r;
    }

    public boolean isCorrect(){
        return response.equals(correct);
    }

}
