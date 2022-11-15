package com.umangx.app;

public class App
{
    public static void main(String[] args) throws InterruptedException {

        gantchart chart = new gantchart();
        chart.add_process("p1",5,0);
        chart.add_process("p1",5,0);
        chart.add_process("p1",5,0);
        chart.add_process("p1",5,0);
        chart.add_process("p1",5,0);
        System.out.println(chart.display());

        //progress bar testing
        progress tester = new progress(5,"Process 1");
        int time_run = tester.time;

        for(int i=0;i< time_run;i++){
            Thread.sleep(1000);
            tester.add_progress();
            if(tester.time == 0){
                System.out.println(tester.show());
                System.out.println(tester.name+" Ended");
                break;
            }
            System.out.println(tester.show());
        }

    }
}

