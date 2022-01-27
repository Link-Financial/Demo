package com.link.app.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.link.app.demo.app.request.AddUserRequest;
import com.link.app.demo.app.request.UpdateUserRequest;
import com.link.app.demo.app.rest.UserController;
import com.link.app.demo.user.entity.User;
import com.link.app.demo.user.presentation.user.GetUserResponse;
import com.link.app.demo.user.presentation.user.GetUsersResponse;
import com.link.app.demo.user.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @InjectMocks
    private UserController userController;
    @Mock
    private IUserService userService;

    private ModelMapper mapper;
    private Faker faker;
    private User testUser;
    int id;
    @BeforeEach
    void setUp() {
        mapper = new ModelMapper();
        faker = new Faker();
        id = new Random().nextInt();
        testUser = new User(id,faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());
    }

    @Test
    void getAllUsers() throws Exception {
        var user = mapper.map(testUser,GetUsersResponse.class); new GetUsersResponse();
        List<GetUsersResponse> users = Arrays.asList(user);
        when(userService.getAllUsers()).thenReturn(users);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/users");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getUserById() throws Exception {
        var user = mapper.map(testUser,GetUserResponse.class);
        when(userService.getUserById(id)).thenReturn(user);
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/users/" + id);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(content));
    }

    @Test
    void addUser() throws Exception {
        var user = mapper.map(testUser, AddUserRequest.class);
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    void updateUser() throws Exception {
        var user = mapper.map(testUser,UpdateUserRequest.class);
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/users/"+id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
    @Test
    void getUserByIdShouldReturnExceptionWhenIdTypeIsNotInteger() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/users/" + "anyString");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    void addUserShouldReturnExceptionWhenFirstNameIsNullAndEmailIsNotValid() throws Exception {
        var user = new AddUserRequest(null,faker.name().lastName(),"exceptionParam");
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
