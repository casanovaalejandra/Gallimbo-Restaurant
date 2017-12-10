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
	private int patienceOverTime = levelOfPatience + arrivalTime;

	/**
	 * Creates an Customer object that will have the following properties for each customer
	 * @param arr arrival time of the customer
	 * @param ID unique identification number of the customer
	 * @param TTprep time required to prepare order
	 * @param cost cost of the order
	 * @param levelP number of unit times the customer will wait until it is attended
	 */
	public Customer(int arr, int ID, int TTprep, double cost,int levelP ) {
		arrivalTime=arr;
		this.ID=ID;
		timeToPrepare=TTprep;
		costOfOrder=cost;
		levelOfPatience=levelP;
	}
/**
 * 
 * @return the level of patience of the determined customer
 */
	public int getLevelOfPatience() {
		return levelOfPatience;
	}
	/**
	 * 
	 * @param levelOfPatience
	 */
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

	public int getPatienceOverTime() {
		return patienceOverTime;
	}

	public void setPatienceOverTime(int patienceOverTime) {
		this.patienceOverTime = patienceOverTime;
	}
}
