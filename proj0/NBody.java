public class NBody{

	public static double readRadius(String filename) {
       In in = new In (filename);
       in.readInt();
       double r = in.readDouble();
       return r;
	}

	public static Body[] readBodies(String filename){
		In in = new In(filename);
		int n = in.readInt();
		in.readDouble();
		Body[] body = new Body[n];
		for(int i = 0; i < n; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
            body[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,img);

		}

		return body;
	}


	public static void main (String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename =  args[2];
        String soundname = args[3];
        double radius = NBody.readRadius(filename);
        Body[] body = NBody.readBodies(filename);
        StdAudio.play(soundname);
        StdDraw.enableDoubleBuffering();
        /** draw the bg*/
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");

        /** draw bodies*/
        
        int len = body.length;
        for(int i = 0; i < len; i++){
           body[i].draw();
        }

        /** making animation*/
        double time = 0;
        while(time <= T){
        	double[] xForce = new double [len+1];
        	double[] yForce = new double [len+1];
        	for(int i = 0; i < len; i++){
        		xForce[i] = body[i].calcNetForceExertedByX(body);
        		yForce[i] = body[i].calcNetForceExertedByY(body);

        	}
            /** update every body after calculating xForce and yForce */
            for(int i = 0; i < len; i++){
           	    body[i].update(dt, xForce[i], yForce[i]);
            }
            
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for(int i = 0; i < len; i++){
                body[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        	time += dt;
        }
        

        StdOut.printf("%d\n", len);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < len; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  body[i].xxPos, body[i].yyPos, body[i].xxVel,
		                  body[i].yyVel, body[i].mass, body[i].imgFileName);   
		}

	}
}