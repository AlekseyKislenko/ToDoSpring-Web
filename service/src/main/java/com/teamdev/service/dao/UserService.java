package com.teamdev.service.dao;

import com.teamdev.model.entity.DTO.UserDTO;
import com.teamdev.model.entity.UserAuthority;
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
public class UserService implements User {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDTO createUser(String username, String password, UserAuthority authority, Boolean enabled) {
        com.teamdev.model.entity.User user = new com.teamdev.model.entity.User(username, password, authority, enabled);
        user.setUsername(username);
        user.setPassword(password);
        user.setAuthority(authority);
        user.setEnabled(enabled);
        em.persist(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        com.teamdev.model.entity.User user = em.find(com.teamdev.model.entity.User.class, id);
        return new UserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        Query query = em.createNamedQuery("deleteUserById");
        return getUserList(query.getResultList());
    }

    @Override
    public List<UserDTO> getUserList(List resultList) {
        Iterator iterator = resultList.iterator();
        List<UserDTO> taskList = new ArrayList<UserDTO>();
        while (iterator.hasNext()){
            taskList.add(new UserDTO((com.teamdev.model.entity.User) iterator.next()));
        }
        return taskList;
    }

    @Override
    public boolean deleteUserById(Long id) {
        em.remove(em.find(com.teamdev.model.entity.User.class, id));
        return true;
    }
}

