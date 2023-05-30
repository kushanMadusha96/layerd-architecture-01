package dao;

import db.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDaoImpl {
    public boolean saveOrderDetails(String orderId, String itemCode, int qty, BigDecimal unitPrice) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        stm.setString(1,orderId);
        stm.setString(2,itemCode);
        stm.setInt(3,qty);
        stm.setBigDecimal(4,unitPrice);
        return stm.executeUpdate()>0;
    }
}
