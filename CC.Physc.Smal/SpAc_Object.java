package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl.Out_Box_Getbl_Rapr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Ocupier.SpAc_Ocupier_Imp;
import CC.Bool.Trn.Task_On_Trnbl_Runbl;
import CC.Encycloped.Abs.Scal.Physc.Physcg_Havr.Physc_Map_Havr;
import CC.Encycloped.TIm.UpdAtbl;
import java.util.Map;
import java.util.HashMap;

import static java.lang.System.out;

public class	  SpAc_Object<
				  SpAc_Typ
	 extends Physc_SpAc>
	 extends SpAc_Ocupier_Imp<
					  SpAc_Typ>
	implements Physc_Map_Havr<
			   Physc_LMNt>,
		Out_Box_Getbl_Rapr
{
	@Override
	public int Get_Dim_Num()
	{return 3;}
	@Override
	public void Ad_To_SpAc(Physc_SpAc SpAc)
	{
		for(Physc_LMNt LMNt:Get_Physcg().values())
		{LMNt.Ad_To_SpAc(SpAc);}
	}
	@Override
	public void Rmov_From_SpAc(Physc_SpAc SpAc)
	{
		out.println("Rmov_From_SpAc");
		for(Physc_LMNt LMNt:Get_Physcg().values())
		{LMNt.Rmov_From_SpAc(SpAc);}
	}

	public Map<String,Physc_LMNt> Physcg;
		@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public final Map<String,Physc_LMNt> Get_Physcg()
		{
			return Physcg;
		}
		@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
		public void Set_Physcg(Map<String,Physc_LMNt> Physcg)
		{
			this.Physcg=Physcg;
			UpdAt();
		}
		public void Print_Physcg()
		{
			out.println("{");
			for(Physc_LMNt LMNt:Get_Physcg().values())
			{out.println(LMNt);}
			out.println("}");
		}
		public void Ad_Physc(Physc_LMNt LMNt)
		{
			String KE=LMNt.Get_Physc_KE();
				Get_Physcg().put(KE,LMNt);
				LMNt.Ad_To_SpAc(Get_SpAc());
			if(LMNt instanceof UpdAtbl UpdAtbl)
			{UpdAtbl.UpdAt();}
			/*
			String KE_="Bordr_Stik";
			if(KE_.equals(KE))
			{throw new RuntimeException("LMNt is A "+KE_);}
			/**/
		}
			public void Ad_Physc(Physc_LMNt... LMNTg)
			{
				for(Physc_LMNt LMNt:LMNTg)
				{Ad_Physc(LMNt);}
			}
		public Task_On_Trnbl_Runbl Physc_Adr(Physc_LMNt LMNt)
		{
			return new Task_On_Trnbl_Runbl(
				()->{Ad_Physc(LMNt);},
				()->{Rmov_Physc(LMNt);});
		}
		public void Rmov_Physc(Physc_LMNt LMNt)
		{
			String KE=LMNt.Get_Physc_KE();
				Get_Physcg().remove(KE);
				Get_SpAc().Rmov_Physc_LMNt(KE,LMNt);
			UpdAt();
		}
		public void Rmov_Physc(String LMNt)
		{Rmov_Physc(Get_Physc_LMNt(LMNt));}
			public void Rmov_Physc(Physc_LMNt... LMNTg)
			{
				for(Physc_LMNt LMNt:LMNTg)
				{Rmov_Physc(LMNt);}
			}
		public Task_On_Trnbl_Runbl Physc_Rmovr(Physc_LMNt LMNt)
		{
			return new Task_On_Trnbl_Runbl(
				()->{Rmov_Physc(LMNt);},
				()->{Ad_Physc(LMNt);});
		}
		public void Togl_Physc(Physc_LMNt LMNt)
		{
			if(Has_Physc_LMNt(LMNt.Get_Physc_KE()))
			{Rmov_Physc(LMNt);}
			else
			{Ad_Physc(LMNt);}
		}
			public Task_On_Trnbl_Runbl Physc_Toglr(Physc_LMNt LMNt)
			{return new Task_On_Trnbl_Runbl(()->{Togl_Physc(LMNt);});}

	@Override
	public Polyhedron Get_Rapd_Box_Getbl()
	{return (Polyhedron)Get_Physc_LMNt("SEn");}

	@Override
	public void UpdAt()
	{
		super.UpdAt();
		for(Physc_LMNt LMNt:Get_Physcg().values())
		{
			LMNt.Tik();
			if(LMNt instanceof UpdAtbl UpdAtbl)
			{UpdAtbl.UpdAt();}
		}
	}

	public SpAc_Object(RL_LOc_Havr Parnt,Object LOc_SOrc,
		Map<String,Physc_LMNt> Physcg)
	{
		super(Parnt,LOc_SOrc);
		Set_Physcg(Physcg);
		Ad_To_SpAc(Get_SpAc());
	}
		public SpAc_Object(RL_LOc_Havr Parnt,Object LOc_SOrc)
		{
			super(Parnt,LOc_SOrc);
			Set_Physcg(new HashMap<>());
			Ad_To_SpAc(Get_SpAc());
		}
			public SpAc_Object(RL_LOc_Havr Parnt,Object LOc_SOrc,
				Physc_LMNt... LMNtg)
			{
				this(Parnt,LOc_SOrc);
				Ad_Physc(LMNtg);
			}
}