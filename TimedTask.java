
//import static TextLoopsWithExecutor.COUNT;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esha
 */
public class TimedTask{
    private int maxPendingTime;
    private final String name;
    


    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimedTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    public int getMaxPendingTime(){
        return this.maxPendingTime;
    }
    


public static void main(String args[]) {
    
    //Executor e = new ThreadPoolExecutor(3, 5, 4L ,MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
    //Executor e = new ThreadPoolExecutor(100000, 150000, 900L ,SECONDS, new ArrayBlockingQueue<Runnable>(2000000));
    //Executor e = new AbstractExecutorService();
    Executor e = new ScheduledThreadPoolExecutor(15000);
    Runnable r;
    
    
    
    System.out.println("USAGE: java TextLoop <mode>");
    System.out.println(" mode 0: without threads");
    System.out.println(" mode 1: with threads");
    
    System.out.println("Enter a mode.");
    Scanner input = new Scanner(System.in);
    String mode = input.nextLine();
    
    
    if (mode.equals("0")) {
    for (int i = 0; i < 10; i++) {
        
    r = new TextLoopsWithExecutor("Thread " + i);
    r.run();
    }
    
    } else {
    for (int i = 0; i < 10; i++) {
    r = new TextLoopsWithExecutor("Thread " + i);
    e.execute(r);
//    Thread t = new Thread(r);
//    t.start();
    }
    }
    }
            
}
