package demos.exceptiondemos;

public class RequestedItemsExceededException extends RuntimeException{
    public RequestedItemsExceededException(String msg){
        super(msg);
    }
}
