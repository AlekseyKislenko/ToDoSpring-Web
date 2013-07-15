package com.teamdev.service;

import com.teamdev.model.entity.DTO.TaskDTO;
import com.teamdev.model.entity.DTO.UserDTO;
import com.teamdev.model.entity.TaskState;
import com.teamdev.model.entity.UserAuthority;
import com.teamdev.service.dao.TaskService;
import com.teamdev.service.dao.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static junit.framework.Assert.*;
import static junit.framework.Assert.assertEquals;

/**
 * @author Aleksey Kislenko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
@Transactional
public class TaskServiceDTOTest {

    @Autowired
    public UserService userService;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TaskService taskService;

    @Test
    public void testSavedTaskHasId() {
        UserDTO user = userService.createUser("Mike", "root", UserAuthority.ROLE_USER, true);
        TaskDTO task = taskService.createTask("read a book", user);
        assertNotNull(task.getId());
        long id1 = task.getId();
        assertNotNull(taskService.getTaskById(id1));
    }

    @Test (expected=NullPointerException.class)
    public void testDeleteByTask() {
        UserDTO user = userService.createUser("Mike1", "root", UserAuthority.ROLE_USER, true);
        TaskDTO task1 = taskService.createTask("read a book", user);
        TaskDTO task2 = taskService.createTask("buy the book", user);
        long id1 = task1.getId();
        long id2 = task1.getId();
        assertTrue(taskService.deleteTask(task2));
        assertTrue(taskService.deleteTask(task1));
        taskService.getTaskById(id1);
        taskService.getTaskById(id2);
    }

    @Test (expected=NullPointerException.class)
    public void testDeleteTaskById() {
        UserDTO user = userService.createUser("Mike", "root", UserAuthority.ROLE_USER, true);
        TaskDTO task = taskService.createTask("read a book", user);
        long id1 = task.getId();
        assertTrue(taskService.deleteTaskById(id1));
        taskService.getTaskById(id1);
    }

    @Test
    public void testChangeTaskState() {

        UserDTO user = userService.createUser("Mike", "root", UserAuthority.ROLE_USER, true);
        TaskDTO task = taskService.createTask("read a book", user);
        Long id = task.getId();

        taskService.changeTaskState(id, TaskState.FINISHED);
        task = taskService.getTaskById(id);
        assertEquals(TaskState.FINISHED, task.getTaskState());

        taskService.changeTaskState(id, TaskState.CLOSED);
        task = taskService.getTaskById(id);
        assertEquals(TaskState.CLOSED, task.getTaskState());

        taskService.changeTaskState(id, TaskState.DELETED);
        task = taskService.getTaskById(id);
        assertEquals(TaskState.DELETED, task.getTaskState());

        taskService.changeTaskState(id, TaskState.UNFINISHED);
        task = taskService.getTaskById(id);
        assertEquals(TaskState.UNFINISHED, task.getTaskState());

    }

    @Test
    public void testChangeTaskText() {

        UserDTO user = userService.createUser("Mike", "root", UserAuthority.ROLE_USER, true);
        TaskDTO task = taskService.createTask("read a book", user);
        Long id = task.getId();

        taskService.changeTaskText(id, "go home after reading the book");
        task = taskService.getTaskById(id);
        assertEquals("go home after reading the book", task.getTaskText());
    }

    @Test
    public void testChangeTaskAssignee() {

        UserDTO user1 = userService.createUser("Mike", "root", UserAuthority.ROLE_USER, true);
        UserDTO user2 = userService.createUser("Tom", "root", UserAuthority.ROLE_USER, true);
        TaskDTO task = taskService.createTask("read a book", user1);
        Long id = task.getId();
        //before Changes
        assertEquals(user1.getUsername(), task.getTaskAssignee().getUsername());

        taskService.changeTaskAssignee(id, user2);
        task = taskService.getTaskById(id);
        //after Changes
        assertEquals(user2.getUsername(), task.getTaskAssignee().getUsername());
    }


    @Test
    public void testGetTasksByUserOrAssignee() {
        // Garry and Peter create new tasks
        UserDTO user1 = userService.createUser("Garry", "root", UserAuthority.ROLE_USER, true);
        UserDTO user2 = userService.createUser("Peter", "root", UserAuthority.ROLE_USER, true);

        TaskDTO task1 = taskService.createTask("1read a first book", user1);
        TaskDTO task2 = taskService.createTask("2read a second book", user1);
        taskService.createTask("3read a first book", user2);
        taskService.createTask("4read a second book", user2);
        taskService.createTask("5read a third book", user2);

        List<TaskDTO> tasks1 = taskService.getTasksByUser(user1);
        assertEquals(2, tasks1.size());
        assertEquals(user1.getUsername(), tasks1.get(0).getTaskUser().getUsername());
        assertEquals(user1.getUsername(), tasks1.get(1).getTaskUser().getUsername());

        List<TaskDTO> tasks2 = taskService.getTasksByUser(user2);
        assertEquals(3, tasks2.size());
        assertEquals(user2.getUsername(), tasks2.get(0).getTaskUser().getUsername());
        assertEquals(user2.getUsername(), tasks2.get(1).getTaskUser().getUsername());
        assertEquals(user2.getUsername(), tasks2.get(2).getTaskUser().getUsername());

        //Next... Garry is creator, but not assignee.

        //task1 and task2 go assignee from Garry to Peter
        taskService.changeTaskAssignee(task1.getId(), user2);
        taskService.changeTaskAssignee(task2.getId(), user2);

        List<TaskDTO> todoGarry = taskService.getTasksByAssignee(user1);
        List<TaskDTO> todoAssignedByGarry = taskService.getTasksByUser(user1);

        List<TaskDTO> todoPeter = taskService.getTasksByAssignee(user2);
        List<TaskDTO> todoAssignedByPeter = taskService.getTasksByUser(user2);

        //Garry don't have any tasks to do
        assertEquals(0, todoGarry.size());
        //Garry have assigned tasks to Peter
        assertEquals(2, todoAssignedByGarry.size());

        //Peter have 3 own tasks and +2 tasks from Garry
        assertEquals(5, todoPeter.size());
        //Peter don't have any assigned tasks
        assertEquals(3, todoAssignedByPeter.size());
    }




}
