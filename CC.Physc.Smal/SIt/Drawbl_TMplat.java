package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.Box_Havr;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.LOcg_TMplat;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_TMplat.Drawbl_TMplat_Projectn;
import CC.Encycloped.Abs.Scal.Physc.SIt.TMplatd_Atom.TMplatd_Projectn;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public interface Drawbl_TMplat<
	Projectn_Typ extends Drawbl_TMplat_Projectn>
	extends LOcg_TMplat,Projectbl<Projectn_Typ>
{
	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
	int Get_LOc_Num();

	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=false)
	void Get_Box(double[] Box,LOcg_Havr Locg);
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default double[] Get_Box(LOcg_Havr Locg)
		{
			double[] Box=new double[6];
			Get_Box(Box,Locg);

			return Box;
		}
	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
	boolean Is_In(int X,int Y,
				  TMplatd_Projectn<?,?,? extends Projectn_Typ> Projectn);
	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=false)
	default boolean Is_In(int X,int Y,
						  LOcg_Havr Projectn)
	{return false;}

	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
	void Draw_Projectn(ScrEn ScrEn,Graphics2D Graphcs,
					   TMplatd_Projectn<?,?,? extends Projectn_Typ> Projectn);

	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
	void UpdAt_Projectn(ScrEn ScrEn,
						TMplatd_Projectn<?,?,? extends Projectn_Typ> Projectn);

	@Finishd(Is_Finishd=true)
	abstract class Drawbl_TMplat_ConcrEt<Projectn_Typ extends Drawbl_TMplat_Projectn>
		implements Drawbl_TMplat		<Projectn_Typ>
	{
		@Finishd(Is_Finishd=true)
		private Filr Filr;
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final Filr Get_Filr()
			{return Filr;}
			@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
			public void Set_Filr(Filr Filr)
			{this.Filr=Filr;}
		@Finishd(Is_Finishd=true)
		private List<Efect> Opg=new ArrayList<>();
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final List<Efect> Get_Efectg()
			{return Opg;}

		@Finishd(Is_Finishd=true)
		public Drawbl_TMplat_ConcrEt(Object Filr_SOrc)
		{Set_Filr(Filr_SOrc);}
	}
	abstract class Drawbl_TMplat_Projectn<TMplat_Typ extends Drawbl_TMplat>
		implements Projectn<TMplat_Typ>,Out_Box_Getbl,Box_Havr
	{
		@Finishd(Is_Finishd=true)
		public TMplat_Typ TMplat;
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public TMplat_Typ Get_Projectd()
			{return TMplat;}
			@Lin_DclAr @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
			public void Set_Projectd(TMplat_Typ TMplat)
			{this.TMplat=TMplat;}

		/*Filr*/
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public Filr Get_Filr()
			{return Get_Projectd().Get_Filr();}
			@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
			public void Set_Filr(Filr Filr)
			{Get_Projectd().Set_Filr(Filr);}
		@Finishd(Is_Finishd=true)
		private List<Efect> Opg=new ArrayList<>();
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final List<Efect> Get_Efectg()
			{return Opg;}

		@Finishd(Is_Finishd=false)
		private Trand_Inbl ShAp;
			@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public Trand_Inbl Get_ShAp()
			{return ShAp;}
		@Finishd(Is_Finishd=true)
		private double[] Box;
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final double[] Get_Box()
			{return Box;}
			@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=false)
			public void Get_Box(double[] Box,LOcg_Havr Locg)
			{TMplat.Get_Box(Box,Locg);}
		//<editor-fold desc="Distnc">
		@Finishd(Is_Finishd=true)
		private double Distnc;
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public final double Get_Distnc()
		{return Distnc;}
		@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=false)
		public		   void Set_Distnc(double Distnc)
		{this.Distnc=Distnc;}
		//</editor-fold>

		public Drawbl_TMplat_Projectn(TMplat_Typ TMplat)
		{Set_Projectd(TMplat);}
	}
}