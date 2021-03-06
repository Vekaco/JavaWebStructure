package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {

//    private static final String DRIVER;
//    private static final String URL;
//    private static final String USERNAME;
//    private static final String PASSWORD;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
//    static {
//        Properties conf = PropsUtil.loadProps("config.properties");
//        DRIVER = conf.getProperty("jdbc.driver");
//        URL = conf.getProperty("jdbc.url");
//        USERNAME = conf.getProperty("jdbc.username");
//        PASSWORD = conf.getProperty("jdbc.password");
//
//        try {
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            LOGGER.error("can not load jdbc driver", e);
//        }
//    }

    public List<Customer> getCustomerList() {
//        Connection conn = null;
//
//        try {
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "select * from customer";
//            conn = DatabaseHelper.getConnection();//DriverManager.getConnection(URL, USERNAME, PASSWORD);

//            PreparedStatement stmt = conn.prepareCall(sql);
//            ResultSet rs = stmt.executeQuery();
//
//            while(rs.next()) {
//                Customer customer = new Customer();
//
//                customer.setId(rs.getLong("id"));
//                customer.setName(rs.getString("name"));
//                customer.setContact(rs.getString("contact"));
//                customer.setTelephone(rs.getString("telephone"));
//                customer.setEmail(rs.getString("email"));
//                customer.setRemark(rs.getString("remark"));
//
//                customerList.add(customer);
//            }
//
//            return customerList;
            return DatabaseHelper.queryEntityList(Customer.class, sql);

        }
//        catch (SQLException e) {
//            LOGGER.error("execute sql failure", e);
//        }
//        finally {
//            DatabaseHelper.closeConnection();
//            if(conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    LOGGER.error("close connection failure", e);
//                }
//            }
//        }


        //return null;
//    }

    public Customer getCustomer(long id) {

        String sql = "select * from customer where id=?";

        Customer customer = DatabaseHelper.queryEntity(Customer.class, sql, id);

        return customer;
    }

    /**
     * 创建客户
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     * @param id
     * @param fieldMap
     * @return
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
