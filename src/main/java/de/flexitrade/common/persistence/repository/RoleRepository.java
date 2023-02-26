package de.flexitrade.common.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.flexitrade.common.persistence.entity.Role;
import de.flexitrade.common.persistence.entity.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleType name);
}