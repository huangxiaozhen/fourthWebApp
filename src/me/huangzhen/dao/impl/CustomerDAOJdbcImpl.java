package me.huangzhen.dao.impl;

import java.util.List;


import me.huangzhen.Customer;
import me.huangzhen.dao.CustomerDAO;
import me.huangzhen.dao.DAO;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO
{

	@Override
	public List<Customer> getAll()
	{
		String sql = "select id,name,address,phone from test_customer";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer)
	{
		String sql = "insert into test_customer(name,address,phone) VALUES(?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());

	}

	@Override
	public Customer get(int id)
	{
		String sql = "select id,name,address,phone from test_customer where id = ?";
		return get(sql, id);
	}

	@Override
	public void delete(int id)
	{
		String sql = "delete from test_customer where id = ?";
		update(sql, id);

	}

	@Override
	public long getCountWithName(String name)
	{
		String sql = "select count(id) from test_customer where name = ?";
 		return getForValue(sql, name);
	}

}
