import java.util.stream.Stream;

/**
 * Основной класс для запуска приложения
 */
public class Main {
    public static void main(String[] args) {
        Stream.of(120, 410, 85, 32, 314, 12, 5, 25, 77, 33).
                filter(x -> x % 5 == 0).
                peek(x -> System.out.format("after filter: %d%n", x)).
                sorted().
                forEach(System.out::println);
    }
}

