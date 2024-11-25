package com.pari.bikeshop;
import java.sql.Connection;
import java.sql.SQLException;

import com.pari.bikeshop.products.Bike;
import com.pari.bikeshop.products.Brake;
import com.pari.bikeshop.products.Frame;
import com.pari.bikeshop.products.Product;
import com.pari.bikeshop.dao.BikeDao;
import com.pari.bikeshop.dao.BikeDaoImpl;
import com.pari.bikeshop.dao.BrakeDao;
import com.pari.bikeshop.dao.BrakeDaoImpl;
import com.pari.bikeshop.dao.FrameDao;
import com.pari.bikeshop.dao.FrameDaoImpl;
import com.pari.bikeshop.dao.ProductDao;
import com.pari.bikeshop.dao.ProductDaoImpl;

public class BikeShop {

	public static void main(String[] args) {
		
		try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Connected to PostgreSQL server");
          
            FrameDao frameDao = new FrameDaoImpl(connection);
            BrakeDao brakeDao = new BrakeDaoImpl(connection);
            BikeDao bikeDao = new BikeDaoImpl(connection);
            ProductDao productDao = new ProductDaoImpl(connection);
			  			  
			//Create
            Frame frame = new Frame();
            frame.setProductId(0);
            frameDao.add(frame);

            /*Bike bike = new Bike();
            bike.setBikeId(20);
            bike.setCompany("test");
            
            bikeDao.add(bike);*/
            
            //Create a new Brake object
            /*Brake brake = new Brake();
            brakeDao.add(brake);
			
			//Read
            /*Bike retrievedBike = bikeDao.getById(2);
            System.out.println("Retrieved Bike: " + retrievedBike);
            
            Frame retrievedFrame = frameDao.getById(1);
            System.out.println("Retrieved Frame: " + retrievedFrame);
            
            Brake retrievedBrake = brakeDao.getById(1);
            System.out.println("Retrieved Brake: " + retrievedBrake);
			
			//Update
            /*frame.setMaterial("Carbon");
            frameDao.update(frame);
            System.out.println("Updated Frame: " + frameDao.getById(1));
			
			//Delete
            frameDao.delete(1);
			
			//Get all products
            List<Frame> frames = frameDao.getAll();
            for (Frame f : frames) {
                System.out.println(f);
            }
            
			  
			//Create
            /*Brake brake = new Brake();
            brakeDao.add(brake);*/
            
            
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
}


