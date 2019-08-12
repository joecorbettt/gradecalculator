package model;

import java.util.HashMap;

public class Section {
	// Instance Variables 
	String name;
	int totalAssignments = 0;
	double pointsEarned, pointsTotal, grade, weightedGrade = 0;
	double percent;
	HashMap<String, double[]> assignments = new HashMap<String, double[]>();

	public Section(String name, double percent) {
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public double getPercent() {
		return percent;
	}
	
	public double getWeightedGrade() {
		return weightedGrade;
	}

	public void calculate() {
		pointsEarned = 0;
		pointsTotal = 0;
		for (String assignment : assignments.keySet()) {
			double[] tempGrades = assignments.get(assignment);
			pointsEarned += tempGrades[0];
			pointsTotal += tempGrades[1];
		}
		grade = round(pointsEarned / pointsTotal) * 100;
		weightedGrade = round(grade * (percent / 100));
	}

	public void add(String name, double pointsScored, double pointsTotal) {
		totalAssignments++;
		assignments.put(name, new double[]{pointsScored, pointsTotal});
	}

	public boolean isEmpty() {
		return totalAssignments == 0;
	}

	public double round(double number) {
		double scale = Math.pow(10, 3);
		return Math.round(scale * number) / scale;
	}

	public String toString() {
		String toReturn = "";
		calculate();
		toReturn += (name.toUpperCase() + " Statistics: \n");
		toReturn += ("Overall Grade: " + Double.toString(grade) + "%\n");
		toReturn +=
				("Weighted Grade: " + Double.toString(weightedGrade) + "%\n");
		toReturn += ("Assignments: " + "\n");
		for (String assignment : assignments.keySet()) {
			double[] tempGrades = assignments.get(assignment);
			toReturn += (assignment + ": " + Double.toString(tempGrades[0])
					+ " out of " + Double.toString(tempGrades[1])
					+ " points\n");
		}
		return toReturn;
	}
}
