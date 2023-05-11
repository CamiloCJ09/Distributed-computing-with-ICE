import java.util.ArrayList;
import java.util.List;

import com.zeroc.Ice.Current;
import Talker.*;

public class ChatImpl implements ChatController {

    private List<String> clients;
   

    public ChatImpl(){
        clients = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, String destination, Current current) {
        // TODO Auto-generated method stub
            
    }

    @Override
    public void broadcastMessage(String message, Current current) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'broadcastMessage'");
    }

    @Override
    public void subscribe(ChatClientPrx client, Current current) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subscribe'");
    }

    @Override
    public void register(String hostname, Current current) {
        clients.add(hostname);
    }

    @Override
    public String[] getClients(Current current) {
        String[] clientsArr = new String[clients.size()];
        return clients.toArray(clientsArr);
    }

 
     
    
}
