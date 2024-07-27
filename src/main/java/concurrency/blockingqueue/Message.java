package concurrency.blockingqueue;

public class Message {
    private final int id;

    public Message(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    // producer and consumer both accessing a shared location (state)
    // p putting value and c is retrieving
    // in this example p and c are p or c messages
}
