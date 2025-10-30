package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import static CC.List.ArA_X.*;
import static CC.Math.Cyclr.Cycl_Mov;
import static CC.Math.Than.Is_BtwEn;
import static CC.UI.ConsOl.Print;
import static DDDTutorial_Modd.D2.D2_Drawbl_Atom.*;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Img.*;
import static CC.Encycloped.Abs.Scal.Physc.SIt.RsOrc_Filr.Img_Filr.Fil_TXtrd;
import static CC.List.List_X.Last;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.Bool$String;
import static CC.Thred.Thred.*;
import static CC.Thred.Thred.WAt_WIl;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.lang.System.nanoTime;
import static java.util.concurrent.Executors.newFixedThreadPool;

import static java.lang.System.out;

public class Draw_RsOrc<Atom_Typ extends Drawbl_Atom<Projectn_Typ>,
						Projectn_Typ extends Atom_Projectn>
{
	public ScrEn ScrEn;

	public byte
		RNdr_MOd=0,
		Drawbl_Atom_Box_MOd=0;
		@Lin_DclAr
		public void Cycl_RNdr_MOd()
		{RNdr_MOd=Cycl_Mov(RNdr_MOd,(byte)1,(byte)4);}
		@Lin_DclAr
		public void Cycl_Drawbl_Atom_Box_MOd()
		{Drawbl_Atom_Box_MOd=Cycl_Mov(Drawbl_Atom_Box_MOd,(byte)1,(byte)2);}

	public		List<Projectn_Typ>  Draw_Ordr;
	public List<List<Projectn_Typ>> LArg;
		@Lin_DclAr
		public void UpdAt_LArg()
		{LArg=LAr(Draw_Ordr,Do_Draw_Num);}

	public int Do_Draw_Num;
		@Lin_DclAr
		public void Set_Do_Draw_Num(int Num)
		{Do_Draw_Num=Num;}
	public int Img_StOr_Num;
		public BufferedImage[] Img_StOrg;
		public Graphics2D[] Img_StOrg_Graphcs;
			public void Set_Img_StOr(int IndX,int X,int Y)
			{
				BufferedImage Img=new BufferedImage(X,Y,TYPE_INT_ARGB);
				Img_StOrg[IndX]=Img;
				Img_StOrg_Graphcs[IndX]=Img.createGraphics();
			}
			public void Rset_Graphcs(int IndX)
			{
				Img_StOrg_Graphcs[IndX].dispose();
				Img_StOrg		 [IndX].createGraphics();
			}
		public boolean[] Img_StOrg_Avalbl;
			public int Get_Avalbl_StOr(int IndX)
			{
				for(;IndX<Img_StOr_Num
					;IndX+=1
	//				,IndX%=Img_StOr_Num
				)
				{
					if(!Img_StOrg_Avalbl[IndX])
					{
						Img_StOrg_Avalbl[IndX]=true;
						return IndX;
					}
	//				else
	//				{out.println("Unavailable");}
				}
				if(true)
				{
					XtNd_StOr();
					return IndX;
				}
				else
				{throw new RuntimeException("No store free");}
			}
				public int Get_Avalbl_StOr()
				{return Get_Avalbl_StOr(0);}
				public void Get_Avalbl_StOrg(int[] StOrg)
				{
					if(StOrg.length>Img_StOr_Num)
					{throw new RuntimeException("Not enough storage");}
					for(int StOr=0,IndX=0;
						StOr<StOrg.length;
						IndX+=1)
					{
						if(IndX>=Img_StOr_Num)
						{throw new RuntimeException("Not enough free storage");}
						if(!Img_StOrg_Avalbl[IndX])
						{
							Img_StOrg_Avalbl[IndX]=true;
							StOrg[StOr]=IndX;
							StOr+=1;
						}
					}
				}
					public int[] Get_Avalbl_StOrg(int Num)
					{
						int[] StOrg=new int[Num];
						Get_Avalbl_StOrg(StOrg);

						return StOrg;
					}
			public void FrE_StOr(int StOr)
			{Img_StOrg_Avalbl[StOr]=false;}
				public void FrE_StOr(int... StOrg)
				{
					for(int StOr:StOrg)
					{FrE_StOr(StOr);}
				}
			public void Print_StOr_Avalbl()
			{
				StringBuilder Bildr=new StringBuilder();
				for(boolean StOr:Img_StOrg_Avalbl)
				{Bildr.append(Bool$String(StOr));}

				out.println("Available:"+Bildr);
			}
		@Lin_DclAr
		public void UpdAt_Xtractd_To()
		{
			Is_Usbl=false;

			int X=ScrEn.getWidth (),
				Y=ScrEn.getHeight();
			if( X>0&&
				Y>0)
			{
				for(int IndX=0;
					IndX<Img_StOr_Num;
					IndX+=1)
				{Set_Img_StOr(IndX,X,Y);}
				MAk_PIplIn(PIplIn_Wid);

				Is_Usbl=true;
			}
		}
		public void XtNd_StOr()
		{
			Img_StOrg=Ad_Item(Img_StOrg,BufferedImage.class,null);
			Img_StOrg_Graphcs=Ad_Item(Img_StOrg_Graphcs,Graphics2D.class,null);
			Set_Img_StOr(Img_StOr_Num,ScrEn.getWidth(),ScrEn.getHeight());
			Img_StOrg_Avalbl=Ad_Item(Img_StOrg_Avalbl,false);
			Img_StOr_Num+=1;
			Chek_Mach();

			out.println("Store extended to "+Img_StOr_Num);
		}
		public void Chek_Mach()
		{
			if(!((Img_StOr_Num==Img_StOrg.length)==(Img_StOrg_Avalbl.length==Img_StOrg_Graphcs.length)))
			{throw new RuntimeException("Mismatch");}
		}

		public void Get_Imgg(BufferedImage[] Imgg,int... StOrg)
		{
			for(int IndX=0;
				IndX<StOrg.length;
				IndX+=1)
			{
				int StOr=StOrg[IndX];
				Imgg[IndX]=
				Img_StOrg[StOr];
			}
		}
		public void Get_Graphcsg(Graphics2D[] Graphcsg,int... StOrg)
		{
			for(int IndX=0;
				IndX<StOrg.length;
				IndX+=1)
			{
				Graphcsg[IndX]=
				Img_StOrg_Graphcs[StOrg[IndX]];
			}
		}
		public void Get_StOrg(BufferedImage[] Imgg,Graphics2D[] Graphcsg,int... StOrg)
		{
			for(int IndX=0;
				IndX<StOrg.length;
				IndX+=1)
			{
				int StOr=StOrg[IndX];
				Imgg[IndX]=Img_StOrg[StOr];
				Graphcsg[IndX]=Img_StOrg_Graphcs[StOr];
			}
		}

	public List<List<BufferedImage>> FrAm_StOr=new ArrayList<>();
	public List<List<Graphics2D>> FrAm_StOr_Graphcs=new ArrayList<>();
	public List<List<Runnable>> Filrg=new ArrayList<>();
	public int PIplIn_Wid;
	public ExecutorService Srvic;
		@Lin_DclAr
		public List<Runnable> Conect_LAr(
			List<Graphics2D> To,
			List<BufferedImage> From,
			int Thred_Num)
		{
			List<Runnable> Filrg=new ArrayList<>();
			for(int From_IndX=0,
				To_IndX=0;
				To_IndX<Thred_Num;
				From_IndX+=2,
				To_IndX+=1)
			{
				Filrg.add(Img_Mrgr(
					To.get(To_IndX),
					From.get(From_IndX),
					From.get(From_IndX+1)));
			}

			return Filrg;
		}
		public long Last_PIplIn=-1;
		public byte PIplIn_Bng_MAd=0;
		@Lin_DclAr
		public void MAk_PIplIn(int Thred_Num)
		{
			out.println("Make pipeline:"+Thred_Num);

			if(PIplIn_Bng_MAd>1)
			{return;}
			WAt_WIl(()->{return PIplIn_Bng_MAd!=0;},1000_0000);
			PIplIn_Bng_MAd+=1;

			try
			{
				long Now=nanoTime(),
					 Sinc_Last=Now-Last_PIplIn;
				Last_PIplIn=Now;
				if(Sinc_Last<10_0000_0000L)
				{Try_WAt_Nano(Print((int)(10_0000_0000-Sinc_Last)));}

				if(Srvic!=null)
				{Srvic.shutdown();}
				Srvic=newFixedThreadPool(Thred_Num);

				int X=ScrEn.getWidth(),
					Y=ScrEn.getHeight();
				List<BufferedImage>
					Last_StOr,
					Crnt_StOr=MAk_Imgg(X,Y,Thred_Num);
				FrAm_StOr.clear();
				FrAm_StOr.add(Crnt_StOr);
				List<Graphics2D>
					Crnt_StOr_Graphcs=MAk_Graphcsg(Crnt_StOr);
				FrAm_StOr_Graphcs.clear();
				FrAm_StOr_Graphcs.add(Crnt_StOr_Graphcs);
				for(;;)
				{
					Thred_Num/=2;

					if(Thred_Num<=1)
					{break;}

					Last_StOr=Crnt_StOr;
					Crnt_StOr=MAk_Imgg(X,Y,Thred_Num);
					FrAm_StOr.add(Crnt_StOr);
					Crnt_StOr_Graphcs=MAk_Graphcsg(Crnt_StOr);
					FrAm_StOr_Graphcs.add(Crnt_StOr_Graphcs);

					Filrg.add(Conect_LAr(Crnt_StOr_Graphcs,Last_StOr,Thred_Num));
				}

				PIplIn_Bng_MAd-=1;
			}
			catch(Exception X)
			{
				PIplIn_Bng_MAd-=1;

				out.println("Exception making pipeline");
				throw X;
			}
		}
		@Lin_DclAr
		public void Get_FrAm(Graphics2D To)
		{
//			Prform_Taskg(Srvic,new ArrayList<>(),
//				Get_LAr_Taskg(
//					ScrEn,
//					PIplIn_Wid,
//					LAr(Draw_Ordr,Boxg,Do_Draw_Num)
//				)
//			);
			Prform_Taskg(Srvic,new ArrayList<>(),
				LAr_Taskg(
					ScrEn,
					PIplIn_Wid,
					Draw_Ordr,Do_Draw_Num)
			);
//			Try_WAt(1000);
			Prform_Taskg2(Srvic,new ArrayList<>(),Filrg);
//			MpT(To);
			ImgN$1(To,Last(FrAm_StOr));
		}
		public void Draw_PIplIn(Graphics2D To,Color Bakground,Color FrAm)
		{
			out.println("Draw_PIplIn");

			int X_LNg=ScrEn.getWidth(),
				Y_LNg=ScrEn.getHeight();
			int LAr_Num=FrAm_StOr.size(),
				Img_Hit=Y_LNg/LAr_Num;
			try
			{
				for(int Y=0;
						Y<LAr_Num;
						Y+=1)
				{
					List<BufferedImage> FrAm_StOr1=FrAm_StOr.get(Y);
					int Bot,Top;
					switch(1)
					{
						case 0->{
							Bot=Y*Img_Hit;
							Top=Bot+Img_Hit;
						}
						case 1->{
							int Hit=Y_LNg/FrAm_StOr1.size();
							Bot=Hit;
							Top=Hit*2;
						}
						default->
						{
							Bot=0;
							Top=0;
						}
					}
					Draw_PIplIn_LAr(To,
						FrAm_StOr1,Bakground,FrAm,
						Bot,Top,
						0,X_LNg);
				}
			}
			catch(Exception X)
			{X.printStackTrace();}
		}

	public boolean Is_Usbl=false;

	public Draw_RsOrc(ScrEn ScrEn,int StOr_Num,int Num,int PIplIn_Wid)
	{
		this.ScrEn=ScrEn;

		Img_StOrg=new BufferedImage[StOr_Num];
		Img_StOrg_Graphcs=new Graphics2D[StOr_Num];
		Img_StOrg_Avalbl=new boolean[StOr_Num];
		Img_StOr_Num=StOr_Num;
		this.PIplIn_Wid=PIplIn_Wid;
		UpdAt_Xtractd_To();

		Draw_Ordr=new ArrayList<>(Num);
		Set_Do_Draw_Num(Num);
	}
}