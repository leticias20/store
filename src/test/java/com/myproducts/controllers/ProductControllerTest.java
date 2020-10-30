
package com.myproducts.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.myproducts.store.StoreApplication;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;

@SpringBootTest(classes= StoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void callProductControllerShouldReturnResponse() throws Exception {

        LinkedMultiValueMap<String,String> requestParams = new LinkedMultiValueMap<>();

        requestParams.add("productName","Jeans");

        this.mockMvc.perform(get("/product-discount").params(requestParams))
                .andDo(print())
                //.accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jeans"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.hasDiscount").value("true"));

    }
}