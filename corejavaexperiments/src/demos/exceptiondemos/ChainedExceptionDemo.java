package demos.exceptiondemos;

public class ChainedExceptionDemo {

    public static void main(String args[]) {
        OrderServiceImpl service = new OrderServiceImpl();
        RequestData requestData = new RequestData();
        requestData.setItem("phone");
        requestData.setUnits(12);
        try {

            service.create(requestData);

        }catch (OrderCreateException e){
          Throwable cause=e.getCause();
          e.printStackTrace();
            System.out.print("order creation unsuccesful");
          if (cause!=null && cause instanceof RequestedItemsExceededException){
              System.out.println(" because "+cause.getMessage());
              cause.printStackTrace();
          }
        }
    }

}
