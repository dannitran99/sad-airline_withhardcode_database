package com.airplanebooking.ticket.booking.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.airplanebooking.ticket.booking.entity.Booking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}
  
	@RequestMapping("/tickets/{plane}")
	public Booking getGallery(@PathVariable String plane) {
		// create gallery object
		Booking gallery = new Booking();
		JSONArray kk = new JSONArray();
		String[] hang = plane.split(",");
		for (int i = 0; i < hang.length; i++) {
			String result = restTemplate.getForObject("http://"+hang[i]+"-gateway/"+hang[i]+"/tickets", String.class);
			try {
				//chuyen doi du lieu server
				Object obj = new JSONParser().parse(result);
				JSONObject ob = (JSONObject) obj;
				JSONArray arr = (JSONArray) ob.get("tickets");
				JSONObject newOb = new JSONObject();
				newOb.put(hang[i], arr);		
				kk.add(newOb);			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				continue;
			}			
		}
		gallery.setTickets((List<Object>) kk);
		return gallery;
	}
		
	
	@RequestMapping("/{plane}/{ngaydi}/{ngayve}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getGallery(@PathVariable String plane, @PathVariable String ngaydi, @PathVariable String ngayve, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe ) {
		
		Booking gallery = new Booking();
		JSONArray kk = new JSONArray();
		String[] hang = plane.split(",");
		for (int i = 0; i < hang.length; i++) {
			String result = restTemplate.getForObject("http://"+hang[i]+"-gateway/"+hang[i]+"/"+ngaydi+"/"+ngayve+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
			try {
				//chuyen doi du lieu server
				Object obj = new JSONParser().parse(result);
				JSONObject ob = (JSONObject) obj;
				JSONArray arr = (JSONArray) ob.get("tickets");
				JSONObject newOb = new JSONObject();
				newOb.put(hang[i], arr);		
				kk.add(newOb);			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				continue;
			}			
		}
		gallery.setTickets((List<Object>) kk);
		return gallery;
		
	}
	@RequestMapping("/{plane}/{ngaydi}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getGallery(@PathVariable String plane, @PathVariable String ngaydi, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe ) {
		
		Booking gallery = new Booking();
		JSONArray kk = new JSONArray();
		String[] hang = plane.split(",");
		for (int i = 0; i < hang.length; i++) {
			String result = restTemplate.getForObject("http://"+hang[i]+"-gateway/"+hang[i]+"/"+ngaydi+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
			try {
				//chuyen doi du lieu server
				Object obj = new JSONParser().parse(result);
				JSONObject ob = (JSONObject) obj;
				JSONArray arr = (JSONArray) ob.get("tickets");
				JSONObject newOb = new JSONObject();
				newOb.put(hang[i], arr);		
				kk.add(newOb);			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				continue;
			}			
		}
		gallery.setTickets((List<Object>) kk);
		return gallery;
		
	}
	
	
}