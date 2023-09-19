package t1consulting.testtask.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StringParserServiceImpl implements StringParserService {
    public List<String> calculateCharFrequencyIn(String string) {
        log.info("Вычисялем частоту символов в строке: {}", string);
        /*
        мапа вида символ : частота встреч символа в строке
         */
        final Map<Character, Integer> result = new HashMap<>();

        for (Character c : string.toCharArray()) {
            result.compute(c, (k, v) -> v == null ? 1 : ++v);
        }
        log.info("Результат вычисления частоты символов (без сортировки): {}", result);
        return result.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(characterIntegerEntry -> characterIntegerEntry.getKey() + ":" + characterIntegerEntry.getValue())
                .collect(Collectors.toList());
    }
}
