/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
/**
 *
 * @author Esha
 */
public class TextLoopsWithExecutor implements Runnable {

    public static final int COUNT = 10;
    private static  ExecutorService e;
    private final String name;
    
public TextLoopsWithExecutor(String name) {
    this.name = name;
}
@Override
public void run() {
    for (int i = 0; i < COUNT; i++) {
    System.out.println("Loop:" + name + ", iteration:" + i + ".");
    }
}

public static void main(String args[]) {
    
    //Executor e = new ThreadPoolExecutor(3, 5, 4L ,MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
    //Executor e = new ThreadPoolExecutor(100000, 150000, 900L ,SECONDS, new ArrayBlockingQueue<Runnable>(2000000));
    //Executor e = new AbstractExecutorService();
    e = new ScheduledThreadPoolExecutor(15000);
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
    }e.shutdown();
    }
}

