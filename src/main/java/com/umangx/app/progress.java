package com.umangx.app;

public class progress {

    public String name;
    int current_index = 1;

    public progress(int burst_time,String p_name){
        time = burst_time;
        name = p_name;
        bar = new StringBuilder();
        bar.setLength(time+2);
        bar.setCharAt(0,'[');
        bar.setCharAt(bar.length()-1,']');
    }

    public int time = 0;
    public StringBuilder bar;

    public void add_progress() {
        bar.setCharAt(current_index,'=');
        current_index++;
        time--;
    }

    public String show() {
        return bar.toString()+" "+name+" Has Time Left :"+time;
    }
}
