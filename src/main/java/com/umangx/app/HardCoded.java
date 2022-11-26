package com.umangx.app;

public class HardCoded {
    public static void print_sec(int sec){
        System.out.println("At Time " + sec);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("A Round Robin Scheduling Scheme");
        Thread.sleep(1000);
        print_sec(0);
        System.out.println("Process P1 Added With Burst Time 6");
        System.out.println("Time Quantum is Set to 2");
        gantchart table = new gantchart();
        table.add_process("P1",6,0);
        table.display();
        Thread.sleep(1000);
        System.out.println("At Time 1 P1 Has Done Some Work And P2 Is Added To Queue With Burst Time 4");
        assert table.main.peek() != null;
        table.addprogress();
        table.add_process("P1",5,1);
        table.display();
        Thread.sleep(1000);
        System.out.println("At Time 2 Time Quantum is Reach P1 is moved Down");

    }
}
