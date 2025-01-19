package ru.bl00dphant0m.criteriabilderlesson.repository;


import ru.bl00dphant0m.criteriabilderlesson.model.User;

import java.util.List;


public interface UserRepositoryCustom {
    List<User> findAllSortedByParam(String sort);
}
