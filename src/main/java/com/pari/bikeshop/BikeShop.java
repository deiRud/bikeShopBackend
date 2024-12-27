package com.pari.bikeshop;
import java.sql.Connection;
import java.sql.SQLException;
import com.google.gson.Gson;
import static spark.Spark.*;

import com.pari.bikeshop.products.Bike;
import com.pari.bikeshop.products.Product;
import com.pari.bikeshop.dao.ProductDao;
import com.pari.bikeshop.dao.ProductDaoImpl;
import com.pari.bikeshop.products.Color;

public class BikeShop {

	public static void main(String[] args) {
		port(8003);

		staticFileLocation("/public");

		before((request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			response.header("Access-Control-Allow-Headers", "Content-Type");
		});

		Gson gson = new Gson();

		Product[] mountainbikes = {
				new Bike(1, "Copperhead 2 27,5", "BULLS", 999.95, 10, "Kettenschaltung | 20 Gang",
						12.5, "images/Copperhead_2_27_5.png", "BULLS", "Copperhead 2 27,5",
						new Color[]{new Color("#FF6347", "images/Copperhead_2_27_5.png"), new Color("#000000", "images/Copperhead_2_27_5_black.png")}),
				new Bike(2, "Copperhead 3 29", "BULLS", 1399.00, 8, "Kettenschaltung | 11 Gang",
						13.0, "images/Copperhead_3_29.png", "BULLS", "Copperhead 3 29",
						new Color[]{new Color("#000000", "images/Copperhead_3_29_black.png"), new Color("#93C572", "images/Copperhead_3_29_green.png"), new Color("#75acb4", "images/Copperhead_3_29_blue.png")}),
				new Bike(3, "Sharptail 2 Disc 29", "BULLS", 799.99, 15, "Kettenschaltung | 27 Gang",
						14.0, "images/Sharptail_2_Disc_29.png", "BULLS", "Sharptail 2 Disc 29",
						new Color[]{new Color("#3b3b3b", "images/Sharptail_3_Disc_29_grey.png"), new Color("#D70040", "images/Sharptail_3_Disc_29_red.png"), new Color("#a6a6a6", "images/Sharptail_3_Disc_29_light_grey.png")})
		};

		Product[] emtb = {
				new Bike(4, "MACINA KAPOHO 7972", "KTM", 5899.00, 5, "Kettenschaltung | 12 Gang",
						15.0, "images/Macina_kapoho_7972.png", "KTM", "MACINA KAPOHO 7972",
						new Color[]{new Color("#D3D3D3", "images/Macina_kapoho_7972.png")}),
				new Bike(5, "MACINA KAPOHO 7973", "KTM", 5299.00, 7, "Kettenschaltung | 20 Gang",
						15.5, "images/Macina_kapoho_7973.png", "KTM", "MACINA KAPOHO 7973",
						new Color[]{new Color("#000000", "images/Macina_kapoho_7973_black.png"), new Color("#0096FF", "images/Macina_kapoho_7973_blue.png")}),
				new Bike(6, "MACINA KAPOHO 7971", "BULKTMLS", 6299.00, 3, "Kettenschaltung | 12 Gang",
						16.0, "images/Macina_kapoho_7971.png", "BULKTMLS", "MACINA KAPOHO 7971",
						new Color[]{new Color("#8b0000", "images/Macina_kapoho_7971_red.png")})
		};


		get("/products/:category", (req, res) -> {
			String category = req.params(":category");
			res.type("application/json");
			Product[] products;
			switch (category.toLowerCase()) {
				case "mountainbikes":
					products = mountainbikes;
					break;
				case "emtb":
					products = emtb;
					break;
				default:
					products = new Product[0];
					break;
			}
			return gson.toJson(products);
		});

		try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Connected to PostgreSQL server");

            //FrameDao frameDao = new FrameDaoImpl(connection);
            //BrakeDao brakeDao = new BrakeDaoImpl(connection);
            //BikeDao bikeDao = new BikeDaoImpl(connection);
            ProductDao productDao = new ProductDaoImpl(connection);


			//Create
            //Frame frame = new Frame();
            //frame.setProductId(0);
            //frameDao.add(frame);

            /*Bike bike = new Bike();
            bike.setBikeId(20);
            bike.setCompany("test");*/

            //bikeDao.add(bike);

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

			/*get("/products/:category", (req, res) -> {
				String category = req.params(":category");
				res.type("application/json");
				return gson.toJson(productDao.getByCategory(category));
			});*/


			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
}


