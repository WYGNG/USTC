package es.source.code.model;

public class MessageEvent {
    private int last;
    private String message;
    private int price;
    public  MessageEvent(String message,int last,int price){
        this.message=message;
        this.last = last;
        this.price = price;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
