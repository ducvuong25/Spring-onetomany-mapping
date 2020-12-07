/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuong.main;

import com.vuong.config.SpringConfig;
import com.vuong.customizeObject.DepartmentCount;
import com.vuong.customizeObject.DepartmentCount2;
import com.vuong.customizeObject.EmployeeCount;
import com.vuong.entity.Department;
import com.vuong.entity.Employee;
import com.vuong.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.vuong.service.HRService;

/**
 *
 * @author ducvuong25
 */
public class main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        DepartmentRepository departmentRepository = (DepartmentRepository) appContext.getBean("departmentRepository");
        List<DepartmentCount> departmentCountByLoc = departmentRepository.getdepartmentCountByLoc();
        for (DepartmentCount departmentCount : departmentCountByLoc) {
            System.out.println(departmentCount.getDepLoc() + ": " + departmentCount.getCount());
        }
        DepartmentCount2 departmentCount = departmentRepository.getdepartmentCount();
        System.out.println("Tong so phong ban la:"  + departmentCount.getCount());
    
    
        List<EmployeeCount> empCountByDep = departmentRepository.getEmpCountByDep();
        for (EmployeeCount employeeCount : empCountByDep) {
            System.out.println(employeeCount.getDepartmentName() + ": " + employeeCount.getEmployeeCount());
        }
    }
    
    
    
    

    public static void saveOneTime(HRService service) {
        // tao 3 empoloees
        Employee emp1 = new Employee();
        emp1.setEmplName("ho minh hoa");
        emp1.setEmplAge(45);
        emp1.setEmplSarary(300);

        Employee emp2 = new Employee();
        emp2.setEmplName("tran thi kim cuong");
        emp2.setEmplAge(23);
        emp2.setEmplSarary(140);

        Employee emp3 = new Employee();
        emp3.setEmplName("minh phuc");
        emp3.setEmplAge(26);
        emp3.setEmplSarary(250);
        // cho va mot mang
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        // tao mot phong ban
        Department kinhdoanh = new Department();
        kinhdoanh.setDepLoc("tang 13");
        kinhdoanh.setDepName("kinh doanh");

        // them danh sach nhn vien vien vao phong moi tao
        kinhdoanh.setEmployees(employees);

        service.addDepartment(kinhdoanh);
    }

}
