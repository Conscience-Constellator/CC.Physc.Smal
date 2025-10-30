package CC.Encycloped.Abs.Scal.Physc.SIt;

import DDDTutorial_Modd.D2.Bound_Colr_Filr;
import CC.Encycloped.Abs.Scal.Physc.SIt.RsOrc_Filr.Img_Filr;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import CC.Encycloped.TIm.TImr;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.*;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.ClEr_Clip;
import static CC.Encycloped.Abs.Scal.Physc.SIt.RsOrc_Filr.Img_Filr.Fil_TXtrd;
import static java.awt.AlphaComposite.SRC;
import static java.awt.AlphaComposite.SRC_OVER;
import static java.awt.Color.*;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.lang.Math.min;
import static java.lang.System.nanoTime;
import static java.lang.System.out;
import static java.util.concurrent.ThreadLocalRandom.current;
import java.util.List;

public class Img
{
	public static List<BufferedImage> MAk_Imgg(
		int X,
		int Y,
		int Num)
	{
		List<BufferedImage> Imgg=new ArrayList<>(Num);
		for(int IndX=0;
			IndX<Num;
			IndX+=1)
		{Imgg.add(new BufferedImage(X,Y,TYPE_INT_ARGB));}
		out.println("Made "+Imgg.size()+" images");

		return Imgg;
	}
	public static List<Graphics2D> MAk_Graphcsg(List<BufferedImage> Imgg)
	{
		int Num=Imgg.size();
		List<Graphics2D> Graphcsg=new ArrayList<>();
		for(int IndX=0;
			IndX<Num;
			IndX+=1)
		{Graphcsg.add(Imgg.get(IndX).createGraphics());}

		return Graphcsg;
	}

	public static void Set_ARGB(BufferedImage Img,
		int XB,int XT,
		int YB,int YT,
		int ARGB)
	{
		for(int i=XB;
			i<XT;
			i++)
		{
			for(int j=YB;
				j<YT;
				j++)
			{Img.setRGB(i,j,ARGB);}
		}
	}
	public static void MpT(BufferedImage Img)
	{Set_ARGB(Img,
		0,Img.getWidth(),
		0,Img.getHeight(),
		0);
	}
	public static void MpT(Graphics2D Graphcs)
	{
		Shape ShAp=Graphcs.getClip();
		Graphcs.setClip(null);

		Graphcs.setComposite(AlphaComposite.getInstance(SRC));
		RsOrc_Filr.Colr_Filr.Fil_Colr(Graphcs,ClEr);
		Graphcs.setComposite(AlphaComposite.getInstance(SRC_OVER));

		Graphcs.setClip(ShAp);
	}
	public static void Set(Graphics2D To,BufferedImage From)
	{
		Shape ShAp=To.getClip();
		To.setClip(null);

		To.setComposite(AlphaComposite.getInstance(SRC));
		Fil_TXtrd(To,From);
		To.setComposite(AlphaComposite.getInstance(SRC_OVER));

		To.setClip(ShAp);
	}

	public static void Prep(Graphics2D Graphcs)
	{
		Graphcs.setComposite(AlphaComposite.getInstance(SRC));
		RsOrc_Filr.Colr_Filr.Fil_Colr(
			Graphcs,
			ClEr);
		Graphcs.setComposite(AlphaComposite.getInstance(SRC_OVER));
	}
	public static void Prep(Graphics2D Graphcs,Shape ShAp)
	{
		Graphcs.setClip(ShAp);
		Prep(Graphcs);
	}
	public static void IntegrAt(
		Graphics2D Img,
		BufferedImage TMp,Shape ShAp)
	{
		Img_Filr.Inst.Fil(null,Img,ShAp,TMp);
	}
		public static void IntegrAt(
			Graphics2D Img,
			BufferedImage TMp,Graphics TMp_Graphcs)
		{IntegrAt(Img,TMp,TMp_Graphcs.getClip());}
	//<editor-fold desc="Xtract">
	public static void Xtract(
		BufferedImage TMp,
		Shape ShAp,int X,int Y,
		BufferedImage Img)
	{
		Graphics2D Graphcs=Img.createGraphics();

		Graphcs.setClip(ShAp);
		Graphcs.drawImage(TMp,
			-X,-Y,
		null);

		Graphcs.dispose();
	}
		public static void Xtract(
			BufferedImage TMp,
			Shape ShAp,
			BufferedImage To)
		{Xtract(TMp,ShAp,0,0,To);}
		public static BufferedImage Xtract(
			BufferedImage TMp,
			Shape ShAp)
		{
			Rectangle Box=ShAp.getBounds();
				int
					X=Box.width,
					Y=Box.height;
			BufferedImage To=new BufferedImage(
				X,Y,
				TYPE_INT_ARGB);

			Xtract(TMp,ShAp,X,Y,To);

			return To;
		}
	//</editor-fold>

