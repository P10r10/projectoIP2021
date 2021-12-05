class Pagina {
	
	ColorImage page;
	Foto[] fotos = new Foto[50];//REVER ESTE VALOR
	int idx = 0;
	
	Pagina(Foto foto, int width, int height){
		page = new ColorImage(width, height);
		fotos[idx++] = foto;
	}
	
	Pagina(ColorImage[] vec, int width, int height){
		page = new ColorImage(width, height);
		for(int i = 0; i < vec.length; i++)
			fotos[idx++] = new Foto(vec[i], "Legenda", "Data");
	}
	
	void fillPage(ColorImage img){
		EditImage.fillImage(page, img);
		EditImage.copyImage(fotos[0].getX(), fotos[0].getY(), page, fotos[0].img);
	}

}