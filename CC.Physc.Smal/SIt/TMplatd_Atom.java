package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.TIm.UpdAtbl;
import DDDTutorial_Modd.D3.Drawbl_LOcg_Usr.Drawbl_LOcg_Usr_ConcrEt;
import DDDTutorial_Modd.D3.Drawbl_LOcg_Usr.Drawbl_LOcg_Usr_Projectn.Drawbl_LOcg_Usr_Projectn_ConcrEt;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Inst;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_TMplat.Drawbl_TMplat_Projectn;
import CC.Encycloped.Abs.Scal.Physc.SIt.TMplatd_Atom.TMplatd_Projectn;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;

import java.awt.*;
import java.awt.image.BufferedImageOp;
import java.util.List;

public    abstract class TMplatd_Atom<
	Projectn_Typ extends TMplatd_Projectn<?,TMplat_Typ,TMplat_Projectn_Typ>,
		TMplat_Typ extends Drawbl_TMplat<TMplat_Projectn_Typ>,
		TMplat_Projectn_Typ extends Drawbl_TMplat.Drawbl_TMplat_Projectn<TMplat_Typ>>
	extends Drawbl_LOcg_Usr_ConcrEt<LOcg_Havr<Physc_SpAc>,Projectn_Typ>
	implements Drawbl_Atom<Projectn_Typ>,LOcg_Inst<TMplat_Typ,Physc_SpAc,LOcg_Havr<Physc_SpAc>>,UpdAtbl
{
	@Finishd(Is_Finishd=true)
	private TMplat_Typ TMplat;
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public final TMplat_Typ Get_TMplat()
		{return TMplat;}
		@Override @Finishd(Is_Finishd=true)
		public void Set_TMplat(TMplat_Typ TMplat)
		{this.TMplat=TMplat;}

		@Override @Finishd(Is_Finishd=false)
		public void Get_Avrg_LOc(double[] LOc)
		{Get_Rapd_LOcg().Get_Avrg_LOc(LOc);}
//		@Override
//		public void Get_Box_CoP(double[] Box)
//		{Get_TMplat().Get_Box(Box,Get_Locg());}

	@Override @Finishd(Is_Finishd=false)
	public Filr Get_Filr()
	{return null;}
	@Override @Finishd(Is_Finishd=false)
	public void Set_Filr(Filr Filr)
	{}
		@Override @Finishd(Is_Finishd=false)
		public void Ad_Opg(List<BufferedImageOp> List,Atom_Projectn Projectn)
		{
			Get_TMplat().Ad_Opg(List,Projectn);
			super.Ad_Opg(List,Projectn);
		}

		@Override @Finishd(Is_Finishd=true)
		public void Draw_Projectn(ScrEn ScrEn,Graphics2D Graphcs,
			Projectn_Typ Projectn)
		{Get_TMplat().Draw_Projectn(ScrEn,Graphcs,Projectn);}

		@Override @Finishd(Is_Finishd=false)
		public void UpdAt()
		{
//			Get_TMplat().UpdAt_Drawbl(Locg);
		}
		@Override @Finishd(Is_Finishd=false)
		public void UpdAt_Projectn(ScrEn ScrEn,
			Projectn_Typ Projectn)
		{
			super.UpdAt_Projectn(ScrEn,Projectn);
			Get_TMplat().UpdAt_Projectn(ScrEn,Projectn);
		}

	@Finishd(Is_Finishd=true)
	public TMplatd_Atom(TMplat_Typ TMplat,LOcg_Havr LOcg,
		boolean Is_Visbl)
	{
		super(LOcg,Is_Visbl);
		Set_TMplat(TMplat);
	}
		@Finishd(Is_Finishd=true)
		public TMplatd_Atom(TMplat_Typ TMplat_Typ,LOcg_Havr Locg)
		{this(TMplat_Typ,Locg,true);}

	public static abstract class TMplatd_Projectn<
				   Atom_Typ extends TMplatd_Atom<? extends TMplatd_Projectn,TMplat_Typ,TMplat_Projectn_Typ>,
				 TMplat_Typ extends Drawbl_TMplat<TMplat_Projectn_Typ>,
		TMplat_Projectn_Typ extends Drawbl_TMplat_Projectn<TMplat_Typ>>
		extends	   Drawbl_LOcg_Usr_Projectn_ConcrEt<LOcg_Havr<Physc_SpAc>,Atom_Typ>
		implements LOcg_Inst<TMplat_Typ,Physc_SpAc, LOcg_Havr<Physc_SpAc>>,
		Atom_Projectn<Atom_Typ>
	{
		@Override @Finishd(Is_Finishd=true)
		public void Set_Projectd(Atom_Typ Atom)
		{
			super.Set_Projectd(Atom);
			Set_TMplat_Projectn(Get_TMplat().MAk_Projectn());
			Set_Rapd_LOcg(Atom.Get_Rapd_LOcg().Get_LOcg_CoP());
		}

		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public final TMplat_Typ Get_TMplat()
		{return Get_Projectd().Get_TMplat();}
		@Override @Finishd(Is_Finishd=true)
		public void Set_TMplat(TMplat_Typ TMplat)
		{Get_Projectd().Set_TMplat(TMplat);}

		private TMplat_Projectn_Typ TMplat_Projectn;
			@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final TMplat_Projectn_Typ Get_TMplat_Projectn()
			{return TMplat_Projectn;}
			@Lin_DclAr @Finishd(Is_Finishd=true)
			public void Set_TMplat_Projectn(TMplat_Projectn_Typ Projectn)
			{TMplat_Projectn=Projectn;}
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final Trand_Inbl Get_ShAp()
			{return Get_TMplat_Projectn().Get_ShAp();}
		/*Box*/
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final void Get_Bordr_Out_Box_StRt(double[] Box)
			{Get_TMplat_Projectn().Get_Bordr_Out_Box_StRt(Box);}
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final void Get_Bordr_Out_Box(double[] Box)
			{Get_TMplat_Projectn().Get_Bordr_Out_Box(Box);}
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public final boolean Is_In(int X,int Y)
		{return Get_TMplat().Is_In(X,Y,Get_Rapd_LOcg());}

		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public final List<Efect> Get_Efectg()
		{return Get_TMplat_Projectn().Get_Efectg();}

		@Override @Finishd(Is_Finishd=false)
		public void UpdAt_New()
		{}

		@Finishd(Is_Finishd=true)
		public TMplatd_Projectn(Atom_Typ Atom)
		{super(Atom);}
	}
}