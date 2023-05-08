module Talker
{
    sequence<string> StringSeq;
    interface Callback
    {
        void notifyCallback();
    };

    interface ChatClient
    {
        void reciveMessage(string message);
    };

    interface ChatController
    {
        void sendMessage(string msg, string destination);

        void broadcastMessage(string message);

        void subscribe(Callback* callback, ChatClient* client);

        void register(string hostname);
    };

}