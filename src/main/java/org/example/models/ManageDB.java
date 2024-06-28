package org.example.models;

import org.example.Product;
import org.example.User;
import org.example.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageDB {
    ConnectDB db = new ConnectDB();
    Connection connection = db.getConnection();
    Statement statement;
    public void createTable() {
        if (connection != null) {

            try {
                statement = connection.createStatement();

                String createProductTable = "CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, name TEXT, price INTEGER, score NUMERIC, stock INTEGER, category TEXT, description TEXT)";
                String createUsersTable = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, lastName TEXT, userName TEXT, password TEXT, address TEXT, phoneNumber TEXT, budget INTEGER)";
                String createAdminsTable = "CREATE TABLE IF NOT EXISTS admins (id INTEGER PRIMARY KEY, name TEXT, price INTEGER, score NUMERIC, stock INTEGER, category TEXT, description TEXT)";

                statement.executeUpdate(createProductTable);
                statement.executeUpdate(createUsersTable);
                statement.executeUpdate(createAdminsTable);

                System.out.println("PRODUCT TABLE CREATED!");
                System.out.println("USERS TABLE CREATED!");
                System.out.println("ADMINS TABLE CREATED!");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addProductToDB(Product product) {
        String sql = "INSERT INTO products (name, price, score, stock, category, description) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.setDouble(3, product.getScore());
            pstmt.setInt(4, product.getStock());
            pstmt.setString(5, product.getCategory());
            pstmt.setString(6, product.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addUsersToDB(User user) {
        String sql = "INSERT INTO users (name, lastName, userName, password, phoneNumber, budget) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getPhoneNumber());
            pstmt.setInt(6, user.getBudget());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addAdminsToDB(Admin admin) {
        String sql = "INSERT INTO users (name, lastName, userName, password, phoneNumber, budget) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, admin.getFirstName());
            pstmt.setString(2, admin.getLastName());
            pstmt.setString(3, admin.getUserName());
            pstmt.setString(4, admin.getPassword());
            pstmt.setString(5, admin.getPhoneNumber());
            pstmt.setInt(6, admin.getBudget());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product(-1,-1,-1, null,null,null);
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setScore(rs.getInt("score"));
                product.setStock(rs.getInt("stock"));
                product.setCategory(rs.getString("category"));
                product.setDescription(rs.getString("description"));

                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User(null,null,null, null);
                user.setFirstName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setBudget(rs.getInt("budget"));

                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public ArrayList<Admin> getAllAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Admin admin = new Admin(null,null,null, null);
                admin.setFirstName(rs.getString("name"));
                admin.setLastName(rs.getString("lastName"));
                admin.setPassword(rs.getString("password"));
                admin.setAddress(rs.getString("address"));
                admin.setPhoneNumber(rs.getString("phoneNumber"));

                admins.add(admin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return admins;
    }


}
