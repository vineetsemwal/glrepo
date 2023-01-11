package demos.exceptiondemos;

public class OrderServiceImpl {


    public  Order  create(RequestData request) throws OrderCreateException {
        try {
           processItems(request.getItem(), request.getUnits());

            //order processing here

            return new Order(request.getItem(),request.getUnits());

        }catch (RequestedItemsExceededException e){
             throw new OrderCreateException("ocuureded because of items exception",e);

        }
    }

    void processItems(String items, int units){
        if(units>getExistingQuantity()){
            throw new RequestedItemsExceededException(units+" items doesn't exist");
        }

    }

    public  int getExistingQuantity(){
        return 1;
    }


}
