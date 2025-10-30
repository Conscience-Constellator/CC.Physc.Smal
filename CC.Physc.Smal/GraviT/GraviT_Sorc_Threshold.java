package CC.Encycloped.Abs.Scal.Physc.GraviT;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Hyp;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Invrs_SqAr;
import static CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag.Hyp;

public class GraviT_Sorc_Threshold
	extends GraviT_Sorc
{
	public double Altitud;
		@Override
		public double CalculAt_Pul(
			double[] From,
			double[] To,
			double[] Dr)
		{
			double Pul=super.CalculAt_Pul(From,To,Dr);
			return (Hyp(From,To)<Altitud)?
				Pul:
				-Pul;
		}

	public GraviT_Sorc_Threshold(RL_LOc_Havr Parnt,Object Loc_Sorc,
		double StrNgth,double Altitud)
	{
		super(Parnt,Loc_Sorc,StrNgth,Hyp,Invrs_SqAr);
		this.Altitud=Altitud;
	}
}