/**
 * Represents color images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - pixel color is encoded as integers (ARGB)
 */
class ColorImage {

	private int[][] data; // @colorimage

	ColorImage(String file) {
		this.data = ImageUtil.readColorImage(file);
	}

	ColorImage(int width, int height) {
		data = new int[height][width];
	}

	int getWidth() {
		return data[0].length;
	}

	int getHeight() {
		return data.length;
	}

	void setColor(int x, int y, Color c) {
		data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
	}

	Color getColor(int x, int y) {
		int[] rgb = ImageUtil.decodeRgb(data[y][x]);
		return new Color(rgb[0], rgb[1], rgb[2]);
	}
	
	void invertColor(){
		for (int i = 0; i < getHeight(); i++)
			for (int j = 0; j < getWidth(); j++)
				setColor(j, i, getColor(j, i).invert());
	}
	
	void adjustBrightness(int val){
		for (int i = 0; i < getHeight(); i++)
			for (int j = 0; j < getWidth(); j++)
				setColor(j, i, getColor(j, i).changeBrightness(val));
	}
	
	void reflectImage(){//REMOVE?
		for (int i = 0; i < getHeight(); i++)
			for (int j = 0; j < getWidth() / 2; j++){
				Color tmp = getColor(j, i);
				setColor(j, i, getColor(getWidth() - j - 1, i));
				setColor(getWidth() - j - 1, i, tmp);
			}
	}
/*Considerar remover as funcoes abaixo*/
	ColorImage blackAndWhite(){//REMOVE?
		ColorImage res = new ColorImage(getWidth(), getHeight());
		for (int y = 0; y < getHeight(); y++)
			for (int x = 0; x < getWidth(); x++){
				if (getColor(x, y).getLuminance() < 128)
					res.setColor(x, y, Color.BLACK);
				else
					res.setColor(x, y, Color.WHITE);
			}
		return res;
	}
	
	ColorImage copyImage(){//REMOVE?
		ColorImage res = new ColorImage(getWidth(), getHeight());
		for (int i = 0; i < getHeight(); i++)
			for (int j = 0; j < getWidth(); j++)
					res.setColor(j, i, getColor(j, i));
		return res;
	}
	/*ainda nao esta blindada para valores invalidos de x e y*/
	ColorImage selection(int start_x, int start_y, int end_x, int end_y){//REMOVE?
		ColorImage res = new ColorImage(end_x - start_x, end_y - start_y);
		for (int i = start_y; i < end_y; i++)
			for (int j = start_x; j < end_x; j++)
					res.setColor(j - start_x, i - start_y, this.getColor(j, i));
		return res;
	}
	
	
}