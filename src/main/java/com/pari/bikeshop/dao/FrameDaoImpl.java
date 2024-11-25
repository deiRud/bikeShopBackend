package com.pari.bikeshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pari.bikeshop.DatabaseConnection;
import com.pari.bikeshop.products.Frame;

public class FrameDaoImpl implements FrameDao {
	
	private final Connection connection;
	
	public FrameDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
    public void add(Frame frame) {
        String sql = "INSERT INTO frame (frame_id, name_model, company, price, amount, description, weight, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, frame.getFrameId());
            pstmt.setString(2, frame.getNameModel());
            pstmt.setString(3, frame.getCompany());
            pstmt.setDouble(4, frame.getPrice());
            pstmt.setInt(5, frame.getAmount());
            pstmt.setString(6, frame.getDescription());
            pstmt.setDouble(7, frame.getWeight());
            pstmt.setString(8, frame.getMaterial());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	 @Override
	    public Frame getById(int id) {
	        String sql = "SELECT * FROM frame WHERE frame_id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return new Frame(
	                        rs.getInt("frame_id"),
	                        rs.getString("name_model"),
	                        rs.getString("company"),
	                        rs.getDouble("price"),
	                        rs.getInt("amount"),
	                        rs.getString("description"),
	                        rs.getDouble("weight"),
	                        rs.getString("material")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 
	 @Override
	 public List<Frame> getAll() {
	        List<Frame> frames = new ArrayList<>();
	        String sql = "SELECT * FROM frame";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Frame frame = new Frame(
	                        rs.getInt("frame_id"),
	                        rs.getString("name_model"),
	                        rs.getString("company"),
	                        rs.getDouble("price"),
	                        rs.getInt("amount"),
	                        rs.getString("description"),
	                        rs.getDouble("weight"),
	                        rs.getString("material")
	                );
	                frames.add(frame);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return frames;
	    }
	 
	 @Override
	    public void update(Frame frame) {
	        String sql = "UPDATE frame SET name_model = ?, company = ?, price = ?, amount = ?, description = ?, weight = ?, material = ? WHERE frame_id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setString(1, frame.getNameModel());
	            pstmt.setString(2, frame.getCompany());
	            pstmt.setDouble(3, frame.getPrice());
	            pstmt.setInt(4, frame.getAmount());
	            pstmt.setString(5, frame.getDescription());
	            pstmt.setDouble(6, frame.getWeight());
	            pstmt.setString(7, frame.getMaterial());
	            pstmt.setInt(8, frame.getFrameId());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 @Override
	    public void delete(int id) {
	        String sql = "DELETE FROM frame WHERE frame_id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
