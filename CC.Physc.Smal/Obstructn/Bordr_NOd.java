package CC.Encycloped.Abs.Scal.Physc.Obstructn;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import CC.List.NOd.TrE_NOd;
import CC.Encycloped.TIm.TImr;
import static CC.Encycloped.TIm.TIm.Sinc;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Getbl;
import MAn.LOc_Obstructn;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import java.util.List;
import java.util.ArrayList;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import static CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl.*;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Hyp;
import static java.lang.System.nanoTime;

import static CC.UI.ConsOl.Print;

public class Bordr_NOd extends TrE_NOd<Bordr_LEf,Bordr_NOd> implements Out_Box_Getbl,SpAc_Getbl
{
	@Override
	public int Get_Dim_Num()
	{return 3;}
	@Override
	public Physc_SpAc Get_SpAc()
	{return LEfg.get(0).Obstructr.Get_SpAc();}

		public void Ad_Object(LOc_Obstructr Object,double[] Loc)
		{
//			out.println("Ad_Object");
//			if(Object==null)
//			{throw new RuntimeException("Nul Object");}

			LEfg.add(new Bordr_LEf(Object,
				Loc,
				Object.Get_Bordr_Out_Box_StRt()));
		}
		public int
			Cbrt=2,
			Max=4;
		public boolean Is_SubdivIdd()
		{return Branchg!=null;}
		public void SubdivId(int Cbrt)
		{
//			out.println("SubdivId");

			double
				X_Bot=Box[0],
				Y_Bot=Box[2],
				Z_Bot=Box[4],
				X_LNg=(Box[1]-X_Bot)/Cbrt,
				Y_LNg=(Box[3]-Y_Bot)/Cbrt,
				Z_LNg=(Box[5]-Z_Bot)/Cbrt;

			int Sqrt=Cbrt*Cbrt;
			Bordr_NOd[] NOdg=new Bordr_NOd[Sqrt*Cbrt];
			for(int X=0;X<Cbrt;X+=1)
			{
				for(int Y=0;Y<Cbrt;Y+=1)
				{
					for(int Z=0;Z<Cbrt;Z+=1)
					{
						Bordr_NOd Branch=new Bordr_NOd(this);
						Branch.Set_Box(UpdAt_Out_Box_From_StRt(
							X_Bot,X*X_LNg,
							Y_Bot,Y*Y_LNg,
							Z_Bot,Z*Z_LNg));
						NOdg[X+(Y*Cbrt)+(Z*Sqrt)]=Branch;
					}
				}
			}
			this.Branchg=NOdg;

			/**Move eligible leaves to branches.*/
			for(int IndX=LEfg.size()-1;
				IndX>0;
				IndX-=1)
			{
				Bordr_LEf LEf=LEfg.get(IndX);
					double[] Box=LEf.Box;
				if(Try_Insrt_Subdivisn(LEf,Box))
				{
					LEfg.remove(IndX);

					break;
				}
			}

//			out.println(Arrays.toString(Box)+" kept:"+LEfg.size());
//			for(Bordr_NOd Branch:NOdg)
//			{out.println(Arrays.toString(Branch.Box)+":"+Branch.LEfg.size());}
		}
			public void SubdivId()
			{SubdivId(2);}
		//<editor-fold desc="Insrt">
		/**Insrt methods return whether LEf was added to subdivision.*/
		public boolean Try_Insrt_Subdivisn(Bordr_LEf LEf,double[] Box)
		{
			for(Bordr_NOd Branch:Branchg)
			{
				if(Is_Box_Al_In_Box(Box,Branch.Box))
				{
					Branch.Insrt(LEf,Box);

					return true;
				}
			}
			return false;
		}
			public boolean Try_Insrt_Subdivisn(Bordr_LEf LEf)
			{return Try_Insrt_Subdivisn(LEf,LEf.Box);}
		public boolean Insrt_SubdivIdd(Bordr_LEf LEf,double[] Box)
		{
			for(Bordr_NOd Branch:Branchg)
			{
				if(Is_Box_Al_In_Box(Box,Branch.Box))
				{
					Branch.Insrt(LEf,Box);

					return true;
				}
			}
			LEfg.add(LEf);

			return false;
		}
			public boolean Insrt_SubdivIdd(Bordr_LEf LEf)
			{return Insrt_SubdivIdd(LEf,LEf.Box);}
		public boolean Insrt_UnsubdivIdd(Bordr_LEf LEf,double[] Box)
		{
			if(LEfg.size()>Max)
			{
				SubdivId(Cbrt);
				return Insrt_SubdivIdd(LEf,Box);
			}
			else
			{
				LEfg.add(LEf);
				return false;
			}
		}
			public boolean Insrt_UnsubdivIdd(Bordr_LEf LEf)
			{return Insrt_UnsubdivIdd(LEf,LEf.Box);}
		public boolean Insrt(Bordr_LEf LEf,double[] Box)
		{
			if(Is_SubdivIdd())
			{return Insrt_SubdivIdd(LEf,Box);}
			else
			{return Insrt_UnsubdivIdd(LEf,Box);}
		}
			public void Insrt(Bordr_LEf LEf)
			{Insrt(LEf,LEf.Box);}
		//</editor-fold>
		public void P(Bordr_LEf LEf,double[] Box)
		{
			if(Is_Box_Al_In_Box(Box,this.Box))
			{
				;
			}
		}
		public double[] Box=new double[6];
			@Lin_DclAr
			public void Set_Box(double[] Box)
			{this.Box=Box;}
			@Lin_DclAr
			public void UpdAt_Box()
			{
				Out_Box_Getbl.Get_Out_Box_Of_List_StRt(Box,LEfg);
				Out_Box_Getbl.Get_Out_Box_Of_List(Box,Branchg);
			}
			@Override
			public void Get_Bordr_Out_Box_StRt(double[] Box)
			{UpdAt_Out_Box_StRt(Box,this.Box);}
			@Override
			public void Get_Bordr_Out_Box(double[] Box)
			{Out_Box_Getbl.UpdAt_Out_Box(Box,this.Box);}
		public int NOd_Num;
		//<editor-fold desc="Walk">
		@Lin_DclAr
		public int Walk(List<Bordr_NOd> NOdg)
		{
			NOdg.add(this);
			NOd_Num=1+Walk_List(NOdg,Branchg);

			return NOd_Num;
		}
			@Lin_DclAr
			public List<Bordr_NOd> Walk()
			{
				List<Bordr_NOd> NOdg=new ArrayList<>();
				Walk(NOdg);

				return NOdg;
			}
				@Lin_DclAr
				public static int Walk_List(List<Bordr_NOd> NOdg,Bordr_NOd[] AdNd)
				{
					int Sibling_Group_Num=0;
					if(AdNd!=null)
					{
						for(Bordr_NOd NOd:AdNd)
						{Sibling_Group_Num+=NOd.Walk(NOdg);}
					}

					return Sibling_Group_Num;
				}
		//</editor-fold>

