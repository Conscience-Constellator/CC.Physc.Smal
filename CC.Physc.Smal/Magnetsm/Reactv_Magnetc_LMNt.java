package CC.Encycloped.Abs.Scal.Physc.Magnetsm;

import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag;
import CC.$.Q$Q.Dubl1$1;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;

public class Reactv_Magnetc_LMNt extends Magnetsm_SOrc
{
	public double Stim;
	public void Get_Puld(double[] Dr,double Mag)
	{
		super.Get_Puld(Dr,Mag);
		StrNgth+=Mag*Stim;
	}

	@Override
	public void Tik()
	{StrNgth*=.1;}

	public Reactv_Magnetc_LMNt(SpAc_Object Parnt,Object Loc_Sorc,
		double Stim,LOc$Dr_Mag Loc$Dr_Mag,Dubl1$1 ScAl,int Is_Efectbl)
	{
		super(
			Parnt,Loc_Sorc,
			0,Loc$Dr_Mag,ScAl,Is_Efectbl);
		this.Stim=Stim;
	}
}