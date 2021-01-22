package com.repair.car.Repositories;


import com.repair.car.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByEmailAndPassword(String email, String password);

    List<User> findByEmailOrAfm(String search,String searchText );

    User findByAfm(String afm);

    User findByEmail(String email);

    User save(User user);

    void delete(User user);

    boolean existsByAfm(String afm);

}
