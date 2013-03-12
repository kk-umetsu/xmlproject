package xmlproject.app;

import java.util.List;

import xmlproject.bean.ImageData;
import xmlproject.util.XMLInput;

public class XMLInputApp {

	public static void main(String[] args) {
		XMLInput xmlInput = new XMLInput();
		List<ImageData> imageDatas = xmlInput.input("/contents/xml/local_sample.xml");

		for (ImageData imageData : imageDatas) {
			System.out.println(imageData.getFilename());
		}
	}
}