	public static void Tran(BufferedImage Img,Shape ShAp,
		int X,int Y,
		int X_LNg,int Y_LNg,
	float[] factors)
	{
		WritableRaster Rastr=Img.getRaster();
		int[] Pixl=new int[4];
		for(;Y<Y_LNg
			;Y+=1)
		{
			for(;X<X_LNg
				;X+=1)
			{
				if(ShAp.contains(X,Y))
				{
					Rastr.getPixel(X,Y,Pixl);

					Pixl[0]=min((int)(Pixl[0]*factors[0]),255);
					Pixl[1]=min((int)(Pixl[1]*factors[1]),255);
					Pixl[2]=min((int)(Pixl[2]*factors[2]),255);
					Pixl[3]=min((int)(Pixl[3]*factors[3]),255);

					Rastr.setPixel(X,Y,Pixl);
				}
			}
		}
	}
		public static void Tran(
			BufferedImage Img,
			Shape ShAp,
			float[] MultiplIrg)
		{
			Rectangle Box=ShAp.getBounds();
			Tran(Img,ShAp,
				Box.x,Box.y,
				Box.width,Box.height,
				MultiplIrg);
		}
	public static RescaleOp Litng(
		float[] RGB)
	{return new RescaleOp(RGB,new float[4],null);}
		public static RescaleOp Litng(
			float R,
			float G,
			float B)
		{return Litng(new float[]{R,G,B});}
			public static RescaleOp Litng(
				double R,
				double G,
				double B)
			{return Litng(
				(float)R,
				(float)G,
				(float)B);
			}
	public static void Multiply_Colr(
		BufferedImage Img,
		float[] MultiplIrg)
	{
		RescaleOp Op=new RescaleOp(MultiplIrg,new float[4],null);
		Op.filter(Img,Img);
	}
		public static void Multiply_Colr(BufferedImage Img,
			double R,
			double G,
			double B)
		{Multiply_Colr(Img,new float[]{
			(float)R,
			(float)G,
			(float)B});
		}
	public static void Multiply_Colr(
		BufferedImage Img,Graphics2D Graphcs,
		Shape ShAp,
		float[] MultiplIrg)
	{
		Graphcs.setClip(ShAp);
		Multiply_Colr(Img,MultiplIrg);
		ClEr_Clip(Graphcs);
	}
		public static void Multiply_Colr(
			BufferedImage Img,Graphics2D Graphcs,
			Shape ShAp,
			double R,
			double G,
			double B)
		{Multiply_Colr(Img,Graphcs,ShAp,new float[]{
			(float)R,
			(float)G,
			(float)B});
		}

