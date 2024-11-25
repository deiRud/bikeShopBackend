package com.pari.bikeshop.dao;
import java.util.List;
import com.pari.bikeshop.products.Bike;


public interface BikeDao {
	void add(Bike bike);
	Bike getById(int id);
	List<Bike> getAll();
	void update(Bike bike);
	void delete(int id);
}
