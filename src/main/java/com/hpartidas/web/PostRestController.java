package com.hpartidas.web;

import com.hpartidas.domain.Post;
import com.hpartidas.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostRestController {
    private final PostRepository postRepository;

    @Autowired
    public PostRestController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/post/findByTitle")
    public Post findOneByTitle(@RequestParam("title") String title) {
        return postRepository.findOneByTitle(title);
    }

    @RequestMapping(value = "/post/search")
    public List<Post> findByBodyContaining(@RequestParam("keyword") String keyword) {
        return postRepository.findByBodyContaining(keyword);
    }

    @RequestMapping(value = "/post/count")
    public long count() {
        return postRepository.count();
    }
}
