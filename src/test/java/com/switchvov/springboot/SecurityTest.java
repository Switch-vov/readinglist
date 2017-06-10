package com.switchvov.springboot;

import com.switchvov.springboot.pojo.Reader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SecurityTest {
    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void home_page_unauthenticated_user() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "http://localhost/login"));
    }

    @Test
    // @WithUserDetails("Switch")
    @WithMockUser(username = "Switch", roles = "READER")
    public void home_page_authenticated_user() throws Exception {
        Reader expectedReader = new Reader();
        expectedReader.setUsername("Switch");
        expectedReader.setPassword("password");
        expectedReader.setFullname("Switch");

        mockMvc.perform(get("/readinglist/Switch"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                //.andExpect(model().attribute("reader", samePropertyValuesAs(expectedReader)))
                .andExpect(model().attribute("books", hasSize(0)));
    }
}
