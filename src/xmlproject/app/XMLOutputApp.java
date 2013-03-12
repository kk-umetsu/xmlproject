package xmlproject.app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import xmlproject.bean.ImageData;
import xmlproject.util.XMLOutput;

public class XMLOutputApp {
	public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, TransformerException {

		List<ImageData> imageDatas = new ArrayList<ImageData>();
		for (int i = 0; i < 10; i++) {
			ImageData imageData = new ImageData();
			imageData.setFilename("C:/workspace/clickapp/WebContent/img/" + i + ".jpg");
			imageDatas.add(imageData);
		};

		XMLOutput xmlOutput = new XMLOutput();
		xmlOutput.output(imageDatas, "/contents/xml/xmloutput.xml");

	}
}
