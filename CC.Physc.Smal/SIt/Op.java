package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.ClEr_Clip;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.ClEr_Tran;

public interface Op extends BufferedImageOp,Efect
{
	@Override
	default BufferedImageOp Get_Op(Drawbl_Atom.Atom_Projectn Projectn)
	{return this;}

	Op No_Op=new Op(){
		@Override
		public BufferedImage filter(
			BufferedImage From,
			BufferedImage To)
		{return To;}
		@Override
		public Rectangle2D getBounds2D(BufferedImage src)
		{return src.getData().getBounds();}
		@Override
		public BufferedImage createCompatibleDestImage(BufferedImage src,ColorModel destCM){
			return null;
		}
		@Override
		public Point2D getPoint2D(Point2D srcPt,Point2D dstPt)
		{return null;}
		@Override
		public RenderingHints getRenderingHints()
		{return null;}
	};

	static void Filtr(
		BufferedImage Img,Graphics2D Graphcs,
		BufferedImageOp Op,Shape ShAp)
	{
		Graphcs.setClip(ShAp);
		Op.filter(Img,Img);
		ClEr_Clip(Graphcs);
	}
	static void Filtr(
		BufferedImage Img,Graphics2D Graphcs,
		BufferedImageOp Op,AffineTransform Tran)
	{
		Graphcs.setTransform(Tran);
		Op.filter(Img,Img);
		ClEr_Tran(Graphcs);
	}
		static void Filtr(
			BufferedImage Img,Graphics2D Graphcs,
			BufferedImageOp Op,Shape ShAp,AffineTransform Tran)
		{
			Graphcs.setClip(ShAp);
			Filtr(Img,Graphcs,Op,Tran);
			ClEr_Clip(Graphcs);
		}
}