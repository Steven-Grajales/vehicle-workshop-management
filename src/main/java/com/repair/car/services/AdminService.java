package com.repair.car.services;

import com.repair.car.model.AdminForm;

import java.util.List;

public interface AdminService {


    List<AdminForm> adminSearch();

    List<AdminForm> userSearch(String email);

}
