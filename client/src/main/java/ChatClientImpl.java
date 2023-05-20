import com.zeroc.Ice.Current;
import Talker.*;
public class ChatClientImpl implements ChatClient{

    @Override
    public void reciveMessage(String message, Current current) {
        System.out.println("Recived message: " + message);
    }

    @Override
    public void notifyCallback(Current current) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyCallback'");
    }
    
}
