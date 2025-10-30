package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;

import CC.Encycloped.Abs.Scal.Physc.Obstructn.LOc_Obstructr;
import CC.Encycloped.TIm.SlId_Tikbl;
import CC.Encycloped.TIm.Untikbl;
import CC.Math.Arithmetc;
import CC.Math.CoP;
import CC.Encycloped.Abs.Scal.Gom.Gom;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr_Rapr;
import CC.Encycloped.Abs.Scal.Physc.Physc_LMNt.Physc_LMNt_ConcrEt;
import DDDTutorial_Modd.Util;
import java.util.List;

import static CC.Encycloped.Abs.Org.Syc.TXt.Num.Dfalt_Mantisa_Lim;
import static CC.Encycloped.Abs.Org.Syc.TXt.Num.List$String;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.*;
import static CC.List.List_X.Togl_Is_In;
import static CC.List.BAs_ArA.A3;
import static CC.List.BAs_ArA.ABC;
import static CC.Math.CoP.SqAr;
import static java.util.concurrent.ThreadLocalRandom.current;

public class Tik_Tran extends Physc_LMNt_ConcrEt
	implements RL_LOc_Havr_Rapr<Physc_SpAc>,
			 Untikbl,
			 SlId_Tikbl
{
	@Override @Neds_Ovrid(NEds=Neds_Ovrid.No) @Finishd(Is_Finishd=true)
	public Physc_SpAc Get_SpAc()
	{return (Physc_SpAc)TRget.Get_SpAc();}

	@Override @Neds_Ovrid(NEds=Neds_Ovrid.No) @Finishd(Is_Finishd=false)
	public String Get_Physc_KE()
	{return "Tran";}

	public SpAc_Object TRget;
		public SpAc_Object Get_Object()
		{return TRget;}
		public void Set_Object(SpAc_Object TRget)
		{this.TRget=TRget;}
		@Override
		public SpAc_Object Get_Rapd_LOc_Havr()
		{return TRget;}
	public double Weit;
	public double[] Trajectry;
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public void Set_Trajectory(double[] Trajectry)
		{ABC(this.Trajectry,Trajectry);}
		@Lin_DclAr
		public void AccLrAt(
			double X,
			double Y,
			double Z)
		{
			Trajectry[0]+=X;
			Trajectry[1]+=Y;
			Trajectry[2]+=Z;
		}
			@Lin_DclAr
			public void AccLrAt(double[] Vectr)
			{
				AccLrAt(
				Vectr[0],
				Vectr[1],
				Vectr[2]);
			}
			@Lin_DclAr
			public void AccLrAt(double[] Dr,double X,double Y,double Z)
			{
				AccLrAt(
				Dr[0]*X,
				Dr[1]*Y,
				Dr[2]*Z);
			}
				@Lin_DclAr
				public void AccLrAt(double[] Dr,double Mag)
				{AccLrAt(Dr,Mag,Mag,Mag);}
		@Lin_DclAr
		public void Push(double[] Vectr)
		{AccLrAt(Vectr,-Weit);}
		@Lin_DclAr
		public void Ad(Tik_Tran AdNd)
		{AccLrAt(AdNd.Trajectry,AdNd.Weit/Weit);}
		@Lin_DclAr
		public void ScAl(double Mag)
		{Arithmetc.Mul(Trajectry,Trajectry,Mag);}
		@Lin_DclAr
		public void SpEd_Limit(double Limit)
		{Gom.ScAl_To_Cap(Trajectry,Limit);}
			public static void SpEd_Limit_Loop(Physc_SpAc SpAc)
			{
				for(Tik_Tran Tran:(List<Tik_Tran>)Util.Cast(SpAc.Get_Physc_LMNt("Tran")))
				{Tran.SpEd_Limit(16);}
			}
		public void SlId(double ScAl)
		{TRget.Mov(
			Trajectry[0]*ScAl,
			Trajectry[1]*ScAl,
			Trajectry[2]*ScAl);
		}
	public double Forc()
	{return Gom.Hyp(Trajectry)*Weit;}
	public void Forc(double[] ArA)
	{Arithmetc.Mul(ArA,Trajectry,Weit);}
		//< editor-fold desc="Tik">
		@Override @Finishd(Is_Finishd=false)
		public void Tik()
		{TRget.Mov(Trajectry);}
			public static void Tik(List<LOc_Obstructr> Obstructrg,double[][] LOcg)
			{
				int Obstructr_Num=Obstructrg.size();
				for(int IndX=0;
						IndX<Obstructr_Num;
						IndX+=1)
				{
					LOc_Obstructr Movr=Obstructrg.get(IndX);
						Tik_Tran Tran=Movr.Tran;
					if(Tran!=null)
					{LOcg[IndX]=Tran.TRget.Get_LOc_CoP_As_ArA();}
				}
			}
		@Override
		public void Untik()
		{TRget.Unmov(Trajectry);}
		@Override @Finishd(Is_Finishd=false)
		public void SlId_Tik(double TIm)
		{SlId(TIm);}
		//</editor-fold>
	public boolean Is_In=false;

	public static void Mix_Tran_(SpAc_Object A,SpAc_Object B)
	{
		Tik_Tran B_Tran=(Tik_Tran)B.Get_Physc_LMNt("Tran");
		if(B_Tran!=null)
		{
			B.Rmov_Physc(B_Tran);
			Tik_Tran A_Tran=((Tik_Tran)A.Get_Physc_LMNt("Tran"));
			if(A_Tran!=null)
			{
				A_Tran.Ad(B_Tran);
				B.Ad_Physc(new Child_Tran(A_Tran,B));
			}
			else
			{A.Ad_Physc(B_Tran);}
		}
	}
		public static void Mix_Tran(SpAc_Object A,SpAc_Object B)
		{
			if(current().nextBoolean())
			{Mix_Tran_(B,A);}
			else
			{Mix_Tran_(A,B);}
		}

	public void Togl_Is_In_SpAc()
	{Togl_Is_In(Get_SpAc().Get_Physc_LMNt("Tran"),this);}

	//<editor-fold desc="Alterations that can happen to A Tik_Tran.">
	public static void Rvrs(Tik_Tran Tran)
	{Arithmetc.Invrt(Tran.Trajectry,Tran.Trajectry);}
	public void Halt()
	{A3(Trajectry,0);}
		public static void Halt(Tik_Tran... Trang)
		{
			for(Tik_Tran Tran:Trang)
			{Tran.Halt();}
		}
		public static void Halt(List<Tik_Tran> Trang)
		{
			for(Tik_Tran Tran:Trang)
			{Tran.Halt();}
		}
	public static void TLeport_To_Origin(Tik_Tran Tran)
	{Tran.Get_Object().UpdAt_LOc(0,0,0);}
	public static void TLeport_To_Origin_PlAn(Tik_Tran Tran)
	{
		RL_LOc_Havr Object=Tran.Get_Object();
		double[]
			Loc=Object.Get_LOc_CoP_As_ArA(),
			MomNtum=Tran.Trajectry;
		double
			Loc0=Loc[0],
			Loc1=Loc[1],
			Loc2=Loc[2],
			MomNtum0=MomNtum[0],
			MomNtum1=MomNtum[1],
			MomNtum2=MomNtum[2],
			MultiplIr=-(
				(Loc0*MomNtum0)+(Loc1*MomNtum1)+(Loc2*MomNtum2))/
				(CoP.SqAr(MomNtum0)+CoP.SqAr(MomNtum1)+CoP.SqAr(MomNtum2));
		Object.Mov(
			MomNtum0*MultiplIr,
			MomNtum1*MultiplIr,
			MomNtum2*MultiplIr);
	}
	public static void Rflect_Of_Norml(double[] Norml,Tik_Tran Tran)
	{
		Gom.Gar_No_Against_Dr_SAm(
			Norml,
			Tran.Trajectry);
	}
	public static void Oposit(
		Tik_Tran A,Tik_Tran B,
		double X,double Y,double Z)
	{
		A.Mov(X,Y,Z);
		B.Unmov(X,Y,Z);
	}
	//</editor-fold>

	@Override
	public String toString()
	{	return List$String(Dfalt_Mantisa_Lim,Trajectry)+ParIs(Get_SpAc());   }

	public Tik_Tran(SpAc_Object TRget,double Weit,double[] Trajectry)
	{
		Set_Object(TRget);
		this.Weit=Weit;
		this.Trajectry=Trajectry;
	}
		public Tik_Tran(SpAc_Object TRget,double Weit)
		{this(TRget,Weit,new double[3]);}

	public static final SpAc_Object No_Object=null
//		new SpAc_Object()
//		{}
	;
	public static final Tik_Tran No_Tik_Tran=new Tik_Tran(No_Object,1)
	{
		@Override
		public void Tik()
		{}
	};
	public static class Child_Tran extends Tik_Tran
	{
		public Tik_Tran Parnt;

		@Override
		public void AccLrAt(double X,double Y,double Z)
		{Parnt.AccLrAt(X,Y,Z);}

		@Override
		public void Tik()
		{
			Trajectry=Parnt.Trajectry;
				Trajectry[0]+=this.Trajectry[0];
				Trajectry[1]+=this.Trajectry[1];
				Trajectry[2]+=this.Trajectry[2];
		}

		public Child_Tran(Tik_Tran Parnt,SpAc_Object TRget)
		{
			super(TRget,Parnt.Weit,Parnt.Trajectry);
			this.Parnt=Parnt;
		}
	}
}