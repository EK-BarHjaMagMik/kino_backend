package org.example.kino_backend.service;

import org.example.kino_backend.model.Employee;
import org.example.kino_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends CrudServiceImpl<Employee, Long> {

    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }
}
