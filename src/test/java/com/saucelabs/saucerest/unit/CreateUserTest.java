package com.saucelabs.saucerest.unit;

import com.saucelabs.saucerest.model.accounts.CreateUser;
import com.saucelabs.saucerest.model.accounts.Roles;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateUserTest {

    @Test
    public void checkParameterTest() {
        List<String> passwords = Arrays.asList("testtest", "testtest1", "testtest!", "testtest1!", "testTEST1", "test");

        for (String password : passwords) {
            assertThrows(IllegalArgumentException.class, () ->
                new CreateUser.Builder()
                    .setUserName("test")
                    .setFirstName("test")
                    .setLastName("test")
                    .setEmail("test@example.com")
                    .setOrganization("test")
                    .setRole(Roles.MEMBER)
                    .setPassword(password)
                    .build());
        }

        assertDoesNotThrow(() -> {
            new CreateUser.Builder()
                .setUserName("test")
                .setFirstName("test")
                .setLastName("test")
                .setEmail("test@example.com")
                .setOrganization("test")
                .setRole(Roles.MEMBER)
                .setPassword("testTEST1!")
                .build();
        });
    }
}