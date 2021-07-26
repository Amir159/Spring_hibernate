package com.syncretis.repository;

import com.syncretis.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findById(long id);
}
