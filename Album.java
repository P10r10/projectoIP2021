import java.util.Iterator;

class Album {
	
	Pagina[] paginas;
	//int next = 0;
	int currentPage = 0;
	
	Album(int width, int height, int numPages){
		paginas = new Pagina[numPages]; 
		for (int i = 0; i < paginas.length; i++)
			//podemos alterar fundo pre-definido da página	
			paginas[i] = new Pagina(width, height, new ColorImage("blue_leafs.bmp"));
	}
	
//permite colocar uma foto na página à escolha
	void addImgToPage(ColorImage img, int pageNb){
		paginas[pageNb].addPhoto(new Foto(img, "", ""));
	}
	void displayCurrentPage(){
		if (paginas[currentPage] == null)
			throw new NullPointerException("paginas is null!");
		System.out.println("Current page is " + currentPage);
		paginas[currentPage].displayPhotos();
	}
	
	void nextPage(){
		if (currentPage == paginas.length - 1)
			throw new IllegalStateException("Already at the last page!");
		currentPage++;
		displayCurrentPage();
	}
	
	void previousPage(){
		if (currentPage == 0)
			throw new IllegalStateException("Already at the first page!");
		currentPage--;
		displayCurrentPage();
	}
	
	void swapPage(int a, int b){
		Pagina tmp = paginas[a];
		paginas[a] = paginas[b];
		paginas[b] = tmp;
	}
}