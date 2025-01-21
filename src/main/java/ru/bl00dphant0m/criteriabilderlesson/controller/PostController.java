package ru.bl00dphant0m.criteriabilderlesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bl00dphant0m.criteriabilderlesson.model.Post;
import ru.bl00dphant0m.criteriabilderlesson.service.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.savePost(post));
    }
}
