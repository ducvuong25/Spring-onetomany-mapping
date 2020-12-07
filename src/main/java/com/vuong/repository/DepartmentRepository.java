package com.vuong.repository;

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
    
    
    

}
