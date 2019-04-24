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
        manager.queue.add(manager.queue.get(manager.queue.size() - 1) + 2);
    }
}
//write class that implements runnable
//this class with
class Manager implements Runnable{

    Semaphore sem;
    String threadName;
    int counter = 0;
    int num;
    ArrayList<Integer> queue = new ArrayList<Integer>();

    public Manager(Semaphore sem, String threadName,int num) {
        this.sem = sem;
        this.threadName = threadName;
        this.num = num;
        queue.add(num);
    }
    //Runs for left manager thread
    private void critLeft(int firstCarIndex)
    {
        //let cars from this side enter the tunnel
        while(counter < queue.size())
        {
            System.out.println("Left-bound car " + queue.get(counter) + " is in the tunnel.");
            counter++;
        }
        //reset counter to the first car that entered the tunnel and let them all leave in sequence
        counter = firstCarIndex;
        while(counter < queue.size())
        {
            System.out.println("Left-bound car " + queue.get(counter) + " has left the tunnel.");
            counter++;
        }
        //release lock
        sem.release();
    }
    //Runs for right manager thread
    private void critRight(int firstCarIndex)
    {
        //let cars from this side enter the tunnel
        while(counter < queue.size())
        {
            System.out.println("Right-bound car " + queue.get(counter) + " is in the tunnel.");
            counter++;
        }
        //reset counter to the first car that entered the tunnel and let them all leave in sequence
        counter = firstCarIndex;
        while(counter < queue.size())
        {
            System.out.println("Right-bound car " + queue.get(counter) + " has left the tunnel.");
            counter++;
        }
        //release lock
        sem.release();
    }
    @Override
    public void run() {
        int firstCarIndex;

        //infinite loop
        while(true)
        {
            //check queue to see if the counter position exists
            if(counter < queue.size())
            {
                //Set firstCar to counter
                firstCarIndex = counter;
                //get semaphore lock
                sem.acquire();

                //ENTER CRITICAL SECTION---------------------------------------
                if(threadName.equals("ahh"))
                {
                    critRight(firstCarIndex);
                }
                else
                    critLeft(firstCarIndex);
                //EXIT CRITICAL SECTION---------------------------------------
            }
        }
    }
}