import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        IntStream stream = Arrays.stream(arr);
        stream
                .filter( x -> x % 2 == 1 )
                .forEach( System.out::println );

//        for (int i = 0; i < arr.length; i++) {
//            if(i % 2 == 1){
//                System.out.println(i);
//            }
//        }



    }

}