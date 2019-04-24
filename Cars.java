public class Cars
{
    public static void main(String[] args) throws InterruptedException
    {
        //define semaphore

        //generate left and right manager threads

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
