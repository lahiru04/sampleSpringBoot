package com.example.demox.repo;

import com.example.demox.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

 @Query(value = "select * from user where id = ?1",nativeQuery = true)
 public User getUserByUserId(int id);


 @Query(value = "select * from user where id = ?1 and address = ?2",nativeQuery = true)
 public User getUserByUserIdAndAddress(int id,String Address);


}
