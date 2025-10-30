package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.ClEr_Clip;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.ClEr_Tran;
import static java.awt.RenderingHints.KEY_INTERPOLATION;
import static java.awt.RenderingHints.VALUE_INTERPOLATION_BILINEAR;
import static java.lang.Integer.MAX_VALUE;

public interface RsOrc_Filr<Rsorc_Typ>
{
	@Lin_DclAr
	void Fil(
		ScrEn ScrEn,Graphics2D Graphcs,
		Rsorc_Typ Rsorc);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Fil(
			ScrEn ScrEn,Graphics2D Graphcs,
			Shape ShAp,
			Rsorc_Typ Rsorc)
		{
			Graphcs.setClip(ShAp);
			Fil(ScrEn,Graphcs,Rsorc);
			ClEr_Clip(Graphcs);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Fil(
			ScrEn ScrEn,Graphics2D Graphcs,
			AffineTransform Tran,
			Rsorc_Typ Rsorc)
		{
			Graphcs.setTransform(Tran);
			Fil(ScrEn,Graphcs,Rsorc);
			ClEr_Tran(Graphcs);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			default void Fil(
				ScrEn ScrEn,Graphics2D Graphcs,
				Shape ShAp,
				AffineTransform Tran,
				Rsorc_Typ Rsorc)
			{
				Graphcs.setClip(ShAp);
				Fil(ScrEn,Graphcs,Tran,Rsorc);
				ClEr_Clip(Graphcs);
			}
	@Lin_DclAr
	void OutlIn(
		ScrEn ScrEn,Graphics2D Graphcs,
		Rsorc_Typ Rsorc);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void OutlIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			Shape ShAp,
			Rsorc_Typ Rsorc)
		{
			Graphcs.setClip(ShAp);
			OutlIn(ScrEn,Graphcs,Rsorc);
			ClEr_Clip(Graphcs);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void OutlIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			AffineTransform Tran,
			Rsorc_Typ Rsorc)
		{
			Graphcs.setTransform(Tran);
			OutlIn(ScrEn,Graphcs,Rsorc);
			ClEr_Tran(Graphcs);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			default void OutlIn(
				ScrEn ScrEn,Graphics2D Graphcs,
				AffineTransform Tran,Shape ShAp,
				Rsorc_Typ Rsorc)
			{
				Graphcs.setClip(ShAp);
				OutlIn(ScrEn,Graphcs,Tran,Rsorc);
				ClEr_Clip(Graphcs);
			}
	@Lin_DclAr
	void Draw_Pixl(
		ScrEn ScrEn,Graphics2D Graphcs,
		int X,int Y,
		Rsorc_Typ Rsorc);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Draw_Pixl(
			ScrEn ScrEn,Graphics2D Graphcs,
			Shape ShAp,
			int X,int Y,
			Rsorc_Typ Rsorc)
		{
			Graphcs.setClip(ShAp);
			Draw_Pixl(ScrEn,Graphcs,X,Y,Rsorc);
			ClEr_Clip(Graphcs);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Draw_Pixl(
			ScrEn ScrEn,Graphics2D Graphcs,
			AffineTransform Tran,
			int X,int Y,
			Rsorc_Typ Rsorc)
		{
			Graphcs.setTransform(Tran);
			Draw_Pixl(ScrEn,Graphcs,X,Y,Rsorc);
			ClEr_Tran(Graphcs);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			default void Draw_Pixl(
				ScrEn ScrEn,Graphics2D Graphcs,
				Shape ShAp,
				AffineTransform Tran,
				int X,int Y,
				Rsorc_Typ Rsorc)
			{
				Graphcs.setClip(ShAp);
				Draw_Pixl(ScrEn,Graphcs,Tran,X,Y,Rsorc);
				ClEr_Clip(Graphcs);
			}
	@Lin_DclAr
	void Draw_LIn(ScrEn ScrEn,Graphics2D Graphcs,
		int AX,int AY,
		int BX,int BY,
		Rsorc_Typ Rsorc);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Draw_LIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			Shape ShAp,
			int AX,int AY,
			int BX,int BY,
			Rsorc_Typ Rsorc)
		{
			Graphcs.setClip(ShAp);
			Draw_LIn(ScrEn,Graphcs,AX,AY,BX,BY,Rsorc);
			ClEr_Clip(Graphcs);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Draw_LIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			AffineTransform Tran,
			int AX,int AY,
			int BX,int BY,
			Rsorc_Typ Rsorc)
		{
			Graphcs.setTransform(Tran);
			Draw_LIn(ScrEn,Graphcs,AX,AY,BX,BY,Rsorc);
			ClEr_Tran(Graphcs);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			default void Draw_LIn(
				ScrEn ScrEn,Graphics2D Graphcs,
				Shape ShAp,
				AffineTransform Tran,
				int AX,int AY,
				int BX,int BY,
				Rsorc_Typ Rsorc)
			{
				Graphcs.setClip(ShAp);
				Draw_LIn(ScrEn,Graphcs,Tran,AX,AY,BX,BY,Rsorc);
				ClEr_Clip(Graphcs);
			}

	interface Colr_Filr extends RsOrc_Filr<Color>
	{
		static void Fil_Colr(
			Graphics2D Graphcs,
			Color Colr)
		{
			Graphcs.setColor(Colr);
			Graphcs.fillRect(
				0,0,
				MAX_VALUE,MAX_VALUE);
//			Graphcs.fill(Graphcs.getClip());
		}
		static void OutlIn_Colr(
			Graphics2D Graphcs,
			Color Colr)
		{
			Graphcs.setColor(Colr);
			Graphcs.draw(Graphcs.getClip());
//			Graphcs.drawRect(
//				0,0,
//				MAX_VALUE,MAX_VALUE);
		}
		static void LIn_Colr(
			Graphics2D Graphcs,
			int AX,int AY,
			int BX,int BY,
			Color Colr)
		{
			Graphcs.setColor(Colr);
			Graphcs.drawLine(
				AX,AY,
				BX,BY);
		}
		static void Pixl_Colr(
			Graphics2D Graphcs,
			int X,int Y,
			Color Colr)
		{
			LIn_Colr(Graphcs,
				X,Y,
				X,Y,
				Colr);
		}
		@Override
		default void Fil(
			ScrEn ScrEn,Graphics2D Graphcs,
			Color Colr)
		{Fil_Colr(Graphcs,Colr);}
		@Override
		default void OutlIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			Color Colr)
		{OutlIn_Colr(Graphcs,Colr);}
		@Override
		default void Draw_Pixl(
			ScrEn ScrEn,Graphics2D Graphcs,
			int X,int Y,
			Color Colr)
		{Pixl_Colr(Graphcs,X,Y,Colr);}
		@Override
		default void Draw_LIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			int AX,int AY,
			int BX,int BY,
			Color Colr)
		{LIn_Colr(Graphcs,AX,AY,BX,BY,Colr);}

		Colr_Filr Inst=new Colr_Filr()
		{};
	}
	interface Img_Filr extends RsOrc_Filr<BufferedImage>
	{
		static void Fil_TXtrd(
			Graphics2D Graphcs,
			BufferedImage Img)
		{Graphcs.drawImage(Img,0,0,null);}
			static void Fil_TXtrd(
				Graphics2D Graphcs,
				AffineTransform Tran,BufferedImage Img)
			{
				Graphcs.setTransform(Tran);
				Graphcs.setRenderingHint(
					KEY_INTERPOLATION,
					VALUE_INTERPOLATION_BILINEAR);
				Fil_TXtrd(Graphcs,Img);
				ClEr_Tran(Graphcs);
			}
		@Override
		default void Fil(
			ScrEn ScrEn,Graphics2D Graphcs,
			BufferedImage Img)
		{Fil_TXtrd(Graphcs,Img);}
			@Override
			default void Fil(
				ScrEn ScrEn,Graphics2D Graphcs,
				AffineTransform Tran,BufferedImage Img)
			{Fil_TXtrd(Graphcs,Tran,Img);}
		@Override
		default void OutlIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			BufferedImage Img)
		{OutlIn(ScrEn,Graphcs,Img);}
		@Override
		default void Draw_Pixl(
			ScrEn ScrEn,Graphics2D Graphcs,
			int X,int Y,
			BufferedImage Img)
		{}
		@Override
		default void Draw_LIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			int AX,int AY,
			int BX,int BY,
			BufferedImage Img)
		{}

		Img_Filr Inst=new Img_Filr()
		{};
	}

