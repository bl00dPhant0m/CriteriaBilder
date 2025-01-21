package ru.bl00dphant0m.criteriabilderlesson.repository.user;


import ru.bl00dphant0m.criteriabilderlesson.model.Post;
import ru.bl00dphant0m.criteriabilderlesson.model.User;

import java.util.List;


public interface UserRepositoryCustom {
    List<User> findAllSortedByParam(String sort);
    List<User> findAllByName(String name);
    List<User> findAllLike(String like);
    List<User> findAllByAgeAndName(int age, String name);
    Long userCount();
    List<Post> findAllJoinPost();
    int maxAge();
    List<User> findAllBetween(int minAge, int maxAge);
    List<User> findAllUserWithPost();
}
