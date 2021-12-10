class tests {

/*copiar a parte n�o transparente de uma imagem para cima de outra imagem.*/

	static void test1(){
		ColorImage img = new ColorImage("mona.bmp");
		ColorImage base = new ColorImage("margot.png");
		EditImage.pasteImage(75, 210, base, img);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*preencher todo o fundo de uma p�gina com uma imagem (ColorImage) com base
numa imagem padr�o dada que ser� replicada (pode incluir transpar�ncia)*/
	
	static void test2(){
		ColorImage base = new ColorImage(433, 333);
		ColorImage fill = new ColorImage("blue_leafs.bmp");
		EditImage.fillPattern(base, fill);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*criar, uma copia escalada da imagem original a partir de um factor
(double) dado*/
	
	static void test3(){
		ColorImage img = new ColorImage("margot.png");
		ColorImage larger = EditImage.scale(img, 1.5);
		ColorImage smaller = EditImage.scale(img, 0.5);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
/*criar, uma copia em tons de cinzento de uma imagem dada (ColorImage)*/
	
	static void test4(){
		ColorImage img = new ColorImage("margot.png");
		ColorImage gray = EditImage.copyGray(img);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*criar uma nova imagem com o efeito vignette, que consiste em escurecer os
cantos da imagem de forma progressiva a partir de determinada dist�ncia do
centro. Dever� existir um par�metro que permite definir a partir de que dist�ncia
do centro a imagem come�a a escurecer*/
	
	static void test5(){
		ColorImage img = new ColorImage("margot.png");
		ColorImage vignette = EditImage.vignette(img, 80);
		ColorImage img2 = new ColorImage("refaeli.png");
		ColorImage vignette2 = EditImage.vignette(img2, 85);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*A classe de objetos Foto: Desenvolver uma classe de objetos que
representa uma fotografia. Permite modificar a legenda da imagem,
a data de cria��o e o posicionamento da imagem na p�gina; */
	
	static void test6(){
		ColorImage img = new ColorImage("face.bmp");
		Foto myFoto = new Foto(img, "Arte Colorida", "12/11/2021");
		System.out.println("Antes da altera��o:");
		System.out.println("A foto \"" + myFoto.caption
			+"\" foi tirada a " + myFoto.date + ". Est� na posi��o ("
			+ myFoto.getX() + ", " + myFoto.getY() + ").");
		myFoto.caption = "Rosto Pintado";
		myFoto.date = "15/12/2021";
		myFoto.setX(111);
		myFoto.setY(222);
		System.out.println("\nDepois da altera��o:");
		System.out.println("A foto \"" + myFoto.caption
		+"\" foi tirada a " + myFoto.date + ". Est� na posi��o ("
		+ myFoto.getX() + ", " + myFoto.getY() + ").");
		
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}

/*Desenvolver uma classe de objetos que representa uma p�gina do �lbum. 
1. dada uma imagem base, criar um padr�o de preenchimento do fundo da p�gina;
2. adicionar (no fim da p�gina) uma Foto nova;
3. remover uma Foto da p�gina numa posi��o dada, deslocando as restantes;
4. trocar as posi��es de duas Fotos na p�gina;
5. calcular automaticamente e posicionar as fotos na p�gina (admita um
espa�amento m�nimo de 5 pixel entre imagens e para as margens);
6. obter a visualiza��o final da p�gina.*/
	
	static void test8(){
		Foto myFoto = new Foto(new ColorImage("charlize.png"), "", "");
		Pagina myPage = new Pagina(myFoto, 675, 800);
		myPage.fillPattern(new ColorImage("mona.bmp"));
		myPage.addPhoto(new Foto(new ColorImage("diane.png"), "", ""));
		myPage.addPhoto(new Foto(new ColorImage("face.bmp"), "", ""));
		myPage.addPhoto(new Foto(new ColorImage("refaeli.png"), "", ""));
		myPage.addPhoto(new Foto(new ColorImage("face.bmp"), "", ""));
		myPage.addPhoto(new Foto(new ColorImage("margot.png"), "", ""));
		myPage.removePhoto(2);
		myPage.swapPhoto(4, 1);
		
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*Um objeto do tipo �lbum pode ser criado fornecendo a largura e altura
do �lbum em pix�is e o n�mero de p�ginas. Um objecto do tipo Poster �
compostos por um vector de objetos do tipo P�gina e por um inteiro que
indica a p�gina actual. Ap�s a sua cria��o, deve ser poss�vel:
1. ir para a p�gina seguinte;
2. ir para a p�gina anterior;
3. visualizar a p�gina actual;
4. trocar as posi��es de duas p�ginas no �lbum; */
	
	static void test9(){
		
		Album myAlbum = new Album(675, 800, 3);
		myAlbum.addPage(new Pagina(new Foto(new ColorImage("charlize.png"), "", ""), 675, 800));
		myAlbum.addPage(new Pagina(new Foto(new ColorImage("diane.png"), "", ""), 675, 800));
		myAlbum.addPage(new Pagina(new Foto(new ColorImage("refaeli.png"), "", ""), 675, 800));
		myAlbum.displayCurrentPage();
		myAlbum.nextPage();
		myAlbum.nextPage();
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
}