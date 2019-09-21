import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Основной класс приложения.
 */
public class Program {
    private Scanner sc;
    private Generator generator;
    private List<Integer> dividedByThree;
    private List<Integer> dividedBySeven;
    private List<Integer> dividedByTwentyOne;
    private int[] array;

    public Program() {
        this.sc = new Scanner(System.in);
        this.generator = new Generator();
    }

    private String menu() {
        System.out.println("---PROGRAM MENU---");
        System.out.println("[init] - инициализация списков набором значений array");
        System.out.println("[print] - печать всех списков");
        System.out.println("[print <type>] - печать конкретного списка, где type принимает значения X,S,M");
        System.out.println("[anyMore] - выводит на экран были ли значения не вошедшие ни в один список, возможные значения true, false");
        System.out.println("[clear <type>] - чистка списка, где type принимает значения X,S,M");
        System.out.println("[merge] - слить все списки в один вывести на экран и очистить все списки");
        System.out.println("[help] - вывод справки по командам");
        System.out.println("[exit] - выход из меню");
        System.out.println("------------------");
        String choice = read();
        return choice;
    }

    public void start() {
        while (true) {
            String choice = menu();
            switch (choice) {
                case "exit":
                    System.out.println("Good bye!");
                    System.exit(0);
                case "init":
                    initArray();
                    break;
                case "print":
                    printAllLists();
                    break;
                case "anyMore":
                    anyMore();
                    break;
                case "merge":
                    merge();
                    break;
                case "help":
                    help();
                    break;
                default:
                    if (choice.matches("print [XSM]")) {
                        printList(getlist(choice));
                        break;
                    }
                    if (choice.matches("clear [XSM]")) {
                        clear(getlist(choice));
                        break;
                    }
                    throw new AssertionError("Incorrected input value");
            }
        }
    }

    private List<Integer> getlist(String input) {
        if (input.contains("X")) {
            return dividedByThree;
        } else if (input.contains("S")) {
            return dividedBySeven;
        } else if (input.contains("M")) {
            return dividedByTwentyOne;
        } else {
            return null;
        }
    }

    private String read() {
        String choice;

        while (true) {
            try {
                choice = sc.nextLine();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    private void initArray() {
        array = generator.generateArray(20, 0, 30);

        dividedByThree = Arrays.stream(array).
                boxed().
                filter(x -> x % 3 == 0).
                sorted().
                collect(Collectors.toList());

        dividedBySeven = Arrays.stream(array).
                boxed().
                filter(x -> x % 7 == 0).
                sorted().
                collect(Collectors.toList());

        dividedByTwentyOne = Arrays.stream(array).
                boxed().
                filter(x -> x % 21 == 0).
                sorted().
                collect(Collectors.toList());
    }

    private void printList(List<Integer> list) {
        list.stream().
                map(x -> x + " ").
                forEach(System.out::print);

        System.out.println("\n");
    }

    private void printAllLists() {
        System.out.print("List X: ");
        printList(dividedByThree);

        System.out.print("List S: ");
        printList(dividedBySeven);

        System.out.print("List M: ");
        printList(dividedByTwentyOne);
    }

    private void anyMore() {
        long counter;

        counter = Arrays.stream(array).
                boxed().
                filter(x -> (x % 3 != 0) && (x % 7 != 0)).
//                peek(x -> System.out.format("anyMore debug: %d%n", x)).
                count();

        if (counter > 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private void clear(List<Integer> list) {
        list.clear();
    }

    private void merge() {
        List<Integer> mergeList = dividedByThree;
        mergeList.addAll(dividedBySeven);
        mergeList.addAll(dividedByTwentyOne);

        mergeList.stream().
                distinct().
                sorted().
                map(x -> x + " ").
                forEach(System.out::print);

        System.out.println("\n");

        clear(dividedByThree);
        clear(dividedBySeven);
        clear(dividedByTwentyOne);
    }

    private void help() {
        System.out.println("------HELPER-------");
        System.out.println("[init]----- Команда для инициализация списков набором значений array (array генерируется рандомно из 20 чисел от 0 до 30)");
        System.out.println("[print]---- Команда для вывода на экран всех списков");
        System.out.println("[print X]-- Команда для вывода на экран списка с числами, которые можно поделить без остатка на 3");
        System.out.println("[print S]-- Команда для вывода на экран списка с числами, которые можно поделить без остатка на 7");
        System.out.println("[print M]-- Команда для вывода на экран списка с числами, которые можно поделить без остатка на 21");
        System.out.println("[anyMore]-- Команда выводит на экран \"true\" если были значения, не вошедшие ни в один список и \"false\" если нет");
        System.out.println("[clear X]-- Команда для чистки списка листа с числами, которые можно поделить без остатка на 3");
        System.out.println("[clear S]-- Команда для чистки списка листа с числами, которые можно поделить без остатка на 7");
        System.out.println("[clear M]-- Команда для чистки списка листа с числами, которые можно поделить без остатка на 21");
        System.out.println("[merge]---- Команда для того, чтобы слить все списки в один вывести на экран и очистить все списки");
        System.out.println("[exit]----- Выход из меню");
        System.out.println("-------------------");
    }
}
