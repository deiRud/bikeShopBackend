package com.pari.bikeshop.dao;
import java.util.List;

import com.pari.bikeshop.products.Wheelset;

public interface WheelsetDao {
	void add(Wheelset wheelset);
	Wheelset getById(int id);
	List<Wheelset> getAll();
	void update(Wheelset wheelset);
	void delete(int id);
}
