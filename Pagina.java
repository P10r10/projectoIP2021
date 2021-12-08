class Pagina {
	
	ColorImage page;
	Foto[] fotos = new Foto[50];
	int next = 0;
	
	Pagina(Foto foto, int width, int height){
		page = new ColorImage(width, height);
		fotos[next++] = foto;
	}
	
	Pagina(ColorImage[] vec, int width, int height){
		page = new ColorImage(width, height);
		for(int i = 0; i < vec.length; i++)
			fotos[next++] = new Foto(vec[i], "Legenda", "Data");
	}
	
	void fillPage(ColorImage img){
		EditImage.fillImage(page, img);
		EditImage.copyImage(fotos[0].getX() + 5, fotos[0].getY() + 5, page, fotos[0].img);
	}

}