package me.huangzhen.test;

import static org.junit.Assert.*;

import java.util.List;

import me.huangzhen.Customer;
import me.huangzhen.dao.CustomerDAO;
import me.huangzhen.dao.impl.CustomerDAOJdbcImpl;

import org.junit.Test;


public class CustomerDAOJdbcImplTest
{

	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();

	@Test
	public void testGetAll()
	{
		List<Customer> customers = customerDAO.getAll();
		System.out.println( customers );
		
	}

	@Test
	public void testSave()
	{
		Customer customer = new Customer();
		customer.setName("huangzhen3");
		customer.setAddress("shanghai");
		customer.setPhone("13011112222");
		customerDAO.save(customer);
	}

	@Test
	public void testGetInt()
	{
		Customer customer = customerDAO.get(2);
		System.out.println( customer );
	}

	@Test
	public void testDelete()
	{
		customerDAO.delete(2);
	}
	
	

	@Test
	public void testGetCountWithName()
	{
		long count = customerDAO.getCountWithName("huangzhen3");
		System.out.println(" count:" + count );
	}

}
