package com.pari.server;

import java.io.IOException;

import java.io.*;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.google.gson.Gson;
import com.pari.bikeshop.*;
import com.pari.bikeshop.dao.*;
import com.pari.bikeshop.products.*;


public class BikeShopServer {
	
	public static void main(String[] args) {
		try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/api/products", new ProductHandler());  // API endpoint for products
            server.setExecutor(null);  // Default executor
            server.start();  // Start the server

            System.out.println("Server started at http://localhost:8080");
        } catch (IOException e) {
            System.err.println("Error starting the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
	// Handler for /api/products endpoint (generalized for all product types)
    static class ProductHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Handle GET request to fetch all products (any type)
            if ("GET".equals(exchange.getRequestMethod())) {
                // Get a connection to the database
                Connection connection = null;
                try {
                    connection = DatabaseConnection.getConnection();  // Get connection to the DB
                    ProductDao productDao = new ProductDaoImpl(connection); // Using generic ProductDao
                    List<Product> products = productDao.getAll();  // Fetch all products from the database

                    // Convert the product list to JSON
                    Gson gson = new Gson();
                    String response = gson.toJson(products);

                    // Send the response to the client
                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, response.getBytes().length);  // 200 OK
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                    
                } catch (SQLException e) {
                    // If there was a database error, return a 500 Internal Server Error
                    String errorResponse = "Database error: " + e.getMessage();
                    exchange.getResponseHeaders().set("Content-Type", "text/plain");
                    exchange.sendResponseHeaders(500, errorResponse.getBytes().length);  // 500 Internal Server Error
                    OutputStream os = exchange.getResponseBody();
                    os.write(errorResponse.getBytes());
                    os.close();
                    e.printStackTrace();
                } catch (IOException e) {
                    // If there was an I/O error, return a 500 Internal Server Error
                    String errorResponse = "I/O error: " + e.getMessage();
                    exchange.getResponseHeaders().set("Content-Type", "text/plain");
                    exchange.sendResponseHeaders(500, errorResponse.getBytes().length);  // 500 Internal Server Error
                    OutputStream os = exchange.getResponseBody();
                    os.write(errorResponse.getBytes());
                    os.close();
                    e.printStackTrace();
                } finally {
                    // Always close the database connection in the finally block
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                // Handle unsupported HTTP methods (e.g., POST, PUT, DELETE, etc.)
                String errorResponse = "Unsupported HTTP method: " + exchange.getRequestMethod();
                exchange.getResponseHeaders().set("Content-Type", "text/plain");
                exchange.sendResponseHeaders(405, errorResponse.getBytes().length);  // 405 Method Not Allowed
                OutputStream os = exchange.getResponseBody();
                os.write(errorResponse.getBytes());
                os.close();
            }
        }
    }
}
