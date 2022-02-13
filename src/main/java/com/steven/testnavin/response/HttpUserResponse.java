package com.steven.testnavin.response;

import com.steven.testnavin.entity.User;
import org.springframework.http.HttpStatus;

public class HttpUserResponse extends HttpBaseResponse{

    private UserResponse user;

    public HttpUserResponse(String text, User user, HttpStatus httpStatus) {
        super(text, httpStatus);
        this.user = new UserResponse();
        if(user != null) {
            this.getUser().setEmail(user.getEmail());
            this.getUser().setFirstName(user.getFirstName());
            this.getUser().setLastName(user.getLastName());
            this.getUser().setId(user.getUserId());
        }
    }

    public UserResponse getUser() {
        return user;
    }

}
