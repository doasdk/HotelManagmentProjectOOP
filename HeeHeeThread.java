package pl.edu.amu.wmi.s474155;

import java.util.Scanner;

public class HeeHeeThread extends Thread{

    public void run(){
        try {
                    Thread.sleep(3000);
                    System.out.println("NEVER GONNA GIVE YOU UP");
                    Thread.sleep(1000);
                    System.out.println("NEVER GONNA LET YOU DOWN");
                    Thread.sleep(1000);
                    System.out.println("NEVER GONNA RUN AROUND AND DESERT YOU");
                    Thread.sleep(1000);
                    System.out.println("NEVER GONNA MAKE YOU CRY");
                    Thread.sleep(1000);
                    System.out.println("NEVER GONNA SAY GOODBYE");
                    Thread.sleep(1000);
                    System.out.println("NEVER GONNA TELL A LIE AND HURT YOU");

            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
