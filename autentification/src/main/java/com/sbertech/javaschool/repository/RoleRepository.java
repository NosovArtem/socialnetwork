package com.sbertech.javaschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbertech.javaschool.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
