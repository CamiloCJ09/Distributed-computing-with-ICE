module Talker
{
    sequence<string> StringSeq;
    interface Callback
    {
        void notifyCallback();
    };

    interface ChatController
    {
        void sendMessage(string msg, string destination);

        void broadcastMessage(string message);

        void register(string hostname);
    };

    interface ChatClient
    {
        void reciveMessage(string message);
    };

}