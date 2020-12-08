/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuong.repository;

import com.vuong.customizeObject.DepartmentCountIF;
import com.vuong.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ducvuong25
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    //liet ke cac nhan vien lam o phong it

//    @Query("select emp from Employee emp join emp.department dep where dep.depId = ?1")
//    List<Employee> findEmployeesByDepartment(String location);
    @Query("select E from Employee E join E.department D where D.depLoc = ?1 order by E.id ASC")
    List<Employee> findEmployeesBylocation(String floor);

    @Query("select D.depName as depName, count(E) as totalEmpl from Department D join D.employees E group by D.depName")
    List<DepartmentCountIF> getTotalEmplByDep();

}
