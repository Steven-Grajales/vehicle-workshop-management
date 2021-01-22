package com.repair.car.services;

//import com.codingSchool.bookstore.Converters.BookToBookDetailsConverter;
import com.repair.car.converters.UserConverter;
import com.repair.car.domain.User;
        import com.repair.car.Repositories.UserRepository;
import com.repair.car.model.UserRegistrationForm;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(com.repair.car.services.UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(UserRegistrationForm userRegistrationForm) throws Exception {
        User user = UserConverter.buildUserObject(userRegistrationForm);
        userRepository.save(user);
        LOG.debug("User has been registered!");
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserRegistrationForm findByAfm(String afm) {
        User retrievedUser = userRepository.findByAfm(afm);
        UserRegistrationForm userRegistrationForm = UserConverter.buildRegistrationForm(retrievedUser);
        return userRegistrationForm;
    }


    @Override
    public List<User> findByEmailOrAfm(String searchText) {
        return userRepository.findByEmailOrAfm(searchText,searchText);
    }

    @Override
    public void save(UserRegistrationForm userRegistrationForm) {
        User user = UserConverter.buildUpdateUserObject(userRegistrationForm);
        userRepository.save(user);
    }
    @Override
    public void delete(String afm){
        User user = userRepository.findByAfm(afm);
        userRepository.delete(user);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> retrievedUsers = userRepository.findAll();

        return retrievedUsers;
    }
}
