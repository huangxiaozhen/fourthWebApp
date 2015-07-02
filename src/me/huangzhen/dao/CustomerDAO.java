package me.huangzhen.dao;

import java.util.List;

import me.huangzhen.Customer;

public interface CustomerDAO
{
	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public Customer get(int id);
	
	public void delete(int id);
	
	public long getCountWithName(String name);

}
