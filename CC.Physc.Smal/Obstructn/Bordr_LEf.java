package CC.Encycloped.Abs.Scal.Physc.Obstructn;

import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;

import static CC.UI.ConsOl.Print;

public class Bordr_LEf implements Out_Box_Getbl
{
	@Override
	public int Get_Dim_Num()
	{return 3;}

	public LOc_Obstructr Obstructr;
	public double[]
		Loc,
		Box;
			@Override
			public void Get_Bordr_Out_Box_StRt(double[] Box)
			{Out_Box_Getbl.UpdAt_Out_Box_StRt(Box,this.Box);}
			@Override
			public void Get_Bordr_Out_Box(double[] Box)
			{Out_Box_Getbl.UpdAt_Out_Box(Box,this.Box);}
	public void Set(LOc_Obstructr Obstructr,
		double[] LOc,
		double[] Box)
	{
		this.Obstructr=Obstructr;
			this.Loc=LOc;
			this.Box=Box;
	}
		public void Set(LOc_Obstructr Obstructr)
		{
			Set(Obstructr,
				Obstructr.Get_LOc_CoP_As_ArA(),
				Obstructr.Get_Bordr_Out_Box_StRt());
		}

	public Bordr_LEf(LOc_Obstructr LEf,
		double[] LOc,double[] Box)
	{Set(LEf,LOc,Box);}
		public Bordr_LEf(LOc_Obstructr LEf)
		{Set(LEf);}
}