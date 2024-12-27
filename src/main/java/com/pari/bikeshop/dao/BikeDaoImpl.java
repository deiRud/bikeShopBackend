package com.pari.bikeshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pari.bikeshop.products.Bike;
import com.pari.bikeshop.products.Color;


public class BikeDaoImpl implements BikeDao {
	private final Connection connection; //final - This ensures that the same database connection is used throughout the lifetime of the DAO instance. uses the same connection for all its operations.
	
	public BikeDaoImpl(Connection connection) {
		this.connection = connection;
	}
    @Override
    public void add(Bike bike) {
        String sql = "INSERT INTO bike (bike_id, name_model, company, price, amount, description, weight) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, bike.getProductId());
            preparedStatement.setString(2, bike.getNameModel());
            preparedStatement.setString(3, bike.getCompany());
            preparedStatement.setDouble(4, bike.getPrice());
            preparedStatement.setInt(5, bike.getAmount());
            preparedStatement.setString(6, bike.getDescription());
            preparedStatement.setDouble(7, bike.getWeight());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	/*@Override
	public Bike getById(int id) {
		String sql = "SELECT * FROM bike WHERE bike_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	return new Bike (
                        rs.getInt("bike_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getDouble("weight")
                 );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}*/

    @Override
    public Bike getById(int id) {
        String sql = "SELECT * FROM bike WHERE bike_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Bike(
                        rs.getInt("bike_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getDouble("weight"),
                        rs.getString("image_url"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        null // Assuming colors are not stored in the bike table
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bike> getAll() {
        List<Bike> bikes = new ArrayList<>();
        String sql = "SELECT * FROM bike";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                bikes.add(new Bike(
                        rs.getInt("bike_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getDouble("weight"),
                        rs.getString("image_url"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        null // Assuming colors are not stored in the bike table
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bikes;
    }
    @Override
    public void update(Bike bike) {
        String sql = "UPDATE bike SET name_model = ?, company = ?, price = ?, amount = ?, description = ?, weight = ?, image_url = ?, brand = ?, model = ? WHERE bike_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, bike.getNameModel());
            pstmt.setString(2, bike.getCompany());
            pstmt.setDouble(3, bike.getPrice());
            pstmt.setInt(4, bike.getAmount());
            pstmt.setString(5, bike.getDescription());
            pstmt.setDouble(6, bike.getWeight());
            pstmt.setString(7, bike.getImageUrl());
            pstmt.setString(8, bike.getBrand());
            pstmt.setString(9, bike.getModel());
            pstmt.setInt(10, bike.getProductId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM bike WHERE bike_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
