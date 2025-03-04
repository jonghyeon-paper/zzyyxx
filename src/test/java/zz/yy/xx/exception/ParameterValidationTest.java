package zz.yy.xx.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class ParameterValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void usingAnnotation() throws Exception {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        // parameters.add("key", "123");
        parameters.add("value", "qwe");

        mockMvc.perform(MockMvcRequestBuilders.get("/sample/validation-using-annotation")
                .params(parameters)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andDo((result) -> {
            System.out.println("-------finish--------");
            System.out.println(result.getResolvedException()); 
            System.out.println(result.getResponse().getContentAsString()); 
        });
    }

    @Test
    public void usingCustom() throws Exception {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        // parameters.add("key", "123");
        parameters.add("value", "qwe");

        mockMvc.perform(MockMvcRequestBuilders.get("/sample/validation-using-custom")
                .params(parameters)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo((result) -> {
                    System.out.println("-------finish--------");
                    System.out.println(result.getResolvedException()); 
                    System.out.println(result.getResponse().getContentAsString()); 
                });
    }
}
