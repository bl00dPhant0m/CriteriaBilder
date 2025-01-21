package ru.bl00dphant0m.criteriabilderlesson.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bl00dphant0m.criteriabilderlesson.model.Post;
import ru.bl00dphant0m.criteriabilderlesson.repository.post.PostRepository;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
