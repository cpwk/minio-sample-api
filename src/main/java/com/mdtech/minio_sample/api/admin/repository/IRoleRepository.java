package com.mdtech.minio_sample.api.admin.repository;

import com.mdtech.minio_sample.api.admin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}