package com.pari.bikeshop.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pari.bikeshop.products.Drivetrain;

public class DrivetrainDaoImpl implements DrivetrainDao {
	
	private final Connection connection;
	
	public DrivetrainDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void add(Drivetrain drivetrain) {
		String sql = "INSERT INTO drivetrain (drivetrain_id, name_model, company, price, amount, description, weight, amount_of_gears) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, drivetrain.getDrivetrainId());
            pstmt.setString(2, drivetrain.getNameModel());
            pstmt.setString(3, drivetrain.getCompany());
            pstmt.setDouble(4, drivetrain.getPrice());
            pstmt.setInt(5, drivetrain.getAmount());
            pstmt.setString(6, drivetrain.getDescription());
            pstmt.setDouble(7, drivetrain.getWeight());
            pstmt.setInt(8, drivetrain.getAmountOfGears());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Drivetrain getById(int id) {
		String sql = "SELECT * FROM frame WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Drivetrain(
                        rs.getInt("product_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getDouble("weight"),
                        rs.getInt("amount_of_gears")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

	}

	@Override
	public List<Drivetrain> getAll() {
		List<Drivetrain> drivetrains = new ArrayList<>();
        String sql = "SELECT * FROM drivetrain";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Drivetrain drivetrain = new Drivetrain(
                        rs.getInt("product_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getDouble("weight"),
                        rs.getInt("amount_of_gears")
                );
                drivetrains.add(drivetrain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivetrains;

	}

	@Override
	public void update(Drivetrain drivetrain) {
		String sql = "UPDATE drivetrain SET name_model = ?, company = ?, price = ?, amount = ?, description = ?, weight = ?, amount_of_gears = ? WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, drivetrain.getNameModel());
            pstmt.setString(2, drivetrain.getCompany());
            pstmt.setDouble(3, drivetrain.getPrice());
            pstmt.setInt(4, drivetrain.getAmount());
            pstmt.setString(5, drivetrain.getDescription());
            pstmt.setDouble(6, drivetrain.getWeight());
            pstmt.setInt(7, drivetrain.getAmountOfGears());
            pstmt.setInt(8, drivetrain.getProductId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM drivetrain WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
	}
	

}
