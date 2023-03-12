package com.arpit.messengerApp.repository;

import com.arpit.messengerApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "Select * from tbl_user where username = :userName and status_id = 1", nativeQuery = true)
    public List<Users> findByUsername(String userName);

    @Query(value = "Select * from tbl_user where user_id = :userId abd status_id = 1", nativeQuery = true)
    public List<Users> getUserByUserId(long userId);

    @Query(value = "Select * from tbl_user where status_id = 1", nativeQuery = true)
    public List<Users> getAllUsers();

//    @Query(value = "update tbl_user set status_id = 2 where user_id = :userId", nativeQuery = true)
//    public List<Users> deleteUserById(long userId);

}
