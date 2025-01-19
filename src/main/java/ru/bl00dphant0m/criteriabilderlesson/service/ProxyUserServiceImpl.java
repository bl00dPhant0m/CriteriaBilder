package ru.bl00dphant0m.criteriabilderlesson.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.bl00dphant0m.criteriabilderlesson.model.User;

import java.util.List;


@Service
@Slf4j
@Primary
public class ProxyUserServiceImpl implements UserService {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> findAllSortedByParam(String param) {
        log.info("method: findAllSortedByParam");
        log.info("param: " + param);
        return userService.findAllSortedByParam(param);
    }

    @Override
    public User save(User user) {
        log.info("method: save");
        log.info("user: " + user);
        return userService.save(user);
    }
}
