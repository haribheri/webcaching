public class Main{

    private Queue<PageRequestEvent> pageRequestEventsQueue;
    private Client client;  

    public static void main(String[] args)
    {
        pageRequestEventsQueue = new Queue<PageRequestEvent>();
	client = new Client(pageRequestEventsQueue);
    }
}