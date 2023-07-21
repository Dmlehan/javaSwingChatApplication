package view;

public class MessageSender {
    private String message;
    private String title;
    public MessageSender(String message, String title) {
             this.message=message;
             this.title=title;
    }

    @Override
    public String toString() {
        return title+" : "+message;
    }
}
