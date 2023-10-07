package t1consulting.testtask.service;

import java.util.List;

/**
 * Интерфейс, определяющий сервис анализатора строк.
 */
public interface StringParserService {
    /**
     * Метод предназначен для расчета частоты встреч символов в строке.
     *
     * @param string строка, для которой производится расчет.
     * @return Строка в формате символ : частота встреч символа.
     */
    List<String> calculateCharFrequencyIn(String string);
}