	//<editor-fold desc="Chek">
	public boolean Chek_Colisn_Rang(
		LOc_Obstructr A,double[] A_LOc,double[] A_StOr,
		double[] B_StOr,int B_IndX,int B_Nd)
	{return LOc_Obstructn.Chek_Colisn_Rang(
		A,A_LOc,A_StOr,
		LEfg,B_StOr,B_IndX,B_Nd);
	}
		public boolean Chek_Colisn_Drect_NAtv(
			LOc_Obstructr A,double[] A_LOc,double[] A_StOr,int A_IndX,
			double[] B_StOr)
		{return LOc_Obstructn.Chek_Colisn_NAtv(
			A,A_LOc,A_StOr,A_IndX,
			LEfg,B_StOr);
		}
		public boolean Chek_Colisn_Drect_Alien(
			LOc_Obstructr A,double[] A_LOc,double[] A_StOr,
			double[] B_StOr)
		{return Chek_Colisn_Rang(
			A,A_LOc,A_StOr,
			B_StOr,0,LEfg.size());
		}
	public static boolean Chek_Colisn_NOdg_Rang(
		LOc_Obstructr A,double[] A_LOc,double[] A_StOr,
		Bordr_NOd[] Bg,double[] B_StOr,int IndX,int Nd)
	{
		boolean Is_In=false;
		for(;IndX<Nd
			;IndX+=1)
		{
			Is_In|=Bg[IndX].Chek_Colisn_Alien(
				A,A_LOc,A_StOr,
				B_StOr);
		}

		return Is_In;
	}
		@Finishd(Is_Finishd=false)
		public boolean Chek_Colisn_NOdg(
			LOc_Obstructr A,double[] A_LOc,double[] A_StOr,
			double[] B_StOr)
		{
			return Chek_Colisn_NOdg_Rang(
				A,A_LOc,A_StOr,
				Branchg,B_StOr,0,Branchg.length);
		}
	@Finishd(Is_Finishd=false)
	public boolean Chek_Colisn_Alien(
		LOc_Obstructr A,double[] A_LOc,double[] A_StOr,
		double[] B_StOr)
	{
		return (Is_Box_Som_In_Box(Box,A_LOc))&&(
			Chek_Colisn_Drect_Alien(
				A,A_LOc,A_StOr,
				B_StOr)|
			Chek_Colisn_NOdg(
				A,A_LOc,A_StOr,
				B_StOr));
	}
	@Finishd(Is_Finishd=false)
	public boolean Chek_Colisn_NAtv(
		LOc_Obstructr A,double[] A_LOc,double[] A_StOr,int A_IndX,
		double[] B_StOr)
	{
		return (Is_Box_Som_In_Box(Box,A_LOc))&&(
			Chek_Colisn_Drect_NAtv(
				A,A_LOc,A_StOr,A_IndX,
				B_StOr)|
			Chek_Colisn_NOdg(
				A,A_LOc,A_StOr,
				B_StOr));
	}
		/**For objects !@ A_IndX.*/
		@Finishd(Is_Finishd=false)
		public boolean Chek_Colisn_NAtv(
			int A_IndX,double[] A_StOr,
			double[] B_StOr)
		{
			Bordr_LEf LEf=LEfg.get(A_IndX);

			return Chek_Colisn_NAtv(
				LEf.Obstructr,LEf.Loc,A_StOr,A_IndX,
				B_StOr);
		}
			/**For all objects w/in.*/
			@Finishd(Is_Finishd=false)
			public List<Bordr_NOd> Chek_Colisn(
				double[] A_StOr,
				double[] B_StOr)
			{
				TImr TImr=new TImr();

				List<Bordr_NOd> NOdg=Walk();
					int NOd_Num=NOdg.size();
				for(int NOd_A_IndX=0;
					NOd_A_IndX<NOd_Num;
					NOd_A_IndX+=1)
				{
					Bordr_NOd NOd_A=NOdg.get(NOd_A_IndX);
						List<Bordr_LEf> Sistr_Group=NOd_A.LEfg;
							int Objectg_LNg=Sistr_Group.size();
					for(int Object_IndX=0;
						Object_IndX<Objectg_LNg;
						Object_IndX+=1)
					{
						long StRt=nanoTime();

						/**Check w/ siblings.*/
						Bordr_LEf A=Sistr_Group.get(Object_IndX);
							LOc_Obstructr A_Obstructr=A.Obstructr;
							double[] A_Loc=A.Loc;
						LOc_Obstructn.Chek_Colisn_Rang(
							A_Obstructr,A_Loc,A_StOr,
							Sistr_Group,B_StOr,Object_IndX,Objectg_LNg);

						/**Check w/ other nodes.*/
						for(int NOd_B_IndX=NOd_A_IndX+1;
							NOd_B_IndX<NOd_Num;)
						{
							Bordr_NOd NOd_B=NOdg.get(NOd_B_IndX);
							if(Is_Loc_In_Box(NOd_B.Box,A_Loc))
							{
								NOd_B.Chek_Colisn_Drect_Alien(
									A_Obstructr,A_Loc,A_StOr,
									B_StOr);

								NOd_B_IndX+=1;
							}
							else
							{
								NOd_B_IndX+=NOd_A.NOd_Num;
							}
						}

						TImr.Ad_Inst(Sinc(StRt));
					}
				}

//				out.println("Object chekd:"+TImr.Get_Avrg_Sec());
				return NOdg;
			}
				@Lin_DclAr @Finishd(Is_Finishd=false)
				public List<Bordr_NOd> Chek_Colisn()
				{return Chek_Colisn(new double[3],new double[3]);}
	//</editor-fold>

