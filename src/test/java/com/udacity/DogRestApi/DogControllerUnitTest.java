package com.udacity.DogRestApi;

import com.udacity.DogRestApi.service.DogService;
import com.udacity.DogRestApi.web.DogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
@WithMockUser(username = "admin", password = "password", roles = "USER")
public class DogControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DogService dogService;

    @Test
    public void getAllDogs() throws Exception {
        mockMvc.perform(get("/dogs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogs();
    }

    @Test
    public void getDogBreed() throws Exception {
        mockMvc.perform(get("/dogs/breed"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogBreed();
    }

    @Test
    public void getDogBreedById() throws Exception {
        mockMvc.perform(get("/1/breed"))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById(1);
    }
}
