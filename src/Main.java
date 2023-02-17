import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Exercise 1
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        findMinMax(list.stream(), Comparator.naturalOrder(), (min, max) -> System.out.println("Min: " + min + ", Max: " + max));

        // Exercise 2

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printEvenNumbersCount(numbers);


    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        Optional<? extends T> min = stream.min(order);
        Optional<? extends T> max = stream.max(order);

        minMaxConsumer.accept(min.orElse(null), max.orElse(null));
    }

    public static void printEvenNumbersCount(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(num -> num % 2 == 0)
                .count();
        System.out.println("Count of even numbers: " + count);
    }

}