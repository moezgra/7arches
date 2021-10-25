package com.example.demo.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Role;

/**
 *
 * @author raitis
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
