package sun.DAO;

import java.util.List;

import sun.Module.Customer;

public interface CustomerBo {
		int save(Customer c);
		int update(Customer c);
		int delete(int id);
		int delete(Customer c);
		Customer get(int id);
		List<Customer>getall();
		
		
	 
	}


