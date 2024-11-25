package com.pari.bikeshop.dao;
import java.util.List;

import com.pari.bikeshop.products.Product;
public interface ProductDao {
    
	void add(Product product);
    Product getById(int id);
    List<Product> getAll();
    void update(Product product);
    void delete(int id);
    
	/*private Connection connection;
	
	
	public ProductDao(Connection connection2) throws SQLException {
	this.connection = connection2;
	}
	
	//Create
	public void addProduct(Product product) throws SQLException {
		String query = "insert into product (product_id, name_model, company, price, amount, description, weight, type) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getNameModel());
			preparedStatement.setString(3, product.getCompany());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, product.getAmount());
			preparedStatement.setString(6, product.getDescription());
			preparedStatement.setDouble(7, product.getWeight());
			preparedStatement.setString(8, product.getClass().getSimpleName());
			//preparedStatement.executeUpdate();	
		}
	}
	
	//Read
	public Product getProduct(int productId) throws SQLException {
		String query = "select * from product where product_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, productId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return createProductFromResultSet(rs);
			}
		}
		return null;
	}
	

	//Read all products
	public List<Product> getAllProducts() throws SQLException {
		List<Product> product = new ArrayList<>();
		String query = "select * from product";
		try (Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query)){
			while (rs.next()) {
				product.add(createProductFromResultSet(rs));
			}
		}
		return product;
	}
	
	//Update
	public void updateProduct(Product product) throws SQLException {
		String query = "update product set product_id = ?, name_model = ?, company = ?, price = ?, amount = ?, description = ?, weight =?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getNameModel());
			preparedStatement.setString(3, product.getCompany());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, product.getAmount());
			preparedStatement.setString(6, product.getDescription());
			preparedStatement.setDouble(7, product.getWeight());
			preparedStatement.executeUpdate();	
		}
	}
	
	//Delete
	public void deleteProduct(int productId) throws SQLException {
		String query = "delete from product where product_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();		
		}
	}
	
	//Creating a product from a resultSet
	private Product createProductFromResultSet(ResultSet rs) throws SQLException {
		int productId = rs.getInt("product_id");
		String nameModel = rs.getString("name_model");
		String company = rs.getString("company");
		double price = rs.getDouble("price");
		int amount = rs.getInt("amount");
		String description = rs.getString("description");
		double weight = rs.getDouble("weight");
		String type = rs.getString("type");
		
		/*switch (type) {
		case "Brake":
			return new Brake(brakeId, nameModel, company, price, amount, description, weight, rs.getString("brake_type"));
		case "Frame":
			return new Frame(frameId, nameModel, company, price, amount, description, weight, rs.getString("material"));
		case "Wheelset":
			return new Wheelset(wheelsetId, nameModel, company, price, amount, description, weight, rs.getString("tires_type"));
		case "Drivetrain":
			return new Drivetrain(drivetrainId, nameModel, company, price, amount, description, weight, rs.getInt("amount_of_gears"));
	
		}*/
		//return null;
		
	//}
}
