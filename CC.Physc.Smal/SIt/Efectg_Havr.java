package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;

import static CC.COd.Neds_Ovrid.*;

import java.awt.image.BufferedImageOp;
import java.util.List;

public interface Efectg_Havr
		 extends   Filr_Havr
{
	@Lin_DclAr
	List<Efect> Get_Efectg();
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default void Ad_Efect(Efect Efect)
		{Get_Efectg().add(Efect);}
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		default void Rmov_Efect(Efect Efect)
		{Get_Efectg().remove(Efect);}
	@Lin_DclAr
	default void Ad_Opg(List<BufferedImageOp> List,Drawbl_Atom.Atom_Projectn Projectn)
	{
//		List<BufferedImageOp> Projectd_List=Projectn.;
		Efect.Ad_Opg_From_Efectg(List,Projectn,Get_Efectg());
	}
}