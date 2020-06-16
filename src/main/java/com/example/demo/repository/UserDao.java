package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * https://github.com/seangogo/CSIC/blob/master/serviceapi/src/main/java/com/dh/repository/UserDao.java
 */
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @Query("select a from User as a where a.loginName=?1")
    User findByLoginName(String loginName);

    @Modifying
    @Query("update User user set user.deviceId ='',user.deviceOs=''  where user.deviceId= ?1 ")
    void emptyDeviceId(String deviceId);

    @Query("select user.deviceId from User user where user.id = ?1 and LENGTH(user.deviceId) > 10")
    String findUserDeviceId(Integer userId);
}
