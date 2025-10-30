package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import java.util.Map;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.QOt;

import static java.lang.System.out;

public interface Physcg_Havr<Physc_Typ>
{
	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
	Physc_Typ Get_Physc_LMNt(String Physc);
		@Lin_DclAr @Neds_Ovrid(NEds=Neds_Ovrid.No) @Finishd(Is_Finishd=false)
		default <Physc_Typ_Specfc>Physc_Typ_Specfc Get_Physc_LMNt_Cast(String Physc)
		{return (Physc_Typ_Specfc)Get_Physc_LMNt(Physc);}

	interface Physc_Map_Havr<Physc_Typ>
	  extends Physcg_Havr	<Physc_Typ>
	{
		@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
		Map<String,Physc_Typ> Get_Physcg();
		@Lin_DclAr
		void Set_Physcg(Map<String,Physc_Typ> Physcg);
			@Lin_DclAr
			default boolean Has_Physc_LMNt(String KE)
			{return Get_Physcg().containsKey(KE);}
			@Override @Neds_Ovrid(NEds=Neds_Ovrid.No)
			default Physc_Typ Get_Physc_LMNt(String KE)
			{
				try{return
//					Nul_Chek(
						Get_Physcg().get(KE)
//					)
				;}
				catch(NullPointerException X)
				{
					out.println("No Physc_LMNt of type "+QOt(KE));
					throw X;
				}
			}
	}
	class Physc_Map_Havr_ConcrEt<Physc_Typ>
		implements Physc_Map_Havr<Physc_Typ>
	{
		public Map<String,Physc_Typ> Physcg;
			@Override @Neds_Ovrid(NEds=Neds_Ovrid.No)
			public Map<String,Physc_Typ> Get_Physcg()
			{return Physcg;}
			@Override
			public void Set_Physcg(Map<String,Physc_Typ> Physcg)
			{this.Physcg=Physcg;}

		public Physc_Map_Havr_ConcrEt(Map<String,Physc_Typ> Physcg)
		{Set_Physcg(Physcg);}
	}
}