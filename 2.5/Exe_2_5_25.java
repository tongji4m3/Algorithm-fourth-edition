package com.tongji.algorithms_2_1;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public final class Exe_2_5_25 implements Comparable<Exe_2_5_25>
{
	public static final Comparator<Exe_2_5_25> X_ORDER = new XOrder();
	public static final Comparator<Exe_2_5_25> Y_ORDER = new YOrder();
	public static final Comparator<Exe_2_5_25> R_ORDER = new ROrder();

	private final double x; // x coordinate
	private final double y; // y coordinate

	public Exe_2_5_25(double x, double y)
	{
		if (Double.isInfinite(x) || Double.isInfinite(y))
			throw new IllegalArgumentException("Coordinates must be finite");
		if (Double.isNaN(x) || Double.isNaN(y))
			throw new IllegalArgumentException("Coordinates cannot be NaN");
		if (x == 0.0)
			this.x = 0.0; // convert -0.0 to +0.0
		else
			this.x = x;

		if (y == 0.0)
			this.y = 0.0; // convert -0.0 to +0.0
		else
			this.y = y;
	}

	public double x()
	{
		return x;
	}
	public double y()
	{
		return y;
	}
	public double r()
	{
		return Math.sqrt(x * x + y * y);
	}
	public double theta()
	{
		return Math.atan2(y, x);
	}
	private double angleTo(Exe_2_5_25 that)
	{
		double dx = that.x - this.x;
		double dy = that.y - this.y;
		return Math.atan2(dy, dx);
	}

	public static int ccw(Exe_2_5_25 a, Exe_2_5_25 b, Exe_2_5_25 c)
	{
		double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		if (area2 < 0)
			return -1;
		else if (area2 > 0)
			return +1;
		else
			return 0;
	}
	public static double area2(Exe_2_5_25 a, Exe_2_5_25 b, Exe_2_5_25 c)
	{
		return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
	}
	public double distanceTo(Exe_2_5_25 that)
	{
		double dx = this.x - that.x;
		double dy = this.y - that.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	public double distanceSquaredTo(Exe_2_5_25 that)
	{
		double dx = this.x - that.x;
		double dy = this.y - that.y;
		return dx * dx + dy * dy;
	}
	public int compareTo(Exe_2_5_25 that)
	{
		if (this.y < that.y)
			return -1;
		if (this.y > that.y)
			return +1;
		if (this.x < that.x)
			return -1;
		if (this.x > that.x)
			return +1;
		return 0;
	}
	public Comparator<Exe_2_5_25> polarOrder()
	{
		return new PolarOrder();
	}
	public Comparator<Exe_2_5_25> atan2Order()
	{
		return new Atan2Order();
	}
	public Comparator<Exe_2_5_25> distanceToOrder()
	{
		return new DistanceToOrder();
	}
	private static class XOrder implements Comparator<Exe_2_5_25>
	{
		public int compare(Exe_2_5_25 p, Exe_2_5_25 q)
		{
			if (p.x < q.x)
				return -1;
			if (p.x > q.x)
				return +1;
			return 0;
		}
	}
	private static class YOrder implements Comparator<Exe_2_5_25>
	{
		public int compare(Exe_2_5_25 p, Exe_2_5_25 q)
		{
			if (p.y < q.y)
				return -1;
			if (p.y > q.y)
				return +1;
			return 0;
		}
	}
	private static class ROrder implements Comparator<Exe_2_5_25>
	{
		public int compare(Exe_2_5_25 p, Exe_2_5_25 q)
		{
			double delta = (p.x * p.x + p.y * p.y) - (q.x * q.x + q.y * q.y);
			if (delta < 0)
				return -1;
			if (delta > 0)
				return +1;
			return 0;
		}
	}
	private class Atan2Order implements Comparator<Exe_2_5_25>
	{
		public int compare(Exe_2_5_25 q1, Exe_2_5_25 q2)
		{
			double angle1 = angleTo(q1);
			double angle2 = angleTo(q2);
			if (angle1 < angle2)
				return -1;
			else if (angle1 > angle2)
				return +1;
			else
				return 0;
		}
	}
	private class PolarOrder implements Comparator<Exe_2_5_25>
	{
		public int compare(Exe_2_5_25 q1, Exe_2_5_25 q2)
		{
			double dx1 = q1.x - x;
			double dy1 = q1.y - y;
			double dx2 = q2.x - x;
			double dy2 = q2.y - y;

			if (dy1 >= 0 && dy2 < 0)
				return -1; // q1 above; q2 below
			else if (dy2 >= 0 && dy1 < 0)
				return +1; // q1 below; q2 above
			else if (dy1 == 0 && dy2 == 0)
			{ // 3-collinear and horizontal
				if (dx1 >= 0 && dx2 < 0)
					return -1;
				else if (dx2 >= 0 && dx1 < 0)
					return +1;
				else
					return 0;
			} else
				return -ccw(Exe_2_5_25.this, q1, q2); // both above or below

			// Note: ccw() recomputes dx1, dy1, dx2, and dy2
		}
	}

	// compare points according to their distance to this point
	private class DistanceToOrder implements Comparator<Exe_2_5_25>
	{
		public int compare(Exe_2_5_25 p, Exe_2_5_25 q)
		{
			double dist1 = distanceSquaredTo(p);
			double dist2 = distanceSquaredTo(q);
			if (dist1 < dist2)
				return -1;
			else if (dist1 > dist2)
				return +1;
			else
				return 0;
		}
	}

	public boolean equals(Object other)
	{
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (other.getClass() != this.getClass())
			return false;
		Exe_2_5_25 that = (Exe_2_5_25) other;
		return this.x == that.x && this.y == that.y;
	}

	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}

	public int hashCode()
	{
		int hashX = ((Double) x).hashCode();
		int hashY = ((Double) y).hashCode();
		return 31 * hashX + hashY;
	}

	public void draw()
	{
		StdDraw.point(x, y);
	}
	public void drawTo(Exe_2_5_25 that)
	{
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	public static void main(String[] args)
	{
		int x0 = Integer.parseInt(args[0]);
		int y0 = Integer.parseInt(args[1]);
		int n = Integer.parseInt(args[2]);

		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 100);
		StdDraw.setPenRadius(0.005);
		StdDraw.enableDoubleBuffering();

		Exe_2_5_25[] points = new Exe_2_5_25[n];
		for (int i = 0; i < n; i++)
		{
			int x = StdRandom.uniform(100);
			int y = StdRandom.uniform(100);
			points[i] = new Exe_2_5_25(x, y);
			points[i].draw();
		}

		// draw p = (x0, x1) in red
		Exe_2_5_25 p = new Exe_2_5_25(x0, y0);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.02);
		p.draw();

		// draw line segments from p to each point, one at a time, in polar order
		StdDraw.setPenRadius();
		StdDraw.setPenColor(StdDraw.BLUE);
		Arrays.sort(points, p.polarOrder());
		for (int i = 0; i < n; i++)
		{
			p.drawTo(points[i]);
			StdDraw.show();
			StdDraw.pause(100);
		}
	}
}
