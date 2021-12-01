class testing {
	
	static void test1(){
		ColorImage img = new ColorImage("C:/Users/Alex/Desktop/ecpliseStuff/projectoIP2021/src/img.jpg");
		ColorImage cross = new ColorImage("C:/Users/Alex/Desktop/ecpliseStuff/projectoIP2021/src/cross.bmp");
		EditImage.copyTransparency(img, cross);
		ColorImage img2 = EditImage.copyGrey(img);
		
		System.out.println("");
	}
	
}