package com.mediame.mediame.repository;

import com.mediame.mediame.entity.UserEntity;
import com.mediame.mediame.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	@Query("select u from UserEntity u where u.firstName = ?1")
	List<UserEntity> findByFirstName(String fName);
	
	@Query("select u from UserEntity u where u.email = ?1")
	UserEntity findByEmail(String email);
	
	@Query("delete from UserEntity u where u.email = ?1")
	UserEntity deleteByEmail(String email);

}


/*package com.mediame.mediame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mediame.mediame.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	@Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="update UserEntity set password=:password where email=:email and phone=:phone")
	//@Bean
    int updatePassword(@Param("email") String email, @Param("phone") String phone,@Param("password") String password);	
}*/