	public static void Set_Tran(AffineTransform Tran,
		double[] Img_X,
		double[] Img_Y,
		int[] SpAc_X,
		int[] SpAc_Y)
	{
		double Img_XA=Img_X[0],Img_YA=Img_Y[0];
		double Img_XB=Img_X[1],Img_YB=Img_Y[1];
		double Img_XC=Img_X[2],Img_YC=Img_Y[2];

		double XA=SpAc_X[0],YA=SpAc_Y[0];
		double XB=SpAc_X[1],YB=SpAc_Y[1];
		double XC=SpAc_X[2],YC=SpAc_Y[2];

		// Calculate the transform
		double dx1=XB-XA,dy1=YB-YA;
		double dx2=XC-XA,dy2=YC-YA;
		double du1=Img_XB-Img_XA,dv1=Img_YB-Img_YA;
		double du2=Img_XC-Img_XA,dv2=Img_YC-Img_YA;

		double det=du1*dv2-dv1*du2;
		if (det == 0) {
			// The points are collinear (or nearly so), which should not happen in a proper projection
			return;
		}

		double a=(dx1*dv2-dx2*dv1)/det;
		double b=(dx2*du1-dx1*du2)/det;
		double c=XA-a*Img_XA-b*Img_YA;

		double d=(dy1*dv2-dy2*dv1)/det;
		double e=(dy2*du1-dy1*du2)/det;
		double f=YA-d*Img_XA-e*Img_YA;

		Tran.setTransform(a,d,b,e,c,f);
	}
		public static AffineTransform Set_Tran(
			double[] Img_X,
			double[] Img_Y,
			int[] SpAc_X,
			int[] SpAc_Y)
		{
			AffineTransform Tran=new AffineTransform();
			Set_Tran(Tran,
				Img_X,Img_Y,
				SpAc_X,SpAc_Y);

			return Tran;
		}
	public static void Set_Tran(AffineTransform Tran,
		double[] Img_X,
		double[] Img_Y,
		Polygon Polygon)
	{
		Set_Tran(Tran,
			Img_X,
			Img_Y,
			Polygon.xpoints,
			Polygon.ypoints);
	}
		public static AffineTransform Set_Tran(
			double[] Img_X,
			double[] Img_Y,
			Polygon Polygon)
		{
			return Set_Tran(
				Img_X,
				Img_Y,
				Polygon.xpoints,
				Polygon.ypoints);
		}

