class EditImage {
	
	static void copyTransparency(ColorImage res, ColorImage img){
		for (int y = 0; y < Math.min(res.getHeight(), img.getHeight()); y++)
			for (int x = 0; x < Math.min(res.getWidth(), img.getWidth()); x++)
				if (!img.getColor(x, y).isSameColor(Color.WHITE))
					res.setColor(x, y, img.getColor(x, y));
	}
	
	static void copyImage(int xp, int yp, ColorImage res, ColorImage img){
		for (int y = yp; y < img.getHeight() + yp && y < res.getHeight(); y++)
			for (int x = xp; x < img.getWidth() + xp && x < res.getWidth(); x++)
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
	
	/*SCALE*/
	
	/*VIGNETE*/
	
	
	
/*	static void posterize(ColorImage img, Color light, Color dark) {//REMOVE
        for(int x = 0; x != img.getWidth(); x++)
            for(int y = 0; y != img.getHeight(); y++)
                if(img.getColor(x, y).getLuminance() < 128)
                    img.setColor(x, y, dark);
                else
                    img.setColor(x, y, light); 
    }
	static Color brighter(Color col, int n){//REMOVE
		return col.adjustBrightness(n);
	}
	static void noise(ColorImage img, int value) {//REMOVE
        for(int x = 0; x != img.getWidth(); x++) {
            for(int y = 0; y != img.getHeight(); y++) {
                img.setColor(x, y, brighter(img.getColor(x, y), (int)(Math.random()*2*value) - value));
            }
        }
    }*/
}