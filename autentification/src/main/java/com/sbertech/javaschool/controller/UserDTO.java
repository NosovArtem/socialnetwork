package com.sbertech.javaschool.controller;

import com.sbertech.javaschool.model.User;

public class UserDTO
{
    private User user;
    private boolean isFriend = false;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }
}
