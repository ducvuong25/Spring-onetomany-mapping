/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuong.customizeObject;

public class DepartmentCount {

    private String depLoc;
    private Long count;

    public DepartmentCount(String depLoc, Long count) {
        this.depLoc = depLoc;
        this.count = count;
    }

    public String getDepLoc() {
        return depLoc;
    }

    public Long getCount() {
        return count;
    }

    public void setDepLoc(String depLoc) {
        this.depLoc = depLoc;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
