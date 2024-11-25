package com.pari.bikeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pari.bikeshop.products.Wheelset;

public class WheelsetDaoImpl implements WheelsetDao{
	
	private final Connection connection;
	
	public WheelsetDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void add(Wheelset wheelset) {
		String sql = "INSERT INTO wheelset (wheelset_id, name_model, company, price, amount, description, weight, tires_types) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, wheelset.getWheelsetId());
            pstmt.setString(2, wheelset.getNameModel());
            pstmt.setString(3, wheelset.getCompany());
            pstmt.setDouble(4, wheelset.getPrice());
            pstmt.setInt(5, wheelset.getAmount());
            pstmt.setString(6, wheelset.getDescription());
            pstmt.setDouble(7, wheelset.getWeight());
            pstmt.setString(8, wheelset.getTypeOfTires());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Wheelset getById(int id) {
		 String sql = "SELECT * FROM wheelset WHERE product_id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return new Wheelset(
	                        rs.getInt("wheelset_id"),
	                        rs.getString("name_model"),
	                        rs.getString("company"),
	                        rs.getDouble("price"),
	                        rs.getInt("amount"),
	                        rs.getString("description"),
	                        rs.getDouble("weight"),
	                        rs.getString("tires_types")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;

	}

	@Override
	public List<Wheelset> getAll() {
		List<Wheelset> wheelsets = new ArrayList<>();
        String sql = "SELECT * FROM wheelset";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Wheelset wheelset = new Wheelset(
                        rs.getInt("wheelset_id"),
                        rs.getString("name_model"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getInt("amount"),
                        rs.getString("description"),
                        rs.getDouble("weight"),
                        rs.getString("tires_types")
                );
                wheelsets.add(wheelset);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wheelsets;

	}

	@Override
	public void update(Wheelset wheelset) {
		String sql = "UPDATE wheelset SET name_model = ?, company = ?, price = ?, amount = ?, description = ?, weight = ?, tires_types = ? WHERE wheelset_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, wheelset.getNameModel());
            pstmt.setString(2, wheelset.getCompany());
            pstmt.setDouble(3, wheelset.getPrice());
            pstmt.setInt(4, wheelset.getAmount());
            pstmt.setString(5, wheelset.getDescription());
            pstmt.setDouble(6, wheelset.getWeight());
            pstmt.setString(7, wheelset.getTypeOfTires());
            pstmt.setInt(8, wheelset.getWheelsetId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM wheelset WHERE wheelset_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
	}
	
}
