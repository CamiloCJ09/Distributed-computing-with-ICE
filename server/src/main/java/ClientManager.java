import Talker.ChatClient;
import Talker.ChatClientPrx;

public class ClientManager {
    
    private ChatClientPrx chatClientPrx;
    private String idString;

    public ClientManager(ChatClientPrx chatClientPrx, String idString) {
        this.chatClientPrx = chatClientPrx;
        this.idString = idString;
    }

    public ChatClientPrx getChatClientPrx() {
        return chatClientPrx;
    }

    public void setChatClientPrx(ChatClientPrx chatClientPrx) {
        this.chatClientPrx = chatClientPrx;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }
}
