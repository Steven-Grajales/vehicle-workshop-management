package com.repair.car.services;

import com.repair.car.domain.User;
import com.repair.car.model.UserRegistrationForm;
//import com.codingSchool.bookstore.Model.BookForm;

import java.util.List;

public interface UserService {

    void register(UserRegistrationForm userRegistrationForm) throws Exception;

    UserRegistrationForm findByAfm(String afm);

    List <User> findAllUsers();

    List <User> findByEmailOrAfm(String searchText);

    User findByEmail(String email);

    void save(UserRegistrationForm userRegistrationForm);

    void delete(String afm);
}