	abstract class Bound_RsOrc_Filr<Rsorc_Typ> implements Filr, RsOrc_Filr<Rsorc_Typ>
	{
		public RsOrc_Filr<Rsorc_Typ> Rapd_Filr;
		public Rsorc_Typ Rsorc;
			@Lin_DclAr
			public Rsorc_Typ Get_RsOrc()
			{return Rsorc;}
			@Lin_DclAr
			public void Set_RsOrc(Rsorc_Typ Rsorc)
			{this.Rsorc=Rsorc;}
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public void Set(RsOrc_Filr<Rsorc_Typ> Filr,Rsorc_Typ Rsorc)
		{
			this.Rapd_Filr=Filr;
			Set_RsOrc(Rsorc);
		}
			@Override @Finishd(Is_Finishd=false)
			public void Fil(ScrEn ScrEn,Graphics2D Graphcs,
				Rsorc_Typ RsOrc)
			{Rapd_Filr.Fil(ScrEn,Graphcs,RsOrc);}
				@Override @Finishd(Is_Finishd=false)
				public void Fil(ScrEn ScrEn,Graphics2D Graphcs)
				{Fil(ScrEn,Graphcs,Rsorc);}
			@Override
			public void OutlIn(
				ScrEn ScrEn,Graphics2D Graphcs,
				Rsorc_Typ Rsorc)
			{Rapd_Filr.Fil(ScrEn,Graphcs,Rsorc);}
				@Override
				public void OutlIn(
					ScrEn ScrEn,Graphics2D Graphcs)
				{Fil(ScrEn,Graphcs,Rsorc);}
			@Override
			public void Draw_Pixl(
				ScrEn ScrEn,Graphics2D Graphcs,
				int X,int Y)
			{Draw_Pixl(ScrEn,Graphcs,X,Y,Rsorc);}
				@Override
				public void Draw_Pixl(
					ScrEn ScrEn,Graphics2D Graphcs,
					int X,int Y,
					Rsorc_Typ Rsorc)
				{Rapd_Filr.Draw_Pixl(ScrEn,Graphcs,X,Y,Rsorc);}
			@Override
			public void Draw_LIn(
				ScrEn ScrEn,Graphics2D Graphcs,
				int AX,int AY,
				int BX,int BY,
				Rsorc_Typ Rsorc)
			{Rapd_Filr.Draw_LIn(ScrEn,Graphcs,AX,AY,BX,BY,Rsorc);}
				@Override
				public void Draw_LIn(
					ScrEn ScrEn,Graphics2D Graphcs,
					int AX,int AY,
					int BX,int BY)
				{Draw_LIn(ScrEn,Graphcs,AX,AY,BX,BY,Rsorc);}

		public Bound_RsOrc_Filr(
			RsOrc_Filr<Rsorc_Typ> Rapd_Filr,
			Rsorc_Typ Rsorc)
		{Set(Rapd_Filr,Rsorc);}
	}
}