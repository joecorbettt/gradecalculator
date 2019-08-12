package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Section;
import model.Class;

public class ClassTests {
	
	@Test
	public void testClass() {
		Class testClass = new Class("CSc 210");
		Section tests = new Section("Tests", 40);
		tests.add("Midterm 1", 192, 200);
		tests.add("Midterm 2", 189, 200);
		Section assignments = new Section("Assignments", 60);
		assignments.add("Total Assignments", 55.1, 60);
		testClass.addSection(tests);
		testClass.addSection(assignments);
		System.out.println(testClass.toString());
	}
}
