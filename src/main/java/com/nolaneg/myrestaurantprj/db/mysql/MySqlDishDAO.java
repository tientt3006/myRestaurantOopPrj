package com.nolaneg.myrestaurantprj.db.mysql;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DishDAO;
import com.nolaneg.myrestaurantprj.db.entity.Dish;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author Hoàng Hướng
 */
public class MySqlDishDAO implements DishDAO {
    private static Dish mapDish(ResultSet rs) throws SQLException {
        int k = 0;
        Dish dish = new Dish(rs.getInt(++k),rs.getString(++k),rs.getFloat(k+=2),rs.getString(++k));
        return dish;
                
    }
    
    @Override
//    public Dish getDish() throws DbException{
//        try (Connection connection = ConnectionPool.getInstance().getConnection();
//            PreparedStatement ps = connection.prepareStatement(SqlUtils.GET_DISH)) {
//
//            try (ResultSet rs = ps.executeQuery()) {
//                if (!rs.next()) return null;
//                return mapDish(rs);
//            }
//        } catch (SQLException ex) {
//            throw new DbException("Cannot getDish", ex);
//        }
//    }
    public List<Dish> getDishes() throws DbException {
        List<Dish> dishes = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.GET_DISHES);
             ResultSet rs = ps.executeQuery()) {

            // Lặp qua tất cả các kết quả và thêm từng món vào danh sách
            while (rs.next()) {
                dishes.add(mapDish(rs));
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot get dishes", ex);
        }
        return dishes;
    }
}
