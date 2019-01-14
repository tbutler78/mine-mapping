package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.service.MineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.jayway.jsonassert.impl.matcher.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MineController.class)
public class MineControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MineService mineService;

    @Test
    public void givenMines_whenGetMines_thenReturnJsonArray() throws Exception{
        Mine mine = new Mine();
        mine.setDeposit("cumberland");

        List<Mine> mines = Arrays.asList(mine);

        given(mineService.findAll()).willReturn(mines);

        this.mvc.perform(get("/mines/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void givenMines_whenGetMineByName_thenReturnJsonValue() throws Exception {
        Mine mine = new Mine();
        mine.setDeposit("blackjack");
        List<Mine> mines = Arrays.asList(mine);

        given(mineService.findMineByName("blackjack")).willReturn(mines);

        this.mvc.perform(get("/mines/minename/blackjack").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$",hasSize(1)));
    }

    @Test
    public void givenMines_whenGivenMineById_thenReturnJsonValue() throws Exception {
        Mine mine = new Mine();
        mine.setDeposit("blackjack");
        mine.setId(1L);


        given(mineService.getMine(1L)).willReturn(mine);

        this.mvc.perform(get("/mines/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
