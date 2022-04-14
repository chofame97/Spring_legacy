package customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	// 해당 클래스가 서비스 레이어 클래스라는 것을 명시.. 객체로 만듬
public class CustomerServiceImpl implements CustomerService {

	@Autowired private CustomerDAO dao;
	
	@Override
	public void customer_insert(CustomerVO vo) {
		dao.customer_insert(vo);
	}

	@Override
	public List<CustomerVO> customer_list() {
		return dao.customer_list();
	}

	@Override
	public CustomerVO customer_detail(int id) {
		return dao.customer_detail(id);
	}

	@Override
	public void customer_update(CustomerVO vo) {
		dao.customer_update(vo);
	}

	@Override
	public void customer_delete(int id) {
		dao.customer_delete(id);
	}

}
