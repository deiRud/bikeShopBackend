package com.pari.bikeshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pari.bikeshop.products.Brake;

public class BrakeDaoImpl implements BrakeDao {
	
	private final Connection connection; //final - This ensures that the same database connection is used throughout the lifetime of the DAO instance. uses the same connection for all its operations.
	
	public BrakeDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void add(Brake brake) {
		String sql = "INSERT INTO brake (brake_id, name_model, company, price, amount, description, weight, brake_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, brake.getBrakeId());
            preparedStatement.setString(2, brake.getNameModel());
            preparedStatement.setString(3, brake.getCompany());
            preparedStatement.setDouble(4, brake.getPrice());
            preparedStatement.setInt(5, brake.getAmount());
            preparedStatement.setString(6, brake.getDescription());
            preparedStatement.setDouble(7, brake.getWeight());
            preparedStatement.setString(8, brake.getBrakeType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	//get all brakes
	@Override
	public Brake getById(int id) {
        String sql = "SELECT * FROM brake WHERE brake_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	/*return new Brake (
                        rs.getInt("brake_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description")
                 );*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	//Update
	@Override
	public void update(Brake brake) {
        String sql = "UPDATE brake SET name_model = ?, company = ?, price = ?, amount = ?, description = ?, weight = ?, brake_type = ? WHERE brake_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, brake.getNameModel());
            pstmt.setString(2, brake.getCompany());
            pstmt.setDouble(3, brake.getPrice());
            pstmt.setInt(4, brake.getAmount());
            pstmt.setString(5, brake.getDescription());
            pstmt.setDouble(6, brake.getWeight());
            pstmt.setString(7, brake.getBrakeType());
            pstmt.setInt(8, brake.getBrakeId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	//Delete	
	@Override
	public void delete(int id) {
        String sql = "DELETE FROM brake WHERE brake_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	@Override
	 public List<Brake> getAll() {
	        List<Brake> brakes = new ArrayList<>();
	        String sql = "SELECT * FROM brake";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Brake brake = new Brake();
	                        brake.setProductId(rs.getInt("brake_id"));
	                        brake.setNameModel(rs.getString("name_model"));
	                        brake.setCompany(rs.getString("company"));
	                        brake.setPrice(rs.getDouble("price"));
	                        brake.setAmount(rs.getInt("amount"));
	                        brake.setDescription(rs.getString("description"));
	                        brake.setWeight(rs.getDouble("weight"));
	                        brake.setBrakeType(rs.getString("brake_type"));
	                        brakes.add(brake);
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return brakes;
	    }
}
