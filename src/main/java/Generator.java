import java.util.Arrays;
import java.util.Random;

/**
 * Класс для генерации начального массива чисел.
 */
public class Generator {
    public int[] generateArray(long limit, int low, int high) {
        int[] array = new Random().ints(limit, low, high).toArray();
        System.out.println("New array was generated: " + Arrays.toString(array) + "\n");
        return array;
    }
}
