package CC.Encycloped.Abs.Scal.Physc.Magnetsm;

import CC.COd.Finishd;

import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag;
import CC.$.Q$Q.Dubl1$1;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Atractr;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import java.util.List;
import static CC.Encycloped.Abs.Scal.Gom.Gom.CalculAt_SimilariT;
import static CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr.Get_LOc_ArAg;

public class Magnetsm_SOrc extends Atractr
{
	public Tik_Tran Tran;

	public static final String Magnetsm_SOrc_KE="Magnetsm_SOrc";
		@Override @Finishd(Is_Finishd=true)
		public String Get_Physc_KE()
		{return Magnetsm_SOrc_KE;}

//	@Override
//	public void CalculAt_Pul()
//	{}
	public int Is_Efectbl;
		public void Set_Is_Efectbl(int Is_Efectbl)
		{
			if(this.Is_Efectbl!=0)
			{
				if(Is_Efectbl!=0)
				{Get_SpAc().Ad_Sortd_Object(this,"Magnetsm_Efectbl");}
			}
			else if(Is_Efectbl==0)
			{Get_SpAc().Rmov_Sortd_Object(this,"Magnetsm_Efectbl");}
			this.Is_Efectbl=Is_Efectbl;
		}
	public void Get_Puld(double[] Dr,double Mag)
	{
		if(Tran!=null)
		{Tran.AccLrAt(Dr,Mag*Is_Efectbl);}
	}
	public static void Aply_Magnetsm(
		List<Magnetsm_SOrc> Efectrg,
		List<Magnetsm_SOrc> Efectblg)
	{
//		out.println(Efectrg.size()+","+Efectblg.size());

		double[]
			Efectr_Loc,
			Efectbl_Loc,
			Efectr_Dr=new double[3],
			Efectbl_Dr=new double[3];
		double[][]
			Efectbl_Locg=RL_LOc_Havr.Get_LOc_ArAg(Efectblg),
			Efectr_Locg=RL_LOc_Havr.Get_LOc_ArAg(Efectrg);
		Magnetsm_SOrc
			Efectr,
			Efectbl;
		for(int Efectbl_IndX=0;
			Efectbl_IndX<Efectblg.size();
			Efectbl_IndX+=1)
		{
			Efectbl=Efectblg.get(Efectbl_IndX);
			Efectbl_Loc=Efectbl_Locg[Efectbl_IndX];
			for(int Efectr_IndX=0;
				Efectr_IndX<Efectr_Locg.length;
				Efectr_IndX+=1)
			{
				Efectr=Efectrg.get(Efectr_IndX);
				Efectr_Loc=Efectr_Locg[Efectr_IndX];
				double
					Efectr_Pul=(Efectr.CalculAt_Pul(
						Efectbl_Loc,
						Efectr_Loc,
						Efectbl_Dr)*2)-1,
					Efectbl_Pul=(Efectbl.CalculAt_Pul(
						Efectr_Loc,
						Efectbl_Loc,
						Efectr_Dr)*2)-1;
				double SimilariT=CalculAt_SimilariT(
					Efectbl_Dr,
					Efectr_Dr);
				Efectbl.Get_Puld(Efectbl_Dr,
					Efectr_Pul*SimilariT);
				Efectr.Get_Puld(Efectr_Dr,
					Efectbl_Pul*SimilariT);
			}
		}
	}

	@Override
	public void Tik()
	{}

	public Magnetsm_SOrc(SpAc_Object Parnt,Object LOc_SOrc,
		double StrNgth,LOc$Dr_Mag Loc$Dr_Mag,Dubl1$1 ScAl,int Is_Efectbl)
	{
		super(Parnt,LOc_SOrc,StrNgth,Loc$Dr_Mag,ScAl);
		this.Tran=(Tik_Tran)Parnt.Get_Physc_LMNt("Tran");
		Set_Is_Efectbl(Is_Efectbl);
	}
}