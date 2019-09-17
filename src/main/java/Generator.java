import java.util.Random;

/**
 * Класс для генерации начального массива чисел.
 *
 * @author hoffmann
 */
public class Generator {
    public int[] generateArray(long limit, int low, int high) {
        int[] array = new Random().ints(limit, low, high).toArray();
        System.out.println("New array: " + array);
        return array;
    }
}
