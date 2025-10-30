package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Img_Clip extends Img_Filr
{
	public double[] X,Y;

	@Override
	public void Fil(ScrEn ScrEn,Graphics2D Graphcs)
	{
		super.Fil(ScrEn,Graphcs);
//		Fil_TXtrd(Graphcs,ShAp,Tran,Img);
//		for(int i=0;
//			i<X.length-1;
//			i+=1)
//		{
//			int x1 = (int) X[i], y1 = (int) Y[i];
//			int x2 = (int) X[i + 1], y2 = (int) Y[i + 1];
//
//			int tx1 = (int) Img_Xg[i], ty1 = (int) Img_Yg[i];
//			int tx2 = (int) Img_Xg[i + 1], ty2 = (int) Img_Yg[i + 1];
//
//			g2d.drawImage(Img, x1, y1, x2, y2, tx1, ty1, tx2, ty2, null);
//		}
//
//		int x1=(int) X[X.length - 1], y1 = (int) Y[Y.length - 1];
//		int x2= (int) X[0], y2 = (int) Y[0];
//
//		int tx1 = (int) Img_Xg[Img_Xg.length - 1], ty1 = (int) Img_Yg[Img_Yg.length - 1];
//		int tx2 = (int) Img_Xg[0], ty2 = (int) Img_Yg[0];
//
//		g2d.drawImage(Img, x1, y1, x2, y2, tx1, ty1, tx2, ty2, null);
	}
	public static double[] mapScreenToImage(AffineTransform tran, 
		double screenX,
		double screenY)
	{
		try
		{
			AffineTransform inverse=tran.createInverse();
			double[] screenPoint={screenX,screenY};
			double[] imagePoint=new double[2];
			inverse.transform(
				screenPoint,0,
				imagePoint,0,
				1);

			return imagePoint;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Img_Clip(BufferedImage Img,
		double[] X,
		double[] Y)
	{
		super(Img);
			this.X=X;
			this.Y=Y;
	}
}