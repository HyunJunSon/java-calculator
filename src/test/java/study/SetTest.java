package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = Set.of(1,1,2,3);
    }

    @DisplayName("Set의 크기를 확인한다.")
    @Test
    public void setSizeTest(){

        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @DisplayName("Set에 1,2,3 값이 존재하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setValueTest(int value){

        assertTrue(numbers.contains(value));

    }

    @DisplayName("set에 없는 값도 확인할수있다.")
    @ParameterizedTest
    @CsvSource(value = {"1-true" , "2-true" ,"3-true","4-false", "5-false"}, delimiter = '-')
    void setValueTest2(int input, boolean result){

        assertEquals( result , numbers.contains(input));
    }

}
