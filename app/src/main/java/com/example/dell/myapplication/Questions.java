package com.example.dell.myapplication;

public class Questions {

    public String mQuestions[] = {
            "What is the name of this song?",
            "Who is the singer of this song?",
            "When was this song released?",
            "What is the name of this song?",
            "What is the name of this song?",
            "Who is the singer of this song?",
            "What is the name of this album?",
            "What is the name of this song?",
            "Who is the singer of this song?",
            "When was this song released?"

    };

    private String mChoices[][] = {
            {"BOOMBAYAH", "DDU-DU DDU-DU", "Hate", "Mr.Mr."},
            {"BIGBANG", "EXO", "GOT7", "WINNER"},
            {"2011", "2008", "2016", "2009"},
            { "BBIBBI", "Palette", "SoulMate", "Colors"},
            {"Fire", "EVERYDAY", "Can't Stop", "DNA"},
            {"IU", "SUNMI", "HyunA", "BoA"},
            { "M", "A", "D", "E"},
            {"Spring Breeze", "Spring Day", "Stars", "Beautiful"},
            {"IKON", "WINNER", "BLOCK B", "NCT 127"},
            {"2016", "2018", "2017", "2007"},

    };

    private String mCorrectAnswers[] = {"DDU-DU DDU-DU", "EXO", "2009", "BBIBBI", "DNA",
            "IU", "D", "Spring Breeze", "IKON", "2017"};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }
    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }
    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }
    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }
    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
