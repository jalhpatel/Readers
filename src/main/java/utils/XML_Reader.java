package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XML_Reader {

	private static final String xmlFile = "employee.xml";

	/**
	 * This will fetch an attribute value from a given xml.
	 */
	static String getXmlString(String filename, String attributeValue) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document doc = null;
		try {
			doc = builder != null ? builder.parse(new File(System.getProperty("user.dir") + "//resources//" + filename))
					: null;
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		NodeList list = doc != null ? doc.getElementsByTagName("string") : null;

//        logger.info("Total no of Strings : " + list.getLength()); //enable to get count when needed
		String requiredValue = null;
		if (list != null) {
			for (int i = 0; i < list.getLength(); i++) {
				Element node = (Element) list.item(i);
				if ((node.getAttribute("name")).equalsIgnoreCase(attributeValue)) {
					requiredValue = node.getTextContent();
				}
			}
		}
		return requiredValue;
	}

	/**
	 * Gets String value from strings.xml
	 *
	 * @param attributeValue
	 * @return
	 */

	public static String getStringName(String attributeValue) {
		return getXmlString(xmlFile, attributeValue);
	}

	/**
	 * Main Method.
	 */
	public static void main(String[] args) {

		String fname = getStringName("firstname");
		String lname = getStringName("lastname");
		String street = getStringName("street");
		String city = getStringName("city");
		String state = getStringName("state");

		System.out.println("fname :" + fname);
		System.out.println("lname :" + lname);
		System.out.print("street :" + street + ",");
		System.out.print("City :" + city + ",");
		System.out.println("state :" + state);

	}

}
