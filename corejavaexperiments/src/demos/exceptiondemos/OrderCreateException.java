package demos.exceptiondemos;

public class OrderCreateException extends Exception{
    public OrderCreateException(String msg){
        super(msg);
    }
    public OrderCreateException(String msg, Throwable cause){
        super(msg,cause);
    }
}
