package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Gom.Projectr.Projectr_Rapr;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Ocupier;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom.Atom_Projectn;
import java.util.List;

public interface Cam<Atom_Typ extends Drawbl_Atom<Projectn_Typ>,Projectn_Typ extends Atom_Projectn>
	extends Physc_LMNt,SpAc_Ocupier<Physc_SpAc>,Projectr_Rapr
{
	@Override
	default void	 Ad_To_SpAc(Physc_SpAc SpAc)
	{
		Physc_LMNt.super.Ad_To_SpAc(SpAc);
		for(Atom_Typ Atom:(List<Atom_Typ>)SpAc.Get_Physc_Atomg_Cast("SEn"))
		{Ad_Drawbl(Atom);}
	}
	@Override
	default void Rmov_From_SpAc(Physc_SpAc SpAc)
	{
		Physc_LMNt.super.Rmov_From_SpAc(SpAc);
		Get_Drawblg().clear();
	}

	@Override
	default String Get_Physc_KE()
	{return "SEs";}

	@Lin_DclAr
	List<Projectn_Typ> Get_Drawblg();
		@Lin_DclAr
		default void Ad_Drawbl(Atom_Typ Atom)
		{Get_Drawblg().add(Atom.MAk_Projectn());}
		@Lin_DclAr
		default void Rmov_Drawbl(Atom_Typ Atom)
		{
			List<Projectn_Typ> Drawblg=Get_Drawblg();
			for(int IndX=0;
				IndX<Drawblg.size();
				IndX+=1)
			{
				Projectn_Typ Projectn=Drawblg.get(IndX);
				if(Projectn.Get_Projectd()==Atom)
				{Drawblg.remove(Projectn);}
			}
		}
}