package CC.Encycloped.Abs.Scal.Physc.Obstructn;

import java.util.List;
import static CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl.Get_Out_Box_Of_List_StRt;

import static CC.UI.ConsOl.Print;

public class Oct_NOd
{
	public static void Oct_Sort(
		List<LOc_Obstructr> List,
		Bordr_NOd Groupg,
		double[] Box)
	{
		Groupg.Set_Box(Box);
		for(int Object_IndX=0;
			Object_IndX<List.size();
			Object_IndX+=1)
		{Groupg.Insrt(new Bordr_LEf(List.get(Object_IndX)));}
	}
	public static Bordr_NOd Oct_Group(
		List<LOc_Obstructr> List,
		int Group_Cbrt)
	{
		double[] Box=Get_Out_Box_Of_List_StRt(List);
		Bordr_NOd NOd=new Bordr_NOd();
		Oct_Sort(
			List,
			NOd,
			Box);

		return NOd;
	}
}