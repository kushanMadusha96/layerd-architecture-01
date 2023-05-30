package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T,String> {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public void add(T dto) throws SQLException, ClassNotFoundException;
    public void update(T dto) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public void delete(String id) throws SQLException, ClassNotFoundException;
    public T search(String id) throws SQLException, ClassNotFoundException;
}
