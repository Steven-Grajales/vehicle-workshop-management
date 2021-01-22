package com.repair.car.converters;

import com.repair.car.domain.User;
import com.repair.car.model.UserRegistrationForm;


public class UserConverter {

    //Registration Form to User
    //Used for register
    public static User buildUserObject(UserRegistrationForm userRegistrationForm) {
        User user = new User();
        user.setAfm(userRegistrationForm.getAfm());
        user.setFirstname(userRegistrationForm.getFirstname());
        user.setLastname(userRegistrationForm.getLastname());
        user.setEmail(userRegistrationForm.getEmail());
        user.setRole(userRegistrationForm.getRole());
        user.setPassword(userRegistrationForm.getPassword());
        user.setAddress(userRegistrationForm.getAddress());
        return user;
    }

    //UserRegistrationForm -> User with UserID
    //Used for updates
    public static User buildUpdateUserObject(UserRegistrationForm userRegistrationForm){
        User user = new User();
        user.setUserId(userRegistrationForm.getUserID());
        user.setAfm(userRegistrationForm.getAfm());
        user.setFirstname(userRegistrationForm.getFirstname());
        user.setLastname(userRegistrationForm.getLastname());
        user.setEmail(userRegistrationForm.getEmail());
        user.setRole(userRegistrationForm.getRole());
        user.setPassword(userRegistrationForm.getPassword());
        user.setAddress(userRegistrationForm.getAddress());
        return user;
    }

    //User -> UserRegistrationForm
    //Used for updates
    public static UserRegistrationForm buildRegistrationForm(User user) {
        UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
        userRegistrationForm.setUserID(user.getUserId());
        userRegistrationForm.setRole(user.getRole());
        userRegistrationForm.setAfm(user.getAfm());
        userRegistrationForm.setFirstname(user.getFirstname());
        userRegistrationForm.setLastname(user.getLastname());
        userRegistrationForm.setEmail(user.getEmail());
        userRegistrationForm.setPassword(user.getPassword());
        userRegistrationForm.setAddress(user.getAddress());
        return userRegistrationForm;
    }

}
