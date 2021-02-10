package by.anton.spring_boot_rest.dao;

import by.anton.spring_boot_rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository   //для всех классов DAO использовать Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    @Transactional //спринг сам контролирует открытие и закрытие транзакции
    public List<Employee> getAllEmployees() {

        Session session=entityManager.unwrap(Session.class); //из hibernate в jpa
//        List<Employee> allEmploees=session.createQuery("from Employee ", Employee.class).getResultList();
        Query<Employee> query=session.createQuery("from Employee ", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;

    }

    @Override
    public void deleteEmployee(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        session.delete(employee);
    }


    @Override
    public void saveEmployee(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);

    }


    public Employee getEmployeeById(int id) {

        Session session=entityManager.unwrap(Session.class);
//        List<Employee> allEmploees=session.createQuery("from Employee ", Employee.class).getResultList();
        Employee query=session.get(Employee.class,id);

        return query;

    }

    @Override
    public Employee getEmployeeLikeName(String name) {
        Session session=entityManager.unwrap(Session.class);
        Query<Employee> employeeQuery=session.createQuery("from Employee where name like :name%");
        employeeQuery.setParameter("name",name);
        Employee employee=employeeQuery.getSingleResult();
        return employee;
    }

}
