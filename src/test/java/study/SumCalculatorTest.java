package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumCalculatorTest {

    @DisplayName("문자열 덧셈 계산의 값을 확인한다.")
    @ParameterizedTest
    @CsvSource(value = { "-0","1,2-3", "1,2,3-6", "1,2:3-6"}, delimiter = '-')
    void stringToIntTest(String target, int total){

        if (target.isEmpty())
            throw new RuntimeException("숫자 값이 아닙니다.");

        int targetSum =
                Arrays.stream(target.split(",:"))
                        .mapToInt(Integer::parseInt)
                        .sum();

        assertEquals(targetSum, total);
    }

}
