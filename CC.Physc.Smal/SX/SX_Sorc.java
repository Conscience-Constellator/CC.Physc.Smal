package CC.Encycloped.Abs.Scal.Physc.SX;

import CC.$.Q$Q.Dubl1$1;
import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Atractr;

public class SX_Sorc extends Atractr
{
	@Override
	public String Get_Physc_KE()
	{return "SX";}

	public SX_Sorc(RL_LOc_Havr Parnt,Object Loc_Sorc,
		double StrNgth,LOc$Dr_Mag Loc$Dr_Mag,Dubl1$1 ScAl)
	{super(Parnt,Loc_Sorc,StrNgth,Loc$Dr_Mag,ScAl);}
}