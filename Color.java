/**
 * Represents RGB colors.
 * RGB values are stored in a 3-position array, with values in the interval [0, 255].
 * rgb[0] - Red
 * rgb[1] - Green
 * rgb[2] - Blue
 */
class Color {
	
	static final Color WHITE = new Color(255, 255, 255);
	static final Color BLACK = new Color(0, 0, 0);
	static final Color RED = new Color(255, 0, 0);
	static final Color GREEN = new Color(0, 255, 0);
	static final Color BLUE = new Color(0, 0, 255);
	static final Color LIGHTGREEN = new Color(0, 128, 0);

	private final int[] rgb; // @color

	/**
	 * Creates an RGB color. Provided values have to 
	 * be in the interval [0, 255]
	 */
	Color(int r, int g, int b) {
		if(!valid(r) || !valid(g) || !valid(b))
			throw new IllegalArgumentException("invalid RGB values: " + r + ", " + g + ", " + b);
		
		this.rgb = new int[] {r, g, b};
	}
	
	void invert(){
		this.rgb[0] = 255 - this.getR();
		this.rgb[1] = 255 - this.getG();
		this.rgb[2] = 255 - this.getB();
	}
	
	void adjustBrightness(int val){
		 this.rgb[0] = Math.max(Math.min(this.getR() + val, 255), 0);
		 this.rgb[1] = Math.max(Math.min(this.getG() + val, 255), 0);
		 this.rgb[2] = Math.max(Math.min(this.getB() + val, 255), 0);
	}
	
	Color setGrey(){
		int val = (int)(getR() * 0.3 + getG() * 0.59 + getB() * 0.11);
		rgb[0] = val;
		rgb[1] = val;
		rgb[2] = val;
		return this;
	}
	
	boolean isSameColor(Color color){
		if (color == null)
			return false;
		return(rgb[0] == color.rgb[0]
				&& rgb[1] == color.rgb[1]
				&& rgb[2] == color.rgb[2]);
	}
	/**
	 * Red value [0, 255]
	 */
	int getR() {
		return rgb[0];
	}

	/**
	 * Green value [0, 255]
	 */
	int getG() {
		return rgb[1];
	}

	/**
	 * Blue value [0, 255]
	 */
	int getB() {
		return rgb[2];
	}

	/**
	 * Obtains the luminance in the interval [0, 255].
	 */
	int getLuminance() {
		return (int) Math.round(rgb[0]*.21 + rgb[1]*.71 + rgb[2]*.08);
	}

	static boolean valid(int value) {
		return value >= 0 && value <= 255;
	}

}
