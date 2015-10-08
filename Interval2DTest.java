public class Interval2DTest
{
	public static void main(String[] args)
	{
		double xlo = Double.parseDouble(args[0]);
		double xhi = Double.parseDouble(args[1]);
		double ylo = Double.parseDouble(args[2]);
		double yhi = Double.parseDouble(args[3]);
		int T = Integer.parseInt(args[4]);
		
		Interval1D xint = new Interval1D(xlo, xhi);
		Interval1D yint = new Interval1D(ylo, yhi);
		Interval2D box = new Interval2D(xint, yint);
		box.draw();
		
		Counter c = new Counter("hits");
		for (int t = 0; t < T; t++)
		{
			double x = StdRandom.uniform(0.0, 1.0);
			double y = StdRandom.uniform(0.0, 1.0);
			Point2D p = new Point2D(x, y);
			if (box.contains(p)) c.increment();
			else				p.draw();
		}
		
		StdOut.println(c);
		StdOut.printf("area = %.2f\n", box.area());
	}
}