import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Основной класс для запуска приложения
 */
public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        int[] array = generator.generateArray(20,0,50);
        Arrays.stream(array).forEach(System.out::println);

        List<Integer> dividedByThree = Arrays.stream(array).
                boxed().
                filter(x -> x % 3 == 0).
                sorted().
                peek(x -> System.out.format("divided by 3: %d%n", x)).
                collect(Collectors.toList());

        List<Integer> dividedBySeven = Arrays.stream(array).
                boxed().
                filter(x -> x % 7 == 0).
                sorted().
                peek(x -> System.out.format("divided by 7: %d%n", x)).
                collect(Collectors.toList());

        List<Integer> dividedByTwentyOne = Arrays.stream(array).
                boxed().
                filter(x -> x % 21 == 0).
                sorted().
                peek(x -> System.out.format("divided by 21: %d%n", x)).
                collect(Collectors.toList());
    }


}


//        Stream.of(120, 410, 85, 32, 314, 12, 5, 25, 77, 33).
//                filter(x -> x % 5 == 0).
//                peek(x -> System.out.format("after filter: %d%n", x)).
//                sorted().
//                forEach(System.out::println);

