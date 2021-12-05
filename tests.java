class tests {

/*copiar a parte n�o transparente de uma imagem para cima de outra imagem.*/

	static void test1(){
		ColorImage face = new ColorImage("src/face.jpg");
		ColorImage lines = new ColorImage("src/lines.bmp");
		EditImage.copyTransparency(face, lines);
		System.out.println();//Colocar coment�rio nesta linha(Pandion)
	}
	
/*preencher todo o fundo de uma p�gina com uma imagem (ColorImage) com base
numa imagem padr�o dada que ser� replicada (pode incluir transpar�ncia)*/
	
	static void test2(){
		ColorImage blank = new ColorImage(433, 333);
		blank.invertColor();
		EditImage.fillImage(blank);
		System.out.println();//Colocar coment�rio nesta linha(Pandion)
	}
	
/*criar, uma copia em tons de cinzento de uma imagem dada (ColorImage)*/
	
	static void test4(){
		ColorImage face = new ColorImage("src/face.jpg");
		ColorImage grey = EditImage.copyGrey(face);
	
		System.out.println("");//Colocar coment�rio nesta linha(Pandion)
	}

/*A classe de objetos Foto. Modificar a legenda da imagem, modificar
a data de cria��o e modificar o posicionamento da imagem na p�gina; */
	
	static void test6(){
		ColorImage face = new ColorImage("src/face.jpg");
		Foto myFoto = new Foto(face, "Arte Colorida", "12/11/2021");
		System.out.println("Antes da altera��o:");
		System.out.println("A foto \"" + myFoto.getCaption()
			+"\" foi tirada a " + myFoto.getDate() + ". Est� na posi��o ("
			+ myFoto.getX() + ", " + myFoto.getY() + ").");
		myFoto.setCaption("Rosto Pintado");
		myFoto.setDate("15/12/2021");
		myFoto.setX(111);
		myFoto.setY(222);
		System.out.println("\nDepois da altera��o:");
		System.out.println("A foto \"" + myFoto.getCaption()
		+"\" foi tirada a " + myFoto.getDate() + ". Est� na posi��o ("
		+ myFoto.getX() + ", " + myFoto.getY() + ").");
		
		System.out.println("");//Colocar coment�rio nesta linha(Pandion)
	}
}