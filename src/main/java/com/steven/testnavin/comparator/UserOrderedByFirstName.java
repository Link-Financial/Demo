package com.steven.testnavin.comparator;

import com.steven.testnavin.entity.User;

import java.util.Comparator;

public class UserOrderedByFirstName implements Comparator<User> {

    public int compare(User user1, User user2) {
        if (user1.getFirstName().compareTo(user2.getFirstName()) == 0) {
            return user1.getUserId() >= user2.getUserId() ? 1 : 0;
        }
        return user1.getFirstName().compareTo(user2.getFirstName());
    }
}
