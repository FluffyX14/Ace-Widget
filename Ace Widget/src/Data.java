public class Data {
	String name;
	double q1Sales;
	double q2Sales;
	double q3Sales;
	double q4Sales;
	double totalSales;
	
	//constructor
	public Data (String n, double q1, double q2, double q3, double q4) {
		name = n;
		q1Sales = q1;
		q2Sales = q2;
		q3Sales = q3;
		q4Sales = q4;
	}
	
	//getters
	public String getName() {
		return name;
	}
	public double getQ1Sales() {
		return q1Sales;
	}
	public double getQ2Sales() {
		return q2Sales;
	}
	public double getQ3Sales() {
		return q3Sales;
	}
	public double getQ4Sales() {
		return q4Sales;
	}
	public double getTotalSales() {
		return totalSales;
	}
	
	//calculates highest quarter sale
	public double highestQSale (double q1, double q2, double q3, double q4) {
		double firstHalf;
		double secondHalf;
		if (Math.max(q1, q2) == q1 ) {
			firstHalf = q1;
		}
		else {
			firstHalf = q2;
		}
		if (Math.max(q3, q4) == q3 ) {
			secondHalf = q3;
		}
		else {
			secondHalf = q4;
		}
		return Math.max(firstHalf, secondHalf);
	}
	
	//calculates lowest quarter sale
		public double lowestQSale (double q1, double q2, double q3, double q4) {
			double firstHalf;
			double secondHalf;
			if (Math.min(q1, q2) == q1 ) {
				firstHalf = q1;
			}
			else {
				firstHalf = q2;
			}
			if (Math.min(q3, q4) == q3 ) {
				secondHalf = q3;
			}
			else {
				secondHalf = q4;
			}
			return Math.min(firstHalf, secondHalf);
		}
}
