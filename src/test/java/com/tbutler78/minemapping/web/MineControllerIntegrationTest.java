package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.MineMappingApplication;
import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.repository.MineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MineMappingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-integrationtest.properties")
public class MineControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    MineRepository mineRepository;

    @Test
    public  void givenMines_whenMines_thenReturn200() throws Exception {
        Mine mine = new Mine();
        mine.setDeposit("blackjack");
        mine.setId(1L);

        mvc.perform(get("/mines/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
