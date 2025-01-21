package ru.bl00dphant0m.criteriabilderlesson.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import ru.bl00dphant0m.criteriabilderlesson.model.Post;
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

    @Override
    public List<User> findAllByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot)
                .where(criteriaBuilder.equal(userRoot.get("username"), name));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<User> findAllLike(String like) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot)
                .where(criteriaBuilder.like(userRoot.get("username"), "%" + like + "%"));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<User> findAllByAgeAndName(int age, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        Predicate predicateUsername = criteriaBuilder.equal(userRoot.get("username"), name);
        Predicate predicateAge = criteriaBuilder.greaterThan(userRoot.get("age"), age);


        criteriaQuery.select(userRoot)
                .where(criteriaBuilder.and(predicateUsername, predicateAge));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Long userCount() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(criteriaBuilder.count(userRoot));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Post> findAllJoinPost() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);

        postRoot.fetch("users", JoinType.INNER);
        criteriaQuery.select(postRoot);


        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public int maxAge() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(criteriaBuilder.max(userRoot.get("age")));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<User> findAllBetween(int minAge, int maxAge) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot)
                .where(criteriaBuilder.between(userRoot.get("age"), minAge, maxAge));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<User> findAllUserWithPost() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        Join<User, Post> join = userRoot.join("posts", JoinType.INNER);

        criteriaQuery.select(userRoot)
                .where(criteriaBuilder.equal(join.get("title"), "Пост"));

        return List.of();
    }
}
