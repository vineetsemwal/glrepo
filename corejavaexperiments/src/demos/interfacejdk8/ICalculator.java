package demos.interfacejdk8;

public  interface ICalculator {
    static String className(){
        return "ICalculator";
    }

    default int add(int num1, int num2){
         return num1+num2;
     }

    int sub(int num1, int num2);

}
