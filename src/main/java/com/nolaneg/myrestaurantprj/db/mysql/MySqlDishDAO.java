package com.nolaneg.myrestaurantprj.db.mysql;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DishDAO;
import com.nolaneg.myrestaurantprj.db.entity.Dish;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.Pair;
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
        return new Dish.Builder()
                .setDishId(rs.getInt("dishId"))
                .setDishName(rs.getString("dishName"))
                .setCategoryId(rs.getInt("categoryId"))
                .setPrice(rs.getFloat("price"))
                .setIngredient(rs.getString("ingredient"))
                .getDish();        
    }
    
    @Override
    public Dish getDishById(int id) throws DbException {
        try (Connection c = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(SqlUtils.GET_DISH_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapDish(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new DbException("Cannot getDishById", e);
        }
    }
    
    @Override
    public List<Dish> getAllDishes() throws DbException {
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
    
    @Override
    public List<Dish> getSortedDishesFromCategoryOnPage(int categoryId, String sortBy, int dishesInPage, int pageNum) throws DbException {
        List<Dish> dishes = new ArrayList<>();
        try (Connection c = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(SqlUtils.GET_SORTED_DISHES_FROM_CATEGORY + sortBy + " LIMIT " + pageNum * dishesInPage + ", " + dishesInPage)) {
            ps.setLong(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dishes.add(mapDish(rs));
                }
            }
            return dishes;
        } catch (SQLException e) {
            throw new DbException("Cannot getSortedDishesFromCategory" + categoryId, e);
        }
    }
    
    @Override
    public List<Dish> getSortedDishesOnPage(String sortBy, int dishesInPage, int pageNum) throws DbException {
        List<Dish> dishes = new ArrayList<>();
        try (Connection c = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(SqlUtils.GET_SORTED_DISHES + sortBy + " LIMIT " + pageNum * dishesInPage + ", " + dishesInPage)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dishes.add(mapDish(rs));
                }
            }
            return dishes;
        } catch (SQLException e) {
            throw new DbException("Cannot getSortedDishes", e);
        }
    }
    
    @Override
    public int getDishesNumber() throws DbException {
        try (Connection c = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(SqlUtils.GET_DISHES_COUNT);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            throw new DbException("Cannot getDishesNumber", e);
        }
    }
    
    @Override
    public int getDishesNumberInCategory(int categoryId) throws DbException {
        try (Connection c = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(SqlUtils.GET_DISHES_COUNT_IN_CATEGORY)) {
            ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
                return -1;
            }
        } catch (SQLException e) {
            throw new DbException("Cannot getDishesNumberInCategory", e);
        }
    }
    
    @Override
    public Map<Integer, Pair<String, Integer>> getDishesOrderCount() throws DbException {
        Map<Integer, Pair<String, Integer>> answ = new HashMap<>();
        try (Connection c = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(SqlUtils.GET_DISH_ORDERS_COUNT);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("dishId");
                String name = rs.getString("dishName");
                int orders = rs.getInt("orders"); //something still wrong here, shouldn't touch
                Pair<String, Integer> pair = new Pair<>(name, orders);
                answ.put(id, pair);
            }
            return answ;
        } catch (SQLException e) {
            throw new DbException("Cannot getDishesOrderCount", e);
        }
    }

    @Override
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
    public ArrayList<Dish> getDishByReceiptId(int receiptId) throws DbException {
        ArrayList<Dish> dishes = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().getConnection();
            ps = con.prepareStatement(SqlUtils.GET_DISHES_BY_RECEIPT_ID);
            ps.setInt(1, receiptId);
            ResultSet rs = ps.executeQuery();

            // Lặp qua tất cả các kết quả và thêm từng món vào danh sách
            while (rs.next()) {
                dishes.add(mapDish(rs));
            }
        }
        catch (SQLException ex) {
            throw new DbException("Cannot get dishes", ex);
        }
        return dishes;
    }
}
