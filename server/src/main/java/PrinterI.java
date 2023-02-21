public class PrinterI implements Demo.Printer
{
    public void printString(String s, com.zeroc.Ice.Current current)
    {

        String[] stringRegex = s.split(":");
        

        System.out.println(s);
    }

    

    //Test 1
    public String fibonacciString(String n, com.zeroc.Ice.Current current)
    {
        String array [] = n.split(":") ;
        int num = Integer.parseInt(array[1]);
        System.out.println("Cliente: "+array[0]+" numero: "+array[1]);
        int[] fib = new int[num];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < num; i++)
        {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        String fibString = "";
        for (int i = 0; i < num; i++)
        {
            fibString += fib[i] + " ";
        }
        return fibString;
    }
}