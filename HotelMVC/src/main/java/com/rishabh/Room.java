package com.rishabh;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

	@Id
	private Long roomNumber;
	private String bedType;
	private char smoking;
	private double roomRate;
	private String occupantName = "Not Occupied";
	private boolean occupied = false;

	public Room() {

	}

	public Room(Long roomNumber, String bedType, char smoking, double roomRate, String occupantName) {
		this.roomNumber = roomNumber;
		this.bedType = bedType;
		this.smoking = smoking;
		this.roomRate = roomRate;
		this.occupantName = occupantName;
	}

	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public void setSmoking(char smoking) {
		this.smoking = smoking;
	}

	public void setRoomRate(double roomRate) {
		this.roomRate = roomRate;
	}

	public void setOccupantName(String occupantName) {
		this.occupantName = occupantName;
	}

	public Long getRoomNumber() {
		return roomNumber;
	}

	public String getBedType() {
		return bedType;
	}

	public char getSmoking() {
		return smoking;
	}

	public double getRoomRate() {
		return roomRate;
	}

	public String getOccupantName() {
		return occupantName;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	@Override
	public String toString() {
		return "\n Details for Room: " + roomNumber + "\n Name Of Guest: " + occupantName + "\n Bed Type: " + bedType
				+ "\n Smoking: " + smoking + "\n Rate: " + roomRate;
	}

}
