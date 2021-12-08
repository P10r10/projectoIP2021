class tests {

/*copiar a parte não transparente de uma imagem para cima de outra imagem.*/

	static void test1(){
		ColorImage img = new ColorImage("face.bmp");
		ColorImage base = new ColorImage(200, 200);
		base.invertColor();
		EditImage.copyImage(30, 40, base, img);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*preencher todo o fundo de uma página com uma imagem (ColorImage) com base
numa imagem padrão dada que será replicada (pode incluir transparência)*/
	
	static void test2(){
		ColorImage base = new ColorImage(433, 333);
		ColorImage leafs = new ColorImage("blue_leafs.bmp");
		EditImage.fillImage(base, leafs);
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
		ColorImage grey = EditImage.copyGrey(img);
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*criar uma nova imagem com o efeito vignette, que consiste em escurecer os
cantos da imagem de forma progressiva a partir de determinada distância do
centro. Deverá existir um parâmetro que permite definir a partir de que distância
do centro a imagem começa a escurecer*/
	
	static void test5(){
		ColorImage img = new ColorImage("margot.png");
		ColorImage vignette = EditImage.vignette(img, 80);
		ColorImage img2 = new ColorImage("charlize.png");
		ColorImage vignette2 = EditImage.vignette(img2, 30);
		
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}
	
/*A classe de objetos Foto: Desenvolver uma classe de objetos que
representa uma fotografia. Permite modificar a legenda da imagem,
a data de criação e o posicionamento da imagem na página; */
	
	static void test6(){
		ColorImage img = new ColorImage("face.bmp");
		Foto myFoto = new Foto(img, "Arte Colorida", "12/11/2021");
		System.out.println("Antes da alteração:");
		System.out.println("A foto \"" + myFoto.caption
			+"\" foi tirada a " + myFoto.date + ". Está na posição ("
			+ myFoto.getX() + ", " + myFoto.getY() + ").");
		myFoto.setCaption("Rosto Pintado");
		myFoto.setDate("15/12/2021");
		myFoto.setX(111);
		myFoto.setY(222);
		System.out.println("\nDepois da alteração:");
		System.out.println("A foto \"" + myFoto.caption
		+"\" foi tirada a " + myFoto.date + ". Está na posição ("
		+ myFoto.getX() + ", " + myFoto.getY() + ").");
		
		System.out.println();//Colocar breakpoint nesta linha(Pandion)
	}

/*Desenvolver uma classe de objetos que representa uma página do álbum. 
1. dada uma imagem base, criar um padrão de preenchimento do fundo da página;*/
	
	static void test7(){
		ColorImage img = new ColorImage("charlize.png");
		ColorImage base = new ColorImage("mona.bmp");
		Foto myFoto = new Foto(img, "Caption", "Date");
		Pagina myPage = new Pagina(myFoto, 675, 800);
		myPage.fillPage(base);
		
		System.out.println("");//Colocar breakpoint nesta linha(Pandion)
	}
	
/*2. adicionar (no fim da página) uma Foto nova;
3. remover uma Foto da página numa posição dada, deslocando as restantes;
4. trocar as posições de duas Fotos na página;
5. calcular automaticamente e posicionar as fotos na página (admita um
espaçamento mínimo de 5 pixel entre imagens e para as margens);
6. obter a visualização final da página.*/
	
	static void test8(){
		ColorImage img = new ColorImage("charlize.png");
//		ColorImage foto1 = new ColorImage("src/face.bmp");
		ColorImage pattern = new ColorImage("src/mona.bmp");
		Foto myFoto = new Foto(img, "Caption", "Date");
		Pagina myPage = new Pagina(myFoto, 675, 800);
		myPage.fillPage(pattern);
		
		System.out.println("");//Colocar breakpoint nesta linha(Pandion)
	}
	
//CRIAR EXCEPCÕES
	
	
	
}