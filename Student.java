

// Student functions interface
interface Functions {
    // interface methods (do not have a body)
    public void seekHelpLater(); 
    public void takeSeat(); 
    public void sleep(); 
    public void getHelp(); 
}

public class Student extends Driver implements Runnable, Functions {
    
    private String name;
    private int id;
    private int counter;
    
    public void seekHelpLater() {
        //code, then poll semaphore again for available seats.
        System.out.println("seek later");
    };

    public void getHelp() {
        //enter critical region then leave
        try {
            isTaFree.acquire();
            isDoorUnlocked.acquire();
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        System.out.println("student is getting help for some secs");

        try {
            Thread.sleep(5000);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        
    };

    public void finishHelp() {
        //enter critical region then leave
        
        try {
            Thread.sleep(8000);
            isDoorUnlocked.release();
            isTaFree.release();
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        System.out.println("help complete");

        
        
        
    };
    
    public void sleep(){
        //sleep student thread for random time 0-5secs
        try {
            Thread.sleep((long)(Math.random() * 5000));   
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void takeSeat(){
        //acquire seat in waiting area
        try {
            waitingArea.acquire();
            
            System.out.println("*takes a seat*");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    // Student constructor
    public Student (String name, int id) { 
        this.name = name;
        this.id = id;
        this.counter = 0;
    }
    
    public void stuActivity(){
        System.out.println("student is coding for (x) secs..." );
        sleep();
        System.out.println("-----------------" );
        System.out.println("student is looking for help..." );
        sleep();
        System.out.println("-----------------" );
        System.out.println("student is taking a seat..." );

            System.out.println("-----------------" );
            //if there are available seats... take a seat
            if(waitingArea.availablePermits() >0){
                takeSeat();
            }else {
                
                seekHelpLater();
            }
            System.out.println("-----------------" );

            //if TA is free and door is unlocked get help
            if(isTaFree.availablePermits() == 1 && isDoorUnlocked.availablePermits() == 1){
                getHelp();
            }

        }
    
    public void techAactivity(){
        try {
            Thread.sleep(3000);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println("TA is available and searching for students...");
        sleep();
        sleep();
        sleep();
        
        
        System.out.println("tutoring done");
        isDoorUnlocked.release();
        isTaFree.release();

        System.out.println("-------------------");
        if(waitingArea.availablePermits()==3){
            System.out.println("Nobody needs help? TA will sleep");
            sleep();
        } else if(isDoorUnlocked.availablePermits()==1 && waitingArea.availablePermits()==3){
            System.out.println("TA will sleep...");
        }

        if(isDoorUnlocked.availablePermits()==0 && waitingArea.availablePermits()>0){
            
            finishHelp();


        }

    


            
        }
        public void placeholder(){
            // System.out.println("NA");
        }


    @Override
    public void run() {
        if(id == 0) techAactivity();
        else stuActivity();
        
    }



    
}
