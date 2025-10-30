package CC.Encycloped.Abs.Scal.Physc.Lit;

import CC.COd.Lin_DclAr;

import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import java.awt.*;
import static CC.Encycloped.Abs.Scal.Gom.Gom.*;

public class LIt_SOrc_Dr extends LIt_SOrc
{
	public double[] Dr;
	@Lin_DclAr
	public void IluminAt(Drawbl_D3_Polygon<?> Atom,double[] Dr)
	{
		double Opositn=CalculAt_Opositn(
			Atom.CoP_FAc_Norml(),
			this.Dr);

		Atom.IluminAt(
			R*Opositn,
			G*Opositn,
			B*Opositn);
	}

	public LIt_SOrc_Dr(RL_LOc_Havr Parnt,Object Loc_Sorc,Color Colr,double Britnes,double[] Dr)
	{
		super(Parnt,Loc_Sorc,Colr,Britnes);
		this.Dr=Dr;
	}
}