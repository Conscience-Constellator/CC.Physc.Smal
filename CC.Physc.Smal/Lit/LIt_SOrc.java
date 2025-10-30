package CC.Encycloped.Abs.Scal.Physc.Lit;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Physc.Colr.Colr_Havr;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr.RL_LOc_Havr_ConcrEt;
import CC.Encycloped.Abs.Scal.Physc.Physc_LMNt;
import java.awt.*;
import java.util.List;
import static CC.Math.SIn.UnsIn;
import static CC.Encycloped.Abs.Scal.Gom.Gom.*;
import static java.lang.Math.max;

public class LIt_SOrc
	extends RL_LOc_Havr_ConcrEt<Physc_SpAc>
	implements Physc_LMNt,Colr_Havr
{
	@Finishd(Is_Finishd=true)
	public static final String Physc_KE="LIt_SOrc";
		@Override @Neds_Ovrid(NEds=Nutrl) @Finishd(Is_Finishd=false)
		public String Get_Physc_KE()
		{return Physc_KE;}

	public Color Colr;
		public double R,G,B,A;
		@Override @Neds_Ovrid(NEds=No)
		public Color Get_Colr()
		{return Colr;}
		@Override
		public void Set_Colr(Color Colr)
		{
			this.Colr=Colr;
			R=Colr.getRed()*A;
			G=Colr.getGreen()*A;
			B=Colr.getBlue()*A;
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public void Set_Colr(Color Colr,double Britnes)
			{
				this.A=Britnes;
				Set_Colr(Colr);
			}

	@Lin_DclAr
	public void IluminAt(Drawbl_D3_Polygon<?> Atom,double[] Dr)
	{
		double
			BtwEn=CalculAt_Metrcg_BtwEn(
				Get_LOc_CoP_As_ArA(),
				Atom.Get_Avrg_LOc(),
				Dr),
			ValU=UnsIn((CalculAt_Opositn(
				Atom.CoP_FAc_Norml(),
				Dr)*2)-1);
			BtwEn=ValU*Invrs_SqAr(BtwEn);

		Atom.IluminAt(
			R*BtwEn,
			G*BtwEn,
			B*BtwEn);
	}
		public static void IluminAt(Drawbl_D3_Polygon Atom,double[] Dr,LIt_SOrc... Sorcg)
		{
			for(LIt_SOrc Sorc:Sorcg)
			{Sorc.IluminAt(Atom,Dr);}
		}
		public static void IluminAt(Drawbl_D3_Polygon Atom,double[] Dr,List<LIt_SOrc> Sorcg)
		{
			for(int IndX=0;
				IndX<Sorcg.size();
				IndX+=1)
			{
				LIt_SOrc Sorc=Sorcg.get(IndX);
				Sorc.IluminAt(Atom,Dr);
			}
		}

	@Override
	public void Tik()
	{}

	public LIt_SOrc(RL_LOc_Havr Parnt,Object LOc_SOrc,
		Color Colr,double Britnes)
	{
		super(Parnt,LOc_SOrc);
		Set_Colr(Colr,Britnes);
	}
}