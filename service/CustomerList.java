package com.alexzit.project02.service;

import com.project02.bean.Customer;

/**
 * @author Alex
 * @create 2021-08-26 19:05
 */
public class CustomerList
{
    private Customer[] customers;//保存客户对象的数组
    private int total = 0;//保存客户对象的数量

    /**
     * 初始化customer数组的构造器
     * @param totalCustomer:指定数组的长度
     */
    public CustomerList(int totalCustomer)
    {
        customers = new Customer[totalCustomer];
    }

    /**
     * 添加成功返回true
     * @param customer
     * @return
     */
    public boolean addCustomer(Customer customer)
    {
        if(total >= customers.length)
        {
            return false;
        }

        customers[total++] = customer;
        return true;
    }

    /**
     * 修改指定客户信息
     * true修改成功
     * @param index
     * @param customer
     * @return
     */
    public boolean replaceCustomer(int index, Customer cust)
    {
        if(index < 0 || index >= total)
        {
            return false;
        }

        customers[index] = cust;
        return true;
    }

    /**
     * 删除指定客户
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index)
    {
        if(index < 0 || index >= total)
        {
            return false;
        }

        for(int i = index; i < total - 1; i++)
        {
            customers[i] = customers[i + 1];
        }
        customers[--total] = null;
        return true;
    }

    /**
     * 返回所有客户信息
     * @return
     */
    public Customer[] getAllCustomers()
    {
        Customer[] custs = new Customer[total];
        for(int i = 0; i < total; i++)
        {
            custs[i] = customers[i];
        }
        return custs;
    }

    public Customer getCustomer(int index)
    {
        if(index < 0 || index >= total)
        {
            return null;
        }
        return customers[index];
    }

    public int getTotal()
    {
        return total;
    }

}
