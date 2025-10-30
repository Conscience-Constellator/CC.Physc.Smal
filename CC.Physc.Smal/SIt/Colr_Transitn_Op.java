package CC.Encycloped.Abs.Scal.Physc.SIt;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.geom.Point2D;
import static CC.Math.Math_Plus.Proportn;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.New_Colr;

public
	class Colr_Transitn_Op
	implements Op
{
	private Color Colr;
		public int R,G,B;
//	@Override
	public void Set_Colr(Color Colr)
	{
		this.Colr=Colr;
		R=Colr.getRed();
		G=Colr.getGreen();
		B=Colr.getBlue();
	}
	private double Factr;
		public void Set_Factr(double Factr)
		{this.Factr=Factr;}

	public void Set(Color Colr,double Factr)
	{
		Set_Colr(Colr);
		Set_Factr(Factr);
	}

	@Override
	public BufferedImage filter(
		BufferedImage From,
		BufferedImage To)
	{
		if(To==null)
		{To=new BufferedImage(
			From.getWidth(),
			From.getHeight(),
			From.getType());}

		for(int y=0;
			y<From.getHeight();
			y+=1)
		{
			for(int x=0;
				x<From.getWidth();
				x+=1)
			{
				Color srcColor=New_Colr(From.getRGB(x,y));
				Color newColor=transitionColor(srcColor,Factr);
				To.setRGB(x, y, newColor.getRGB());
			}
		}

		return To;
	}

	private Color transitionColor(
		Color srcColor,
		double Proportn)
	{
		int R=Proportn(srcColor.getRed(),this.R,Proportn);
		int G=Proportn(srcColor.getGreen(),this.G,Proportn);
		int B=Proportn(srcColor.getBlue(),this.B,Proportn);
		int A=srcColor.getAlpha();

		return new Color(R,G,B,A);
	}

	@Override
	public Rectangle2D getBounds2D(BufferedImage src)
	{
		return new Rectangle(
			0,0,
			src.getWidth(),src.getHeight());
	}

	@Override
	public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel destCM)
	{
		if(destCM==null)
		{destCM=src.getColorModel();}

		return new BufferedImage(destCM, destCM.createCompatibleWritableRaster(src.getWidth(),src.getHeight()), destCM.isAlphaPremultiplied(), null);
	}

	@Override
	public Point2D getPoint2D(Point2D srcPt, Point2D dstPt)
	{
		if(dstPt==null)
		{dstPt=(Point2D)srcPt.clone();}
		else
		{dstPt.setLocation(srcPt);}

		return dstPt;
	}

	@Override
	public RenderingHints getRenderingHints()
	{return null;}

	public Colr_Transitn_Op(Color Colr,double Factr)
	{Set(Colr,Factr);}
}
