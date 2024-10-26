package com.springboot.CustomSecurityWithDB.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.CustomSecurityWithDB.entities.UserInfo;

@Repository
public interface UserInfoDAO extends JpaRepository<UserInfo, String> {
	
	@Query(value="SELECT u FROM UserInfo u WHERE userName=?1")
	public UserInfo getActiveUser(String userName);
}
