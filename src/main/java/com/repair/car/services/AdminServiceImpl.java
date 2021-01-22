package com.repair.car.services;

import com.repair.car.Repositories.RepairRepository;
import com.repair.car.converters.RepairToAdminFormConverter;
import com.repair.car.domain.Repair;
import com.repair.car.model.AdminForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RepairRepository repairRepository;


    @Override
    public List<AdminForm> adminSearch()  {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = LocalDate.now().format(df).toString();

        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
        String time = LocalTime.now().format(tf).toString();


        List<Repair> retrievedRepairs = repairRepository.findRepairsOfDay(date,time);

        if (retrievedRepairs.size() > 10){

            retrievedRepairs = retrievedRepairs.subList(0,9);
        }

        return retrievedRepairs
                .stream()
                .map(RepairToAdminFormConverter::buildAdminForm)
                .collect(Collectors.toList());
    }


    @Override
    public List<AdminForm> userSearch(String email)  {

        List<Repair> retrievedRepairs = repairRepository.findByVehicle_User_emailOrderByRepairDateDescRepairTimeAsc(email);

        return retrievedRepairs
                .stream()
                .map(RepairToAdminFormConverter::buildAdminForm)
                .collect(Collectors.toList());
    }

}
