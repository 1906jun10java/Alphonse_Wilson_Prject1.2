package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.bean.Car;

public interface CarDAO {
	public List<Car> getCar()
			throws SQLException;
	public Car getCarById(String id)
			throws SQLException;
	public Car getCarById(String id, Connection conn)
			throws SQLException;
	public int addCarToLot(Car car)
			throws SQLException;
	public void removeCarFromLot(Car car)
			throws SQLException;
}
