import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    public final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        java.util.List<String> extraArgs = new java.util.ArrayList<>();

        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "config.client",
                extraArgs)) {
            // com.zeroc.Ice.ObjectPrx base =
            // communicator.stringToProxy("SimplePrinter:default -p 10000");
            Demo.PrinterPrx twoway = Demo.PrinterPrx.checkedCast(
                    communicator.propertyToProxy("Printer.Proxy")).ice_twoway().ice_secure(false);
            // Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);

            Talker.ChatControllerPrx tControllerPrx = Talker.ChatControllerPrx.checkedCast(
                communicator.propertyToProxy("Chat.Proxy").ice_twoway().ice_secure(false)
            );
            Demo.PrinterPrx printer = twoway.ice_twoway();
            Talker.ChatControllerPrx chat = tControllerPrx.ice_twoway();

            if (printer == null && chat == null) {
                throw new Error("Invalid proxy");
            }

            
            if(args[0] ==  null){
                throw new Error("Invalid args");
            }

            //System.out.println("Se esta haciendo la prueba con:  "+args[0]);
            fibbonacci(printer, args);
            
            
            
            
        }catch(Exception exception){
            System.err.println(exception);
            System.exit(1);
        }
    }

    private static void fibbonacci(Demo.PrinterPrx printer, String [] input) throws UnknownHostException {
        String localIP = InetAddress.getLocalHost().getHostName();
        String number = printer.fibonacciString(localIP + ":" + input[0]);
        System.out.println("Es el turno de "+localIP);
        System.out.println(localIP + " esta probando con  "+": " + input[0]+" el server respondio: "+number);
        System.out.println();
        
    }

}