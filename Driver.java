

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

    private static int[] Queue = new int[10];
    
    Semaphore waitingArea = new Semaphore(1);
    Semaphore isTaFree = new Semaphore(1);
    Semaphore isDoorUnlocked = new Semaphore(1);
    


    // ExecutorService service = Executors.newFixedThreadPool(50);

    // IntStream.of(200).forEach(i -> service.execute(new Task(semaphore)));

    //     Runnable runtask = () -> {

    //    };

    public static void main(String[] args) throws InterruptedException {  

        Thread first = new Thread(new Student("Producer", 0));
        Thread second = new Thread(new Student("Consumer", 1));

           first.start();
           second.start();
    
    
    }


};

         
//SCRATCH PAPER



        // create student thread: executorservice object w/ 10 threads

        // ExecutorService student = Executors.newFixedThreadPool(10);
        // student.execute(new Runnable() {


        //     @Override
        //     public void run() {
                
        //         System.out.println("student is writing some coding...");
        //         try {
        //             Thread.sleep(3000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }

        //         System.out.println("student is looking for help...");

                

        //             try {
        //                 System.out.println("- will take a seat");
        //                 waitingArea.acquire();
        //                 System.out.println("Seats available :" + waitingArea.availablePermits());
                        
        //             } catch (Exception e) {
        //                 e.printStackTrace();
        //             }

        //             //intialize critical region
        //             if(flag.availablePermits()==1){
        //                 System.out.println("showing interest");

        //             } else if(flag.availablePermits()==0){
        //                 System.out.println("flag busy");

        //             }



        //             try {
        //                 System.out.println("- will release a seat");
        //                 waitingArea.release();
        //                 System.out.println("Seats available :" + waitingArea.availablePermits());
                        
        //             } catch (Exception e) {
        //                 e.printStackTrace();
        //             }

                    
       
              



//          Runnable takeSeat = () -> {
//              try {
//                  waitingArea.acquire();
//                  System.out.println("Available permits:" + waitingArea.availablePermits());
                 
//              } catch (Exception e) {
//                  e.printStackTrace();
//              }

//          };
//          System.out.println("//////");

//         Runnable releaseSeat = () -> {
         
//         // release (1) waiting area seat
//         waitingArea.release();
//         System.out.println("Available permits:" + waitingArea.availablePermits());

// };
        


 