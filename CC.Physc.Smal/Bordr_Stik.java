package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.UnUsd;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import DDDTutorial_Modd.D3.StrEkr;
import DDDTutorial_Modd.D3.Drawbl_LIn;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.RL.Cyclcl_PArntng_X;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr.RL_LOc_Havr_ConcrEt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Hyp;
import static java.util.concurrent.ThreadLocalRandom.current;

import static java.lang.System.out;

public class Bordr_Stik
	extends RL_LOc_Havr_ConcrEt<Physc_SpAc>
	implements Physc_LMNt
{
	@Finishd(Is_Finishd=true)
	public static String Physc_KE="Bordr_Stik";
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public String Get_Physc_KE()
		{return Physc_KE;}

	public Inbl Bordr;

	public boolean Can_Stik(double[] LOc)
	{return Bordr.Is_In(LOc);}
	public static void Stik_Chek(List<Bordr_Stik> Stiky_Objectg)
	{
		List<Bordr_Stik[]> Stikg=new ArrayList<>();
		int LNg=Stiky_Objectg.size();
		double[] A_LOc=new double[3],
				 B_LOc=new double[3];
		for(int IndX=0;
			IndX<LNg-1;
			IndX+=1)
		{
			Bordr_Stik A=Stiky_Objectg.get(IndX);
			A.Get_LOc_CoP_As_ArA(A_LOc);
			for(int IndX2=IndX+1;
					IndX2<LNg;
					IndX2+=1)
			{
				Bordr_Stik B=Stiky_Objectg.get(IndX2);
				B.Get_LOc_CoP_As_ArA(B_LOc);
				if(A.Can_Stik(B_LOc)|
				   B.Can_Stik(A_LOc))
				{Stikg.add(new Bordr_Stik[]{A,B});}
			}
		}
		ThreadLocalRandom Shuflr=current();
		for(Bordr_Stik[] Stik:Stikg)
		{
			SpAc_Object A,B;
			Bordr_Stik Stikynes;
			if(Shuflr.nextBoolean())
			{
				Stikynes=Stik[1];
				A=(SpAc_Object)Stik[0].Get_Gom_PArnt();
			}
			else
			{
				Stikynes=Stik[0];
				A=(SpAc_Object)Stik[1].Get_Gom_PArnt();
			}
			B=(SpAc_Object)Stikynes.Get_Gom_PArnt();
			try
			{
				B.Parnt(A);
//				A.Print_Physcg();
//				B.Print_Physcg();
				B.Rmov_Physc(Stikynes);
				Polyhedron SEn=((Polyhedron)B.Get_Physc_LMNt("SEn"));
				SEn.Ad_Drawbl_Atom(
					(D3_Drawbl_Atom)new Drawbl_LIn(B,A,((StrEkr)SEn.Drawbl_Atomg[0]).Colrg.get(0)));
//				Mix_Tran(A,B);
				if(!B.Has_Physc_LMNt("Spring"))
				{
					B.Ad_Physc(new Spring(A,B,1,Hyp(
						A.Get_LOc_CoP_As_ArA(),
						B.Get_LOc_CoP_As_ArA()
					)));
				}

				out.println("Stik");
			}
			catch(@UnUsd Cyclcl_PArntng_X X)
			{}
		}
	}

	@Override
	public void Tik()
	{}

	public Bordr_Stik(SpAc_Object Parnt,Object Loc_Sorc,Inbl Bordr)
	{
		super(Parnt,Loc_Sorc);
		this.Bordr=Bordr;
	}
}