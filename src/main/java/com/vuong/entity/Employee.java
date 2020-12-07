/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuong.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String EmplName;
    private int EmplAge;
    private double EmplSarary;

    @ManyToOne
    @JoinColumn(name = "depId")
    private Department department;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public String getEmplName() {
        return EmplName;
    }

    public int getEmplAge() {
        return EmplAge;
    }

    public double getEmplSarary() {
        return EmplSarary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmplName(String EmplName) {
        this.EmplName = EmplName;
    }

    public void setEmplAge(int EmplAge) {
        this.EmplAge = EmplAge;
    }

    public void setEmplSarary(double EmplSarary) {
        this.EmplSarary = EmplSarary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", EmplName=" + EmplName + ", EmplAge=" + EmplAge + ", EmplSarary=" + EmplSarary + '}';
    }

}
