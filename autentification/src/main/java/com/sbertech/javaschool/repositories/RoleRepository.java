package com.sbertech.javaschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbertech.javaschool.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
