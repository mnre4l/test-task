package t1consulting.testtask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Тестирование контроллера")
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Пришла null строка")
    void shouldBeBadRequestWhenStringIsNull() throws Exception {
        mockMvc.perform(
                        get("/parser")
                                .param("string", ""))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Пришла строка с пробелами")
    void shouldBeBadRequestWhenStringWithSpaces() throws Exception {
        mockMvc.perform(
                        get("/parser")
                                .param("string", "T 1 Consulting"))
                .andExpect(status().isBadRequest());
    }
}
