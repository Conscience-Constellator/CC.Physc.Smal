package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D3.Drawbl_LOcg_Usr;
import DDDTutorial_Modd.D3.Fild_Area.Fild_Area_ConcrEt;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon;

public abstract class Drawbl_Polygon<
	Projectn_Typ extends Polygon_Projectn,Polygon_Typ extends D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>
	extends Fild_Area_ConcrEt<Projectn_Typ>
	implements Drawbl_LOcg_Usr<Polygon_Typ,Projectn_Typ>
{
	public Drawbl_Polygon()
	{}
	public Drawbl_Polygon(Polygon_Typ Polygon,
		Object Filr_SOrc,boolean Is_Visbl)
	{
		super(Filr_SOrc,Is_Visbl);
		Set_Rapd_LOcg(Polygon);
	}
		@Finishd(Is_Finishd=true)
		public Drawbl_Polygon(Polygon_Typ Polygon,
			Object Filr_SOrc)
		{this(Polygon,Filr_SOrc,true);}
}