package com.example.demo;

import com.example.demo.entity.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class MainUserViewSerialization {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setFirstName("Marcial");
        user.setUsername("mgperez");

        System.out.println("-- before serialization --");
        System.out.println(user);

        ObjectMapper om = new ObjectMapper();
        String jsonString = om.writerWithView(UserView.QuickContactView.class)
                .writeValueAsString(user);
        System.out.println("-- after serialization --");
        System.out.println(jsonString);

    }
}
