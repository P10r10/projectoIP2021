class Album {
	
	Pagina[] paginas;
	ColorImage album;
	int index = 0;
	int currentPage = 0;
	int totalPages = 0;
	
	Album(int width, int height, int numPages){
		album = new ColorImage(width, height);
		paginas = new Pagina[numPages]; 
		totalPages = numPages;
	}
	
	void addPage(Pagina page){
		if (index == totalPages)
			throw new IllegalStateException("Album has no more room for pages!");
		paginas[index++] = page;
		//album = page.pageImg;
		//page.displayPhotos();
	}
	void displayCurrentPage(){
		if (paginas[currentPage] == null)
			throw new NullPointerException("paginas is null!");
		System.out.println("Current page is " + currentPage);
		paginas[currentPage].displayPhotos();
	}
	
	void nextPage(){
		currentPage++;
		displayCurrentPage();
	}
}

/*Álbum pode ser criado fornecendo a largura e altura
do Álbum em pixéis e o número de páginas*/