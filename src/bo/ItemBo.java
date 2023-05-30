package bo;

import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    void deleteItem(String code) throws SQLException, ClassNotFoundException;
    void saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;
    boolean isExistItem(String code) throws SQLException, ClassNotFoundException;
    String genarateNewId() throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException;
    boolean updateItem(String description, BigDecimal unitPrice, int qtyOnHand, String code) throws SQLException, ClassNotFoundException;
}
