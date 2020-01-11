package com.blogomat.blogomat;

import com.blogomat.blogomat.enums.GENDER;
import com.blogomat.blogomat.model.entities.*;
import com.blogomat.blogomat.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class BlogomatApplication {
    private static final Logger log = LoggerFactory.getLogger(BlogomatApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BlogomatApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(RoleRepository roleRepository, UserRepository userRepository, PostRepository repository, LikeRepository likeRepository, CommentRepository commentRepository) {
        return (args) -> {
            // save a couple of customers
            LocalDate localDate = LocalDate.now();
            String[] tab = new String[5];
            tab[0] = "tag1";
            tab[1] = "tag2";
            tab[2] = "tag3";
            tab[3] = "tag4";
            tab[4] = "tag5";
            Role admin = new Role("admin");
            Role user = new Role("user");

            roleRepository.save(user);
            roleRepository.save(admin);
            userRepository.save(new User("user", "user", BCrypt.hashpw("pass", BCrypt.gensalt()), "email@email.com", GENDER.MALE, user));
            userRepository.save(new User("admin", "admin", BCrypt.hashpw("admin", BCrypt.gensalt()), "email@email.com", GENDER.MALE, admin));

            repository.save(new Post("tytuł1", new HashSet<>((Arrays.asList(tab).subList(0, 2))), "Content1Content1Content1Content1Content1", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), "Author1"));
            repository.save(new Post("tytuł2", new HashSet<>(Arrays.asList(tab).subList(2, 4)), "Content2Content1Content1Content1Content1", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "Author1"));
            repository.save(new Post("tytuł3", new HashSet<>(Arrays.asList(tab).subList(3, 5)), "Content3Content1Content1Content1Content1", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(2))), "Author1"));
            repository.save(new Post("tytuł4", new HashSet<>(Arrays.asList(tab).subList(1, 4)), "Content4Content1Content1Content1Content1", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(3))), "Author1"));
            repository.save(new Post("tytuł5", new HashSet<>(Arrays.asList(tab).subList(0, 1)), "Content5Content1Content1Content1Content1", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(5))), "Author1"));
            Integer[] tab2 = {1, 2, 3, 4, 5};

            likeRepository.save(new Like(1, new HashSet<>(Arrays.asList(tab2).subList(0, 2))));
            likeRepository.save(new Like(2, new HashSet<>(Arrays.asList(tab2).subList(0, 3))));
            likeRepository.save(new Like(3, new HashSet<>(Arrays.asList(tab2).subList(3, 4))));
            likeRepository.save(new Like(4, new HashSet<>(Arrays.asList(tab2).subList(2, 4))));
            likeRepository.save(new Like(5, new HashSet<>(Arrays.asList(tab2))));


            commentRepository.save(new Comment(1, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "User1", "COntent 1 commenta"));
            commentRepository.save(new Comment(1, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "User2", "COntent 1 commenta"));
            commentRepository.save(new Comment(1, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(2))), "User2", "COntent 1 commenta"));
            commentRepository.save(new Comment(1, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(3))), "User2", "COntent 1 commenta"));
            commentRepository.save(new Comment(2, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(4))), "User1", "COntent 2 commenta"));
            commentRepository.save(new Comment(2, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(5))), "User1", "COntent 2 commenta"));
            commentRepository.save(new Comment(2, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "User3", "COntent 2 commenta"));
            commentRepository.save(new Comment(2, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(7))), "User3", "COntent 2 commenta"));
            commentRepository.save(new Comment(3, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(23))), "User3", "COntent 3 commenta"));
            commentRepository.save(new Comment(3, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(4))), "User3", "COntent 3 commenta"));
            commentRepository.save(new Comment(4, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(5))), "User3", "COntent 4 commenta"));
            commentRepository.save(new Comment(4, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(11))), "User5", "COntent 4 commenta"));
            commentRepository.save(new Comment(5, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "User4", "COntent 5 commenta"));


            // fetch all Posts
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User userEntity : userRepository.findAll()) {
                log.info(userEntity.toString());
                /*  log.info(post.getTags().toString());*/
            }
            log.info("Roels found with findAll():");
            log.info("-------------------------------");
            for (Role role : roleRepository.findAll()) {
                log.info(role.toString());
                /*  log.info(post.getTags().toString());*/
            }
            log.info("");  // fetch all Posts
            log.info("Posts found with findAll():");
            log.info("-------------------------------");
            for (Post post : repository.findAll()) {
                log.info(post.toString());
                /*  log.info(post.getTags().toString());*/
            }
            log.info("");
            log.info("Posts found with findAll():");
            log.info("-------------------------------");
            for (Like like : likeRepository.findAll()) {
                log.info(like.toString());
                /*  log.info(post.getTags().toString());*/
            }
            log.info("");
            log.info("");
            log.info("Comments found with findAll():");
            log.info("-------------------------------");
            for (Comment comment : commentRepository.findAll()) {
                log.info(comment.toString());
                /*  log.info(post.getTags().toString());*/
            }
            log.info("");
/*
            // fetch an individual Post by ID
            //  Post Post = repository.findOne(1L);
            log.info("Post found with findOne(1L):");
            log.info("--------------------------------");
            log.info(post.toString());
            log.info("");
*/

          /*  // fetch Posts by last name
            log.info("Post found with findByLastNameStartsWithIgnoreCase('Bauer'):");
            log.info("--------------------------------------------");
        *//*    for (Post post : repository
            //    .findByLastNameStartsWithIgnoreCase("Bauer")) {
            log.info(post.toString());
        }*//*
            log.info("");
        }*/
        };
    }
}