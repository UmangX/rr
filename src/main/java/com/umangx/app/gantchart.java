package com.umangx.app;
import de.vandermeer.asciitable.AsciiTable;
import java.util.LinkedList;
import java.util.Queue;

public class gantchart {

        Queue<process> main = new LinkedList<process>();
        int time_q = 2;
        int timer = 0;

        public void add_process(String name,int btime,int arrival){
            process p1 = new process(name,btime,arrival);
            main.add(p1);
        }
        public void addtoback(process p1){
            main.add(p1);
        }

        public void display(){
            AsciiTable at = new AsciiTable();
            at.addRule();
            at.addRow("Process Name","Burst Time","Arrival","Progress","Time Left","Waiting");
            at.addRule();
            for(process x : main){
                at.addRow(x.name,x.btime,x.arrival,x.get_progress(),x.time_left,x.waiting);
                at.addRule();
            }
            System.out.println(at.render());
        }

        //todo add the damn simulation

        public void start() throws InterruptedException {


            //runs while process/chart size is not cleared
            while(main.size()!=0){
                System.out.println("Current Time : "+timer);
                Thread.sleep(1000);
                for(int i=0;i<2;i++){
                    process current_p = main.peek();
                    if(current_p.time_left == 1) {
                        current_p.time_left = current_p.time_left - 1;
                        display();
                        main.poll();
                    }else{
                        current_p.time_left = current_p.time_left -1;
                        display();
                        main.add(current_p);
                        main.poll();
                    }
                    timer++;
                }
            }
        }
}
