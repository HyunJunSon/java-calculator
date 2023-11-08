package study;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @DisplayName("1,2 를 , 기준으로 split 했을때 1,2로 잘 분리되는지 확인한다.")
    @Test
    void splitTest(){
        String[] expected = {"1" ,"2"};
        String target = "1,2";

        assertThat(target.split(","))
                .contains(expected[0],expected[1])
//                .isEqualTo(expected);
                .containsExactly(expected);
//
    }

    @DisplayName("1을 , 기준으로 split 했을대 1만을 포함하는 배열이 반환되는지 확인한다.")
    @Test
    public void splitTest2(){
        String[] expected = {"1"};
        String target = "1";

        assertThat(target.split(","))
                .contains(expected[0])
                .containsExactly(expected);

    }

    @DisplayName("요구사항2 : \"(1,2)\"가 주어질때 ()를 제거하고 1,2가 반환되는지 확인")
    @Test
    public void subStringTest(){
        String expected = "1,2";
        String target = "(1,2)";

        assertThat(target.substring(1, target.length() - 1))
                .isEqualTo(expected);
    }


    @DisplayName("요구사항3 : charAt()으로 특정 위치의 문자 가져오는지 확인")
    @ParameterizedTest()
    @ValueSource(ints = {0, 1, 2, 3})
    public void charAtTest(int index) {
        String target = "abc";
        char expected = 'b';

        if (index < target.length()) {
            char actual = target.charAt(index);
            assertThat(actual).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> target.charAt(index))
                    .isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: " + index);
        }
    }


}
