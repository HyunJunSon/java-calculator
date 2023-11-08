import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "-0";

        String[] split = str.split("-");

        System.out.println(Arrays.toString(split));
    }
}
