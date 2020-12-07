/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuong.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int depId;
    private String depName;
    private String depLoc;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    public Department() {
    }

    public int getDepId() {
        return depId;
    }

    public String getDepName() {
        return depName;
    }

    public String getDepLoc() {
        return depLoc;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setDepLoc(String depLoc) {
        this.depLoc = depLoc;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        for (Employee e : employees) {
            e.setDepartment(this);
        }
    }

}
