/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuong.service;

import com.vuong.entity.Department;
import com.vuong.entity.Employee;
import java.util.List;

/**
 *
 * @author ducvuong25
 */
public interface HRService {
//######################################################################
    // Khởi tạo dữ liệu ban đầu (cả Department lẫn Employee)

    void initData();
//######################################################################
    //Các method lam việc với Department
    // Lấy Department theo ID

    Department getDepartment(int id);

    //Lấy department theo số nhân viên  lớn hơn or bằng  số N
    List<Department> getDepartmentsHasEmplGreaterThan(long N);

    //Lấy department theo tên nhân viên là name by param
    List<Department> getDepartmentsByNameEmployee(String name);
    
    
    //Lấy department theo tên nhân viên là name  by hardcode
    List<Department> getDepartmentsByNameHardCode();

    // Thêm một Department
    void addDepartment(Department department);

    // Xóa một department theo ID
    void deleteDepartment(int Id);
//######################################################################
    //Các method lam việc với Employee
    //Lấy toàn bộ các Employee

    List<Employee> getAllEmployees();

    //Lấy Employee theo location
    List<Employee> getEmployeesByLocation(String floor);

    // Lấy Employee theo ID
    Employee getEmployee(int id);

    // Lưu một Employee
    void addEmloyee(Employee employee);

    // Lưu một List Employees
    void addEmployess(List<Employee> employees);

}
