class Album {
	
	Pagina[] paginas;
	private int width;
	private int height;
	int next = 0;
	int currentPage = 0;
	int totalPages = 0;
	
	Album(int width, int height, int numPages){
		this.width = width;
		this.height = height;
		paginas = new Pagina[numPages]; 
		totalPages = numPages;
	}
	
	void addPage(Pagina page){
		if (next == totalPages)
			throw new IllegalStateException("Album has no more room for pages!");
		paginas[next++] = page;
	}
	void displayCurrentPage(){
		if (paginas[currentPage] == null)
			throw new NullPointerException("paginas is null!");
		System.out.println("Current page is " + currentPage);
		paginas[currentPage].displayPhotos();
	}
	
	void nextPage(){
		if (currentPage == totalPages)
			throw new IllegalStateException("Already at the last page!");
		currentPage++;
		displayCurrentPage();
	}
	
	void previousPage(){
		if (currentPage == 0)
			throw new IllegalStateException("You're at the 1st page!");
		currentPage--;
		displayCurrentPage();
	}
	
	void swapPage(){
		//IMPLEMENTAR
	}
}