package com.hpartidas.repository;

import com.hpartidas.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface PostRepository extends CrudRepository<Post, Long> {
    Post findOneByTitle(String title);

    List<Post> findByBodyContaining(String keyword);
}
