public class PrinterI implements Demo.Printer
{
    public void printString(String s, com.zeroc.Ice.Current current)
    {

        String[] stringRegex = s.split(":");
        

        System.out.println(s);
    }

    

    //Test 1
    public String fibonacciString(int n, com.zeroc.Ice.Current current)
    {
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++)
        {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        String fibString = "";
        for (int i = 0; i < n; i++)
        {
            fibString += fib[i] + " ";
        }
        return fibString;
    }
}