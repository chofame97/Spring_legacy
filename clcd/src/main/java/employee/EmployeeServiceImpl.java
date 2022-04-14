package employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired private EmployeeDAO dao;
	
	@Override
	public List<EmployeeVO> employee_list() {
		return dao.employee_list();
	}

	@Override
	public EmployeeVO employee_detail(int id) {
		return dao.employee_detail(id);
	}

	@Override
	public List<DepartmentVO> employee_department() {
		return dao.employee_department();
	}

	@Override
	public List<EmployeeVO> employee_list(String dept_id) {
		return dao.employee_list(dept_id);
	}

}
