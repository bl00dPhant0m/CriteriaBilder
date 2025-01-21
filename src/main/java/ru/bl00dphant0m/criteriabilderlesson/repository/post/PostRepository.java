package ru.bl00dphant0m.criteriabilderlesson.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bl00dphant0m.criteriabilderlesson.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
