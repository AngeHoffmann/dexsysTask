import java.util.Arrays;

/**
 * Основной класс для запуска приложения
 */
public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        int[] array = generator.generateArray(15,0,15);
        Arrays.stream(array).forEach(System.out::println);



//        Stream.of(120, 410, 85, 32, 314, 12, 5, 25, 77, 33).
//                filter(x -> x % 5 == 0).
//                peek(x -> System.out.format("after filter: %d%n", x)).
//                sorted().
//                forEach(System.out::println);
    }
}

