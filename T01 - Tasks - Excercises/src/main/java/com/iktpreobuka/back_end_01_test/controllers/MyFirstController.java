package com.iktpreobuka.back_end_01_test.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

	public static final int NUM = 25;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello, world!";
	}

	@GetMapping("/greetings")
	@ResponseBody
	public String greetings(@RequestParam String name) {
		return "Hello, " + name + "!";
	}

	@RequestMapping("/date")
	public String date() {
		return LocalDateTime.now().toString();
	}

	@RequestMapping("/family")
	public List<String> family() {

		// with a stream
		return Stream.of("John", "Peter", "Ivan").collect(Collectors.toList());

		// Without a stream
//		List<String> l = new LinkedList<String>();
//		
//		l.add("John");
//		l.add("Peter");
//		l.add("Ivan);
//		
//		return l;
	}

	public static String loadHTMLTemplate(String file, List<String> students) {

		//
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			// make a new line for reading and Stringbuilder to read
			String line;
			StringBuilder text = new StringBuilder();

			// Read through the file with the builder
			while ((line = br.readLine()) != null) {
				text.append(line);
				text.append("\n");
			}

			// create a new string builder list that will make the
			StringBuilder list = new StringBuilder();

			list.append("<ul>\n");
			for (String s : students) {
				list.append("<li>");
				list.append(s);
				list.append("</li>\n");
			}
			list.append("</ul>");

			return text.toString().replaceAll("%", list.toString());
		} catch (IOException e) {
			System.err.println("An error has occurred writing the file " + e.getMessage());
		}

		return null;
	}

	@RequestMapping("/myclass")
	public String myclass() {

		List<String> students = new LinkedList<String>();

		students.add("John");
		students.add("Dean");
		students.add("Mike");
		return loadHTMLTemplate("res/group.html", students);
	}

	@RequestMapping("/intarr")
	public int[] intArr() {

		int[] arr = new int[NUM];

		for (int i = 0; i < NUM; i++)
			arr[i] = (int) (Math.random() * 100);

		return arr;
	}

	@RequestMapping("/intarrsort")
	public int[] intArrSort() {
		int[] arr = new int[NUM];

		for (int i = 0; i < NUM; i++)
			arr[i] = (int) (Math.random() * 100);

		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		return arr;
	}

	@RequestMapping("/minmax")
	public long[] minMax() {

		long[] arr = new long[NUM];

		for (int i = 0; i < NUM; i++)
			arr[i] = (long) (Math.random() * 100);

		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
			if (arr[i] > max)
				max = arr[i];
		}

		return new long[] { min, max };
	}

	@RequestMapping("/sum")
	public int sum(@RequestParam String n) {

		int sum = 0;

		for (int i = 0; i <= Integer.parseInt(n.trim()); i++)
			sum += i;

		return sum;
	}

	@GetMapping("/dictionary")
	@ResponseBody
	public String dictionary(@RequestParam String word) {

		Map<String, String> dictionary = new HashMap<String, String>();

		dictionary.put("man", "bowl");
		dictionary.put("spider", "cat");

		return dictionary.containsKey(word) ? String.format("Word means: '%s' : %s %n", word, dictionary.get(word))
				: String.format("Word %s is not in the dictionary.", word);
	}
}
