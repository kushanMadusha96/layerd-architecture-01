package bo;

import dao.CustomerDAO;
import dao.CustomerDaoImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpoImpl implements CustomerBo{
    CustomerDAO customerDAO = new CustomerDaoImpl();
    @Override
    public ArrayList<CustomerDTO> loadAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.loadAllCustomer();
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.saveCustomer(customerDTO);
    }

    @Override
    public void updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {
        customerDAO.updateCustomer(id, name, address);
    }

    @Override
    public boolean isExistCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.isExistCustomer(id)
    }

    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.deleteCustomer(id);
    }

    @Override
    public String genarateNewId() throws SQLException, ClassNotFoundException {
        return customerDAO.genarateNewId();
    }

    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return customerDAO.searchCustomer(newValue);
    }
}
