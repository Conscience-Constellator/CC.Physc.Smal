package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_Atom;
import DDDTutorial_Modd.D2.D2_Drawbl_Atom;
import DDDTutorial_Modd.D2.D2_Projectn;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon.D2_Polygon;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.Avrg_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.Box_Havr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom.Atom_Projectn;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;
import static CC.COd.Shudnt_B_Cald_X.Soft;
import static CC.List.ArA_X.New_Inst;
import static CC.Math.Math_Plus.CNtr;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.New_Colr;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.ShAd;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Img.IntegrAt;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Img.Litng;

public interface Drawbl_Atom<Projectn_Typ extends Atom_Projectn> extends
				  Physc_Atom,
				 Out_Box_Getbl,Box_Havr,
				 Avrg_LOc_Havr,Projectbl<Projectn_Typ>,
	Filr_Havr
{
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	default Physc_SpAc Get_SpAc()
	{return Get_Parnt().Get_SpAc();}

	@Lin_DclAr @Finishd(Is_Finishd=true)
	Polyhedron Get_Parnt();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_Parnt(Polyhedron Parnt);

	@Finishd(Is_Finishd=true)
	String Physc_KE="SEn";
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default String Get_Physc_KE()
		{return Physc_KE;}

	@Lin_DclAr @Finishd(Is_Finishd=false)
	default void UpdAt()
	{}
		@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=false)
		default void Tik()
		{UpdAt();}
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void UpdAt_Projectn(ScrEn ScrEn,
		Projectn_Typ Projectn);
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Draw_Projectn(ScrEn ScrEn,Graphics2D Graphcs,
		Projectn_Typ Projectn);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default void Try_Draw(ScrEn ScrEn,Graphics2D Graphcs,
			Projectn_Typ Projectn)
		{
			if(Projectn.Do_Draw())
			{
				ScrEn.Drawn+=1;
				Draw_Projectn(ScrEn,Graphcs,Projectn);
			}
			else
			{
				ScrEn.Undrawn+=1;
			}
		}

	//<editor-fold desc="Litng">
	@Lin_DclAr @Finishd(Is_Finishd=true)
	double Get_LItng_R();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_Litng_R(double R);
	@Lin_DclAr @Finishd(Is_Finishd=true)
	double Get_LItng_G();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_Litng_G(double G);
	@Lin_DclAr @Finishd(Is_Finishd=true)
	double Get_LItng_B();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_Litng_B(double B);
	@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	default void Set_Litng_RGB(double R,double G,double B)
	{
		Set_Litng_R(R);
		Set_Litng_G(G);
		Set_Litng_B(B);
	}
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default RescaleOp Get_Litng()
		{
			return Litng(
				(float)Get_LItng_R(),
				(float)Get_LItng_G(),
				(float)Get_LItng_B());
		}
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default void ClEr_Litng()
		{Set_Litng_RGB(0,0,0);}
	@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	default void IluminAt(
		double R,
		double G,
		double B)
	{
		Set_Litng_RGB(
			Get_LItng_R()+R,
			Get_LItng_G()+G,
			Get_LItng_B()+B);
	}
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default void IluminAt(
			double R,
			double G,
			double B,
			double Britns)
		{IluminAt(
			R*Britns,
			G*Britns,
			B*Britns);
		}
