package by.anton.spring_boot_rest.dao;

import by.anton.spring_boot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void deleteEmployee(Employee employee);
    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public Employee getEmployeeLikeName(String name);
}
