package com.example.shopping_api.Repository.CustomRepository.Implement;

import com.example.shopping_api.Repository.CustomRepository.UserRepositoryCustom;
import com.example.shopping_api.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getByName(String name) {
        //String jpql = String.format("SELECT * FROM Users WHERE username='%s'",name);
        //TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

        //System.out.println(query.getSingleResult());
        try{
            User user =  entityManager.find(User.class, name);

        }catch (Exception e){
            System.out.println(e);
            return null;
        }
return null;
    }
}