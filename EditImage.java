class EditImage {
	
	static void copyImage(int xp, int yp, ColorImage res, ColorImage img){
		for (int y = yp; y < img.getHeight() + yp && y < res.getHeight(); y++)
			for (int x = xp; x < img.getWidth() + xp && x < res.getWidth(); x++)
				if (!img.getColor(x - xp, y - yp).isSameColor(Color.WHITE))
					res.setColor(x, y, img.getColor(x - xp, y - yp));
	}
	
	static void fillImage(ColorImage img, ColorImage pat){
		for (int y = 0; y < img.getWidth(); y += pat.getHeight())
			for (int x = 0; x < img.getWidth(); x += pat.getWidth())
				copyImage(x, y, img, pat);
		
	}
	
	static ColorImage copyGrey(ColorImage img){
		ColorImage res = new ColorImage(img.getWidth(), img.getHeight());
		for (int y = 0; y < res.getHeight(); y++)
			for (int x = 0; x < res.getWidth(); x++)
				res.setColor(x, y, img.getColor(x, y).setGrey());
		return res;
	}
	
	static ColorImage scale(ColorImage img, double factor){
		ColorImage res = new ColorImage((int)(img.getWidth() * factor),
				(int)(img.getHeight() * factor));
		for (int y = 0; y < res.getHeight(); y++)
			for (int x = 0; x < res.getWidth(); x++)
				res.setColor(x, y, img.getColor((int)(x / factor),
						(int)(y / factor)));
		return res;
	}
	
	static ColorImage vignette(ColorImage img, int radius){
		ColorImage res = new ColorImage(img.getWidth(), img.getHeight());
		int h = img.getWidth() / 2;
		int k = img.getHeight() / 2;
			for (int y = 0; y < res.getHeight(); y++)
				for (int x = 0; x < res.getWidth(); x++){
					int dist = (int)(Math.sqrt(Math.pow(x - h, 2) + Math.pow(y - k, 2)));
					if(dist > radius)
						res.setColor(x, y, img.getColor(x, y).changeBrightness(-1 * (dist - radius) * 2));
					else
						res.setColor(x, y, img.getColor(x, y));
				}
		return res;
	}
}