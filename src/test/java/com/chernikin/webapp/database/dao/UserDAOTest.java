package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.domain.User;
import org.junit.Ignore;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {

    @Ignore
    @Test
    public void returnUserWhenUserDataExist() {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser("VladChernikin1", "Chernikin1");

        assertNotNull(user);
        System.out.println(user);
    }

    @Ignore
    @Test
    public void returnNullWhenUserDataNotExist() {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser("qwerty", "sasay");

        assertNull(user);
    }

    @Ignore
    @Test
    public void returnUserIdIfUserSuccessfullySavedInDatabase() {
        UserDAO userDAO = new UserDAO();

        User user = new User();
        user.setLogin("qwe");
        user.setPassword("asdas");
//        user.setFirstName("asd");
//        user.setLastName("asdas");

        int i = userDAO.create(user);

        assertTrue(i > -1);
    }

    /*@Ignore
    @Test
    public void returnAllUserWhenUserDataExist() {
        UserDAO userDAO = new UserDAO();
        List<User> allUser = userDAO.getAllUser();

        assertNotNull(allUser);
        assertFalse(allUser.isEmpty());
    }

    @Ignore
    @Test
    public void returnAllUserByRoleUserWhenUserDataExist() {
        UserDAO userDAO = new UserDAO();
        List<User> allUser = userDAO.getAllUser();

        assertNotNull(allUser);
        assertFalse(allUser.isEmpty());
    }*/
    @Ignore
    @Test
    public void returnUsersByRoleUserWhenUserDataExist() {
        UserDAO userDAO = new UserDAO();
        /*List<String> roles = new ArrayList<>();
        roles.add("user");
        roles.add("moderator");*/
        List<User> users = userDAO.getUsersByRole("user", "moderator");

        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}
