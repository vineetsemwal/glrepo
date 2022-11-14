package demos.streamapidemos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamApiDemo6 {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();

        list.add(20);
        list.add(40);
        list.add(30);
        list.add(50);
        list.add(10);

        Stream<Integer> stream1 = list.stream();
        BinaryOperator<Integer>operator=(a,b)->a+b;
        Optional<Integer> optional=stream1.reduce(operator);
        if(optional.isPresent()){
            Integer value=optional.get();
            System.out.println("value="+value);
        }

    }
}
