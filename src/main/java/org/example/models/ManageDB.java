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

                String createProductTable = "CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, name TEXT, price INTEGER, score NUMERIC, stock INTEGER, category TEXT, description TEXT, pictureAddress TEXT)";
                String createUsersTable = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, lastName TEXT, userName TEXT, password TEXT, address TEXT, phoneNumber TEXT, budget INTEGER)";
                String createAdminsTable = "CREATE TABLE IF NOT EXISTS admins (id INTEGER PRIMARY KEY, name TEXT, lastName TEXT, userName TEXT, password TEXT, address TEXT, phoneNumber TEXT)";

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
        String sql = "INSERT INTO products (name, price, score, stock, category, description, pictureAddress) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.setDouble(3, product.getScore());
            pstmt.setInt(4, product.getStock());
            pstmt.setString(5, product.getCategory());
            pstmt.setString(6, product.getDescription());
            pstmt.setString(7,product.getPictureAddress());
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
            pstmt.setString(7, admin.getAddress());
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
                Product product = new Product(-1,-1,-1, null,null,null, null);
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setScore(rs.getInt("score"));
                product.setStock(rs.getInt("stock"));
                product.setCategory(rs.getString("category"));
                product.setDescription(rs.getString("description"));
                product.setPictureAddress(rs.getString("pictureAddress"));

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
                User user = new User(null,null,null,null,null,null,null,2);
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
                Admin admin = new Admin(null,null,null, null, null,null,null,-1);
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

    public void editUser(User userToEdit, User chanedUser){
        String selectSQL = "SELECT * FROM products WHERE id = ?";
        String updateSQL = "UPDATE products SET name = ?, lastName = ?, userName = ?, password = ?, phoneNumber = ?, email = ?, budget = ? WHERE id = ?";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
             PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {

            selectStmt.setString(1, userToEdit.getUserName());
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                updateStmt.setString(1, chanedUser.getFirstName());
                updateStmt.setString(2, chanedUser.getLastName());
                updateStmt.setString(3, chanedUser.getUserName());
                updateStmt.setString(4, chanedUser.getPassword());
                updateStmt.setString(5, chanedUser.getAddress());
                updateStmt.setString(6, chanedUser.getPhoneNumber());
                updateStmt.setInt(7, chanedUser.getBudget());
                updateStmt.executeUpdate();
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean loginCheck(String userName, String password){
        String selectSQL = "SELECT password FROM users WHERE username = ?";

        try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL)) {
            selectStmt.setString(1, userName);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");

                if (storedPassword.equals(password)){
                    return true;
                }else {
                    System.out.println("register First");
                    return false;
                }

            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean registerCheck(String firstName, String lastName, String userName, String address, String email, String phoneNumber, String password, String password2){
        String checkUserSQL = "SELECT username FROM users WHERE username = ?";
        String insertUserSQL = "INSERT INTO users (name, lastName, username, password, address, phoneNumber, budget) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement checkStmt = connection.prepareStatement(checkUserSQL)) {
            checkStmt.setString(1, userName);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("Username already exists. Please choose a different username.");
                return false;
            } else {
                // Username does not exist, register
                try (PreparedStatement insertStmt = connection.prepareStatement(insertUserSQL)) {
                    if(password.equals(password2)) {
                        insertStmt.setString(1, firstName);
                        insertStmt.setString(2, lastName);
                        insertStmt.setString(3, userName);
                        insertStmt.setString(4, password);
                        insertStmt.setString(5, address);
                        insertStmt.setString(6, phoneNumber);
                        insertStmt.setInt(7, 0);

                        insertStmt.executeUpdate();
                        System.out.println("User registered successfully.");
                        return true;
                    }else {
                        System.out.println("passwords are different");
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean deleteUser(String userName) {
        String deleteSQL = "DELETE FROM users WHERE username = ?";

        try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSQL)) {
            deleteStmt.setString(1, userName);
            int rowsAffected = deleteStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User deleted successfully.");
                return true;
            } else {
                System.out.println("User not found.");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean deleteProduct(String productName) {
        String deleteSQL = "DELETE FROM users WHERE products = ?";

        try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSQL)) {
            deleteStmt.setString(1, productName);
            int rowsAffected = deleteStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("product deleted successfully.");
                return true;
            } else {
                System.out.println("product not found.");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
