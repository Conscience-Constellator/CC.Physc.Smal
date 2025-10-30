package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Lin_DclAr;

import CC.$.Q$Q.Int1$1;
import CC.$.Q$Q.Point1$1;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.Aply;

public interface
	Int1$1_Op extends Op,
	Int1$1,
	Point1$1<Color,Color>
{
	@Lin_DclAr
	default Color Point1$1(Color Colr)
	{return Aply(this,Colr);}

	@Override
	default BufferedImage filter(BufferedImage From,
								 BufferedImage To)
	{
		if(To==null)
		{
			To=new BufferedImage(From.getWidth(),
								 From.getHeight(),
								 From.getType());
		}

		for(int y=0;
				y<From.getHeight();
				y+=1)
		{
			for(int x=0;
					x<From.getWidth();
					x+=1)
			{
				To.setRGB(
					x,y,
					Int1$1(From.getRGB(x,y)));
			}
		}

		return To;
	}

	@Override
	default Rectangle2D getBounds2D(BufferedImage src)
	{
		return new Rectangle(
			0,0,
			src.getWidth(),src.getHeight());
	}

	@Override
	default BufferedImage createCompatibleDestImage(BufferedImage src,ColorModel destCM)
	{
		if(destCM==null)
		{destCM=src.getColorModel();}

		return new BufferedImage(
			destCM,
			destCM.createCompatibleWritableRaster(
				src.getWidth(),
				src.getHeight()),
			destCM.isAlphaPremultiplied(),
			null);
	}

	@Override
	default Point2D getPoint2D(
		Point2D srcPt,
		Point2D dstPt)
	{
		if(dstPt==null)
		{dstPt=(Point2D)srcPt.clone();}
		else
		{dstPt.setLocation(srcPt);}

		return dstPt;
	}

	@Override
	default RenderingHints getRenderingHints()
	{return null;}
}