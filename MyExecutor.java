
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esha
 */
public class MyExecutor {
    
    //ExecutorService e = Executors.newFixedThreadPool(1000);
    ExecutorService e = new ThreadPoolExecutor(3, 5, 4L ,MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
    
    
    
}
