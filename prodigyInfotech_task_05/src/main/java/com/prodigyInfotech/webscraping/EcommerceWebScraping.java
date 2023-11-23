package com.prodigyInfotech.webscraping;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class EcommerceWebScraping {
	public static void main(String[] args) {
		
		String url = "https://www.ebay.com/itm/383791923777?_trkparms=pageci%3A1acddaf4-889f-11ee-86c8-06127f782077%7Cparentrq%3Af339efd318b0a57d15aa7476ffff7fc6%7Ciid%3A1";
		try {
			
			Document doc = Jsoup.connect(url).get();
			String title = doc.select(".x-item-title__mainTitle").text().toUpperCase();
			String price = doc.select(".x-price-primary").text();
			String rating = doc.select(".fdbk-seller-rating__details").text();
		
			FileWriter writer = new FileWriter("src/main/resources/data.csv");
			writer.append("Title : ").append(title).append("\n").append("Price : "+price).append("\n").append("Rating : "+rating).append("\n");
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
