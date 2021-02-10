package by.anton.spring_boot_rest.controller;

import by.anton.spring_boot_rest.entity.Employee;
import by.anton.spring_boot_rest.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MyRESTController {
    private static Logger logger= LoggerFactory.getLogger(MyRESTController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        logger.info("Get all employees");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        Employee employee=employeeService.getEmployeeById(id);
        logger.info("Get employee by ID "+id);
        return employee;


    }
 //RequestBody связывает json обьект с классом Employee
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        logger.info("Add employee with name "+employee.getName());
        return employee;
    }
//для изменения работника используем PutMapping
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        logger.info("Update employee with name "+employee.getName());
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id){

        Employee employee= employeeService.getEmployeeById(id);
        logger.info("Delete employee with name " +employee.getName());
        employeeService.deleteEmployee(employee);
        return "Employee with id="+id+" was deleted.";
    }


}
