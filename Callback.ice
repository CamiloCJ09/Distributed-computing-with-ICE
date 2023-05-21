module Talker
{
    sequence<string> StringSeq;
    
    interface ChatClient
    {
        void notifyCallback();
        void reciveMessage(string message);
    };

    interface ChatController
    {
        void sendMessage(string msg, string destination);

        void broadcastMessage(string message);

        void subscribe(ChatClient* client, string hostname);

        void register(string hostname, ChatClient* client);
        
        StringSeq getClients();
    };

}