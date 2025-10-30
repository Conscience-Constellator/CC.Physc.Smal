package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Physc.SIt.Projectbl.Projectn;
import static CC.List.ArA_X.New_Inst;

@Finishd(Is_Finishd=true)
public interface Projectbl<
	Projectn_Typ extends Projectn> extends Efectg_Havr
{
	@Lin_DclAr @Finishd(Is_Finishd=true)
	Projectn_Typ MAk_Projectn();
		@Finishd(Is_Finishd=true)
		static <
			Projectbl_Typ extends Projectbl<Projectn_Typ>,
			Projectn_Typ  extends Projectn<Projectbl_Typ>>void
		MAk_Projectng(
			Projectbl_Typ[] Projectblg,
			Projectn_Typ[] Projectng)
		{
			for(int IndX=0;
				IndX<Projectng.length;
				IndX+=1)
			{Projectng[IndX]=Projectblg[IndX].MAk_Projectn();}
		}
			@Finishd(Is_Finishd=true)
			static <
				Projectbl_Typ extends Projectbl<Projectn_Typ>,
				Projectn_Typ  extends Projectn<Projectbl_Typ>>Projectn_Typ[]
			MAk_Projectng(
				Projectbl_Typ[] Projectblg,
				Class<Projectn_Typ> Projectn_Typ)
			{
				Projectn_Typ[] Projectng=New_Inst(Projectn_Typ,Projectblg.length);
				MAk_Projectng(Projectblg,Projectng);

				return Projectng;
			}

	@Finishd(Is_Finishd=true)
	interface Projectn<Projectd_Typ extends Projectbl> extends Efectg_Havr
	{
		@Lin_DclAr @Finishd(Is_Finishd=true)
		Projectd_Typ Get_Projectd();
		@Lin_DclAr @Finishd(Is_Finishd=true)
		void Set_Projectd(Projectd_Typ Projectd);

		//<editor-fold desc="Distnc">
		@Lin_DclAr @Finishd(Is_Finishd=true)
		double Get_Distnc();
		@Lin_DclAr @Finishd(Is_Finishd=true)
		void Set_Distnc(double Distnc);
		//</editor-fold>
	}
}