
import java.io.IOException;
import static java.lang.System.out;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
public class App2 {
//callable. 
    int i;
    public int geti(){
        return this.i;
    }
    public static void main (String[] args) throws InterruptedException, ExecutionException{
        App2 test = new App2();
        test.launch();
    }
        
        public void launch() throws InterruptedException{
        for ( i = 0; i <10; i++){
        ExecutorService executor = Executors.newCachedThreadPool();
        
        
        Future<Integer> future = executor.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                
                Random random = new Random();
                int duration = random.nextInt(4000);
                
                if (duration>2000) throw new IOException("Sleeping for way too long!");
                
               System.out.println("Starting..." + geti()); 
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               System.out.println("Finishing..."); 
               
               return duration;
            }
        });
    
    executor.shutdown();
            try {
                System.out.println("Result is: "+ future.get());//future.get() calls some exceptions (Execution and interrupted exception)
            } catch (ExecutionException ex) {
                //Logger.getLogger(App2.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(geti()+ "thread: "+ex.getMessage());
            }
    
    
    
    }}
}

