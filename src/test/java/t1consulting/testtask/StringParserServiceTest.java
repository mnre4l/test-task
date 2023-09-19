package t1consulting.testtask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import t1consulting.testtask.service.StringParserService;
import t1consulting.testtask.service.StringParserServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестирование сервиса парсинга")
public class StringParserServiceTest {
    private final StringParserService stringParserService = new StringParserServiceImpl();

    @Test
    @DisplayName("На вход в сервис пришла строка из 1 символа")
    void shouldReturnOneCharAndOneCount() {
        String s = "a";
        List<String> expectedResult = List.of("a:1");

        assertEquals(expectedResult, stringParserService.calculateCharFrequencyIn(s));
    }

    @Test
    @DisplayName("На вход в сервис пришла строка из n одинаковых символов")
    void shouldReturnOneCharAndTenCount() {
        int n = 10;
        String s = "a".repeat(n);
        List<String> expectedResult = List.of("a:" + n);

        assertEquals(expectedResult, stringParserService.calculateCharFrequencyIn(s));
    }

    @Test
    @DisplayName("На вход в сервис пришла стандартная строка")
    void shouldReturnExpectedResult() {
        String s = "T1Consultiinggg";
        List<String> result = stringParserService.calculateCharFrequencyIn(s);

        assertEquals("g:3", result.get(0));
        assertEquals("i:2", result.get(1));
    }
}
