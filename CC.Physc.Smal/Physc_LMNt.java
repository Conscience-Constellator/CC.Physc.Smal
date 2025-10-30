package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Adbl;
import CC.Encycloped.TIm.Tikbl;

public interface Physc_LMNt extends
	   SpAc_Adbl<Physc_SpAc>,Tikbl
{
	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
	String Get_Physc_KE();

	@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
	default void	 Ad_To_SpAc(Physc_SpAc SpAc)
	{SpAc.Ad_Physc_LMNt(this);}
	@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
	default void Rmov_From_SpAc(Physc_SpAc SpAc)
	{SpAc.Rmov_Physc_LMNt(this);}

	@Lin_DclAr
	default <Physc_Typ extends Physc_LMNt>Physc_Typ Get_Sistr_Physc(String Physc)
	{
		return (Physc_Typ)((SpAc_Object)((RL_LOc_Havr)this).Get_Gom_PArnt()).Get_Physc_LMNt(Physc);
	}

	abstract class Physc_LMNt_ConcrEt
		implements Physc_LMNt
	{
		public Physc_LMNt_ConcrEt()
		{}
	}
}