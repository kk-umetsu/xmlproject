package xmlproject.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.serializer.OutputPropertiesFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xmlproject.bean.ImageData;

/**
 *
 * @author umetsu
 *
 */
public class XMLOutput {

	/**
	 * {@link ImageData} から画像のパスを取り出して, 指定されたへxmlファイルを出力します.
	 * @param imageDatas
	 * @param outputPath 出力するファイルの名前
	 * @return 成功した場合 0
	 *         失敗した場合 -1
	 */
	public int output(List<ImageData> imageDatas, String outputPath) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return -1;
		}

		/* ---------- ここから出力内容 ----------- */

		Document document = builder.newDocument();

		Element root = document.createElement("sample");
		document.appendChild(root);

		for (ImageData imageData : imageDatas) {
			Element elementChild = document.createElement("img");
			elementChild.setAttribute("src", imageData.getFilename());
			root.appendChild(elementChild);
		}

		/* ---------- ここまで出力内容 ----------- */

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return -1;
		}

		// インデントの設定
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT,"4");

		DOMSource source = new DOMSource(document);
		File newXML = new File(outputPath);
		FileOutputStream os;
		try {
			os = new FileOutputStream(newXML);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		StreamResult result = new StreamResult(os);
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
			return -1;
		}

		return 0;
	}
}
