package ru.bl00dphant0m.criteriabilderlesson.service;

import ru.bl00dphant0m.criteriabilderlesson.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllSortedByParam(String param);
    User save(User user);
}
