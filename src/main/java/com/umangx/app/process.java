package com.umangx.app;

public class process {
    int btime = 0;
    public String name;
    int arrival = 0;
    StringBuilder bar = new StringBuilder();
    boolean waiting = false;
    int time_left = 0;

    public  process(String new_name,int new_btime,int new_arrival){
        btime = new_btime;
        arrival = new_arrival;
        name = new_name;
        time_left = btime;
        bar.setLength(btime+2);
        bar.setCharAt(0,'[');
        bar.setCharAt(bar.length()-1,']');
    }
    public String get_progress(){
        int time_spent = Math.abs(btime-time_left);
        for(int i=1;i<time_spent;i++){
            bar.setCharAt(i,'=');
        }
        return bar.toString();
    }
}
