package com.example.cproject.repository;

import com.example.cproject.entity.DAOUserMkrtchanLS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoMkrtchanLS extends JpaRepository<DAOUserMkrtchanLS, Long> {
    DAOUserMkrtchanLS findUserByUserName(String username);
}
