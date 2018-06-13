package day8;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {

	Map<Map.Entry<Integer, Integer>, Boolean> screen = new HashMap<Map.Entry<Integer, Integer>, Boolean>();
	int screenWidth, screenHeight;

	public Screen(int w, int h) {
		screenWidth = w;
		screenHeight = h;
	}

	public String print() {

		String output = "";
		for (int y = 0; y < screenHeight; y++) {
			if (y > 0) {
				output += "/";
			}
			for (int x = 0; x < screenWidth; x++) {

				Boolean pixelOn = screen.get(new AbstractMap.SimpleEntry<Integer, Integer>(x, y));

				if (pixelOn != null && pixelOn == true) {
					output += "#";
				} else {
					output += ".";
				}
			}
		}
		return output;
	}

	public void rect(Integer w, Integer h) {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				SimpleEntry<Integer, Integer> mapEntry = new AbstractMap.SimpleEntry<Integer, Integer>(x, y);
				screen.put(mapEntry, true);
			}
		}
	}

	public void rotateColumn(int columnIdx, int rotateCount) {

		List<Boolean> columnPixels = new ArrayList<Boolean>();
		for (int y = 0; y < screenHeight; y++) {
			columnPixels.add(screen.get(new AbstractMap.SimpleEntry<Integer, Integer>(columnIdx, y)));
		}

		for (int r = 0; r < rotateCount; r++) {
			columnPixels.add(0, columnPixels.get(columnPixels.size() - 1));
			columnPixels.remove(columnPixels.size() - 1);
		}

		for (int y = 0; y < screenHeight; y++) {
			SimpleEntry<Integer, Integer> mapEntry = new AbstractMap.SimpleEntry<Integer, Integer>(columnIdx, y);
			screen.put(mapEntry, columnPixels.get(y));
		}

	}

	public void rotateRow(int rowIdx, int rotateCount) {

		List<Boolean> rowPixels = new ArrayList<Boolean>();
		for (int x = 0; x < screenWidth; x++) {
			rowPixels.add(screen.get(new AbstractMap.SimpleEntry<Integer, Integer>(x, rowIdx)));
		}

		for (int r = 0; r < rotateCount; r++) {
			rowPixels.add(0, rowPixels.get(rowPixels.size() - 1));
			rowPixels.remove(rowPixels.size() - 1);
		}

		for (int x = 0; x < screenWidth; x++) {
			SimpleEntry<Integer, Integer> mapEntry = new AbstractMap.SimpleEntry<Integer, Integer>(x, rowIdx);
			screen.put(mapEntry, rowPixels.get(x));
		}
		
	}

	public Object numberOfpixelsOn() {
		
		int pixelsOnCount = 0;
		
		for (int y = 0; y < screenHeight; y++) {
			for (int x = 0; x < screenWidth; x++) {
				if (screen.get(new AbstractMap.SimpleEntry<Integer, Integer>(x, y))) {
					pixelsOnCount++;
				}
			}
			
		}
		
		return pixelsOnCount;
	}

}
