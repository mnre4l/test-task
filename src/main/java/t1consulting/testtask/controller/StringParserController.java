package t1consulting.testtask.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import t1consulting.testtask.service.StringParserService;
import t1consulting.testtask.service.validation.OneWord;

import javax.validation.Valid;
import java.util.List;

/**
 * Класс-контролер для обслуживания поступающих на парсинг строк.
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/parser")
@Validated
public class StringParserController {
    /**
     * Сервис парсинга строк.
     */
    private final StringParserService stringParserService;

    /**
     * Метод предназначен для возвращения результата расчета частоты встречи символов в строке в формате:
     * символ : частота встречи символа в строке string
     * В качестве ограничений предполагается, что string != null и string не содержит пробелов.
     *
     * @param string строка, для которой производится подсчет встречающихся символов
     * @return лист строк вида символ : частота встреч символа в строке
     */
    @GetMapping
    public List<String> getCharFrequencyIn(@RequestParam(value = "string") @Valid @OneWord final String string) {
        log.info("GET /parser, string = {}", string);
        return stringParserService.calculateCharFrequencyIn(string);
    }
}
