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
    //FIXME [MA]
//Data loading been, to prevent using real database file, PostGreSQL needs only to be installed, SpringBoot does the data,
    //To make the data do not refresh, delete the line below in application.properties file
  //spring.jpa.hibernate.ddl-auto=create
    @Bean
    public CommandLineRunner loadData(SocialMediaRepository socialMediaRepository, RoleRepository roleRepository, UserRepository userRepository, PostRepository repository, LikeRepository likeRepository, CommentRepository commentRepository) {
        return (args) -> {

            LocalDate localDate = LocalDate.now();
            String[] tab = new String[5];
            tab[0] = "tag1";
            tab[1] = "tag2";
            tab[2] = "tag3";
            tab[3] = "tag4";
            tab[4] = "tag5";
            Role admin = new Role("admin");
            Role user = new Role("user");


            repository.save(new Post("Another day", new HashSet<>((Arrays.asList(tab).subList(0, 2))), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna" +
                    "    aliqua. Nulla pellentesque dignissim enim sit amet venenatis urna cursus eget. Elit eget gravida cum sociis natoque" +
                    "    penatibus et magnis. Vel risus commodo viverra maecenas accumsan lacus vel facilisis. Adipiscing elit pellentesque" +
                    "    habitant morbi tristique senectus et netus. Sit amet facilisis magna etiam tempor orci eu lobortis elementum. Vitae" +
                    "    tortor condimentum lacinia quis. Pellentesque habitant morbi tristique senectus et netus et malesuada. Mi ipsum" +
                    "    faucibus vitae aliquet. Dolor sit amet consectetur adipiscing elit duis tristique sollicitudin nibh. Pulvinar" +
                    "    pellentesque habitant morbi tristique. Mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a. Nulla" +
                    "    posuere sollicitudin aliquam ultrices sagittis orci a scelerisque. At augue eget arcu dictum varius duis at." +
                    "    Venenatis" +
                    "    tellus in metus vulputate. Arcu risus quis varius quam quisque. Arcu non sodales neque sodales ut etiam sit." +
                    "    Faucibus" +
                    "    purus in massa tempor. Justo donec enim diam vulputate ut pharetra sit amet. Velit scelerisque in dictum non.", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(3))), "Roberto"));
            repository.save(new Post("Social media", new HashSet<>(Arrays.asList(tab).subList(2, 4)), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna" +
                    "aliqua. Nulla pellentesque dignissim enim sit amet venenatis urna cursus eget. Elit eget gravida cum sociis natoque" +
                    "penatibus et magnis. Vel risus commodo viverra maecenas accumsan lacus vel facilisis. Adipiscing elit pellentesque" +
                    "habitant morbi tristique senectus et netus. Sit amet facilisis magna etiam tempor orci eu lobortis elementum. Vitae" +
                    "tortor condimentum lacinia quis. Pellentesque habitant morbi tristique senectus et netus et malesuada. Mi ipsum" +
                    "faucibus vitae aliquet. Dolor sit amet consectetur adipiscing elit duis tristique sollicitudin nibh.", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "cohen12"));
            repository.save(new Post("My first poem", new HashSet<>(Arrays.asList(tab).subList(3, 5)), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna" +
                    "aliqua. Nulla pellentesque dignissim enim sit amet venenatis urna cursus eget. Elit eget gravida cum sociis natoque" +
                    "penatibus et magnis. Vel risus commodo viverra maecenas accumsan lacus vel facilisis. Adipiscing elit pellentesque" +
                    "habitant morbi tristique senectus et netus. Sit amet facilisis magna etiam tempor orci eu lobortis elementum. Vitae" +
                    "tortor condimentum lacinia quis. Pellentesque habitant morbi tristique senectus et netus et malesuada. Mi ipsum" +
                    "faucibus vitae aliquet. Dolor sit amet consectetur adipiscing elit duis tristique sollicitudin nibh.", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(2))), "John Smith"));
            repository.save(new Post("Heaven & Hell", new HashSet<>(Arrays.asList(tab).subList(1, 4)), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna" +
                    "aliqua. Nulla pellentesque dignissim enim sit amet venenatis urna cursus eget. Elit eget gravida cum sociis natoque" +
                    "penatibus et magnis. Vel risus commodo viverra maecenas accumsan lacus vel facilisis. Adipiscing elit pellentesque" +
                    "habitant morbi tristique senectus et netus. Sit amet facilisis magna etiam tempor orci eu lobortis elementum. Vitae" +
                    "tortor condimentum lacinia quis. Pellentesque habitant morbi tristique senectus et netus et malesuada. Mi ipsum" +
                    "faucibus vitae aliquet. Dolor sit amet consectetur adipiscing elit duis tristique sollicitudin nibh.", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(3))), "Sam Paul"));
            repository.save(new Post("Web developer part 4", new HashSet<>(Arrays.asList(tab).subList(0, 1)), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna faucibus vitae aliquet. Dolor sit amet consectetur adipiscing elit duis tristique sollicitudin nibh.", Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(5))), "Author1"));
            Integer[] tab2 = {1, 2, 3, 4, 5};

            likeRepository.save(new Like(1, new HashSet<>(Arrays.asList(tab2).subList(0, 2))));
            likeRepository.save(new Like(2, new HashSet<>(Arrays.asList(tab2).subList(0, 3))));
            likeRepository.save(new Like(3, new HashSet<>(Arrays.asList(tab2).subList(3, 4))));
            likeRepository.save(new Like(4, new HashSet<>(Arrays.asList(tab2).subList(2, 4))));
            likeRepository.save(new Like(5, new HashSet<>(Arrays.asList(tab2))));


            commentRepository.save(new Comment(1, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "User1", "First comment"));
            commentRepository.save(new Comment(1, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "User2", "Second comment"));
            commentRepository.save(new Comment(2, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(2))), "User2", "First comment"));
            commentRepository.save(new Comment(2, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(3))), "User2", "Second comment"));
            commentRepository.save(new Comment(2, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(4))), "User1", "COntent 2 commenta"));
            commentRepository.save(new Comment(3, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(5))), "User1", "COntent 2 commenta"));
            commentRepository.save(new Comment(3, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "User3", "COntent 2 commenta"));
            commentRepository.save(new Comment(3, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(7))), "User3", "COntent 2 commenta"));
            commentRepository.save(new Comment(4, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(23))), "User3", "COntent 3 commenta"));
            commentRepository.save(new Comment(5, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(4))), "Roberto", "First comment"));
            commentRepository.save(new Comment(5, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(3))), "Sam Paul", "Second comment"));
            commentRepository.save(new Comment(5, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(2))), "Roberto", "Third comment"));
            commentRepository.save(new Comment(5, Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().minus(Period.ofDays(1))), "Sam Paul", "Fourth comment"));

            roleRepository.save(user);
            roleRepository.save(admin);
            userRepository.save(new User("username1", "user1", "password1!", "email@email.com", GENDER.MALE, user));
            userRepository.save(new User("administrator1", "admin1", "admininstrator1!", "email@email.com", GENDER.MALE, admin));
            userRepository.save(new User("username1", "Roberto", "password1!", "email@email.com", GENDER.MALE, user));
            userRepository.save(new User("username12", "cohen12", "password1!", "email@email.com", GENDER.MALE, user));
            userRepository.save(new User("username13", "Sam Paul", "password1!", "email@email.com", GENDER.MALE, user));
            userRepository.save(new User("username14", "Author1", "password1!", "email@email.com", GENDER.MALE, user));
            userRepository.save(new User("username15", "John Smith", "password1!", "email@email.com", GENDER.MALE, user));
            socialMediaRepository.save(new SocialMedia(28, "link do facebooka", "link do twittera", "link do snapchata", "link do instagrama"));
            socialMediaRepository.save(new SocialMedia(29, "link do facebooka1", "link do twittera", "link do snapchata", "link do instagrama"));
            socialMediaRepository.save(new SocialMedia(30, "link do facebooka2", "link do twittera", "link do snapchata", "link do instagrama"));
            socialMediaRepository.save(new SocialMedia(31, "www.facebook.com/author1", "www.twitter.com/author1", "www.snapchat.com/author1", "www.instagram.com/author1"));
            socialMediaRepository.save(new SocialMedia(32, "link do facebooka4", "link do twittera", "link do snapchata", "link do instagrama"));

        };

    }
}