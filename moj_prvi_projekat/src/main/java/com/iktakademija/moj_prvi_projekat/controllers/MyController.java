package com.iktakademija.moj_prvi_projekat.controllers;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello world!";
		
	}

	@RequestMapping("/greetings")
	public String greetings() {
		return "Hello rado";
	}

	@RequestMapping("/getdate")
	public String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	@RequestMapping("/getFamilyMembers")
	public List<String> getFamilyMembers()
	{
		List<String> familyMembers = new ArrayList<>();
		familyMembers.add("Rado");
		familyMembers.add("Kati");
		
		return familyMembers;
	}
	
	@RequestMapping("/array")
	public int[] returnArray()
	{
		int[] myArray = {1,2,3,4,5};
		return myArray;
		
	}
	
}
