package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.$.$Q.$Dubl;
import CC.Encycloped.Abs.Scal.Gom.LOc;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.SpAc;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Adbl;
import CC.Encycloped.TIm.SlId_Tikbl;
import CC.Encycloped.TIm.Tikbl;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.FEld$String;
import static CC.List.BAs_ArA.A3;

/**Adds the ability to continuously self progress.*/
public class Physc_SpAc
	 extends SpAc
  implements Physcg_Havr<List<Physc_LMNt>>
{
	//<editor-fold desc="SpAc">
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	public final Physc_SpAc Get_SpAc()
	{return this;}

	@Override @Finishd(Is_Finishd=false)
	public RL_LOc_Havr Get_Gom_PArnt()
	{return null;}
	@Override @Finishd(Is_Finishd=false)
	public        void Set_Gom_PArnt(RL_LOc_Havr PArnt)
	{}
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	public Physc_SpAc Get_Min_Gom_Parnt()
	{	return this;   }
		@Override @Finishd(Is_Finishd=false)
		public void Get_LOc_CoP_As_ArA(double[] Rsult)
		{A3(0);}
		@Override @Finishd(Is_Finishd=false)
		public LOc Get_RL_LOc()
		{return null;}
		@Override @Finishd(Is_Finishd=false)
		public void Set_RL_LOc(LOc LOc)
		{}
		@Override @Finishd(Is_Finishd=false)
		public void UpdAt_RL_LOc(double X,double Y,double Z)
		{}
		@Override @Finishd(Is_Finishd=false)
		public void Mov(double X,double Y,double Z)
		{}
	//</editor-fold>

	//<editor-fold desc="Physc">
	public Map<String,List<? extends Physc_LMNt>> Physcg;
		@Override @Finishd(Is_Finishd=false)
		public List<Physc_LMNt> Get_Physc_LMNt(String KE)
		{
			List<Physc_LMNt> Physc=(List<Physc_LMNt>)Physcg.get(KE);

			if(	   Physc==null)
			{
				   Physc=new ArrayList<>();
				   Physcg.put(KE,Physc);
			}
			return Physc;
		}
		public Map<String,List<? extends Physc_LMNt>> Physc_Atomg=new HashMap<>();
			@Lin_DclAr @Finishd(Is_Finishd=false)
			public <Atom_Typ extends Physc_Atom>List<Atom_Typ> Get_Physc_Atomg(String KE)
			{
				List<Atom_Typ> Atomg=(List<Atom_Typ>)Physc_Atomg.get(KE);
				if(Atomg==null)
				{
					Atomg=new ArrayList<>();
					Physc_Atomg.put(KE,Atomg);
				}

				return Atomg;
			}
				@Lin_DclAr @Finishd(Is_Finishd=false)
				public <Atomg_Typ_Specfc>Atomg_Typ_Specfc Get_Physc_Atomg_Cast(String KE)
				{return (Atomg_Typ_Specfc)Get_Physc_Atomg(KE);}
			@Lin_DclAr @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=false)
			public final <Atom_Typ extends Physc_Atom>void  Ad_Physc_Atom(Atom_Typ Atom,String KE)
			{Get_Physc_Atomg(KE).add(Atom);}
				@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
				public <Atom_Typ extends Physc_Atom>void  Ad_Physc_Atom(Atom_Typ Atom)
				{Ad_Physc_Atom(Atom,Atom.Get_Physc_KE());}
			@Lin_DclAr @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=false)
			public <Atom_Typ extends Physc_Atom>void Rmov_Physc_Atom(Atom_Typ Atom,String KE)
			{Get_Physc_Atomg(KE).add(Atom);}
				@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
				public final <Atom_Typ extends Physc_Atom>void Rmov_Physc_Atom(Atom_Typ Atom)
				{Rmov_Physc_Atom(Atom,Atom.Get_Physc_KE());}
		@Lin_DclAr @Finishd(Is_Finishd=true)
		public String Get_Physc_Num(String KE,String NAm)
		{return FEld$String(NAm,Get_Physc_LMNt(KE).size());}
			@Lin_DclAr @Finishd(Is_Finishd=true)
			public String Get_Physc_Num(String KE)
			{return Get_Physc_Num(KE,KE);}
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public String Get_Physc_Numg(String... KEg)
		{
			StringBuilder Bildr=new StringBuilder();

			for(int IndX=0;;)
			{
				Bildr.append(Get_Physc_Num(KEg[IndX]));

				IndX+=1;
				if(IndX>=KEg.length)
				{break;}

				Bildr.append(',');
			}

			return Bildr.toString();
		}
