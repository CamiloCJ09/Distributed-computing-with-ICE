import java.util.ArrayList;
import java.util.List;

import com.zeroc.Ice.Current;
import Talker.*;

public class ChatImpl implements ChatController {

    private List<ClientManager> clients;
    private List<String> messagesList;

    public ChatImpl(){
        clients = new ArrayList<>();
        messagesList = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, String destination, Current current) {
        System.out.println("Sending message: " + msg + " to: " + destination);
        new Thread(() -> {
            ChatClientPrx callbackPrx = getCallbackPrx(destination);
            System.out.println("new Message: " + msg);
            comand(msg, callbackPrx, current);
        }).start();
            
    }

    public void comand(String msg, ChatClientPrx callbackPrx, Current current) {
        if (msg.contains("BC")) {
            broadcastMessage(msg.split("BC ")[1], current);
        } else if (msg.contains("list clients")) {
            sendMessage("list clients "+ clients.toString(), callbackPrx.ice_getAdapterId(), current);
        } else if (msg.contains("to ") && msg.contains(":")) {
            String hostname = msg.split("to ")[1].split(":")[0];
            String message = msg.split("to ")[1].split(":")[1];
            for(ClientManager client : clients){
                if(client.getChatClientPrx().equals(callbackPrx)){
                    sendMessages(message, client.getChatClientPrx());
                }
            }
        } else if (msg.toLowerCase().equals("help")) {
            callbackPrx.reciveMessage("BC <msg> : envia un mensaje a todos los clientes conectados");
            callbackPrx.reciveMessage("list clients : lista los clientes conectados");
            callbackPrx.reciveMessage("to <hostname>:<msg> : envia un mensaje a un cliente especifico");
            callbackPrx.reciveMessage("fibonacci: <numero> : retorna la serie de fibonacci hasta <numero>");;

        }else if(msg.contains("fibonacci:")){
            String result = fibonacciString(msg);
            callbackPrx.reciveMessage("resultado: "+result);
        } else {
            callbackPrx.reciveMessage("comando no reconocido");
        }

    }
    public String fibonacciString(String n) {
        String array[] = n.split(":");
        int num = Integer.parseInt(array[1]);
    
        int[] fib = new int[num];
        fib[0] = 0;
        if (num > 1) {
            fib[1] = 1;
            for (int i = 2; i < num; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }

        String fibString = "";
        for (int i = 0; i < num; i++) {
            fibString += fib[i] + " ";
        }
        
        return String.valueOf(fib[num - 1]);
    }

    private void sendMessages(String msg, ChatClientPrx clientPrx){
        clientPrx.reciveMessage(msg);
    }

    @Override
    public void broadcastMessage(String message, Current current) {
        clients.stream().forEach(client -> 
            sendMessages(message, client.getChatClientPrx())
        );
    }

    @Override
    public void subscribe(ChatClientPrx client,String hostname ,Current current) {
        System.out.println("Registering client: ");
        ClientManager clientManager = new ClientManager(client, hostname);
        if(!clients.contains(clientManager)){
            clients.add(clientManager);
        }
    }

    @Override
    public void register(String hostname, ChatClientPrx client, Current current) {
        System.out.println("Registering client: " + hostname);
        ClientManager clientManager = new ClientManager(client, hostname);
        if(!clients.contains(clientManager)){
            clients.add(clientManager);
        }
    }

    @Override
    public String[] getClients(Current current) {
        String[] clientsArr = new String[clients.size()];
        return clients.toArray(clientsArr);
    }

    public ChatClientPrx getCallbackPrx(String hostname) {
        for (ClientManager client : clients) {
            if (client.getIdString().equals(hostname)) {
                System.out.println("se encontró el callback de " + hostname + "");
                return client.getChatClientPrx();
            }
        }
        System.out.println("no se encontró el callback de " + hostname + "");
        return null;
    }
 
     
    
}
