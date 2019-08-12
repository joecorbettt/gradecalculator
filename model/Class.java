package model;

import java.util.ArrayList;
import java.util.List;

public class Class {

	//Instance Variables
	String className = "";
	List<Section> sections;
	double totalGrade = 0;

	public Class(String name) {
		className = name;
		sections = new ArrayList<Section>();
	}

	public void addSection(String name, double percent) {
		sections.add(new Section(name, percent));
	}
	
	public void addSection(Section section) {
		sections.add(section);
	}

	public double getTotalGrade() {
		return totalGrade;
	}
	
	public List<Section> getSections() {
		return sections;
	}
	
	//public Section getSection(String sectionName) {
//		for (Section tempSect: sections) {
//			if(tempSect.name.toLowerCase().equals(sectionName.toLowerCase())) {
//				return tempSect;
//			}
//		}
		// Add if not found then create new one if not at 100%
		
	//}

	public void calculateTotalGrade() {
		double totalPercent = 100;
		double percentScored = 0;
		for (Section tempSect : sections) {
			if (tempSect.isEmpty()) {  	    //  ADD THIS WHEN ALL SECTIONS MUST BE ADDED
				totalPercent -= tempSect.getPercent();    // ADD WRITE AND READ FILES
				continue;                   //  ADD METHOD TO MAKE SURE SECTIONS ARE 100%
			}
			tempSect.calculate();
			percentScored += tempSect.getWeightedGrade();
		}
		double scale = Math.pow(10, 3);
		totalGrade = Math.round(scale * (percentScored / totalPercent)) / scale;
		totalGrade = totalGrade * 100;
	}

	public String toString() {
		calculateTotalGrade();
		String toReturn = className + " Statistics: \n";
		toReturn += "Current Grade: " + Double.toString(totalGrade) + "%\n\n";
		for (Section tempSect : sections) {
			toReturn += tempSect.toString() + "\n";
		}
		return toReturn;
	}
}
