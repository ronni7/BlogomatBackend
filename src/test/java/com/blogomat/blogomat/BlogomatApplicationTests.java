package com.blogomat.blogomat;

import com.blogomat.blogomat.model.entities.Post;
import com.blogomat.blogomat.repositories.PostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogomatApplication.class)
@AutoConfigureMockMvc
class BlogomatApplicationTests {

    @Autowired
    PostRepository postRepository;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Before
    public void init() {

    }

    @Test
    void contextLoads() {

    }

    @Test
    void ShouldReturnPostWithSameID() throws Exception {
        Post post = new Post(
                "titleTest",
                new HashSet<>(),
                "Post content",
                new Date(),
                "Author2");
        postRepository.save(post);
        String response = this.mockMvc.perform(
                get("http://localhost:8080/post/posts?order=DESC&sort=publishDate"))
                .andDo(print()).andReturn().getResponse().getContentAsString();
        ArrayList list = mapper.readValue(response, ArrayList.class);
        List<Post> posts = mapper.convertValue(list, new TypeReference<>() {
        });
        assert posts.get(0).getId().equals(post.getId());
    }

}
