package ru.bl00dphant0m.criteriabilderlesson.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bl00dphant0m.criteriabilderlesson.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
}
