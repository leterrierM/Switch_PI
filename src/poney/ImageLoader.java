package poney;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

public class ImageLoader {
	
	private List<ImageIcon> imagesList;
	private List<String> pathsList;
	
	private String canonicalPath = "";
	
	private int height = 150;
	private int width = 150;

	public ImageLoader() {
		imagesList = new ArrayList<ImageIcon>();
				
		try {
			canonicalPath = new File(".").getCanonicalPath();
		} catch (IOException e) {
			System.out.println("Error in path, can't load images!!");
			e.printStackTrace();
		}
		
		pathsList = Arrays.asList(canonicalPath + "/cyan.png", canonicalPath + "/green.png", canonicalPath + "/pink.png");
		
		
		for(String path : pathsList){
			imagesList.add( resize(new ImageIcon(path), width, height) );
		}

	}
	
	private ImageIcon resize(ImageIcon imgToResize, int width, int height) {
		return new ImageIcon(imgToResize.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<ImageIcon> getImagesList() {
		return imagesList;
	}

	public String getCanonicalPath() {
		return canonicalPath;
	}
	
	public ImageIcon getImageIndex(int index) {
		return imagesList.get(index);
	}
	
	public int getLength(int total, int size, int space){
		return total / (size + space);
	}
	
	public int getHeightIndex(int index, int total, int size, int space){
		return (int)(index / getLength(total, size, space));
	}

	public int getWidthIndex(int index, int total, int size, int space){		
		return (int)(index % getLength(total, size, space));	
	}

}
