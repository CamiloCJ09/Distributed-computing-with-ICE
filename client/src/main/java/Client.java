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

            System.out.println("BIENVENIDO\n Ingrese una opcion: ");
            System.out.println("1) Para ejecutar las funciones de fibbonacci");
            System.out.println("2) Iniciar el chat con diferentes funciones");
            
            String option = scanner.nextLine();

            int selection = Integer.parseInt(option);

            switch(selection){
                case 1: fibbonacci(printer);
                    break;
                case 2: chat(chat);
                    break;    
            }
            
            
        }catch(Exception exception){
            System.err.println(exception);
            System.exit(1);
        }
    }

    private static void fibbonacci(Demo.PrinterPrx printer) throws UnknownHostException {
        String localIP = InetAddress.getLocalHost().getHostName();
        String defaultText = "¿Que numero de la serie fibonacci desea ver?";
        System.out.println(defaultText);
        String n = scanner.nextLine();

        while (!n.equalsIgnoreCase("exit")) {
            if (Integer.parseInt(n) >= 0) {
            //    int fibo = Integer.parseInt(n);
                String number = printer.fibonacciString(localIP + ":" + n);
                System.out.println(localIP + ": " + number);
                System.out.println(defaultText);
                n = scanner.nextLine();
            } else {
                System.out.println(localIP + ":" + n);
                System.out.println(localIP + ":" + 0);
                System.out.println(defaultText);
                n = scanner.nextLine();
            }

        }
    }

    private static void chat(Talker.ChatControllerPrx chat){
        //TODO: IMPLEMENT
    }
}