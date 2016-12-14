package ru.nosov.autentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nosov.autentification.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
