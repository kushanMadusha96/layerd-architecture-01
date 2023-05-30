package bo;

import dao.ItemDAO;
import dao.ItemDaoImpl;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo{
    ItemDAO itemDAO = new ItemDaoImpl();
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAllItems();
    }

    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.deleteItem(code);
    }

    @Override
    public void saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {
        return itemDAO.saveItem(code,description,unitPrice,qtyOnHand);
    }

    @Override
    public boolean isExistItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.isExistItem(code);
    }

    @Override
    public String genarateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.genarateNewId();
    }

    @Override
    public ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException {
        return itemDAO.searchItem(s);
    }

    @Override
    public boolean updateItem(String description, BigDecimal unitPrice, int qtyOnHand, String code) throws SQLException, ClassNotFoundException {
        return itemDAO.updateItem(description,unitPrice,qtyOnHand,code);
    }
}
