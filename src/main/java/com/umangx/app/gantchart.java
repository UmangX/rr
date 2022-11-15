package com.umangx.app;
import de.vandermeer.asciitable.AsciiTable;

import java.util.LinkedList;
import java.util.Queue;


public class gantchart {

        Queue<process> main = new LinkedList<process>();

        public void add_process(String name,int btime,int arrival){
            process p1 = new process();
            p1.name = name;
            p1.setArrival(arrival);
            p1.setBtime(btime);
            main.add(p1);
        }
        public void addtoback(process p1){
            main.add(p1);
        }
        public int size(){
            return main.size();
        }
        public String display(){
            AsciiTable at = new AsciiTable();
            at.addRule();
            at.addRow("Process Name","Burst Time","Arrival");
            at.addRule();
            for(process x : main){
                at.addRow(x.name,x.getBtime(),x.getArrival());
                at.addRule();
            }
            String ren = at.render();
            return ren;
        }
}
