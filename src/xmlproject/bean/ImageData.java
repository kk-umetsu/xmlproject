package xmlproject.bean;

import java.io.Serializable;

public class ImageData implements Serializable {
	private static final long serialVersionUID = -7152477017866687242L;

	private String username;
	private String filename;
	private String contentType;
	private byte[] picture;
	private String description;

	public ImageData(String username, String filename, String contentType, byte[] picture, String description) {
		this.username = username;
		this.filename = filename;
		this.contentType = contentType;
		this.picture = picture;
		this.description = description;
	}

	public ImageData(String username, String filename) {
		this.username = username;
		this.filename = filename;
	}

	public ImageData() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
