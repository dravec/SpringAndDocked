package lax.lajolla.SpringBoot;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldWellComeMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(
                "<b>Wellcome Screen </b> <br> <a href=\"/all\">La lista de palabras</a>")));
    }
    @Test
    public void shouldReturnAllPalabras() throws Exception {
        this.mockMvc.perform(get("/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("[{\"value\":\"objetivo\",\"idioma\":\"es\"}]"))
                .andExpect(content().string(containsString("[{\"value\":\"objetivo\",\"idioma\":\"es\"}]")));
    }
}
	