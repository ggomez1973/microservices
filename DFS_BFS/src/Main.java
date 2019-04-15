import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Fizzbuzz
        // IntStream.range(0, 100).forEach(i ->fizzbuzz(i));
        // plusMinus
        //plusMinus(new int[]{1, -2, -7, 9, 1, -8 ,-5});
        //plusMinus(null);
        //plusMinus(new int[]{});
        //staircase(5);
        //miniMaxSum(new int[]{8,5,3,4,5});
        //birthdayCakeCandles(new int[]{3,2,1,3});

    }

    private static void birthdayCakeCandles(int[] ar) {
        OptionalInt max= Arrays.stream(ar).max();
        long candles = Arrays.stream(ar).filter(p -> p == max.getAsInt()).count();
        System.out.println(candles);
    }

    private static void miniMaxSum(int[] ints) {
        List<Integer> boxedInts = Arrays.stream(ints).boxed().sorted().collect(Collectors.toList());
        List<Integer> max = boxedInts.subList(1,boxedInts.size());
        List<Integer> min = boxedInts.subList(0, boxedInts.size()-1);
        System.out.println(boxedInts);
        System.out.println(min.stream().mapToLong(p -> p.longValue()).sum()+" "+max.stream().mapToLong(p -> p.longValue()).sum());
    }

    private static void staircase(int n) {
        StringBuilder builder = new StringBuilder();
        if(n > 0) {
            for (int i = 0; i < n; i++)
                builder.append(" ");
            int j = 0;

            for (int i = 1; i <= n; i++) {
                builder.replace(builder.length() - i,
                        builder.length() - j, "#");
                System.out.println(builder);
                j++;
            }
        }
    }

    private static void plusMinus(int[] ints) {
        assert (ints != null); assert (ints.length <=100); // Don't work if disabled
        if(ints != null && ints.length > 0 && ints.length <=100) {

            Map<String, List<Integer>> values = Arrays.stream(ints).boxed()
                    .collect(Collectors.groupingBy(v -> {
                        int x = v;
                        if (x > 0) {
                            return "plus";
                        } else if (x < 0) {
                            return "minus";
                        }
                        return "zero";
                    }));
            System.out.println(values);

            Map<String, Long> valuesCount = Arrays.stream(ints).boxed()
                    .collect(Collectors.groupingBy(v -> {
                        int x = (int) v;
                        if (x > 0) {
                            return "plus";
                        } else if (x < 0) {
                            return "minus";
                        }
                        return "zero";
                    }, Collectors.counting()));

            if (valuesCount.get("plus") == null) {
                valuesCount.put("plus", 0L);
            }
            if (valuesCount.get("minus") == null) {
                valuesCount.put("minus", 0L);
            }
            if (valuesCount.get("zero") == null) {
                valuesCount.put("zero", 0L);
            }
            System.out.println(new DecimalFormat("#0.000000").format(valuesCount.get("plus").doubleValue() / ints.length));
            System.out.println(new DecimalFormat("#0.000000").format(valuesCount.get("minus").doubleValue() / ints.length));
            System.out.println(new DecimalFormat("#0.000000").format(valuesCount.get("zero").doubleValue() / ints.length));
        }
    }

    private static void fizzbuzz(int i) {
        String fizz = "", buzz = "";
        if(i%3!=0 && i%5!=0){
            System.out.println(i);
        } else {
            if (i%3==0) {
                fizz = "Fizz";
            }
            if (i%5==0) {
                buzz = "Buzz";
            }
            System.out.println(fizz + buzz);
        }
    }

    private static String apply(Object v) {
        Integer i = (Integer) v;
        if(i < 0){
            return "minus";
        } else if(i > 0) {
            return "plus";
        } else {
            return "zero";
        }
    }
}
