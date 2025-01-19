package ru.bl00dphant0m.criteriabilderlesson.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bl00dphant0m.criteriabilderlesson.model.User;
import ru.bl00dphant0m.criteriabilderlesson.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public List<User> findAllSortedByParam(String param) {
        return userRepository.findAllSortedByParam(param);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
