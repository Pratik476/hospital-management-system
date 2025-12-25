package com.pratik.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratik.doclogin.entity.Appoinment;

@Repository
public interface AppoinmentRepository extends JpaRepository<Appoinment, Long> {

}
