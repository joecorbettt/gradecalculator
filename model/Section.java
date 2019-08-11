import java.util.HashMap;

public class Section {
	
	// Instance Variables 
	String name;
	int totalAssignments, double totalSum, grade = 0;
	double percent;
	HashMap<String, Double> assignments = new HashMap<String, Double>();
	
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
	
	public void calculate() {
		totalAssignments = assignments.keySet().size();
		for (String assignment: assignments.keySet()) {
			double tempGrade = assignments.get(assignment);
			totalSum += tempGrade;
		}
		grade = round(totalSum / totalAssignments);	
	}
	
	public void add(String name, double percent) {
		assignments.put(name, percent);
	}
	
	public boolean isEmpty() {
		return assignments.keySet().size() == 0;
	}
	
	private double round(double number) {
		double scale = Math.pow(10, 2);
		return Math.round(scale * number)/ scale;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		calculate();
		sb.append(name.toUpperCase() + " Statistics: \n\n");
		sb.append("Section Grade: " + Double.toString(grade) + "\n\n");
		sb.append("Assignments: " + "\n");
		for (String assignment: assignments.keySet()) {
			double tempGrade = round(assignments.get(assignment));
			sb.append(assignment + " " + Double.toString(tempGrade) + "\n");
		}
		
	}
	
}
