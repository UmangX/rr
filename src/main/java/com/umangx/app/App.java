package com.umangx.app;
import de.vandermeer.asciitable.AsciiTable;

public class App
{
    public static void main(String[] args) throws InterruptedException {

        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Process Name", "Burst Time","Arrival");
        at.addRule();
        at.addRow("P1", "5","0");
        at.addRule();
        at.addRow("P2", "4","1");
        at.addRule();
        at.addRow("P3", "2","2");
        at.addRule();

        //rendering and printing the data
        String rend = at.render();
        System.out.println(rend);



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

