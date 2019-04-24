package semaphore;
import java.util.concurrent.Semaphore;

public class Cars
{
    public static void main(String[] args) throws InterruptedException
    {
		Semaphore sem = new Semaphore(1);
		Manager manEven = new Manager(sem,"ahh");
		manager manOdd = new Manager(sem,"what");

        int random;
        //enter infinite loop
        while(true)
        {
            random = (int)(Math.random() * 2);

            if(random == 0)
            {
                //add car to left manager
            }
            else
            {
                //add car to right manager
            }
            random = (int)(Math.random() * 1901 + 100);

            Thread.sleep(random);
        }
    }
}
//write class that implements runnable 
//this class with 
class Manager implements Runnable{
	Semaphore sem;
	String threadName;
	public Manager(Semaphore sem, String threadName) {
		this.sem = sem;
		this.threadName = threadName;
	}
	private void runLeft() {
		try 
		{
			
		}
		
	}
	private void runRight() {
		try 
		{
			
		}
	
} 
	@Override
	public void run() { 
		if(threadName.equals("ahh"))
		{
			runRight();
		}
		else
			runLeft();
			
	}
}
