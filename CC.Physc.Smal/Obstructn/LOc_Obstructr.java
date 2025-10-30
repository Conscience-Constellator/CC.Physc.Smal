package CC.Encycloped.Abs.Scal.Physc.Obstructn;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.LOc$Dr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.*;
import static CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl.Is_In_;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Gom.Handlr;
import CC.Encycloped.Abs.Scal.Physc.Bordr_Physc;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import java.util.ArrayList;
import java.util.List;
import static CC.Encycloped.Abs.Scal.Gom.Handlr.Gar_Handlr;
import static CC.Encycloped.Abs.Scal.Gom.Handlr.MAk_Pushr;

public class LOc_Obstructr<Rapd_Inbl_Typ extends Trand_Inbl<Physc_SpAc,?>>
	   extends Bordr_Physc<Rapd_Inbl_Typ>
{
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=false)
	public Physc_SpAc Get_SpAc()
	{return Get_Rapd_Inbl().Get_SpAc();}

	public static final String LOc_Obstructr_KE="LOc_Obstructr";
		@Override @Finishd(Is_Finishd=true)
		public String Get_Physc_KE()
		{return LOc_Obstructr_KE;}

	@Finishd(Is_Finishd=false)
	public static List<LOc_Obstructr> Get_Ing(List<LOc_Obstructr> List,double[] LOc)
	{
		List<LOc_Obstructr> Ing=new ArrayList<>();
		for(int IndX=0;
				IndX<List.size();
				IndX+=1)
		{
			LOc_Obstructr Bordr=List.get(IndX);
				if(Bordr.Is_In(LOc))
				{Ing.add(Bordr);}
		}

		return Ing;
	}
	public LOc$Dr Norml_SOrc;
	@Lin_DclAr @Finishd(Is_Finishd=false)
	public void Get_Norml(RL_LOc_Havr Loc,double[] Dr)
	{Norml_SOrc.LOc$Dr(Loc.Get_LOc_CoP_As_ArA(),Dr);}
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public double[] Get_Norml(RL_LOc_Havr Loc)
		{return Norml_SOrc.LOc$Dr(Loc.Get_LOc_CoP_As_ArA());}

	public Handlr In_Handlr;
		@Lin_DclAr @Finishd(Is_Finishd=true)
		public void Set_In_Handlr(Handlr Handlr)
		{In_Handlr=Handlr;}
	@Lin_DclAr @Finishd(Is_Finishd=false)
	public void Aply(
		Tik_Tran Tran,
		double[] Loc,
		double[] StOr)
	{
//		out.println("Loc:"+Arrays.toString(Loc));
		if(Is_In(Loc))
		{
//			out.println("Is in");
			Norml_SOrc.LOc$Dr(Loc,StOr);
			if(Is_In(Loc))
			{In_Handlr.Handl(this.Tran,Tran,Loc,StOr);}
		}
	}
	@Lin_DclAr @Finishd(Is_Finishd=false)
	public static void Aply(LOc_Obstructr A,double[] A_LOc,double[] StOr_A,
							LOc_Obstructr B,double[] B_LOc,double[] StOr_B)
	{
//		out.println("Is in");
		A.Norml_SOrc.LOc$Dr(B_LOc,StOr_B);
		B.Norml_SOrc.LOc$Dr(A_LOc,StOr_A);
		Tik_Tran A_Tran=A.Tran,
				 B_Tran=B.Tran;
		if(B_Tran!=null){A.In_Handlr.Handl(A_Tran,B_Tran,B_LOc,StOr_B);}
		if(A_Tran!=null){B.In_Handlr.Handl(B_Tran,A_Tran,A_LOc,StOr_A);}
	}
		@Lin_DclAr
		public static boolean Try_Aply(LOc_Obstructr A,double[] A_LOc,double[] StOr_A,
									   LOc_Obstructr B,double[] B_Loc,double[] StOr_B)
		{
			boolean Is_In=Is_In_(A,A_LOc,
								 B,B_Loc);
			Aply(				 A,A_LOc,StOr_A,
								 B,B_Loc,StOr_B);

			return Is_In;
		}
		@Lin_DclAr
		public static boolean Try_Aply_No_SLf(LOc_Obstructr A,double[] A_LOc,double[] StOr_A,
											  LOc_Obstructr B,double[] B_LOc,double[] StOr_B)
		{
			if(A!=B)
			{
				Aply(A,A_LOc,StOr_A,
					 B,B_LOc,StOr_B);

				return true ;
			}
			else
			{
				return false;
			}
		}

	public Tik_Tran Tran;

	@Override @Finishd(Is_Finishd=false)
	public void Tik()
	{}

	@Override @Finishd(Is_Finishd=false)
	public String toString()
	{return "Object("+Get_Rapd_Inbl()+","+Norml_SOrc+","+
		In_Handlr+")";
	}

	public LOc_Obstructr(Tik_Tran Tran,Rapd_Inbl_Typ Rapd_Inbl,LOc$Dr Norml_SOrc,
		Handlr In)
	{
		super(Rapd_Inbl);
		this.Tran=Tran;
		this.Norml_SOrc=Norml_SOrc;
		Set_In_Handlr(In);
	}
		public LOc_Obstructr(Tik_Tran Tran,Rapd_Inbl_Typ Rapd_Inbl,LOc$Dr Norml_SOrc,
			double StrNgth)
		{
			this(Tran,Rapd_Inbl,Norml_SOrc,
				MAk_Pushr(StrNgth));
		}
		public LOc_Obstructr(Tik_Tran Tran,Rapd_Inbl_Typ Rapd_Inbl,LOc$Dr Norml_SOrc,
			Object In_Handlr_SOrc)
		{
			this(Tran,Rapd_Inbl,Norml_SOrc,
				Gar_Handlr(In_Handlr_SOrc,Rapd_Inbl));
		}
}