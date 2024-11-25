package com.pari.bikeshop.dao;
import java.util.List;

import com.pari.bikeshop.products.Brake;

public interface BrakeDao {
	
	void add(Brake brake);
    Brake getById(int id);
    List<Brake> getAll();
    void update(Brake brake);
    void delete(int id);
   
}
