class EditImage {
	
	static void copyTransparency(ColorImage res, ColorImage img){
		for (int i = 0; i < Math.min(res.getHeight(), img.getHeight()); i++)
			for (int j = 0; j < Math.min(res.getWidth(), img.getWidth()); j++)
				if (!img.getColor(j, i).isSameColor(Color.WHITE))
					res.setColor(j, i, img.getColor(j, i));
	}
	
	static ColorImage copyGrey(ColorImage img){
		ColorImage res = new ColorImage(img.getWidth(), img.getHeight());
		for (int i = 0; i < res.getHeight(); i++)
			for (int j = 0; j < res.getWidth(); j++)
				res.setColor(j, i, img.getColor(j, i).setGrey());
		return res;
	}
}