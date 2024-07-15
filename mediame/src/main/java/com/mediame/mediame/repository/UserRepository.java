package com.mediame.mediame.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mediame.mediame.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	@Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="update UserEntity set password=:password where email=:email and phone=:phone")
	@Bean
    int updatePassword(@Param("email") String email, @Param("phone") String phone,@Param("password") String password);	
}
