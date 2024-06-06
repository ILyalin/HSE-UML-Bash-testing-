mport java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.function.Function;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new BufferedReader(new InputStreamReader(System.in, "UTF-8")).lines()
                .flatMap(line -> Pattern.compile("(?U)\\b[\\p{IsAlphabetic}\\d]+\\b")
                        .matcher(line.toLowerCase())
                        .results()
                        .map(MatchResult::group))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().equals(a.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue().compareTo(a.getValue()))
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
    }
}