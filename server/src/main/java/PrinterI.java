public class PrinterI implements Demo.Printer {
    public void printString(String s, com.zeroc.Ice.Current current) {

        String[] stringRegex = s.split(":");

        System.out.println(s);
    }

    // Test 1
    public String fibonacciString(String n, com.zeroc.Ice.Current current) {
        String array[] = n.split(":");
        long num = Long.parseLong(array[1]);
       
        String fibString = "";
        for (long i = 1; i <= num; i++) {
			fibString+= fibbonacci(i) + ",";
		}
        System.out.println("Cliente: " + array[0] + " numero: " + fibString);
        return fibString;

    }

    private long fibbonacci(long n){
        if(n <= 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        return fibbonacci(n-1) + fibbonacci(n-2);
    }
}