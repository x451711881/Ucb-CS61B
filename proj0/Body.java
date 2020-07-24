public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static double G = 6.67E-11;

	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance (Body a){
		double x = this.xxPos - a.xxPos;
		double y = this.yyPos - a.yyPos;
		double x2 = Math.pow(x,2);
		double y2 = Math.pow(y,2);
		double r = Math.sqrt(x2 + y2);
		return r;
	}

	public double calcForceExertedBy (Body a){
		
		double r = this.calcDistance(a);
		double force = G * this.mass * a.mass / (r * r); 
		return force;
	}

	public double calcForceExertedByX(Body a){
		double x = a.xxPos - this.xxPos;
		double forceX = this.calcForceExertedBy(a) * x / this.calcDistance(a);
		return forceX;
	}

	public double calcForceExertedByY(Body a){
		double y = a.yyPos - this.yyPos;
		double forceY = this.calcForceExertedBy(a) * y / this.calcDistance(a);
		return forceY;
	}

	public double calcNetForceExertedByX (Body[] b){
		int len = b.length;
		double netforceX = 0;
		for(int i = 0 ; i < len; i++){
			if(this.equals(b[i])) continue;
            netforceX += this.calcForceExertedByX(b[i]);
		}

		return netforceX;
	}

	public double calcNetForceExertedByY (Body[] b){
		int len = b.length;
		double netforceY = 0;
		for(int i = 0 ; i < len; i++){
			if(this.equals(b[i])) continue;
            netforceY += this.calcForceExertedByY(b[i]);
		}

		return netforceY;
	}

	public void update(double dt,double fx, double fy){
      double ax = fx/this.mass;
      double ay = fy/this.mass;
      this.xxVel = this.xxVel + ax * dt;
      this.yyVel = this.yyVel + ay * dt;
      this.xxPos = this.xxPos + xxVel * dt;
      this.yyPos = this.yyPos + yyVel * dt;
	}

	public void draw (){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);

	}
    
    
}