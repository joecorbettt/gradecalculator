package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Section;

public class SectionTests {
	
	@Test
	public void testisEmpty() {
		Section test = new Section("Tests", 40);
		assertTrue(test.isEmpty());
		test.add("Midterm 1", 192, 200);
		test.add("Homework 2", 189, 200);
		assertFalse(test.isEmpty());
		System.out.println(test.toString());
	}
	
	
}
