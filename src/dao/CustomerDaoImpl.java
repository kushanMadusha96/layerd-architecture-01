package dao;

import db.DBConnection;
import model.CustomerDTO;
import utill.SQLUtill;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDAO{

    public ArrayList<CustomerDTO> loadAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();

        ResultSet rst = SQLUtill.execute("SELECT * FROM Customer");

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    public void saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        SQLUtill.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    public void updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {
        SQLUtill.execute("UPDATE Customer SET name=?, address=? WHERE id=?",name,address,id);
    }

    public boolean isExistCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.execute("SELECT id FROM Customer WHERE id=?",id);
        return rst.next();
    }

    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        SQLUtill.execute("DELETE FROM Customer WHERE id=?",id);
    }

    public String genarateNewId() throws SQLException, ClassNotFoundException {
         ResultSet rst = SQLUtill.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.execute("SELECT * FROM Customer WHERE id=?",newValue + "");
        rst.next();
        return new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
    }
}
