import javax.swing.*;
import java.text.DecimalFormat;
import BreezySwing.*;
public class Gui extends GBFrame {
	JLabel nameLabel = addLabel				("Name:", 1, 1, 1, 1);
	JTextField nameInput = addTextField										("", 1, 2, 1, 1);
	JLabel q1Label = addLabel				("Quarter 1 Sales:", 2, 1, 1, 1);
	DoubleField q1Input = addDoubleField									(0, 2, 2, 1, 1);
	JLabel q2Label = addLabel				("Quarter 2 Sales:", 3, 1, 1, 1);
	DoubleField q2Input = addDoubleField									(0, 3, 2, 1, 1);
	JLabel q3Label = addLabel				("Quarter 3 Sales:", 4, 1, 1, 1);
	DoubleField q3Input = addDoubleField									(0, 4, 2, 1, 1);
	JLabel q4Label = addLabel				("Quarter 4 Sales:", 5, 1, 1, 1);
	DoubleField q4Input = addDoubleField									(0, 5, 2, 1, 1);
	JButton enter = addButton("Enter", 6, 1, 1, 1);
	JButton viewData = addButton("Show data", 6, 2, 1, 1);
	Data[] empObj = new Data[10];
	int employeeCounter = 0;
	DecimalFormat dc = new DecimalFormat("0.00");
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enter) {
			if (q1Input.isValidNumber() == false) {
				messageBox("Invalid input for quarterly sales");
			}
			else if (q2Input.isValidNumber() == false) {
				messageBox("Invalid input for quarterly sales");
			}
			else if (q3Input.isValidNumber() == false) {
				messageBox("Invalid input for quarterly sales");
			}
			else if (q4Input.isValidNumber() == false) {
				messageBox("Invalid input for quarterly sales");
			}
			if (nameInput.getText().isBlank()) {
				messageBox("Name cannot be blank");
			}
			else {
				empObj[employeeCounter] = new Data(nameInput.getText(), q1Input.getNumber(), q2Input.getNumber(), q3Input.getNumber(), q4Input.getNumber());
				employeeCounter++;
				nameInput.setText("");
				q1Input.setText("0.0");
				q2Input.setText("0.0");
				q3Input.setText("0.0");
				q4Input.setText("0.0");
			}
			
		}
		if (buttonObj == viewData) {
			
			nameLabel.setVisible(false);
			nameInput.setVisible(false);
			q1Label.setVisible(false);
			q1Input.setVisible(false);
			q2Label.setVisible(false);
			q2Input.setVisible(false);
			q3Label.setVisible(false);
			q3Input.setVisible(false);
			q4Label.setVisible(false);
			q4Input.setVisible(false);
			enter.setVisible(false);
			viewData.setVisible(false);
			
			
			//outputs new GUI
			nameLabel.setVisible(true);
			q1Label.setVisible(true);
			q2Label.setVisible(true);
			q3Label.setVisible(true);
			q4Label.setVisible(true);
			
			//outputs names
			for (int i = 0; i < employeeCounter; i++) {
				JLabel nameOutput = addLabel (empObj[i].getName(), 1, i+4, 1, 1);
			}
			//outputs q1 sales
			for (int i = 0; i < employeeCounter; i++) {
				JLabel q1Output = addLabel ("$" + dc.format(empObj[i].getQ1Sales()), 2, i+4, 1, 1);
			}
			//outputs q2 sales
			for (int i = 0; i < employeeCounter; i++) {
				JLabel q2Output = addLabel ("$" + dc.format(empObj[i].getQ2Sales()), 3, i+4, 1, 1);
			}
			//outputs q3 sales
			for (int i = 0; i < employeeCounter; i++) {
				JLabel q3Output = addLabel ("$" + dc.format(empObj[i].getQ3Sales()), 4, i+4, 1, 1);
			}
			//outputs q4 sales
			for (int i = 0; i < employeeCounter; i++) {
				JLabel q4Output = addLabel ("$" + dc.format(empObj[i].getQ4Sales()), 5, i+4, 1, 1);
			}
			
			//outputs highest quarter sale info
			double highestSale = 0;
			String highestName = "";
			for (int i = 0; i < employeeCounter; i++) {
				if (highestSale < empObj[i].highestQSale(empObj[i].getQ1Sales(), empObj[i].getQ2Sales(), empObj[i].getQ3Sales(), empObj[i].getQ4Sales())) {
					highestSale = empObj[i].highestQSale(empObj[i].getQ1Sales(), empObj[i].getQ2Sales(), empObj[i].getQ3Sales(), empObj[i].getQ4Sales());
				}
			}
			for (int i = 0; i < employeeCounter; i++) {
				if (empObj[i].getQ1Sales() > highestSale) {
					highestName = empObj[i].getName();
				}
				if (empObj[i].getQ2Sales() > highestSale) {
					highestName = empObj[i].getName();
				}
				if (empObj[i].getQ3Sales() > highestSale) {
					highestName = empObj[i].getName();
				}
				if (empObj[i].getQ4Sales() > highestSale) {
					highestName = empObj[i].getName();
				}
			}
			JLabel highestSaleLabel = addLabel ("Employee with highest quarters sales: " + highestName, 12, 1, 1, 1);
			
			//outputs lowest quarter sale info
			double lowestSale = 999999999;
			String lowestName = "";
			for (int i = 0; i < employeeCounter; i++) {
				if (lowestSale > empObj[i].lowestQSale(empObj[i].getQ1Sales(), empObj[i].getQ2Sales(), empObj[i].getQ3Sales(), empObj[i].getQ4Sales())) {
					lowestSale = empObj[i].lowestQSale(empObj[i].getQ1Sales(), empObj[i].getQ2Sales(), empObj[i].getQ3Sales(), empObj[i].getQ4Sales());
				}
			}
			for (int i = 0; i < employeeCounter; i++) {
				if (empObj[i].getQ1Sales() < lowestSale) {
					lowestName = empObj[i].getName();
				}
				else if (empObj[i].getQ2Sales() < highestSale) {
					lowestName = empObj[i].getName();
				}
				else if (empObj[i].getQ3Sales() < highestSale) {
					lowestName = empObj[i].getName();
				}
				else if (empObj[i].getQ4Sales() < highestSale) {
					lowestName = empObj[i].getName();
				}
			}
			JLabel lowestSaleLabel = addLabel ("Employee with lowest quarters sales: " + lowestName, 13, 1, 1, 1);
		}
	}
			
	//outputs GUI
	public static void main(String[] args) {
		JFrame frm = new Gui();
		frm.setTitle("Ace Widget");
		frm.setSize(1000, 500);
		frm.setVisible(true);
	}
}
