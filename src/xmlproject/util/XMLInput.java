package xmlproject.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import xmlproject.bean.ImageData;

public class XMLInput {
	public List<ImageData> input(String filename) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return new ArrayList<ImageData>();
		}

		File f = new File(filename);
		Document doc;
		try {
			doc = builder.parse(f);
		} catch (SAXException e) {
			e.printStackTrace();
			return new ArrayList<ImageData>();
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<ImageData>();
		}

		Element root = doc.getDocumentElement();
		NodeList children = root.getChildNodes();
		List<ImageData> imageDatas = new ArrayList<ImageData>();

		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);

			if (child.getNodeName().equals("img")) {
				ImageData imageData = new ImageData();
				NamedNodeMap nodeMap = child.getAttributes();
				Node nodeAttribute = nodeMap.getNamedItem("src");
				imageData.setFilename(nodeAttribute.getNodeValue());
				imageDatas.add(imageData);
			}
		}
		return imageDatas;
	}
}
