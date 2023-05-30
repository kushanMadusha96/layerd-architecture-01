package dao;

import db.DBConnection;
import model.ItemDTO;
import utill.SQLUtill;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDAO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> itemList= new ArrayList<>();

        ResultSet rst = SQLUtill.execute("SELECT * FROM Item");

        while(rst.next()){
            itemList.add(new ItemDTO(rst.getString(1),rst.getString(2),rst.getBigDecimal(3),rst.getInt(4)));
        }
        return itemList;
    }

    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        SQLUtill.execute("DELETE FROM Item WHERE code=?",code);
    }

    public void saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {
        SQLUtill.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",code,description,unitPrice,qtyOnHand);
    }

    public boolean isExistItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.execute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();
    }

    public String genarateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    public ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.execute("SELECT * FROM Item WHERE code=?",s + "");
        rst.next();
        ItemDTO item = new ItemDTO(s + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return item;
    }

    public boolean updateItem(String description, BigDecimal unitPrice, int qtyOnHand, String code) throws SQLException, ClassNotFoundException {
        boolean update = SQLUtill.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",description,unitPrice,qtyOnHand,code);
        return update;
    }
}
