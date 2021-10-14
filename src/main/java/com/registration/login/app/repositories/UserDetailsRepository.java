package com.registration.login.app.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.registration.login.app.entities.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

	@Query(value = "select * from user_details u where binary u.username = :username", nativeQuery = true)
	public UserDetails findByUsername(String username);

	@Query(value = "select * from user_details u where binary u.username= :username AND u.password = :password", nativeQuery = true)
	public UserDetails findByPassword(String password, String username);

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query(value = "update user_details SET failed_tries = :failedTries where binary username = :username ", nativeQuery = true)
	public void updateUserFailedTries(String username, Integer failedTries);

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query(value = "update user_details SET locked = :isLocked where binary username = :username ", nativeQuery = true)
	public void updateIsLocked(String username, Integer isLocked);

	@Query(value = "select * from user_details where binary username = :username", nativeQuery = true)
	public Integer existsUserDetailsByUsername(String username);
}
