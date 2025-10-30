package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.Gar_Filr;

@Finishd(Is_Finishd=true)
public interface Filr_Havr
{
	@Lin_DclAr @Finishd(Is_Finishd=true)
	Filr Get_Filr();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_Filr(Filr Filr);
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default void Set_Filr(Object SOrc)
		{Set_Filr(Gar_Filr(SOrc));}
}