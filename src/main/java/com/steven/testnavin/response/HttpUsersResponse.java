package com.steven.testnavin.response;

import com.steven.testnavin.entity.User;
import org.springframework.http.HttpStatus;

import java.util.Set;

public class HttpUsersResponse extends HttpBaseResponse{

    private Set<User> users;

    public HttpUsersResponse(String text, Set<User> users, HttpStatus httpStatus) {
        super(text, httpStatus);
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }
}
