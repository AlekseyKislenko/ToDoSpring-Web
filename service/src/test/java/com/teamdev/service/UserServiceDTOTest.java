package com.teamdev.service;

import com.teamdev.model.entity.DTO.UserDTO;
import com.teamdev.service.dao.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * @author Aleksey Kislenko
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
@Transactional
public class UserServiceDTOTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSavedUserHasId() {
        UserDTO user = userService.createUser("John", "root");
        assertNotNull(user.getId());
        assertNotNull(userService.getUserById(user.getId()));
    }

    @Test
    public void testDeleteUserById() {
        UserDTO user = userService.createUser("Mike", "root");
        assertTrue(userService.deleteUserById(user.getId()));
    }

    @Test
    public void testSelectListUsers() {
        UserDTO user1 = userService.createUser("Mike", "root");
        UserDTO user2 = userService.createUser("John", "root");
        UserDTO user3 = userService.createUser("Garry", "root");
        UserDTO user4 = userService.createUser("Peter", "root");

        List<UserDTO> allUsers = userService.getAllUsers();

        assertEquals(4, allUsers.size());

        assertEquals(user1.getLogin(), allUsers.get(0).getLogin());
        assertEquals(user2.getLogin(), allUsers.get(1).getLogin());
        assertEquals(user3.getLogin(), allUsers.get(2).getLogin());
        assertEquals(user4.getLogin(), allUsers.get(3).getLogin());
    }



}
