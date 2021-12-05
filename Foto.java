class Foto {
	
	private int x;
	private int y;
	private ColorImage img;
	private String caption;//legenda
	private String date;
	
	Foto(ColorImage img, String caption,String date){
		this.img = img;
		this.caption = caption;
		this.date = date;
		x = 0;
		y = 0;
	}
	
	int getX(){
		return x;
	}
	
	int getY(){
		return y;
	}
	
	ColorImage getImage(){
		return img;
	}
	
	String getCaption(){
		return caption;
	}
	
	String getDate(){
		return date;
	}

	void setX(int x){
		this.x = x;
	}
	
	void setY(int y){
		this.y = y;
	}
	
	void setCaption(String caption){
		this.caption = caption;
	}
	
	void setDate(String date){
		this.date = date;
	}
}