package demos.exceptiondemos;

public class StringWork {

    public static void main(String args[]){
            StringWork demo = new StringWork();
            System.out.println("inside main before lowercase called");
            try {
                String result = demo.toLowerCase("good");
                System.out.println("result=" + result);
            }catch (InvalidArgumentException e){
                System.out.println("invalid argument,"+e.getMessage());
            }

    }

    String toLowerCase(String input) throws InvalidArgumentException{
            if (input == null || input.isEmpty()) {
              throw  new InvalidArgumentException("input is null or empty");
            }
            String lowercased = input.toLowerCase();
            System.out.println("after lowercase");
            return lowercased;

    }

}
