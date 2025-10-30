package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;

import CC.$.Q$Q.Dubl1$1;
import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;

public class Colr_SOrc extends Atractr
{
	@Override @Finishd(Is_Finishd=false)
	public String Get_Physc_KE()
	{return "Colr";}

	@Finishd(Is_Finishd=false)
	public Colr_SOrc(RL_LOc_Havr Parnt,Object LOc_SOrc,
		double StrNgth,LOc$Dr_Mag LOc$Dr_Mag,Dubl1$1 ScAl)
	{super(Parnt,LOc_SOrc,
		StrNgth,LOc$Dr_Mag,ScAl);
	}
}