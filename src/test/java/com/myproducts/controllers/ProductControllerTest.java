
package com.myproducts.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes=ProductController.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void callProductControllerShouldReturnResponse() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/product-discount?productName=Jeans")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jeans"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hasDiscount").value("true"));

    }
}