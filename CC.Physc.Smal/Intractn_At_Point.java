package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;

@Finishd(Is_Finishd=true)
public interface Intractn_At_Point
{
	@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	void Intract(Drawbl_Atom Atom);
}