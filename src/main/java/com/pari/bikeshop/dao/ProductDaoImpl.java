package com.pari.bikeshop.dao;

import com.pari.bikeshop.products.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
	
	private final Connection connection; /*final - This ensures that the same database connection is used throughout 
	the lifetime of the DAO instance. uses the same connection for all its operations. 
	It declares a field in the BrakeDaoImpl class that will hold a reference to a Connection object. 
	The Connection object represents a connection to the database. 
	The final keyword ensures that once this field is assigned a value, it cannot be changed. 
	This means that the BrakeDaoImpl class will use the same Connection instance for all database operations it performs.*/
	
	public ProductDaoImpl(Connection connection) {
		this.connection = connection;
	}

	/*@Override
	public void add(Product product) {
		String sql = "INSERT INTO product (product_id, name_model, company, price, amount, description, weight) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getNameModel());
            preparedStatement.setString(3, product.getCompany());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getAmount());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setDouble(7, product.getWeight());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}*/

	/*@Override
	public Product getById(int id) {
		String sql = "SELECT * FROM product WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	return new Product (
                        rs.getInt("product_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description")
                 );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}*/

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getDouble("weight"),
                        rs.getString("image_url")
                ) {
                };
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

	/*@Override
	public void update(Product product) {
		String sql = "UPDATE product SET name_model = ?, company = ?, price = ?, amount = ?, description = ?, weight = ? WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getNameModel());
            pstmt.setString(2, product.getCompany());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getAmount());
            pstmt.setString(5, product.getDescription());
            pstmt.setDouble(6, product.getWeight());
            pstmt.setInt(8, product.getProductId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}*/

	/*@Override
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}*/
    @Override
    public List<Product> getByCategory(String category) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE category = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getDouble("weight"),
                        rs.getString("image_url")
                ) {
                };
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
