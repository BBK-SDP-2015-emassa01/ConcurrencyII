
import static java.lang.System.out;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
public class App {//RUNNABLE!
//see App2 for callable.    
    public static void main (String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        
        executor.submit(new Runnable(){
            public void run(){
                
                Random random = new Random();
                int duration = random.nextInt(4000);
                
               System.out.println("Starting..."); 
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               System.out.println("Finishing..."); 
                
            }
        });
    
    executor.shutdown();
    
    }
}
