package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();
		FileReader reader = null;

		reader = new FileReader(".\\resources\\employee.json");
		Object obj = jsonParser.parse(reader);

		JSONObject employeeObject = (JSONObject) obj;

		String fname = (String) employeeObject.get("firstname");
		String lname = (String) employeeObject.get("lastname");

		System.out.println("fname :" + fname);
		System.out.println("lname :" + lname);

		JSONArray addArray = (JSONArray) employeeObject.get("address");

//		JSONObject addressObject = (JSONObject) addArray.get(0);

		for (int i = 0; i < addArray.size(); i++) {

			JSONObject addressObject = (JSONObject) addArray.get(i);

			String street = (String) addressObject.get("street");
			String city = (String) addressObject.get("city");
			String state = (String) addressObject.get("state");

			System.out.print("street :" + street + ",");
			System.out.print("City :" + city + ",");
			System.out.println("state :" + state);
		}

	}

}
