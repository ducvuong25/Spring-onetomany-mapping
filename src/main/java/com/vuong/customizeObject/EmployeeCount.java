/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuong.customizeObject;

/**
 *
 * @author ducvuong25
 */
public class EmployeeCount {
    String departmentName;
    Long employeeCount;

    public EmployeeCount(String departmentName, Long employeeCount) {
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Long getEmployeeCount() {
        return employeeCount;
    }
     
}