	public static void Aply_Op(Graphics2D Graphcs,BufferedImage Img,BufferedImageOp Op)
	{Graphcs.drawImage(Img,Op,0,0);}
	//<editor-fold desc="IntegrAt">
	public static TImr IntegrAt_TImr=new TImr();
	public static boolean Singl_Colr_Chek=true;
	public static void IntegrAt_Fil_Colr(
		Graphics2D Img_Graphcs,
		Shape ShAp,Color Colr,BufferedImageOp... Opg)
	{
		final long StRt=nanoTime();

		Img_Graphcs.setClip(ShAp);

		RsOrc_Filr.Colr_Filr.Fil_Colr(
			Img_Graphcs,
			Pixl(Colr,Opg));

		ClEr_Clip(Img_Graphcs);

		IntegrAt_TImr.Ad_Inst_(StRt);
	}
	public static void IntegrAt_Fil_Colr(
		Graphics2D Img_Graphcs,
		Shape ShAp,Color Colr,List<BufferedImageOp> Opg)
	{
		final long StRt=nanoTime();

		Img_Graphcs.setClip(ShAp);

		RsOrc_Filr.Colr_Filr.Fil_Colr(
			Img_Graphcs,
			Pixl(Colr,Opg));

		ClEr_Clip(Img_Graphcs);

		IntegrAt_TImr.Ad_Inst_(StRt);
	}
	public static void IntegrAt_Fil_(
		ScrEn Img,Graphics2D Img_Graphcs,
		BufferedImage TMp,Graphics2D TMp_Graphcs,
		Shape ShAp,AffineTransform Tran,Filr Filr,BufferedImageOp... Opg)
	{
		final long StRt=nanoTime();

		Prep(TMp_Graphcs,ShAp);
		Img_Graphcs.setClip(ShAp);

		int LNg=Opg.length;
		if(LNg>0)
		{
			Filr.Fil(Img,TMp_Graphcs,Tran);
			int IndX=0;
			for(;IndX<LNg-1
				;IndX+=1)
			{Aply_Op(TMp_Graphcs,TMp,Opg[IndX]);}
			Aply_Op(Img_Graphcs,TMp,Opg[IndX]);
		}
		else
		{Filr.Fil(Img,Img_Graphcs,Tran);}

		ClEr_Clip(TMp_Graphcs);
		ClEr_Clip(Img_Graphcs);

		IntegrAt_TImr.Ad_Inst_(StRt);
	}
	public static void IntegrAt_Fil_(
		ScrEn Img,Graphics2D Img_Graphcs,
		BufferedImage TMp,Graphics2D TMp_Graphcs,
		Shape ShAp,AffineTransform Tran,Filr Filr,List<BufferedImageOp> Opg)
	{
		final long StRt=nanoTime();

		Prep(TMp_Graphcs,ShAp);
		Img_Graphcs.setClip(ShAp);

		int LNg=Opg.size();
		if(LNg>0)
		{
			Filr.Fil(Img,TMp_Graphcs,Tran);
			int IndX=0;
			for(;IndX<LNg-1
				;IndX+=1)
			{Aply_Op(TMp_Graphcs,TMp,Opg.get(IndX));}
			Aply_Op(Img_Graphcs,TMp,Opg.get(IndX));
		}
		else
		{Filr.Fil(Img,Img_Graphcs,Tran);}

		ClEr_Clip(TMp_Graphcs);
		ClEr_Clip(Img_Graphcs);

		IntegrAt_TImr.Ad_Inst_(StRt);
	}
	public static void IntegrAt_Fil(
		ScrEn Img,Graphics2D Img_Graphcs,
		BufferedImage TMp,Graphics2D TMp_Graphcs,
		Shape ShAp,AffineTransform Tran,Filr Filr,BufferedImageOp... Opg)
	{
		if(
			Singl_Colr_Chek&&
			Filr instanceof Bound_Colr_Filr Colr_Filr)
		{
			IntegrAt_Fil_Colr(
				Img_Graphcs,
				ShAp,Colr_Filr.Get_Colr(),Opg);
		}
		else
		{
			IntegrAt_Fil_(
				Img,Img_Graphcs,
				TMp,TMp_Graphcs,
				ShAp,Tran,Filr,Opg);
		}
	}
	public static void IntegrAt_Fil(
		ScrEn Img,Graphics2D Img_Graphcs,
		BufferedImage TMp,Graphics2D TMp_Graphcs,
		Shape ShAp,AffineTransform Tran,Filr Filr,List<BufferedImageOp> Opg)
	{
		if(
			Singl_Colr_Chek&&
			Filr instanceof Bound_Colr_Filr Colr_Filr)
		{
			IntegrAt_Fil_Colr(
				Img_Graphcs,
				ShAp,Colr_Filr.Get_Colr(),Opg);
		}
		else
		{
			IntegrAt_Fil_(
				Img,Img_Graphcs,
				TMp,TMp_Graphcs,
				ShAp,Tran,Filr,Opg);
		}
	}
	public static void IntegrAt_OutlIn(
		ScrEn Img,Graphics2D Img_Graphcs,
		BufferedImage TMp,Graphics2D TMp_Graphcs,
		Shape ShAp,AffineTransform Tran,Filr Filr,BufferedImageOp... Opg)
	{
		Prep(TMp_Graphcs,ShAp);
		Img_Graphcs.setClip(ShAp);

		if(
			Singl_Colr_Chek&&
			Filr instanceof Bound_Colr_Filr Colr_Filr)
		{
			RsOrc_Filr.Colr_Filr.OutlIn_Colr(
				Img_Graphcs,
				Pixl(Colr_Filr.Get_Colr(),Opg));
			return;
		}
		int LNg=Opg.length;
		if(LNg>0)
		{
			Filr.OutlIn(Img,TMp_Graphcs,Tran);
			int IndX=0;
			for(;IndX<LNg-1
				;IndX+=1)
			{Aply_Op(TMp_Graphcs,TMp,Opg[IndX]);}
			Aply_Op(Img_Graphcs,TMp,Opg[IndX]);
		}
		else
		{Filr.OutlIn(Img,Img_Graphcs,Tran);}

		ClEr_Clip(TMp_Graphcs);
		ClEr_Clip(Img_Graphcs);
	}
	public static void IntegrAt_OutlIn(
		ScrEn Img,Graphics2D Img_Graphcs,
		BufferedImage TMp,Graphics2D TMp_Graphcs,
		Shape ShAp,AffineTransform Tran,Filr Filr,List<BufferedImageOp> Opg)
	{
		Prep(TMp_Graphcs,ShAp);
		Img_Graphcs.setClip(ShAp);

		if(
			Singl_Colr_Chek&&
			Filr instanceof Bound_Colr_Filr Colr_Filr)
		{
			RsOrc_Filr.Colr_Filr.OutlIn_Colr(
				Img_Graphcs,
				Pixl(Colr_Filr.Get_Colr(),Opg));
			return;
		}
		int LNg=Opg.size();
		if(LNg>0)
		{
			Filr.OutlIn(Img,TMp_Graphcs,Tran);
			int IndX=0;
			for(;IndX<LNg-1
				;IndX+=1)
			{Aply_Op(TMp_Graphcs,TMp,Opg.get(IndX));}
			Aply_Op(Img_Graphcs,TMp,Opg.get(IndX));
		}
		else
		{Filr.OutlIn(Img,Img_Graphcs,Tran);}

		ClEr_Clip(TMp_Graphcs);
		ClEr_Clip(Img_Graphcs);
	}
	public static void IntegrAt(boolean Wich,
		ScrEn Img,Graphics2D Img_Graphcs,
		BufferedImage TMp,Graphics2D TMp_Graphcs,
		Shape ShAp,AffineTransform Tran,Filr Filr,BufferedImageOp... Opg)
	{
		if(Wich)
		{
			IntegrAt_OutlIn(
				Img,Img_Graphcs,
				TMp,TMp_Graphcs,
				ShAp,Tran,
				Filr,Opg);
		}
		else
		{
			IntegrAt_Fil(
				Img,Img_Graphcs,
				TMp,TMp_Graphcs,
				ShAp,Tran,
				Filr,Opg);
//			Img.OutlIn(Filr,Img_Graphcs);
		}
	}
	public static void IntegrAt(boolean Wich,
		ScrEn Img,Graphics2D Img_Graphcs,
		BufferedImage TMp,Graphics2D TMp_Graphcs,
		Shape ShAp,AffineTransform Tran,Filr Filr,List<BufferedImageOp> Opg)
	{
		if(Wich)
		{
			IntegrAt_OutlIn(
				Img,Img_Graphcs,
				TMp,TMp_Graphcs,
				ShAp,Tran,
				Filr,Opg);
		}
		else
		{
			IntegrAt_Fil(
				Img,Img_Graphcs,
				TMp,TMp_Graphcs,
				ShAp,Tran,
				Filr,Opg);
//			Img.OutlIn(Filr,Img_Graphcs);
		}
	}
	//</editor-fold>
	public static int Get_Pixl(BufferedImage Img)
	{return Img.getRGB(0,0);}
	public static Color Pixl(Color Colr,BufferedImageOp... Opg)
	{
		int LNg=Opg.length;
		if(LNg>0)
		{
			BufferedImage Img=new BufferedImage(1,1,TYPE_INT_ARGB);
			Graphics2D Graphcs=Img.createGraphics();
			Img.setRGB(0,0,Colr.getRGB());
//			out.println(Get_Pixl(Img));
			int IndX=0;
			do
			{
				Aply_Op(Graphcs,Img,Opg[IndX]);
//				out.println("->"+Get_Pixl(Img));

				IndX+=1;
			}
			while(IndX<LNg);

			return
				New_Colr(Get_Pixl(Img));
//				Color.black;
		}
		else
		{
			return
				Colr;
//				Color.black;
		}
	}
	public static Color Pixl(Color Colr,List<BufferedImageOp> Opg)
	{
		int LNg=Opg.size();
		if(LNg>0)
		{
			BufferedImage Img=new BufferedImage(1,1,TYPE_INT_ARGB);
			Graphics2D Graphcs=Img.createGraphics();
			Img.setRGB(0,0,Colr.getRGB());
//			out.println(Get_Pixl(Img));
			int IndX=0;
			do
			{
				Aply_Op(Graphcs,Img,Opg.get(IndX));
//				out.println("->"+Get_Pixl(Img));

				IndX+=1;
			}
			while(IndX<LNg);

			return
				New_Colr(Get_Pixl(Img));
//				Color.black;
		}
		else
		{
			return
				Colr;
//				Color.black;
		}
	}

//	public static BufferedImage P()
//	{
//		for(int StOr:StOrg)
//		{
////		out.println("Integrate layer");
//
//			Fil_TXtrd(Graphics,Rsorc.Img_StOrg[StOr]);
//		}
//	}

