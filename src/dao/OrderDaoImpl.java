package dao;

import db.DBConnection;
import utill.SQLUtill;

import java.sql.*;
import java.time.LocalDate;

public class OrderDaoImpl implements OrderDAO{
    public String genarateNewOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    public boolean isExistOrderId(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtill.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        /*if order id already exist*/
        if (rst.next()) {
            return true;
        }
        return false;
    }

    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {
        boolean save = SQLUtill.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderId,orderDate,customerId);

        return save;
    }
}
