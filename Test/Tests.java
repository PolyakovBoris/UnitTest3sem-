import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Calculation;
import org.example.Main;
import org.example.SomeService;
import org.junit.jupiter.api.*;

public class Tests {

    /**
    Задание 1
    **/
    @Test
    void insufficientCoverageTest() {
        SomeService someService = new SomeService();

        System.out.println(someService.calculatingDiscount(2000.0, 10));
        assertThat(someService.calculatingDiscount(2000.0, 50))
                .isEqualTo(1000); // обычная скидка
        assertThat(someService.calculatingDiscount(2000.0, 100))
                .isEqualTo(0); // обычная скидка
        assertThat(someService.calculatingDiscount(2000.0, 0))
                .isEqualTo(2000); // обычная скидка
    }

    @Test
    void discounCorrect() {
        SomeService someService = new SomeService();
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }
    @Test
    void discounNotCorrect(){
        SomeService someService = new SomeService();
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

    @Test
    void purchaseAmountLessThanZeroException (){
        SomeService someService = new SomeService();
        assertThatThrownBy(() ->
                someService.calculatingDiscount(-1, 5))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    /**
    Задание 2
    **/

    @DisplayName("проверка четного")
    @Test
    void isItEven (){
        Calculation calculation = new Calculation();
        assertTrue(calculation.evenOddNumber(2));
    }
    @DisplayName("проверка нечетного")
    @Test
    void isItOdd (){
        Calculation calculation = new Calculation();
        assertFalse(calculation.evenOddNumber(3));
    }

    /**
      Задание 3
     **/

    @DisplayName("проверка числа в интервале")
    @Test
    void isItInInterval () {
        Calculation calculation = new Calculation();
        assertTrue(calculation.numberInInterval(25));
        assertTrue(calculation.numberInInterval(26));
        assertTrue(calculation.numberInInterval(100));
        assertTrue(calculation.numberInInterval(99));
    }
    @DisplayName("проверка числа не в интервале")
    @Test
    void isItNotInInterval () {
        Calculation calculation = new Calculation();
        assertFalse(calculation.numberInInterval(24));
        assertFalse(calculation.numberInInterval(101));
    }

}