	public static int[] Get_Avrg_Colr(BufferedImage Img)
	{
		long
			R=0,
			G=0,
			B=0;
		int width=Img.getWidth();
		int height=Img.getHeight();
		int Pixl_Num=width*height;
		for(int y=0;
			y<height;
			y+=1)
		{
			for(int x=0;x<width;x++)
			{
				int rgb=Img.getRGB(x,y);
				int red=(rgb>>16)&0xFF;
				int green=(rgb>>8)&0xFF;
				int blue=rgb&0xFF;
				R+=red;
				G+=green;
				B+=blue;
			}
		}

		return new int[]{
			(int)(R/Pixl_Num),
			(int)(G/Pixl_Num),
			(int)(B/Pixl_Num)};
	}
	public static int Is_Blank(BufferedImage image)
	{
		int
			width=image.getWidth(),
			height=image.getHeight(),
			totalPixels=width*height,
			Sum=0;
		for(int y=0;y<height;y++)
		{
			for(int x=0;x<width;x++)
			{Sum+=image.getRGB(x,y);}
		}

		return Sum;
	}
	public static boolean Is_Provbly_No_Blank(BufferedImage Img)
	{
		int
			width=Img.getWidth(),
			height=Img.getHeight(),
			totalPixels=width*height;
		ThreadLocalRandom Shuflr=current();
		for(int y=0;y<totalPixels/64;y++)
		{
			if(Img.getRGB(
				Shuflr.nextInt(width),
				Shuflr.nextInt(height))!=0)
			{return true;}
		}
		return false;
	}
	public static void Img2$1(Graphics2D To,
		BufferedImage A,
		BufferedImage B)
	{
		Set(To,A);
		Fil_TXtrd(To,B);
	}
		public static Runnable Img_Mrgr(Graphics2D To,
			BufferedImage A,
			BufferedImage B)
		{return ()->{Img2$1(To,A,B);};}
	public static void ImgN$1(Graphics2D To,BufferedImage... From)
	{
		for(BufferedImage Img:From)
		{Fil_TXtrd(To,Img);}
	}
	public static void ImgN$1(Graphics2D To,List<BufferedImage> From)
	{
		for(BufferedImage Img:From)
		{Fil_TXtrd(To,Img);}
	}

