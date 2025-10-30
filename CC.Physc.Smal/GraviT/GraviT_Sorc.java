package CC.Encycloped.Abs.Scal.Physc.GraviT;

import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.$.Q$Q.Dubl1$1;
import CC.Encycloped.Abs.Scal.Physc.Atractr;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import java.util.List;
import static CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr.Get_LOc_ArAg;

public class GraviT_Sorc extends Atractr
{
	@Override
	public String Get_Physc_KE()
	{return "GraviT_Sorc";}

	public static void Aply_GraviT(
		List<GraviT_Sorc> SOrcg,
		List<Tik_Tran> Efectblg)
	{
//		out.println(SOrcg.size()+","+Efectblg.size());

		double[]
			From=new double[3],
			Dr=new double[3];
		double[][] Tog=RL_LOc_Havr.Get_LOc_ArAg(SOrcg);
		for(int Efectbl_IndX=0;
			Efectbl_IndX<Efectblg.size();
			Efectbl_IndX+=1)
		{
			Tik_Tran Tran=Efectblg.get(Efectbl_IndX);
			Tran.Get_Object().Get_LOc_CoP_As_ArA(From);
			for(int Efectr_IndX=0;
				Efectr_IndX<Tog.length;
				Efectr_IndX+=1)
			{
				double Atractn=SOrcg.get(Efectr_IndX).CalculAt_Pul(
					From,
					Tog[Efectr_IndX],
					Dr);
				Tran.AccLrAt(Dr,Atractn);
			}
		}
	}

	public GraviT_Sorc(RL_LOc_Havr Parnt,Object Loc_Sorc,
		double StrNgth,LOc$Dr_Mag Loc$Dr_Mag,Dubl1$1 ScAl)
	{super(Parnt,Loc_Sorc,StrNgth,Loc$Dr_Mag,ScAl);}
}