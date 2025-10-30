package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.Bordr_Havr;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl_Rapr.Trand_Inbl_Rapr_ConcrEt;

public abstract class Bordr_Physc<Rapd_Inbl_Typ extends Trand_Inbl<Physc_SpAc,?>>
	extends Trand_Inbl_Rapr_ConcrEt<Physc_SpAc,Rapd_Inbl_Typ>
	implements Physc_LMNt,Bordr_Havr<Physc_SpAc,Rapd_Inbl_Typ>
{
	String Colisn="Colisn";
	@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
	public void   Ad_To_SpAc(Physc_SpAc SpAc)
	{
		Physc_LMNt.super.Ad_To_SpAc(SpAc);
		SpAc.Ad_Sortd_Item(Get_Rapd_Inbl(),Colisn);
	}
	@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
	public void Rmov_From_SpAc(Physc_SpAc SpAc)
	{
		Physc_LMNt.super.Ad_To_SpAc(SpAc);
		SpAc.Rmov_Sortd_Item(Get_Rapd_Inbl(),Colisn);
	}

	@Finishd(Is_Finishd=true)
	public Bordr_Physc(Rapd_Inbl_Typ Rapd)
	{super(Rapd);}
}