	public static void Draw_OutlInd_FrAm(
		Graphics2D To,
		BufferedImage Img,Color Bakground,Color FrAm,
		int XB,int XT,
		int YB,int YT)
	{
		To.setColor(Bakground);
		int
			X_LNg=XT-XB,
			Y_LNg=YT-YB;
		To.fillRect(
			XB,YB,
			X_LNg,Y_LNg);
		To.drawImage(Img,
			XB,YB,
			X_LNg,Y_LNg,
			null);
		To.setColor(FrAm);
		To.drawRect(
			XB,YB,
			X_LNg,Y_LNg);
	}

	public static void Draw_PIplIn_LAr(
		Graphics2D To,
		List<BufferedImage> LAr,Color Bakground,Color FrAm,
		int YB,int YT,
		int XB,int XT)
	{
		int
			LAr_LNg=LAr.size(),
			Img_Wid=(XT-XB)/LAr_LNg;
		for(int X=0;
			X<LAr_LNg;
			X+=1)
		{
			BufferedImage Img=LAr.get(X);
			int LFt,Rit;
			switch(1)
			{
				case 0->{
					LFt=X*Img_Wid;
					Rit=LFt+Img_Wid;
				}
				case 1->{
					LFt=X*Img_Wid;
					Rit=(X+1)*LFt+Img_Wid;
				}
				default->{
					LFt=0;
					Rit=0;
				}
			}
			Draw_OutlInd_FrAm(
				To,
				Img,Bakground,FrAm,
				LFt,Rit,
				YB,YT);
			int DialAtn=5;
			if(YB==0)
			{
				Set_ARGB(Img,
					(X*Img_Wid)+DialAtn,
					((X+1)*Img_Wid)-DialAtn,
					YB+DialAtn,
					YT-DialAtn,
					red.getRGB());
			}

//			out.println("Draw "+Bot+"-"+Top+","+LFt+"-"+Rit);
		}
	}
}