package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tools.ArrayIndexList;



public class Customer {
	private int arrivalTime;
	private int ID;
	private int timeToPrepare;
	private double costOfOrder;
	private int levelOfPatience;
	private ArrayIndexList<Customer> customers;
	private int INITCAP = 100;

	public Customer(int arr, int ID, int TTprep, double cost,int levelP ) {
		arrivalTime=arr;
		this.ID=ID;
		timeToPrepare=TTprep;
		costOfOrder=cost;
		levelOfPatience=levelP;
		customers = new ArrayIndexList<Customer>();
	}

	public int getLevelOfPatience() {
		return levelOfPatience;
	}
	public void setLevelOfPatience(int levelOfPatience) {
		this.levelOfPatience = levelOfPatience;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTimeToPrepare() {
		return timeToPrepare;
	}
	public void setTimeToPrepare(int timeToPrepare) {
		this.timeToPrepare = timeToPrepare;
	}
	public double getCostOfOrder() {
		return costOfOrder;
	}
	public void setCostOfOrder(double costOfOrder) {
		this.costOfOrder = costOfOrder;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
