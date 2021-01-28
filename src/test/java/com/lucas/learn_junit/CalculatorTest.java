package com.lucas.learn_junit;

//"junit-jupiter-params"
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

//junit-jupiter-api
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Learnig the juinter api
 * For the tests results open the file on browser: build/reports/tests/test/index.html
 */
@DisplayName("Test class for Calculator")
public class CalculatorTest {
    private static Calculator calc = null;
    
    @BeforeAll
    static void initAll() { calc = new Calculator(); }

    @BeforeEach
    void enableCalculator() { calc.enableCalculator(); }

    @Test
    @DisplayName("Test if 1 + 1 = 2") 
    void simpleAdition() { assertEquals(2, calc.add(1, 1)); }

    @Test
    @Disabled("This will never works")
    @DisplayName("This will never works")
    void failingTest() { fail("a failing test"); }

    /**
     * 
     * !! Parameterized tests are currently an experimental feature. !!
     * 
     */
    @DisplayName("Test if square calc is ok for numbers 2, 3 and 4") // ## this not work ##
    @ParameterizedTest(name = "{index} => the square of {0}")
    @ValueSource(ints = {2, 3, 4})
    void sqare(int num) {  assertEquals(num * num, calc.square(num));  }

    @DisplayName("Test if some additions") 
    @ParameterizedTest(name = "{index} => {0} + {1} = {2}")
    @CsvSource({
    	"0, 1, 1",
    	"1, 2, 3",
    	"2, 3, 5",
    })
    void simpleAditionWithMultiplevalues(int a, int b, int x) {  assertEquals(x, calc.add(a, b)); }

    @AfterEach
    void disableCalculator() { calc.disableCalculator();  }

    @AfterAll
    static void tearDownAll() { calc = null; }
}
