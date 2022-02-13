package com.steven.testnavin.response;

import com.steven.testnavin.entity.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public class HttpListUsersResponse extends HttpBaseResponse{

    private List<User> users;

    public HttpListUsersResponse(String text, List<User> users, HttpStatus httpStatus) {
        super(text, httpStatus);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
