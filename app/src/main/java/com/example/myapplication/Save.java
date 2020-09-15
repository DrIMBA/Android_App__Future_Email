package com.example.myapplication;

public class Save {
    public static String email;
    public static String subject;
    public static String content;
    public static double hours;


    /* Constructor */
    public Save(String e, String subj, String con, double hr){
        this.email = e;
        this.content = con;
        this.hours = hr;
        this.subject = subj;
    }

    public Save(){
        this.email = "";
        this.content = "";
        this.hours = -1.0;
        this.subject = "";
    }

    public void update(String e, String subj, String con, double hr){
        this.email = e;
        this.content = con;
        this.hours = hr;
        this.subject = subj;
    }
}
