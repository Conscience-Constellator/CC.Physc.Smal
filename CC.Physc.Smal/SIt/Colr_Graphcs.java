package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.$.Q$Q.Dubl1$1;
import CC.$.Q$Q.Rtrnr;
import CC.$.Q$Q.Int1$1.Int1$1g;
import CC.Math.Invrtr;
import CC.Math.ScAlr;

import static CC.Encycloped.Abs.Org.Comput.Bi.Int_Byt_Modr.ABCD$Int;
import static CC.$.Q$Q_Grup.Num_A$A.NegAt;
import CC.Util.Shufl.Shuflr;
import static CC.Util.Shufl.Shufl.Rol;
import static CC.Encycloped.Abs.Org.Comput.Bi.Bi.No;
import CC.Encycloped.Abs.Org.Comput.Bi.Byt0_Modr;
import CC.Encycloped.Abs.Org.Comput.Bi.Byt1_Modr;
import CC.Encycloped.Abs.Org.Comput.Bi.Byt2_Modr;
import CC.Encycloped.Abs.Org.Comput.Bi.Byt3_Modr;
import static CC.Encycloped.Abs.Org.Comput.Bi.Shiftr.Shufl_Cycl_Shiftr;
import static CC.Encycloped.Abs.Org.Comput.Bi.Shiftr.Shufl_Shiftr;
import CC.$.Q$Q.Int1$1;
import CC.Encycloped.Abs.Scal.Physc.SIt.Efect_.Int1$1_Efect;
import java.util.concurrent.ThreadLocalRandom;
import static CC.Math.Bounc_ConfInr.Bounc;
import static CC.Math.Cyclr.Cycl;
import static CC.Math.ConfInr.Snap_ConfInr;

import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.Gar_Chanl_Valid;

import CC.Encycloped.Abs.Scal.Gom.Gom;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.$.$Q.$Int;
import CC.Math.Dublg$Dubl;
import static java.lang.System.nanoTime;

public class Colr_Graphcs
{
	public static Int1$1 Adr(ThreadLocalRandom Shuflr,int B,int T)
	{
		int Vectr=Shuflr.nextInt(B,T);

		return (Num)->
		{return Gar_Chanl_Valid(Num+Vectr);};
	}
		public static Int1$1 Adr(ThreadLocalRandom Shuflr,int Rad)
		{return Adr(Shuflr,-Rad,Rad);}

	public static Int1$1 Shufl_Mod(ThreadLocalRandom Shuflr,int Rad,int Rang)
	{
		return switch(Shuflr.nextInt(5))
			{
				case 0->Adr(Shuflr,Rad);
				case 1->new Invrtr(Rang);
				case 2->(Shuflr.nextBoolean())?
					Shufl_Cycl_Shiftr(Shuflr,Rad):
					Shufl_Shiftr(Shuflr,Rad);
				case 3->NegAt;
				case 4->No;
				default->null;
			};
			/**To add:
			 * Rvrs
			 * Rvrs on <whOl segmnt*/
	}
	public static Int1$1 Shufl_Efect(ThreadLocalRandom Shuflr)
	{
		Int1$1 Mod;
		int Num=Shuflr.nextInt(11);
		if(Num==10)
		{
			Mod=(Shuflr.nextInt(3)==2)?
				new Shuflr(Shuflr):
				new Int1$1_Efect(
					Shufl_Mod(Shuflr,16,Integer.MAX_VALUE));
		}
		else
		{
			Mod=Shufl_Mod(Shuflr,16,255);
			Mod=switch(Num)
			{
				case 0,1->new Byt1_Modr(Mod);
				case 2,3->new Byt2_Modr(Mod);
				case 4,5->new Byt3_Modr(Mod);
				case 6,7->new Byt0_Modr(Mod);
				case 8,9->new Int1$1g(
					new Byt1_Modr(Mod),
					new Byt2_Modr(Mod),
					new Byt3_Modr(Mod),
					new Byt0_Modr(Mod));
				default->throw new RuntimeException("");
			};
		}
		return (Rol(Shuflr,16))?
			Mod:
			new Int1$1g(Mod,new Byt0_Modr(Adr(Shuflr,-64,-16)));
	}
	public static Int1$1_Efect Shufl_Efect_(ThreadLocalRandom Shuflr)
	{return new Int1$1_Efect(Shufl_Efect(Shuflr));}
	public static Int1$1_Rap_Op Shufl_Op(ThreadLocalRandom Shuflr)
	{return new Int1$1_Rap_Op(Shufl_Efect(Shuflr));}
	public static Dubl1$1 Shufl_Mod_Dubl(ThreadLocalRandom Shuflr)
	{
		ScAlr ScAlr=new ScAlr(Shuflr.nextDouble((double)1/16,1024));
		Int1$1 ConfInr=Shufl_Chanl_ConfInr(Shuflr);

		return (In)->
		{return ConfInr.Int1$1((int)ScAlr.Dubl1$1(In));};
	}

	public static Int1$1
		NErst_ConfInr=(Chanl)->
		{return Snap_ConfInr.ConfIn(Chanl,0,255);},
		Cyclcl_ConfInr=(Chanl)->
		{return Cycl(Chanl,256);},
		Bounc_ConfInr=(Chanl)->
		{return Bounc(Chanl,256);}
	;
	public static Int1$1 Shufl_Chanl_ConfInr(ThreadLocalRandom Shuflr)
	{
		return switch(Shuflr.nextInt(3))
		{
			case 0->NErst_ConfInr;
			case 1->Cyclcl_ConfInr;
			case 2->Bounc_ConfInr;
			default->throw new IllegalStateException("Unexpected value: "+Shuflr.nextInt(3));
		};
	}
	public static Int1$1 Shufl_Chanl_PIp(ThreadLocalRandom Shuflr)
	{
		return (Shuflr.nextBoolean())?
			Shufl_Chanl_ConfInr(Shuflr):
			Rtrnr.Inst;
	}

	public static Dublg$Dubl Shufl_A_SOrc(ThreadLocalRandom Shuflr)
	{
		return switch(Shuflr.nextInt(2))
		{
			case 0->Gom::Hyp;
			case 1->(LOc)->{return nanoTime();};
			default->throw new IllegalStateException("Unexpected value: "+Shuflr.nextInt());
		};
	}
	public static Dublg$Dubl Shufl_LOc$Colr(ThreadLocalRandom Shuflr)
	{
		Dubl1$1 Cord_Mod=Shufl_Mod_Dubl(Shuflr);
		Dublg$Dubl A_SOrc=Shufl_A_SOrc(Shuflr);

		return (LOc)->
		{
			LOc[3]=A_SOrc.Dublg$Dubl(LOc);
			Cord_Mod.Dublg$Dublg(LOc);

			return ABCD$Int(
				(int)LOc[3],
				(int)LOc[0],
				(int)LOc[1],
				(int)LOc[2]);
		};
	}
	public static $Int Shufl_LOc$Colr(ThreadLocalRandom Shuflr,RL_LOc_Havr LOc_SOrc)
	{
		Dublg$Dubl LOc$Colr=Shufl_LOc$Colr(Shuflr);

		return ()->
		{
			double[] LOc=new double[4];
			LOc_SOrc.Get_LOc_CoP_As_ArA(LOc);

			return (int)LOc$Colr.Dublg$Dubl(LOc);
		};
	}
}