//	@Lin_DclAr @Finishd(Is_Finishd=false)
//	default void CalculAt_Litng(Physc_SpAc SpAc)
//	{}
//		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
//		default void CalculAt_LItng()
//		{CalculAt_LItng(Get_SpAc());}
	/**Applies lighting of this Atom to {@code Colr}.*/
	@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	default Color LIt_Colr(Color Colr)
	{
		return New_Colr(ShAd(Colr.getRGB(),
			Get_LItng_R(),
			Get_LItng_G(),
			Get_LItng_B()));
	}
	@Lin_DclAr @Finishd(Is_Finishd=false)
	default void UpdAt_LItng(Physc_SpAc SpAc)
	{}
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default void UpdAt_LItng()
		{UpdAt_LItng(Get_SpAc());}
	//</editor-fold>

	@Lin_DclAr @Finishd(Is_Finishd=true)
	boolean Get_Is_Transparnt();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_Is_Transparnt(boolean Is);

	@Lin_DclAr @Finishd(Is_Finishd=true)
	boolean Get_Is_Visbl();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_Is_Visbl(boolean Is);

	@Lin_DclAr @Finishd(Is_Finishd=true)
	boolean Get_Is_TRgetbl();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_Is_TRgetbl(boolean Is);

		@Finishd(Is_Finishd=true)
		static <
			Atom_Typ extends Drawbl_Atom,Projectn_Typ extends Atom_Projectn<Atom_Typ>
			>Projectn_Typ[] MAk_Projectng(
				Projectn_Typ[] Projectng,Atom_Typ... Atomg)
		{
			for(int IndX=0;
					IndX<Projectng.length;
					IndX+=1)
			{
				Projectng[IndX]=
					(Projectn_Typ)Atomg[IndX].MAk_Projectn();
			}

			return Projectng;
		}
			@Finishd(Is_Finishd=true)
			static <Atom_Typ extends Drawbl_Atom,Projectn_Typ extends Atom_Projectn<Atom_Typ>>
			Projectn_Typ[] MAk_Projectng(Class<Projectn_Typ> Projectn_Typ,Atom_Typ... Atomg)
			{
				Projectn_Typ[] Projectng=New_Inst(Projectn_Typ,Atomg.length);
				MAk_Projectng(Projectng,Atomg);

				return Projectng;
			}

	abstract class Drawbl_Atom_ConcrEt<Projectn_Typ extends Atom_Projectn>
		implements Drawbl_Atom<Projectn_Typ>
	{
		@Finishd(Is_Finishd=true)
		private Polyhedron Parnt;
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final Polyhedron Get_Parnt()
			{return Parnt;}
			@Override @Finishd(Is_Finishd=true)
			public void Set_Parnt(Polyhedron Parnt)
			{this.Parnt=Parnt;}

		private final double[] Box=new double[6];
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public double[] Get_Box()
			{return Box;}

		private List<Efect> Opg=new ArrayList<>();
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final List<Efect> Get_Efectg()
			{return Opg;}
		//<editor-fold desc="Litng">
		private double
			Litng_R=1,
			Litng_G=1,
			Litng_B=1;
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final double Get_LItng_R()
			{return Litng_R;}
			@Override @Finishd(Is_Finishd=true)
			public void Set_Litng_R(double R)
			{Litng_R=R;}
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final double Get_LItng_G()
			{return Litng_G;}
			@Override @Finishd(Is_Finishd=true)
			public void Set_Litng_G(double G)
			{Litng_G=G;}
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final double Get_LItng_B()
			{return Litng_B;}
			@Override @Finishd(Is_Finishd=true)
			public void Set_Litng_B(double B)
			{Litng_B=B;}
		//</editor-fold>

		private boolean
			Is_Transparnt,
			Is_Visbl=true,
			Is_TRgetbl=true;
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final boolean Get_Is_Transparnt()
			{return Is_Transparnt;}
			@Override @Finishd(Is_Finishd=true)
			public void Set_Is_Transparnt(boolean Is)
			{Is_Transparnt=Is;}
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final boolean Get_Is_Visbl()
			{return Is_Visbl;}
			@Override @Finishd(Is_Finishd=true)
			public void Set_Is_Visbl(boolean Is)
			{Is_Visbl=Is;}
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final boolean Get_Is_TRgetbl()
			{return Is_TRgetbl;}
			@Override @Finishd(Is_Finishd=true)
			public void Set_Is_TRgetbl(boolean Is)
			{Is_TRgetbl=Is;}

		public Drawbl_Atom_ConcrEt(boolean Is_Visbl)
		{Set_Is_Visbl(Is_Visbl);}
			public Drawbl_Atom_ConcrEt()
			{this(true);}
	}

	interface Atom_Projectn<Atom_Typ extends Drawbl_Atom>
		extends Projectn<Atom_Typ>,D2_Drawbl_Atom<D2_Projectn>,Out_Box_Getbl
	{
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default Polyhedron Get_Parnt()
		{return Get_Projectd().Get_Parnt();}
		@Override @Finishd(Is_Finishd=true)
		default void Set_Parnt(Polyhedron Parnt)
		{Get_Projectd().Set_Parnt(Parnt);}

		@Override @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
		Atom_Typ Get_Projectd();
		@Override @Finishd(Is_Finishd=false)
		void Set_Projectd(Atom_Typ Atom);

		//<editor-fold desc="Filr">
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			default Filr Get_Filr()
			{return Get_Projectd().Get_Filr();}
			@Override @Finishd(Is_Finishd=true)
			default void Set_Filr(Filr Filr)
			{Get_Projectd().Set_Filr(Filr);}
		//</editor-fold>
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default void Ad_Opg(List<BufferedImageOp> List,Atom_Projectn Projectn)
		{
			Get_Projectd().Ad_Opg(List,Projectn);
			D2_Drawbl_Atom.super.Ad_Opg(List,Projectn);
		}

		//<editor-fold desc="ShAp">
		@Lin_DclAr
		Trand_Inbl Get_ShAp();
		//<editor-fold desc="Box">
		@Lin_DclAr
		default void UpdAt_Box()
		{CalculAt_Box(Get_Box());}
			@Finishd(Is_Finishd=true)
			static <Atom_Typ extends Atom_Projectn>void UpdAt_Boxg(
				Atom_Typ[] Atomg,
				int Num)
			{
				for(int IndX=0;
					IndX<Num;
					IndX+=1)
				{Atomg[IndX].UpdAt_Box();}
			}
			@Finishd(Is_Finishd=true)
			static <Atom_Typ extends Atom_Projectn>void UpdAt_Boxg(
				List<Atom_Typ> Atomg,
				int Num)
			{
				for(int IndX=0;
					IndX<Num;
					IndX+=1)
				{Atomg.get(IndX).UpdAt_Box();}
			}
		@Lin_DclAr @Finishd(Is_Finishd=false)
		default void CalculAt_Box(double[] Box)
		{Get_ShAp().Get_Bordr_Out_Box_StRt(Box);}
			@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=false)
			default void UpdAt_Box_()
			{
				double[] Box=Get_Box();
				CalculAt_Box(Box);
				Set_Distnc(CNtr(Box[4],Box[5]));
			}
		//</editor-fold>
		//</editor-fold>

		//<editor-fold desc="TRget">
		@Override @Finishd(Is_Finishd=true)
		default boolean Get_Is_TRgetbl()
		{return Get_Projectd().Get_Is_TRgetbl();}
		@Override @Finishd(Is_Finishd=false)
		default void Set_Is_TRgetbl(boolean Is)
		{Get_Projectd().Set_Is_TRgetbl(Is);}
		//</editor-fold>

		//<editor-fold desc="Litng">
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default double Get_LItng_R()
		{return Get_Projectd().Get_LItng_R();}
		@Override @Finishd(Is_Finishd=true)
		default void Set_Litng_R(double R)
		{Get_Projectd().Set_Litng_R(R);}
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default double Get_LItng_G()
		{return Get_Projectd().Get_LItng_R();}
		@Override @Finishd(Is_Finishd=true)
		default void Set_Litng_G(double G)
		{Get_Projectd().Set_Litng_G(G);}
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default double Get_LItng_B()
		{return Get_Projectd().Get_LItng_B();}
		@Override @Finishd(Is_Finishd=true)
		default void Set_Litng_B(double B)
		{Get_Projectd().Set_Litng_B(B);}
		//</editor-fold>

		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default boolean Get_Is_Transparnt()
		{return Get_Projectd().Get_Is_Transparnt();}
		@Override @Finishd(Is_Finishd=true)
		default void Set_Is_Transparnt(boolean Is)
		{Get_Projectd().Set_Is_Transparnt(Is);}

		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default boolean Get_Is_Visbl()
		{return Get_Projectd().Get_Is_Visbl();}
		@Override @Finishd(Is_Finishd=true)
		default void Set_Is_Visbl(boolean Is)
		{Get_Projectd().Set_Is_Visbl(Is);}

		@Lin_DclAr @Finishd(Is_Finishd=true)
		boolean Do_Draw();
		@Lin_DclAr @Finishd(Is_Finishd=true)
		void Set_Do_Draw(boolean Do);

		//<editor-fold desc="Draw">
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default void Draw(ScrEn ScrEn,Graphics2D Graphcs)
		{Get_Projectd().Draw_Projectn(ScrEn,Graphcs,this);}
		@Override @Finishd(Is_Finishd=false)
		default void Draw_Projectn(ScrEn ScrEn,Graphics2D Graphcs,
			D2_Projectn Projectn)
		{
			Soft();

			Get_Projectd().Try_Draw(ScrEn,Graphcs,Projectn);
		}
		//</editor-fold>

		//<editor-fold desc="UpdAt">
		@Lin_DclAr @Finishd(Is_Finishd=true)
		void UpdAt_New();
		@Override @Finishd(Is_Finishd=true)
		default void UpdAt_Drawbl(ScrEn ScrEn)
		{Get_Projectd().UpdAt_Projectn(ScrEn,this);}
			@Finishd(Is_Finishd=true)
			static <Projectn_Typ extends Atom_Projectn>void UpdAt_Loop(ScrEn ScrEn,Projectn_Typ... Projectng)
			{
				for(Atom_Projectn Projectn:Projectng)
				{Projectn.UpdAt_Drawbl(ScrEn);}
			}
		@Override @Finishd(Is_Finishd=false)
		default void UpdAt_Projectn(ScrEn ScrEn,
			D2_Projectn Projectn)
		{}
		//</editor-fold>

		@Override @Finishd(Is_Finishd=false)
		default D2_Projectn MAk_Projectn()
		{return null;}

		abstract class Atom_Projectn_ConcrEt<
			Atom_Typ extends Drawbl_Atom>
			implements Atom_Projectn<Atom_Typ>
		{
			private Atom_Typ Atom;
				@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
				public final Atom_Typ Get_Projectd()
				{return Atom;}
				@Override @Finishd(Is_Finishd=false)
				public void Set_Projectd(Atom_Typ Atom)
				{
					this.Atom=Atom;
					UpdAt_New();
				}

			private Trand_Inbl ShAp;
				@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
				public Trand_Inbl Get_ShAp()
				{return ShAp;}
			private double[] Box=new double[6];
				@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
				public final double[] Get_Box()
				{return Box;}

			@Override @Finishd(Is_Finishd=true)
			public void Get_Avrg_LOc(double[] LOc)
			{Get_Projectd().Get_Avrg_LOc(LOc);}
			//<editor-fold desc="Distnc">
			private double Distnc;
				@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
				public final double Get_Distnc()
				{return Distnc;}
				@Override @Finishd(Is_Finishd=true)
				public void Set_Distnc(double Distnc)
				{this.Distnc=Distnc;}
			//</editor-fold>

			private List<Efect> Opg=new ArrayList<>();
				@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
				public List<Efect> Get_Efectg()
				{return Opg;}
			private boolean Do_Draw;
				@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
				public boolean Get_Do_Draw()
				{return Do_Draw;}
				@Override @Finishd(Is_Finishd=true)
				public void Set_Do_Draw(boolean Do)
				{Do_Draw=Do;}
				@Override @Finishd(Is_Finishd=false)
				public boolean Do_Draw()
				{
					return
						Get_Do_Draw()&&
						Get_Projectd().Get_Is_Visbl();
				}

			@Finishd(Is_Finishd=true)
			public Atom_Projectn_ConcrEt(Atom_Typ Atom)
			{Set_Projectd(Atom);}
		}
	}

	//<editor-fold desc="Draw_ShAp">
	@Finishd(Is_Finishd=false)
	static void Draw_ShAp(ScrEn ScrEn,Graphics Graphcs,
		Shape ShAp,AffineTransform Tran,boolean Is_Transparnt,Filr Filr,BufferedImageOp... Opg)
	{
//		int A=Colr.getAlpha();
//		if(A==0)
//		{return;}

//		if(Is_Rvrs!=Do_Rvrs)
//		{Rvrs();}

//		ScrEn.OutlIn(D3.Get_Filr(),ScrEn.Img_StOr1_Graphcs);
		Draw_RsOrc Rsorc=ScrEn.Draw_Rsorc;
		int StOr=Rsorc.Get_Avalbl_StOr();
		try
		{
			IntegrAt(Is_Transparnt,
				ScrEn,(Graphics2D)Graphcs,
				Rsorc.Img_StOrg[StOr],Rsorc.Img_StOrg_Graphcs[StOr],
				ShAp,Tran,Filr,Opg);
		}
		catch(Exception X)
		{X.printStackTrace();}
		Rsorc.FrE_StOr(StOr);
	}
	@Finishd(Is_Finishd=false)
	static void Draw_ShAp(ScrEn ScrEn,Graphics Graphcs,
		Shape ShAp,AffineTransform Tran,boolean Is_Transparnt,Filr Filr,List<BufferedImageOp> Opg)
	{
//		int A=Colr.getAlpha();
//		if(A==0)
//		{return;}

//		if(Is_Rvrs!=Do_Rvrs)
//		{Rvrs();}

//		ScrEn.OutlIn(D3.Get_Filr(),ScrEn.Img_StOr1_Graphcs);
		Draw_RsOrc Rsorc=ScrEn.Draw_Rsorc;
		int StOr=Rsorc.Get_Avalbl_StOr();
		try
		{
			IntegrAt(Is_Transparnt,
				ScrEn,(Graphics2D)Graphcs,
				Rsorc.Img_StOrg[StOr],Rsorc.Img_StOrg_Graphcs[StOr],
				ShAp,Tran,Filr,Opg);
		}
		catch(Exception X)
		{X.printStackTrace();}
		Rsorc.FrE_StOr(StOr);
	}
		@Finishd(Is_Finishd=false)
		static void Draw_ShAp(ScrEn ScrEn,Graphics Graphcs,
			Shape ShAp,D2_Polygon Projectn,Filr Filr,BufferedImageOp... Opg)
		{Draw_ShAp(ScrEn,Graphcs,
			ShAp,Projectn.Tran,Projectn.Get_Is_Transparnt(),Filr,Opg);
		}
		@Finishd(Is_Finishd=false)
		static void Draw_ShAp(ScrEn ScrEn,Graphics Graphcs,
			Shape ShAp,D2_Polygon Projectn,Filr Filr,List<BufferedImageOp> Opg)
		{Draw_ShAp(ScrEn,Graphcs,
			ShAp,Projectn.Tran,Projectn.Get_Is_Transparnt(),Filr,Opg);
		}
	//</editor-fold>
}