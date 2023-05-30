package dao;

import db.DBConnection;
import utill.SQLUtill;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDAO{
    public boolean saveOrderDetails(String orderId, String itemCode, int qty, BigDecimal unitPrice) throws SQLException, ClassNotFoundException {
        boolean save = SQLUtill.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",orderId,itemCode,qty,unitPrice);
        return save;
    }
}
