public class TestBody{

	public static void main (String[] args){
		Body b1 = new Body(0,0,1,2,1,"img1");
		Body b2 = new Body(0,3,2,1,2,"img2");
		double force = b1.calcForceExertedBy(b2);
		System.out.println(force);
	}
}