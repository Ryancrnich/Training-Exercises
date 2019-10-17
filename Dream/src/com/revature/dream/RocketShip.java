package com.revature.dream;


	public class RocketShip {

		int numOfRockets;

		String color;

		String model;

		boolean hasMiniFridge;

		static {System.out.println("Static code Block ");}

		{System.out.println("Detecting  Same Rockets ");}

		public RocketShip(int numOfRockets, String color, String model, boolean hasMiniFridge) {

			super();

			this.numOfRockets = numOfRockets;

			this.color = color;

			this.model = model;

			this.hasMiniFridge = hasMiniFridge;

		}



		@Override

		public String toString() {

			return "RocketShip [numOfRockets=" + numOfRockets + ", color=" + color + ", model=" + model + ", hasMiniFridge="

					+ hasMiniFridge + "]";

		}

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

		public boolean isHasMiniFridge() {

			return hasMiniFridge;

		}

		public void setHasMiniFridge(boolean hasMiniFridge) {

			this.hasMiniFridge = hasMiniFridge;

		}

		@Override

		public int hashCode() {

			final int prime = 31;

			int result = 1;

			result = prime * result + ((color == null) ? 0 : color.hashCode());

			result = prime * result + (hasMiniFridge ? 1231 : 1237);

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

			if (hasMiniFridge != other.hasMiniFridge)

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

		

	