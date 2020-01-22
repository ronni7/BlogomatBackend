package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.*;
import com.blogomat.blogomat.model.VO.UserContextVO;
import com.blogomat.blogomat.repositories.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ContactRepository contactRepository;
    private SocialMediaRepository socialMediaRepository;
    private UserDetailsRepository userDetailsRepository;
    private PersonalDataSettingsRepository personalDataSettingsRepository;
    private SocialMediaSettingsRepository socialMediaSettingsRepository;
    private ThemeRepository themeRepository;

    public UserServiceImpl(UserRepository userRepository, ContactRepository contactRepository, SocialMediaRepository socialMediaRepository, UserDetailsRepository userDetailsRepository, PersonalDataSettingsRepository personalDataSettingsRepository, SocialMediaSettingsRepository socialMediaSettingsRepository, ThemeRepository themeRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.personalDataSettingsRepository = personalDataSettingsRepository;
        this.socialMediaSettingsRepository = socialMediaSettingsRepository;
        this.themeRepository = themeRepository;
    }

    @Override
    public com.blogomat.blogomat.model.entities.User registerNewUser(com.blogomat.blogomat.model.entities.User u) {
        //u.setPassword(BCrypt.hashpw(String.valueOf(u.getPassword()), BCrypt.gensalt()).toCharArray());
        return userRepository.save(u);
    }

    @Override
    public UserContextVO logUserIn(String login, String password) {
        Iterable<User> u = userRepository.findByLogin(login);
        //  if (BCrypt.checkpw(String.valueOf(password), String.valueOf(u.getPassword())))
        for (User user : u) {
            if (user.getPassword().equals(password)) {
                return new UserContextVO(user.getUserID(), user.getRole().getName(), user.getUsername());
            }
        }
        return null;
    }

    @Override
    public void contactAdmin(ContactMessage contactMessage) {
        contactRepository.save(contactMessage);
    }

    @Override
    public Iterable<ContactMessage> getContactMessages() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<UserDetails> getUserDetails(Integer userID) {
        return userDetailsRepository.findByUserID(userID);
    }

    @Override
    public Optional<SocialMedia> getUserSocialMedia(String author) {
        Optional<User> u = userRepository.findByUsername(author);
        return u.map(user -> socialMediaRepository.findByUserID(user.getUserID())).orElse(null);

    }

    @Override
    public SocialMedia saveUserSocialMedia(SocialMedia socialMedia) {
        return socialMediaRepository.save(socialMedia);
    }

    @Override
    public PersonalDataSettings savePersonalDataSettings(PersonalDataSettings personalDataSettings) {
        return personalDataSettingsRepository.save(personalDataSettings);
    }

    @Override
    public Optional<PersonalDataSettings> getPersonalDataSettings(Integer userID) {
        return personalDataSettingsRepository.findByUserID(userID);
    }

    @Override
    public SocialMediaSettings saveSocialMediaSettings(SocialMediaSettings socialMediaSettings) {
        return socialMediaSettingsRepository.save(socialMediaSettings);
    }

    @Override
    public Optional<SocialMediaSettings> getSocialMediaSettings(Integer userID) {
        return socialMediaSettingsRepository.findByUserID(userID);
    }

    @Override
    public Theme saveSelectedTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    @Override
    public Optional<Theme> getSelectedTheme(Integer userID) {
        return themeRepository.findByUserID(userID);
    }

}
