package com.umangx.app;

import de.vandermeer.asciitable.AsciiTable;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class gantchart {

    public Queue<process> main = new LinkedList<process>();
    int time_q = 2;
    //timer is the clock counter that is counting the converted time
    int timer = 0;


    //adding the processes to the gant table
    public void add_process(String name, int btime, int arrival) {
        process p1 = new process(name, btime, arrival);
        main.add(p1);
    }

    //p1 -> p2 -> p3 -> p1 -> p2 ...... All Process Ended

    public void display() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Process Name", "Burst Time", "Arrival", "Progress", "Time Left", "Status");
        at.addRule();
        for (process x : main) {
            at.addRow(x.name, x.btime, x.arrival, x.get_progress(), x.time_left, x.State);
            at.addRule();
        }
        System.out.println(at.render());
    }

    public void addprogress() {
        if (main.peek() != null) {
            main.peek().time_left = main.peek().time_left - 1;
            main.peek().State = "RUNNING";
            for (process p : main) {
                if (!Objects.equals(p.State, "RUNNING")) {
                    p.State = "WAITING";
                }
            }
        }

    }

    public boolean is_empty(){
        for(process x : main){
            if(x.State != "TERMINATED"){
                return false;
            }
        }
        return true;
    }
    //todo add the damn simulation

    public void start() throws InterruptedException {
        //what we need cycle form up to down terminate the process move back up do a cycle

        while (!is_empty()) {

            process current = main.peek();

            for (int i = 0; i < time_q; i++) {
                if (current.time_left - 1 == 0) {
                    current.time_left = 0;
                    current.State = "TERMINATED";
                } else {
                    current.time_left = current.time_left - 1;
                    current.State = "RUNNING";
                    display();
                }

                current.State = "WAITING";
                main.add(main.peek());
                main.poll();
            }
        }
        display();
    }
}
