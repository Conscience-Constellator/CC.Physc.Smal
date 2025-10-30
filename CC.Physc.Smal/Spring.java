package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Physc.Physc_LMNt.Physc_LMNt_ConcrEt;
import static CC.Math.Arithmetc.Invrt;
import static CC.Encycloped.Abs.Scal.Gom.Gom.CalculAt_Metrcg_BtwEn;

public class Spring extends Physc_LMNt_ConcrEt
{
	@Override
	public Physc_SpAc Get_SpAc()
	{return A.Get_SpAc();}

	@Override
	public String Get_Physc_KE()
	{return "Spring";}

	public SpAc_Object<Physc_SpAc> A,B;
		public double StrNgth,Pref_Distnc;

	public static double CalculAt_Atractn(
		double Pref,double StrNgth,double BtwEn)
	{return (BtwEn!=0)?
		StrNgth*(BtwEn-Pref):
		0;
	}
		@Lin_DclAr
		public double Pul(
			double[] From,
			double[] To,
			double[] Dr)
		{
			return CalculAt_Atractn(StrNgth,Pref_Distnc,
				   CalculAt_Metrcg_BtwEn(From,To,Dr));
		}
	@Override
	public void Tik()
	{
		Tik_Tran
			A_Tran=(Tik_Tran)A.Get_Physc_LMNt("Tran"),
			B_Tran=(Tik_Tran)B.Get_Physc_LMNt("Tran");
		double[] Dr=new double[3];
		double Atractn=Pul(
			B.Get_LOc_CoP_As_ArA(),
			A.Get_LOc_CoP_As_ArA(),
		Dr);
		boolean
			Is_A_Movbl=A_Tran!=null,
			Is_B_Movbl=B_Tran!=null;
		if(
			Is_A_Movbl&&
			Is_B_Movbl)
		{Atractn/=2;}
		if(Is_B_Movbl)
		{B_Tran.AccLrAt(Dr,Atractn);}
		if(Is_A_Movbl)
		{
			Invrt(Dr);
			A_Tran.AccLrAt(Dr,Atractn);
		}
	}

	public Spring(SpAc_Object A,SpAc_Object B,double StrNgth,double Pref_Distnc)
	{
		this.A=A;
		this.B=B;
		this.StrNgth=StrNgth;
		this.Pref_Distnc=Pref_Distnc;
	}
}