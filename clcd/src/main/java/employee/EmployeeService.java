package employee;

import java.util.List;

public interface EmployeeService {

	// 사원목록 조회
	List<EmployeeVO> employee_list();
	
	// 사원 상세정보 조회
	EmployeeVO employee_detail(int id);
	
	// 사원이 소속된 부서명 조회
	List<DepartmentVO> employee_department();
	
	// 특정 부서의 사원 목록 조회
	List<EmployeeVO> employee_list(String dept_id);
	
	
	
}
