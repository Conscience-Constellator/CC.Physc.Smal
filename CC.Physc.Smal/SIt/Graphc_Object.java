package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Ocupier.SpAc_Ocupier_Imp;

public class Graphc_Object extends SpAc_Ocupier_Imp<Physc_SpAc>
  implements Graphc_LMNt
{
	@Override
	public void Tik()
	{}

	public Graphc_Object(RL_LOc_Havr Parnt,Object LOc)
	{super(Parnt,LOc);}
}