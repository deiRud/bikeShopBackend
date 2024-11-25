package com.pari.bikeshop.dao;
import java.util.List;
import com.pari.bikeshop.products.Drivetrain;

public interface DrivetrainDao {
	
	void add (Drivetrain drivetrain);
	Drivetrain getById(int id);
	List<Drivetrain> getAll();
	void update(Drivetrain drivetrain);
	void delete(int id);
	
}
