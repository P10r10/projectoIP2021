class Pagina {
	
	final int MAX = 50;
	ColorImage pageImg;
	Foto[] fotos = new Foto[MAX];
	int lastPhoto = 0;
	ColorImage currentPattern = null;
	
	Pagina(Foto foto, int width, int height){
		pageImg = new ColorImage(width, height);
		fotos[lastPhoto++] = foto;
	}
	
	Pagina(ColorImage[] vec, int width, int height){
		pageImg = new ColorImage(width, height);
		for(int i = 0; i < vec.length; i++)
			fotos[lastPhoto++] = new Foto(vec[i], "Legenda", "Data");
	}
	
	Pagina(int width, int height, ColorImage pattern){
		pageImg = new ColorImage(width, height);
		fillPattern(pattern);
	}

/* Calcula todos os x,y de cada foto do vector fotos por forma a ficarem *
 * dispostos na página.                                                  */
	void setPhotosPosition(){
		int totalWidth = 0;
		int totalHeight = 0;
		int maxHeight = 0;
		for(int i = 0; i < fotos.length && fotos[i] != null && fotos[i].img != null; i++){
			fotos[i].setX(5 + totalWidth);
			fotos[i].setY(5 + totalHeight);
			totalWidth += 5 + fotos[i].img.getWidth();
			maxHeight = Math.max(maxHeight, fotos[i].img.getHeight());
			if (totalWidth >= pageImg.getWidth()){
				totalWidth = 0;
				totalHeight += 5 + maxHeight;
				maxHeight = 0;
			}
		}
	}
	
	void displayPhotos(){
		setPhotosPosition();
		for(int i = 0; i < fotos.length && fotos[i] != null && fotos[i].img != null; i++)
			EditImage.pasteImage(fotos[i].getX(), fotos[i].getY(), pageImg, fotos[i].img);
	}
	
	void addPhoto(Foto photo){
		if (lastPhoto == fotos.length)
			throw new IllegalStateException("Page has no more room for photos!");
		fotos[lastPhoto++] = photo;
		fillPattern(currentPattern);
	}
	
	void removePhoto(int index){
		if (lastPhoto == 0)
			throw new IllegalStateException("Page has no photos to remove!");
		Foto[] res = new Foto[MAX];
		for (int i = 0, j = 0; i < res.length && fotos[i] != null; i++)
			if (i != index)
				res[j++] = fotos[i];
		lastPhoto--;
		fotos = res;
		fillPattern(currentPattern);
	}
	
	void swapPhoto(int idx_a, int idx_b){
		if (idx_a < 0 || idx_b < 0)
			throw new IllegalArgumentException("Arguments must be positive integers!");
		Foto tmp = new Foto(null, "", "");
		tmp = fotos[idx_a];
		fotos[idx_a] = fotos[idx_b];
		fotos[idx_b] = tmp;
		fillPattern(currentPattern);
	}                  
	
	void fillPattern(ColorImage img){
		currentPattern = img;
		EditImage.fillPattern(pageImg, currentPattern);
		displayPhotos();
	}
}