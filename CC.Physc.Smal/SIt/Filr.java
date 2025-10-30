package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import DDDTutorial_Modd.D2.Bound_Colr_Filr;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import CC.$.Q$Q.Int1$1;
import java.awt.*;
import java.awt.geom.AffineTransform;

public interface Filr
{
	@Lin_DclAr
	void Fil(ScrEn ScrEn,Graphics2D Graphcs);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Fil(
			ScrEn ScrEn,Graphics2D Graphcs,
			Shape ShAp)
		{
			Graphcs.setClip(ShAp);
			Fil(ScrEn,Graphcs);
			ClEr_Clip(Graphcs);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Fil(
			ScrEn ScrEn,Graphics2D Graphcs,
			AffineTransform Tran)
		{
			Graphcs.setTransform(Tran);
			Fil(ScrEn,Graphcs);
			ClEr_Tran(Graphcs);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			default void Fil(
				ScrEn ScrEn,Graphics2D Graphcs,
				Shape ShAp,AffineTransform Tran)
			{
				Graphcs.setClip(ShAp);
				Fil(ScrEn,Graphcs,Tran);
				ClEr_Clip(Graphcs);
			}
	@Lin_DclAr
	void OutlIn(ScrEn ScrEn,Graphics2D Graphcs);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void OutlIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			Shape ShAp)
		{
			Graphcs.setClip(ShAp);
			OutlIn(ScrEn,Graphcs);
			ClEr_Clip(Graphcs);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void OutlIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			AffineTransform Tran)
		{
			Graphcs.setTransform(Tran);
			OutlIn(ScrEn,Graphcs);
			ClEr_Tran(Graphcs);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			default void OutlIn(
				ScrEn ScrEn,Graphics2D Graphcs,
				AffineTransform Tran,Shape ShAp)
			{
				Graphcs.setClip(ShAp);
				OutlIn(ScrEn,Graphcs,Tran);
				ClEr_Clip(Graphcs);
			}
	@Lin_DclAr
	void Draw_Pixl(ScrEn ScrEn,Graphics2D Graphcs,
		int X,int Y);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Draw_Pixl(
			ScrEn ScrEn,Graphics2D Graphcs,
			Shape ShAp,
			int X,int Y)
		{
			Graphcs.setClip(ShAp);
			Draw_Pixl(ScrEn,Graphcs,X,Y);
			ClEr_Clip(Graphcs);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Draw_Pixl(
			ScrEn ScrEn,Graphics2D Graphcs,
			AffineTransform Tran,
			int X,int Y)
		{
			Graphcs.setTransform(Tran);
			Draw_Pixl(ScrEn,Graphcs,X,Y);
			ClEr_Tran(Graphcs);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			default void Draw_Pixl(
				ScrEn ScrEn,Graphics2D Graphcs,
				Shape ShAp,
				AffineTransform Tran,
				int X,int Y)
			{
				Graphcs.setClip(ShAp);
				Draw_Pixl(ScrEn,Graphcs,Tran,X,Y);
				ClEr_Clip(Graphcs);
			}
	@Lin_DclAr
	void Draw_LIn(ScrEn ScrEn,Graphics2D Graphcs,
		int AX,int AY,
		int BX,int BY);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Draw_LIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			Shape ShAp,
			int AX,int AY,
			int BX,int BY)
		{
			Graphcs.setClip(ShAp);
			Draw_LIn(ScrEn,Graphcs,AX,AY,BX,BY);
			ClEr_Clip(Graphcs);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Draw_LIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			AffineTransform Tran,
			int AX,int AY,
			int BX,int BY)
		{
			Graphcs.setTransform(Tran);
			Draw_LIn(ScrEn,Graphcs,AX,AY,BX,BY);
			ClEr_Tran(Graphcs);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			default void Draw_LIn(
				ScrEn ScrEn,Graphics2D Graphcs,
				Shape ShAp,
				AffineTransform Tran,
				int AX,int AY,
				int BX,int BY)
			{
				Graphcs.setClip(ShAp);
				Draw_LIn(ScrEn,Graphcs,Tran,AX,AY,BX,BY);
				ClEr_Clip(Graphcs);
			}

	@Lin_DclAr
	void Mod(Int1$1 Mod);

	@Lin_DclAr @Finishd(Is_Finishd=true)
	boolean NEds_Prev_Data();

	@Finishd(Is_Finishd=false)
	static Filr Gar_Filr(Object SOrc)
	{
		return //Nul_Chek(
			(SOrc instanceof Filr Filr)?Filr:
			(SOrc instanceof Color Colr)?new Bound_Colr_Filr(Colr):
			(SOrc instanceof Integer Colr)?new Bound_Colr_Filr(Colr):
			null
		//)
		;
	}

	Filr No_Filr=new Filr(){
		@Override @Finishd(Is_Finishd=false)
		public void Fil(
			ScrEn ScrEn,Graphics2D Graphcs)
		{}
		@Override @Finishd(Is_Finishd=false)
		public void OutlIn(
			ScrEn ScrEn,Graphics2D Graphcs)
		{}
		@Override @Finishd(Is_Finishd=false)
		public void Draw_Pixl(
			ScrEn ScrEn,Graphics2D Graphcs,
			int X,int Y)
		{}
		@Override @Finishd(Is_Finishd=false)
		public void Draw_LIn(
			ScrEn ScrEn,Graphics2D Graphcs,
			int AX,int AY,
			int BX,int BY)
		{}
		@Override @Finishd(Is_Finishd=false)
		public void Mod(Int1$1 Mod)
		{}

		@Override @Finishd(Is_Finishd=false)
		public boolean NEds_Prev_Data()
		{return false;}
	};

	@Finishd(Is_Finishd=false)
	static void ClEr_Clip(Graphics2D Graphcs)
	{Graphcs.setClip(null);}

	AffineTransform Blank_Tran=new AffineTransform();
	static void ClEr_Tran(Graphics2D Graphcs)
	{Graphcs.setTransform(Blank_Tran);}

	static void Trip(Graphics2D Graphcs,AffineTransform Tran,Shape ShAp)
	{
		Graphcs.setClip(ShAp);
		Graphcs.setTransform(Tran);
	}
		static void Trip(Graphics2D Graphcs,AffineTransform Tran)
		{Trip(Graphcs,Tran,null);}
		static void Trip(Graphics2D Graphcs,Shape ShAp)
		{Trip(Graphcs,Blank_Tran,ShAp);}
			static void Trip(Graphics2D Graphcs)
			{Trip(Graphcs,(Shape)null);}

	class Bound_Filr implements Runnable
	{
		public Filr Rapd_Filr;
			public ScrEn ScrEn;
			public Graphics2D To;
				@Lin_DclAr
				public void UpdAt_To(Graphics2D To)
				{this.To=To;}

		@Override
		public void run()
		{Rapd_Filr.Fil(ScrEn,To);}

		public Bound_Filr(Filr Rapd,ScrEn ScrEn,Graphics2D To)
		{
			Rapd_Filr=Rapd;
			this.ScrEn=ScrEn;
			UpdAt_To(To);
		}
	}
}