package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Ocupier.SpAc_Ocupier_Imp;
import CC.$.Q$Q.Dubl1$1;
import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag;

public abstract class Atractr
	extends SpAc_Ocupier_Imp<Physc_SpAc>
	implements Physc_LMNt
{
	public double StrNgth;
		public LOc$Dr_Mag Loc$Dr_Mag;
		public Dubl1$1 ScAl;

	@Lin_DclAr @Neds_Ovrid(NEds=Nutrl) @Finishd(Is_Finishd=false)
	public double CalculAt_Pul(
		double[] LOc,
		double[] Dr)
	{return StrNgth*
		ScAl.Dubl1$1(
			Loc$Dr_Mag.Loc$Dr_Mag(LOc,Dr));
	}
		@Lin_DclAr
		public double CalculAt_Pul(
			double[] From,
			double[] To,
			double[] Dr)
		{return StrNgth*
			ScAl.Dubl1$1(
				Loc$Dr_Mag.CalculAt_Metrcg_BtwEn(From,To,Dr));
		}

	@Override
	public void Tik()
	{}

	public Atractr(RL_LOc_Havr Parnt,Object LOc_SOrc,
		double StrNgth,LOc$Dr_Mag Loc$Dr_Mag,Dubl1$1 ScAl)
	{
		super(Parnt,LOc_SOrc);
		this.StrNgth=StrNgth;
		this.Loc$Dr_Mag=Loc$Dr_Mag;
		this.ScAl=ScAl;
	}
}