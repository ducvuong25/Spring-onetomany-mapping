/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuong.service;

import com.vuong.entity.Department;
import com.vuong.entity.Employee;
import com.vuong.repository.DepartmentRepository;
import com.vuong.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ducvuong25
 */
@Service
public class HRServiceImpl implements HRService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(e -> employees.add((Employee) e));
        return employees;
    }

    @Override
    public void initData() {
        //tao 4 phong ban
        Department dep1 = new Department();
        dep1.setDepName("van thu luu tru");
        dep1.setDepLoc("tang 15");

        Department dep2 = new Department();
        dep2.setDepName("ke toan tai chinh");
        dep2.setDepLoc("tang 13");

        Department dep3 = new Department();
        dep3.setDepName("hanh chinh nhan su");
        dep3.setDepLoc("tang 7");

        Department dep4 = new Department();
        dep4.setDepName("cong nghe thong tin");
        dep4.setDepLoc("tang 7");
        //them bon phong ban vao mot mang
        List<Department> departments = new ArrayList<>();
        departments.add(dep1);
        departments.add(dep2);
        departments.add(dep3);
        departments.add(dep4);

        // Lưu 4 phòng bạn vào database
        departmentRepository.saveAll(departments);
//################################################

// tao ra 6 employee
        Employee emp1 = new Employee();
        emp1.setEmplName("le duc vuong");
        emp1.setEmplAge(25);
        emp1.setEmplSarary(1000);
        emp1.setDepartment(dep4);  //set department cho moi employeee==> vì bên emp này đang là own

        Employee emp2 = new Employee();
        emp2.setEmplName("nguyen bao nhi");
        emp2.setEmplAge(29);
        emp2.setEmplSarary(600);
        emp2.setDepartment(dep4); //set department cho moi employeee==> vì bên này đang là own


        Employee emp3 = new Employee();
        emp3.setEmplName("nguyen van dung");
        emp3.setEmplAge(24);
        emp3.setEmplSarary(750);
        emp3.setDepartment(dep4); //set department cho moi employeee==> vì bên này đang là own


        Employee emp4 = new Employee();
        emp4.setEmplName("tran hoang vy");
        emp4.setEmplAge(44);
        emp4.setEmplSarary(400);
        emp4.setDepartment(dep2); //set department cho moi employeee==> vì bên này đang là own


        Employee emp5 = new Employee();
        emp5.setEmplName("le thi lai");
        emp5.setEmplAge(27);
        emp5.setEmplSarary(300);
        emp5.setDepartment(dep1); //set department cho moi employeee==> vì bên này đang là own


        Employee emp6 = new Employee();
        emp6.setEmplName("tran tan binh");
        emp6.setEmplAge(33);
        emp6.setEmplSarary(150);
        emp6.setDepartment(dep3);
        List<Employee> employees = new ArrayList<>();

        
        // tao ra mot mang 6 employee
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);
        // lưu 6 empploy vao bang
        employeeRepository.saveAll(employees);

    }

    @Override
    public Department getDepartment(int id) {
        return departmentRepository.findById(id).orElse(null);

    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void addEmployess(List<Employee> employees) {
        employeeRepository.saveAll(employees);

    }

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void addEmloyee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteDepartment(int Id) {
        departmentRepository.deleteById(Id);
    }

    @Override
    public List<Employee> getEmployeesByLocation(String floor) {
        return employeeRepository.findEmployeesBylocation(floor);
    }

    @Override
    public List<Department> getDepartmentsHasEmplGreaterThan(long N) {
        return departmentRepository.findDepartmentsHasEmplGreaterThan(N);
    }

    @Override
    public List<Department> getDepartmentsByNameEmployee(String name) {
        return departmentRepository.findDepartmentsByNameEmployee(name);
    }

    @Override
    public List<Department> getDepartmentsByNameHardCode() {
        return departmentRepository.findDepartmentsByNameHardCode();
    }

}
