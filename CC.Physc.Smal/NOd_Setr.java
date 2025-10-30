package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

public abstract class NOd_Setr<NOd_Typ extends NOd_Object>
{
	@Lin_DclAr
	public abstract void Set_NOd(NOd_Typ NOd);
}