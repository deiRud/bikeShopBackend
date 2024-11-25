package com.pari.bikeshop.dao;
import java.util.List;
import com.pari.bikeshop.products.Frame;

public interface FrameDao {
	
	void add(Frame frame);
    Frame getById(int id);
    List<Frame> getAll();
    void update(Frame frame);
    void delete(int id);

}