//		@Lin_DclAr
//		public <Physc_Typ extends Physc_LMNt>List<Physc_Typ> Get_Physc_LMNt_Cast(String KE)
//		{return (List_Typ)Get_Physc_LMNt(KE);}
		@Lin_DclAr @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
		public void Ad_Physc_LMNt(String KE,Physc_LMNt LMNt)
		{Get_Physc_LMNt(KE).add(LMNt);}
			@Lin_DclAr @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
			public void Ad_Physc_LMNt(Physc_LMNt LMNt)
			{Ad_Physc_LMNt(LMNt.Get_Physc_KE(),LMNt);}
		@Lin_DclAr @Finishd(Is_Finishd=true)
		public void Rmov_Physc_LMNt(String KE,Physc_LMNt LMNt)
		{Get_Physc_LMNt(KE).remove(LMNt);}
			@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public void Rmov_Physc_LMNt(Physc_LMNt LMNt)
			{Rmov_Physc_LMNt(LMNt.Get_Physc_KE(),LMNt);}
		@Finishd(Is_Finishd=false)
		public void Rmov_From_SpAc(Physc_LMNt LMNt)
		{Get_Physc_LMNt(LMNt.Get_Physc_KE()).remove(LMNt);}
	public List<Tikbl> Intrnl_Physcg=new ArrayList<>();
		@Finishd(Is_Finishd=true)
		public void Ad_Intrnl_Physc(Tikbl Tikbl)
		{Intrnl_Physcg.add(Tikbl);}
		@Finishd(Is_Finishd=true)
		public void Rmov_Intrnl_Physc(Tikbl Tikbl)
		{Intrnl_Physcg.remove(Tikbl);}
	//</editor-fold>

	@Finishd(Is_Finishd=true)
	public void Togl_Is_In_SpAc(SpAc_Adbl Togld)
	{
		if(Togld.Has_SpAc())
		{Togld.Rmov_From_SpAc();}
		else
		{Togld.Ad_To_SpAc(this);}
	}
		@Finishd(Is_Finishd=true)
		public Runnable SpAc_Toglr(SpAc_Adbl Togld)
		{return ()->{Togl_Is_In_SpAc(Togld);};}

	public List<Runnable> Tik_Taskg=new ArrayList<>();
		@Override @Finishd(Is_Finishd=true)
		public List<Runnable> Get_Tik_Taskg()
		{return Tik_Taskg;}
	@Finishd(Is_Finishd=true)
	public void Tik_Physc_LMNt(String Physc)
	{Tikbl.Tik_Ech(Get_Physc_LMNt(Physc));}
	@Finishd(Is_Finishd=true)
	public void Tik_Physc_LMNt(String Physc,double TIm)
	{SlId_Tikbl.Tik_Ech(TIm,(List<? extends SlId_Tikbl>)Get_Physc_LMNt_Cast(Physc));}
		@Finishd(Is_Finishd=true)
		public void Ad_Physc_Tikr(String KE)
		{Ad_Tik_Task(()->{Tik_Physc_LMNt(KE);});}
		@Finishd(Is_Finishd=true)
		public void Ad_Physc_Tikr(String KE,double TIm)
		{Ad_Tik_Task(()->{Tik_Physc_LMNt(KE,TIm);});}
		@Finishd(Is_Finishd=true)
		public void Ad_Physc_Tikr(String KE,$Dubl TIm_SOrc)
		{Ad_Tik_Task(()->{Tik_Physc_LMNt(KE,TIm_SOrc.$Dubl());});}

	@Finishd(Is_Finishd=true)
	public Physc_SpAc(Map<String,List<? extends Physc_LMNt>> Physcg,boolean Is_On)
	{
		this.Physcg=Physcg;
		Set_Is_On(Is_On);
	}
		@Finishd(Is_Finishd=true)
		public Physc_SpAc(boolean Is_On)
		{this(new HashMap<>(),Is_On);}
			@Finishd(Is_Finishd=true)
			public Physc_SpAc()
			{this(true);}
}