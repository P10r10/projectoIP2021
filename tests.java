class tests {

/*copiar a parte n�o transparente de uma imagem para cima de outra imagem.*/

	static void test1(){
		ColorImage face = new ColorImage("src/face.jpg");
		ColorImage lines = new ColorImage("src/lines.bmp");
		EditImage.copyTransparency(face, lines);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*preencher todo o fundo de uma p�gina com uma imagem (ColorImage) com base
numa imagem padr�o dada que ser� replicada (pode incluir transpar�ncia)*/
	
	static void test2(){
		ColorImage blank = new ColorImage(433, 333);
		ColorImage leafs = new ColorImage("src/blue_leafs.bmp");
		blank.invertColor();
		EditImage.fillImage(blank, leafs);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*criar, uma copia em tons de cinzento de uma imagem dada (ColorImage)*/
	
	static void test4(){
		ColorImage face = new ColorImage("src/face.jpg");
		ColorImage grey = EditImage.copyGrey(face);
	
		System.out.println("");//Colocar breakpoint nesta linha(Pandion)
	}

/*A classe de objetos Foto. Modificar a legenda da imagem, modificar
a data de cria��o e modificar o posicionamento da imagem na p�gina; */
	
	static void test6(){
		ColorImage face = new ColorImage("src/face.jpg");
		Foto myFoto = new Foto(face, "Arte Colorida", "12/11/2021");
		System.out.println("Antes da altera��o:");
		System.out.println("A foto \"" + myFoto.caption
			+"\" foi tirada a " + myFoto.date + ". Est� na posi��o ("
			+ myFoto.getX() + ", " + myFoto.getY() + ").");
		myFoto.setCaption("Rosto Pintado");
		myFoto.setDate("15/12/2021");
		myFoto.setX(111);
		myFoto.setY(222);
		System.out.println("\nDepois da altera��o:");
		System.out.println("A foto \"" + myFoto.caption
		+"\" foi tirada a " + myFoto.date + ". Est� na posi��o ("
		+ myFoto.getX() + ", " + myFoto.getY() + ").");
		
		System.out.println("");//Colocar breakpoint nesta linha(Pandion)
	}

/*Desenvolver uma classe de objetos que representa uma p�gina do �lbum. 
1. dada uma imagem base, criar um padr�o de preenchimento do fundo da p�gina;
2. adicionar (no fim da p�gina) uma Foto nova;
3. remover uma Foto da p�gina numa posi��o dada, deslocando as restantes;
4. trocar as posi��es de duas Fotos na p�gina;
5. calcular automaticamente e posicionar as fotos na p�gina (admita um
espa�amento m�nimo de 5 pixel entre imagens e para as margens);
6. obter a visualiza��o final da p�gina.*/
	
	static void test7(){
		ColorImage foto1 = new ColorImage("src/face.jpg");
		ColorImage pattern = new ColorImage("src/mona.bmp");
		Foto myFoto = new Foto(foto1, "Caption", "Date");
		Pagina myPage = new Pagina(myFoto, 700, 700);
		myPage.fillPage(pattern);
		
		System.out.println("");//Colocar breakpoint nesta linha(Pandion)
	}
}