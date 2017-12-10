/*
 * Alejandra Casanova
 * JoseA Melendez
 */

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
	 * @param levelOfPatience of the determined customer 
	 */
	public void setLevelOfPatience(int levelOfPatience) {
		this.levelOfPatience = levelOfPatience;
	}
	/**
	 * 
	 * @return ID of the dertermined customer
	 */
	public int getID() {
		return ID;
	}
	/**
	 * 
	 * @param iD set ID of the determined customer 
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * 
	 * @return timeToPrepare of the determined order
	 */
	public int getTimeToPrepare() {
		return timeToPrepare;
	}
	/**
	 * 
	 * @param set timeToPrepare of the determined customer
	 */
	public void setTimeToPrepare(int timeToPrepare) {
		this.timeToPrepare = timeToPrepare;
	}
	/**
	 * 
	 * @return costOfOrder of the determined customer
	 */
	public double getCostOfOrder() {
		return costOfOrder;
	}
	/**
	 * 
	 * @param set costOfOrder of the determined customer
	 */
	public void setCostOfOrder(double costOfOrder) {
		this.costOfOrder = costOfOrder;
	}
	/**
	 * 
	 * @return arrival time of the determined customer
	 */

	public int getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * 
	 * @param set arrivalTime of the determined customer
	 */
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * 
	 * @return patience time of the determined customer
	 */
	public int getPatienceOverTime() {
		return patienceOverTime;
	}

	/**
	 * 
	 * @param set patienceOverTime of the determined customer
	 */
	public void setPatienceOverTime(int patienceOverTime) {
		this.patienceOverTime = patienceOverTime;
	}
}
