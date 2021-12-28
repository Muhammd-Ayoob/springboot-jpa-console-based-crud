package com.springjpacrud.springjpacrud.dao;

import com.springjpacrud.springjpacrud.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    public Employee getByName(String name);

    public List<Employee> findAllBySalary(Integer salary);
}
