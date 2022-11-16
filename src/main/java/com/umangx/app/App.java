package com.umangx.app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws InterruptedException {

        int no_of_pro = 3;
        int time_q = 2;
        gantchart display = new gantchart();
        //using the for loop for the input;
        display.add_process("p1", 10, 0);
        display.add_process("p2", 6, 1);
        display.add_process("p3", 7, 2);

        display.start();

//        //progress bar testing
//        progress tester = new progress(5,"Process 1");
//        int time_run = tester.time;
//
//        for(int i=0;i< time_run;i++){
//            Thread.sleep(1000);
//            tester.add_progress();
//            if(tester.time == 0){
//                System.out.println(tester.show());
//                System.out.println(tester.name+" Ended");
//                break;
//            }
//            System.out.println(tester.show());
//        }

    }
}

