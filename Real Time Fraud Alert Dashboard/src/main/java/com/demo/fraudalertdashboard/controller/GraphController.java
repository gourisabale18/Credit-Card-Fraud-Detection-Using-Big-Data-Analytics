package com.demo.fraudalertdashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class GraphController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
			public String getHomePage()
		{
			return "home";
		}

	/*@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		surveyMap.put("Java", 40);
		surveyMap.put("Dev oops", 25);
		surveyMap.put("Python", 20);
		surveyMap.put(".Net", 15);
		model.addAttribute("surveyMap", surveyMap);
		return "barGraph";
	}

	@GetMapping("/lineGraph")
	public String LineGraph(Model model) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/templates/avg_fraud_percentage_by_month.csv"));
		String line =  null;
		HashMap<String,Double> map = new LinkedHashMap<>();
		while((line=br.readLine())!=null){
			String str[] = line.split(",");
			map.put(str[0], Double.parseDouble(str[1]));
		}
		model.addAttribute("lMap", map);
		return "lineGraph";
	}

	@GetMapping("/displayHorizontalBarGraph")
	public String horizontalBarGraph(Model model) throws IOException {
	//	Map<String, Integer> surveyMap = new LinkedHashMap<>();
	//	surveyMap.put("Java", 40);
	//	surveyMap.put("Dev oops", 25);
	//	surveyMap.put("Python", 20);
	//	surveyMap.put(".Net", 15);
	//	model.addAttribute("surveyMap", surveyMap);
		BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/templates/data.csv"));
		String line =  null;
		HashMap<String,Integer> map = new LinkedHashMap<>();
		while((line=br.readLine())!=null){
			String str[] = line.split(",");
				map.put(str[0], Integer.parseInt(str[1]));
		}
		model.addAttribute("sMap", map);
		return "bar1Graph";
	}

	@GetMapping("/displayPieChart")
	public String pieChart(Model model) {
		model.addAttribute("pass", 50);
		model.addAttribute("fail", 50);
		return "pieChart";
	}
*/
}
