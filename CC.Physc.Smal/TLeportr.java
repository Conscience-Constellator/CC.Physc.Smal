package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;

import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl_Rapr.Trand_Inbl_Rapr_ConcrEt;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.$.$Q.$Point;
import java.util.List;

public class TLeportr extends Trand_Inbl_Rapr_ConcrEt<Physc_SpAc,Trand_Inbl<Physc_SpAc,?>> implements Physc_LMNt
{
	@Override
	public Physc_SpAc Get_SpAc()
	{return Get_Rapd_Inbl().Get_SpAc();}

	@Finishd(Is_Finishd=true)
	public static String Physc_KE="TLeportr";
		@Override
		public String Get_Physc_KE()
		{return Physc_KE;}

	public $Point<double[]> DStinatn_Sorc;
	public void TLeport(RL_LOc_Havr Object)
	{Object.UpdAt_LOc(DStinatn_Sorc.$Point());}
	public void TLeport_Chek(RL_LOc_Havr Object)
	{
		if(Is_In(Object.Get_LOc_CoP_As_ArA()))
		{TLeport(Object);}
	}
		public static void TLeport_Chek(List<TLeportr> TLeportrg,List<RL_LOc_Havr> Objectg)
		{
			for(int TLeportE_IndX =0;
					TLeportE_IndX<Objectg.size();
					TLeportE_IndX+=1)
			{
				RL_LOc_Havr Object=Objectg.get(TLeportE_IndX);
				for(TLeportr TLeportr:TLeportrg)
				{TLeportr.TLeport_Chek(Object);}
			}
		}

	@Override
	public void Tik()
	{}

	public TLeportr($Point<double[]> DStinatn_Sorc,Trand_Inbl Bordr)
	{
		super(Bordr);
		this.DStinatn_Sorc=DStinatn_Sorc;
	}
		public TLeportr(double[] DStinatn,Trand_Inbl Bordr)
		{this(()->{return DStinatn;},Bordr);}
		public TLeportr(RL_LOc_Havr DStinatn,Trand_Inbl Bordr)
		{this(DStinatn::Get_LOc_CoP_As_ArA,Bordr);}
}