package com.teamdev.service;

import com.teamdev.model.entity.DTO.UserDTO;
import com.teamdev.model.entity.UserAuthority;
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
        UserDTO user = userService.createUser("John", "root", UserAuthority.ROLE_USER, true);
        assertNotNull(user.getId());
        assertNotNull(userService.getUserById(user.getId()));
    }

    @Test
    public void testDeleteUserById() {
        UserDTO user = userService.createUser("Mike", "root", UserAuthority.ROLE_USER, true);
        assertTrue(userService.deleteUserById(user.getId()));
    }

    @Test
    public void testSelectListUsers() {
        UserDTO user1 = userService.createUser("Mike", "root", UserAuthority.ROLE_USER, true);
        UserDTO user2 = userService.createUser("John", "root", UserAuthority.ROLE_USER, true);
        UserDTO user3 = userService.createUser("Garry", "root", UserAuthority.ROLE_USER, true);
        UserDTO user4 = userService.createUser("Peter", "root", UserAuthority.ROLE_USER, true);

        List<UserDTO> allUsers = userService.getAllUsers();

        assertEquals(4, allUsers.size());

        assertEquals(user1.getUsername(), allUsers.get(0).getUsername());
        assertEquals(user2.getUsername(), allUsers.get(1).getUsername());
        assertEquals(user3.getUsername(), allUsers.get(2).getUsername());
        assertEquals(user4.getUsername(), allUsers.get(3).getUsername());
    }



}