	@Finishd(Is_Finishd=false)
	public Bordr_NOd(Bordr_NOd Parnt)
	{Set_StM(Parnt);}
		@Finishd(Is_Finishd=false)
		public Bordr_NOd()
		{this(null);}

	@Finishd(Is_Finishd=false)
	public static double[][] SLect_Voronoi_NOdg(List<LOc_Obstructr> List,int Num)
	{
//		for();
		return null;
	}
	@Finishd(Is_Finishd=false)
	public static double[][] Voronoi_Grid(double[] Box,int Group_Cbrt)
	{
		int Cub=Group_Cbrt*Group_Cbrt*Group_Cbrt;
		double
			Group_LNg_X=(Box[1]-Box[0])/Group_Cbrt,
			Group_LNg_Y=(Box[3]-Box[2])/Group_Cbrt,
			Group_LNg_Z=(Box[5]-Box[4])/Group_Cbrt,
			X_Bot=Box[0]+Group_LNg_X/2,
			Y_Bot=Box[2]+Group_LNg_Y/2,
			Z_Bot=Box[4]+Group_LNg_Z/2;
		double[][] Group_Locg=new double[Cub][];
		int Group_Loc=0;
		for(int Z=0;
			Z<Group_Cbrt;
			Z+=1)
		{
			for(int Y=0;
				Y<Group_Cbrt;
				Y+=1)
			{
				for(int X=0;
					X<Group_Cbrt;
					X+=1)
				{
					Group_Locg[Group_Loc]=new double[]{
						X_Bot+(X*Group_LNg_X),
						Y_Bot+(Y*Group_LNg_Y),
						Z_Bot+(Z*Group_LNg_Z)};
					Group_Loc+=1;
				}
			}
		}

		return Group_Locg;
	}
	@Finishd(Is_Finishd=false)
	public static void MAk_Groupg(Bordr_NOd Groupg,int Group_Num)
	{
		Bordr_NOd[] NOdg=new Bordr_NOd[Group_Num];
		for(int Group_IndX=0;
			Group_IndX<Group_Num;
			Group_IndX+=1)
		{NOdg[Group_IndX]=new Bordr_NOd(Groupg);}
		Groupg.Branchg=NOdg;
	}
		@Finishd(Is_Finishd=false)
		public static Bordr_NOd MAk_Groupg(int Group_Num)
		{
			Bordr_NOd Groupg=new Bordr_NOd();
			MAk_Groupg(Groupg,Group_Num);

			return Groupg;
		}
	//<editor-fold desc="Sort">
	public interface Sortr
	{
		@Lin_DclAr @Finishd(Is_Finishd=false)
		void Sort(
			List<LOc_Obstructr> List,
			Bordr_NOd Groupg,
			double[][] Group_Locg);
			@Lin_DclAr @Finishd(Is_Finishd=false)
			default Bordr_NOd Sort(
				List<LOc_Obstructr> List,
				double[][] Group_Locg)
			{
				Bordr_NOd Groupg=MAk_Groupg(Group_Locg.length);
				Sort(List,Groupg,Group_Locg);

				return Groupg;
			}
	}
	@Finishd(Is_Finishd=false)
	public static void Voronoi_Sort(
		List<LOc_Obstructr> Objectg,
		Bordr_NOd Groupg,
		double[][] Group_Locg,
		double[] Box)
	{
		int Group_Num=Group_Locg.length;
		Bordr_NOd[] NOdg=Groupg.Branchg;
			Bordr_NOd Group0=NOdg[0];
		double[]
			Group_Loc0=Group_Locg[0],
			Loc;
		for(int Object_IndX=0;
			Object_IndX<Objectg.size();
			Object_IndX+=1)
		{
			LOc_Obstructr Object=Objectg.get(Object_IndX);
			Tik_Tran Tran=Object.Tran;
			Loc=Object.Get_LOc_CoP_As_ArA();
				Bordr_NOd Group=Group0;
				double Prox=Hyp(
					Loc,
					Group_Loc0);
			for(int Group_IndX=0;
				Group_IndX<Group_Num;
				Group_IndX+=1)
			{
				double New_Prox=Hyp(
					Loc,
					Group_Locg[Group_IndX]);
				if(New_Prox<Prox)
				{
					Group=NOdg[Group_IndX];
					Prox=New_Prox;
				}
			}
			Group.Ad_Object(Object,Loc);
		}
		Groupg.Set_Box(Box);
	}
		@Finishd(Is_Finishd=false)
		public static Bordr_NOd Voronoi_Sort(
			List<LOc_Obstructr> List,
			double[][] Group_Locg,
			double[] Box)
		{
			Bordr_NOd Groupg=MAk_Groupg(Group_Locg.length);
			Voronoi_Sort(List,Groupg,Group_Locg,Box);

			return Groupg;
		}
	@Finishd(Is_Finishd=false)
	public static void WIn_1st_Dfalt_Prox_Sort(
		List<LOc_Obstructr> List,
		Bordr_NOd Groupg,
		double[][] Group_LOcg,double Threshold,
		double[] Box)
	{
		int Group_Num=Group_LOcg.length;
		Bordr_NOd[] NOdg=Groupg.Branchg;
			Bordr_NOd Group0=NOdg[0];
		double[]
			Group_LOc0=Group_LOcg[0],
			LOc;
		for(int Object_IndX=0;
			Object_IndX<List.size();
			Object_IndX+=1)
		{
			LOc_Obstructr Object=List.get(Object_IndX);
				LOc=Object.Get_LOc_CoP_As_ArA();
				Bordr_NOd Grup=Group0;
				double Prox=Hyp(
					LOc,
					Group_LOc0);
			for(int Grup_IndX=0;
				Prox>Threshold&&Grup_IndX<Group_Num;
				Grup_IndX+=1)
			{
				double New_Prox=Hyp(
					LOc,
					Group_LOcg[Grup_IndX]);
				if(New_Prox<Prox)
				{
					Grup=NOdg[Grup_IndX];
					Prox=New_Prox;
				}
			}
			Grup.Ad_Object(Object,LOc);
		}
		Groupg.Set_Box(Box);
	}
		@Finishd(Is_Finishd=false)
		public static Bordr_NOd WIn_1st_Dfalt_Prox_Sort(
			List<LOc_Obstructr> List,
			double[][] Grup_LOcg,double Threshold,
			double[] Box)
		{
			Bordr_NOd Groupg=MAk_Groupg(Grup_LOcg.length);
			WIn_1st_Dfalt_Prox_Sort(List,Groupg,Grup_LOcg,Threshold,Box);

			return Groupg;
		}
	@Finishd(Is_Finishd=false)
	public static void WIn_1st_Sort(
		List<LOc_Obstructr> List,
		Bordr_NOd Groupg,
		double[][] Group_Locg,double Threshold,
		double[] Box)
	{
		int Group_Num=Group_Locg.length;
		double[]
			BfOr,
			LOc;
		Bordr_NOd[] NOdg=Groupg.Branchg;
		for(int Object_IndX=0;
			Object_IndX<List.size();
			Object_IndX+=1)
		{
			LOc_Obstructr Object=List.get(Object_IndX);
				LOc=Object.Get_LOc_CoP_As_ArA();
			for(int Group_IndX=1;
				Group_IndX<Group_Num;
				Group_IndX+=1)
			{
				if(Hyp(
					LOc,
					Group_Locg[Group_IndX]
					)<Threshold)
				{
					NOdg[Group_IndX].Ad_Object(Object,LOc);

					break;
				}
			}
		}
		Groupg.Set_Box(Box);
	}
		@Finishd(Is_Finishd=false)
		public static Bordr_NOd WIn_1st_Sort(
			List<LOc_Obstructr> List,
			double[][] Group_Locg,double Threshold,
			double[] Box)
		{
			Bordr_NOd Groupg=MAk_Groupg(Group_Locg.length);
			WIn_1st_Sort(List,Groupg,Group_Locg,Threshold,Box);

			return Groupg;
		}
	//</editor-fold>
	@Finishd(Is_Finishd=false)
	public static Bordr_NOd Voronoi_Group(
		List<LOc_Obstructr> List,
		int Group_Cbrt)
	{
		double[] Box=Get_Out_Box_Of_List_StRt(List);

		return Voronoi_Sort(
			List,
			Voronoi_Grid(Box,Group_Cbrt),
			Box);
	}
}