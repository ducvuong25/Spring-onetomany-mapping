package com.vuong.repository;

import com.vuong.customizeObject.DepartmentCount;
import com.vuong.customizeObject.DepartmentCount2;
import com.vuong.customizeObject.EmployeeCount;
import com.vuong.entity.Department;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    @Query("select D from Department D join D.employees E GROUP BY D.depId HAVING count(E) >= ?1")
    List<Department> findDepartmentsHasEmplGreaterThan(long N);

    // Lất tất cả các phòng có nhân viên tên Binh dang truyen tham so
    @Query("SELECT distinct D from Department D join D.employees E WHERE E.EmplName like %?1 ")
    List<Department> findDepartmentsByNameEmployee(String Name);

    // Lất tất cả các phòng có nhân viên tên Binh dang hardcode
    @Query("SELECT distinct D from Department D join D.employees E WHERE E.EmplName like '%binh' ")
    List<Department> findDepartmentsByNameHardCode();

    // Liet ke ra tat cac phong ban
    @Query("select d from Department d")
    List<Department> getAllDepartments();

    // Liet ke cac phong ban theo tang
    @Query("select d from Department d where d.depLoc = ?1")
    List<Department> getAllDepartments(String tang);

    // tra ve mot danh sach cac phan tu ma moi phan tu chua tang va so luong phong o tang do
    @Query("select new com.vuong.customizeObject.DepartmentCount(d.depLoc, count(d)) from  Department d group by d.depLoc")
    List<DepartmentCount> getdepartmentCountByLoc();

// tra về duy nhat tong so phong ban tỏng cy 
    @Query("select new com.vuong.customizeObject.DepartmentCount2(count(d)) from  Department d")
    DepartmentCount2 getdepartmentCount();

    // tra ve mot danh sach cac phan tu ma moi phan tu chua tang va so luong phong o tang do
    @Query("select new com.vuong.customizeObject.EmployeeCount(d.depName, count(e)) from  Department d join d.employees e group by d.depId")
    List<EmployeeCount> getEmpCountByDep();

}


