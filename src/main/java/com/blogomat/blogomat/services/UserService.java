package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.*;
import com.blogomat.blogomat.model.VO.UserContextVO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User registerNewUser(User u);

    UserContextVO logUserIn(String login, String password);

    void contactAdmin(ContactMessage contactMessage);

    Iterable<ContactMessage> getContactMessages();

    Optional<UserDetails> getUserDetails(Integer userID);

    Optional<SocialMedia> getUserSocialMedia(String author);
    SocialMedia saveUserSocialMedia(SocialMedia socialMedia);

    PersonalDataSettings savePersonalDataSettings(PersonalDataSettings personalDataSettings);

    Optional<PersonalDataSettings> getPersonalDataSettings(Integer userID);

    SocialMediaSettings saveSocialMediaSettings(SocialMediaSettings socialMediaSettings);

    Optional<SocialMediaSettings> getSocialMediaSettings(Integer userID);

    Theme saveSelectedTheme(Theme theme);

    Optional<Theme> getSelectedTheme(Integer userID);
}
