package ru.bl00dphant0m.criteriabilderlesson.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import ru.bl00dphant0m.criteriabilderlesson.model.User;

import java.util.List;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllSortedByParam(String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

//        Order order = criteriaBuilder.desc(userRoot.get(sort));
//        criteriaQuery.orderBy(order);

        Predicate predicateName = criteriaBuilder.like(userRoot.get("username"), "%" + "ALI" + "%");
        criteriaQuery.where(predicateName);


        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
