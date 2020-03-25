package com.example.demo.controllers;

import com.example.demo.models.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserControllerTests {

    @Test
    void TestFirstCase() {
        UserController userController = new UserController();

        User user = userController.getUser();
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getName()).isEqualTo("John");
    }


}
