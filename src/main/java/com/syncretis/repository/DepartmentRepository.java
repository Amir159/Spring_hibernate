package com.syncretis.repository;

import com.syncretis.entity.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findById(long id);
}
