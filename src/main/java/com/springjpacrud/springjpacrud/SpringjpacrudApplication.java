package com.springjpacrud.springjpacrud;

import com.springjpacrud.springjpacrud.dao.EmployeeRepository;
import com.springjpacrud.springjpacrud.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringjpacrudApplication {

    public static void main(String[] args) {
      ApplicationContext context = SpringApplication.run(SpringjpacrudApplication.class, args);

        EmployeeRepository employeeRepository= context.getBean(EmployeeRepository.class);

        /**
         * Adding Employee object in database
         */

//        Employee employee = new Employee();
//        employee.setName("Abdul Muqeet");
//        employee.setCity("Kandhkot");
//        employee.setSalary(70000);
//        employeeRepository.save(employee);









        /**
         * Getting object by id
         */

        Optional<Employee> optional = employeeRepository.findById(3);
        Employee employee1 = optional.get();
        System.out.println(employee1);


        /**
         * Updating Employee with id 2
         * we already have the object with id 2, which we get in previous step
         * now simply we have to update it.
         */

        employee1.setName("Abdul Muqeet");
        Employee employee2 = employeeRepository.save(employee1);
        System.out.println("After update"+employee2);


        /**
         *GETTING ALL EMPLOYEES RECORD
         */


       Iterable<Employee> employees = employeeRepository.findAll();
        System.out.println("ALL EMPLYEES LIST");
       employees.forEach(employee -> {
           System.out.println(employee);
       });


        /**
         *
         * Deleting an specific element
         */

        employeeRepository.deleteById(2);
    }

}
