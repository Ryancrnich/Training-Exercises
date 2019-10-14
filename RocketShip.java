/* *Create a new java project called: Dream
Establish a bean class called RocketShip with the fields, numOfRockets, color, model, and hasMiniFridge.
Also include 1 static and 1 instance code block.
In a Driver class, which should be in a different class, instantiate 5 RocketShips and then see if any of those objects match.
If none match, use the appropiate steps to change the fields for 1 object to match another.
Push this project to your branch on the batch repository. */

package com.revature.bean;

public class RocketShip {
	
	//Variables
	private int numOfRockets;
	private String color;
	private String model;
	public Boolean hasMiniFridge;

	
	public static void main(String[] args) {
		System.out.println("Prepare for Launch");
	}
	
	//
	public RocketShip(int numOfRockets, String color, String model, Boolean hasMiniFridge) {
		this.numOfRockets = numOfRockets;
		this.color = color;
		this.model = model;
		this.hasMiniFridge = hasMiniFridge;
	}

	//Getters and setters
	public int getNumOfRockets() {
		return numOfRockets;
	}

	public void setNumOfRockets(int numOfRockets) {
		this.numOfRockets = numOfRockets;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getHasMiniFridge() {
		return hasMiniFridge;
	}

	public void setHasMiniFridge(Boolean hasMiniFridge) {
		this.hasMiniFridge = hasMiniFridge;
	}
	
	//Prints out the Rocketship fields
	public String toString() {
		return numOfRockets + ", Color: " + color + ", Model: " + model + ", Mini Fridge: " + hasMiniFridge + "]";
	}
	
	
	//Creating a hashcode and comparing the objects
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((hasMiniFridge == null) ? 0 : hasMiniFridge.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + numOfRockets;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RocketShip other = (RocketShip) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (hasMiniFridge == null) {
			if (other.hasMiniFridge != null)
				return false;
		} else if (!hasMiniFridge.equals(other.hasMiniFridge))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (numOfRockets != other.numOfRockets)
			return false;
		return true;
	}
}
