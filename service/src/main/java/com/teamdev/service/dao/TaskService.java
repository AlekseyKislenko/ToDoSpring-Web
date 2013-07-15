package com.teamdev.service.dao;

import com.teamdev.model.entity.DTO.TaskDTO;
import com.teamdev.model.entity.DTO.UserDTO;
import com.teamdev.model.entity.Task;
import com.teamdev.model.entity.TaskState;
import com.teamdev.model.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Aleksey Kslenko
 */
@Service

@Transactional
public class TaskService implements Tasks {

    @PersistenceContext
    private EntityManager em;

    @Override
    public TaskDTO createTask(String taskText, UserDTO userDTO) {
        User user = em.find(User.class, userDTO.getId());
        com.teamdev.model.entity.Task task = new com.teamdev.model.entity.Task();
        task.setTaskState(TaskState.UNFINISHED);
        task.setTaskDate();
        task.setTaskText(taskText);
        task.setTaskUser(user);
        task.setTaskAssignee(user);
        em.persist(task);
        return new TaskDTO(task);
    }
    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        taskDTO.getTaskState();
        taskDTO.getTaskDate();
        taskDTO.getTaskText();
        taskDTO.getTaskUser();
        taskDTO.getTaskAssignee();
        Task task = new Task();
        return new TaskDTO(task);
    }

    @Override
    public boolean deleteTaskById(Long id) {
        em.remove(em.find(com.teamdev.model.entity.Task.class, id));
        return true;
    }

    @Override
    public boolean deleteTask(TaskDTO task) {
        em.remove(em.find(com.teamdev.model.entity.Task.class, task.getId()));
        return true;
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        com.teamdev.model.entity.Task task = em.find(com.teamdev.model.entity.Task.class, id);
        return new TaskDTO(task);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TaskDTO> getTasksByUser(UserDTO user) {
        Query query = em.createNamedQuery("getTaskByUser").
                setParameter("user", em.find(User.class, user.getId()));
        em.clear();
        return getTaskList(query.getResultList());
    }

    @Override
    public List<TaskDTO> getTaskList(List<TaskDTO> tasksByUser) {
        Iterator iterator = tasksByUser.iterator();
        List<TaskDTO> taskList = new ArrayList<TaskDTO>();
        while (iterator.hasNext()){
            taskList.add(new TaskDTO((com.teamdev.model.entity.Task) iterator.next()));
        }
        return taskList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TaskDTO> getTasksByAssignee(UserDTO user) {
        Query query = em.createNamedQuery("getTaskByAssignee").
                setParameter("user", em.find(User.class, user.getId()));
        em.clear();
        return getTaskAssigneeList(query.getResultList());
    }

    @Override
    public List<TaskDTO> getTaskAssigneeList(List<TaskDTO> tasksByAssignee) {
        Iterator iterator = tasksByAssignee.iterator();
        List<TaskDTO> taskList = new ArrayList<TaskDTO>();
        while (iterator.hasNext()){
            taskList.add(new TaskDTO((com.teamdev.model.entity.Task) iterator.next()));
        }
        return taskList;
    }

    @Override
    public boolean changeTaskState(Long id, TaskState newTaskState) {
        Query query = em.createNamedQuery("changeTaskState").
                setParameter("taskState", newTaskState).
                setParameter("id", id);
        query.executeUpdate();
        em.clear();
        return true;
    }

    @Override
    public boolean changeTaskText(Long id, String newTaskText) {
        Query query = em.createNamedQuery("changeTaskText").
                setParameter("taskText", newTaskText).
                setParameter("id", id);
        query.executeUpdate();
        em.clear();
        return true;
    }

    @Override
    public boolean changeTaskAssignee(Long id, UserDTO taskAssignee) {
        Query query = em.createNamedQuery("changeTaskAssignee").
                setParameter("taskAssignee", em.find(User.class, taskAssignee.getId())).
                setParameter("id", id);
        query.executeUpdate();
        em.clear();
        return true;
    }




}
