package semaphore;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;

public class Cars
{
    public static void main(String[] args) throws InterruptedException
    {
        Semaphore sem = new Semaphore(1);
        Manager manEven = new Manager(sem,"ahh");
        Manager manOdd = new Manager(sem,"what");

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

    //Adds a car to the queue of left or right
    public static void addCar(Manager manager, int leftRight)
    {
        manager.queue.add(queue.get(queue.size - 1) + 2);
    }
}
//write class that implements runnable
//this class with
class Manager implements Runnable{

    Semaphore sem;
    String threadName;
	int num;
	public Manager(Semaphore sem, String threadName,int num) {
		this.sem = sem;
		this.threadName = threadName;
		this.num = num;
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(num);
    }
	private void runLeft() throws InterruptedException {
		while(true)
		{
			
		}
	}
	private void runRight() throws InterruptedException{
		while(true)
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
