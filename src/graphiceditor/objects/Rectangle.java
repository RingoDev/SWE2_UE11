package graphiceditor.objects;

import graphiceditor.visitors.Visitor;

import java.awt.Graphics;

public class Rectangle extends GraphicObject {

	private int w;
	private int h;

	/**
	 * Constructor initializing x-, y-coordinator and the width and the height
	 * @param x x-coordinator
	 * @param y y-coordinator
	 * @param w the width
	 * @param h the height
	 */
	public Rectangle(int x, int y, int w, int h) {
		super(x, y);
		this.w = w;
		this.h = h;
	}

	/**
	 * Paints the rectangle on the graphics context
	 * @param g the graphics context
	 */
	@Override
	public void paint(Graphics g) {
		g.fillRect(x - w / 2, y - h / 2, w, h);
	}

	/**
	 * Returns a string representation. 
	 */
	@Override
	public String toString() {
		return "Rectangle[" + w + ", " + h + "]";
	}

	/**
	 * Gets the width of this object
	 * @return the width
	 */
	@Override
	public int getWidth() {
		return w;
	}

	/**
	 * Gets the height of this object
	 * @return the height
	 */
	@Override
	public int getHeight() {
		return h;
	}

	/**
	 * Sets the width of this object
	 * @param w the width
	 */
	public void setWidth(int w) {
		this.w = w;
	}

	/**
	 * Sets the height of this object
	 * @param h the height
	 */
	public void setHeight(int h) {
		this.h = h;
	}

	@Override
	public GraphicObject copy(int x, int y){
		return new Rectangle(this.x + x,this.y +y ,this.w,this.h);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitRectangle(this);
	}
}
