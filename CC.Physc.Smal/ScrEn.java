package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import CC.COd.UnUsd;

import CC.Bool.Trn.Task_On_Trnbl_Calbl;
import CC.$.Q$.Int$;

import static CC.COd.Neds_Ovrid.No;
import static CC.Encycloped.Abs.Org.Syc.TXt.Num.*;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.*;
import static CC.Encycloped.Abs.Scal.Physc.Obstructn.LOc_Obstructr.Get_Ing;
import static CC.Encycloped.Abs.Scal.Physc.Obstructn.LOc_Obstructr.LOc_Obstructr_KE;
import static CC.Math.CoP.SqAr;
import CC.Cam_CalculAtr;
import CC.Encycloped.Abs.Scal.Gom.*;
import CC.Encycloped.Abs.Scal.Physc.Colr.Colr;
import CC.Encycloped.Abs.Scal.Physc.SIt.*;
import CC.MAkng_RsOrc;
import CC.Math.Arithmetc;
import CC.Math.Cyclr;
import CC.UI.Sig.Input_Havr;
import DDDTutorial_Modd.*;
import DDDTutorial_Modd.ConstL.StR;
import DDDTutorial_Modd.D2.*;
import DDDTutorial_Modd.D3.*;
import DDDTutorial_Modd.D3.D2$3.D2$3_Projectn;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon.D2_Polygon;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon;
import MAn.LOc_Obstructn;
import CC.$.$Q.$Point;
import CC.Bool.Trn.Onbl;
import CC.Bool.Trn.Task_On_Trnbl_Runbl;
import MAn.MAn;
import CC.Encycloped.Abs.Scal.Physc.GraviT.GraviT_Sorc;
import CC.Encycloped.Abs.Scal.Physc.Lit.LIt_SOrc;
import CC.Encycloped.TIm.UpdAtbl;
import CC.Encycloped.Abs.Scal.Physc.Obstructn.Bordr_NOd;
import CC.Encycloped.Abs.Org.Syc.TXt.LIn_Adbl;
import CC.UI.Sig.Input_Com;
import UI.Mous_Lokr;
import static CC.Math.Cyclr.Cycl_Mov;
import static CC.UI.Sig.Input_COd.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import static CC.List.BAs_ArA.ABC;
import static CC.Math.Math_Plus.Is_Nth;
import static CC.Math.Calculatr.*;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Img.IntegrAt_TImr;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Img.Singl_Colr_Chek;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.*;
import static DDDTutorial_Modd.D2.D2_Drawbl_Atom.*;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.Trip;
import static DDDTutorial_Modd.D3.D3_Projectn.D3_Projectn_ConcrEt.UpdAt_Ordr;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Invrs_SqAr;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl.Draw;
import static CC.List.List_X.Cycl_Item;
import static DDDTutorial_Modd.Tool.SLectn_Info;
import static MAn.HUD_Util.*;
import static MAn.Physc_.Ad_GraviT;
import static MAn.Physc_.Ad_Lit;
import static DDDTutorial_Modd.Util.*;
import static CC.Encycloped.Abs.Scal.Physc.Magnetsm.Magnetsm_SOrc.Magnetsm_SOrc_KE;
import static CC.Encycloped.Abs.Scal.Physc.Tik_Tran.Halt;
import static java.awt.Color.black;
import static java.awt.Color.white;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.MouseEvent.*;
import static java.lang.Math.*;
import static java.lang.System.*;
import static java.lang.Thread.sleep;

public class ScrEn extends JPanel implements
	Cam<D3_Drawbl_Atom<D3_Projectn>,D3_Projectn>,
	Input_Com,LIn_Adbl,TLeportbl
{
	//<editor-fold desc="SpAc">
	private RL_LOc_Havr Parnt;
		@Override @Neds_Ovrid(NEds=Neds_Ovrid.No) @Finishd(Is_Finishd=true)
		public final RL_LOc_Havr Get_Gom_PArnt()
		{return Parnt;}
		@Override @Finishd(Is_Finishd=true)
		public void Set_Gom_PArnt(RL_LOc_Havr PArnt)
		{this.Parnt=PArnt;}

	//<editor-fold desc="LOc">
	private LOc RL_Loc=new LOc();
		@Override @Neds_Ovrid(NEds=Neds_Ovrid.No) @Finishd(Is_Finishd=true)
		public final LOc Get_RL_LOc()
		{return RL_Loc;}
		@Override @Finishd(Is_Finishd=true)
		public void Set_RL_LOc(LOc LOc)
		{RL_Loc=LOc;}
	public double[]
		LOc_Cach=new double[3],VEw_To={100,100,100},
		Last_VEw_From={15,5,10},Last_VEw_To={100,100,100},
		Last_TLeport_VEw_From={15,5,10},Last_TLeport_VEw_To={100,100,100};
		public TLeport_ContXt TLeport_ContXt=new TLeport_ContXt(this);
		@Finishd(Is_Finishd=false)
		public void UpdAt_Loc_Cach()
		{Get_LOc_CoP_As_ArA(LOc_Cach);}
		@Override @Finishd(Is_Finishd=false)
		public void TLeport(double X,double Y,double Z)
		{
			double[] VEw_From=Get_LOc_CoP_As_ArA();

			ABC(Last_VEw_From,VEw_From);
			ABC(Last_VEw_To,VEw_To);

			Get_Gom_PArnt().UpdAt_LOc(X,Y,Z);

			ABC(Last_TLeport_VEw_From,VEw_From);
			ABC(Last_TLeport_VEw_To,VEw_To);

			out.println("Teleported to:"+X+","+Y+","+Z);
		}
		public Hyp_Vectr VEw_Vectr;
			public int
				Look_Octnt,
				Rev_Look_Octnt;
			@Finishd(Is_Finishd=false)
			public byte UpdAt_Look_Octnt(byte Latrl)
			{
				byte Look_Category=(byte)VEw_Vectr.CalculAt_Dr_Octnt(Latrl);
				this.Look_Octnt=Look_Category;
				Look_Category=Hyp_Vectr.Rev_Dr(Look_Category);
				this.Rev_Look_Octnt=Look_Category;

				return Look_Category;
			}
			public double Dr_Rang=switch(1)
			{
				case 0->.5;
				default->1;
			};
				@Finishd(Is_Finishd=false)
				public void Mov_Dr_Rang(double Vectr)
				{Dr_Rang=ConfIn(Dr_Rang+Vectr,0,1);}
	//The smaller the zoom the more zoomed out you are and visa versa, although altering too far from 1000 will make it look pretty weird
	public double[] Focus_POs=new double[3];
	public double
		Zoom=1000,
		Min_Zoom=-5000,Max_Zoom=5000,
		Mous_X=0,Mous_Y=0,
		Mov_SpEd=
			8
//			.5
		,
		OutlIn_Britns=.5;
	public double
		Draw_FPS=0,Max_FPS=
//			20
			100
			,
		SlEp_TIm=1000/Max_FPS,Last_Rfresh=0,
		StRt_TIm=currentTimeMillis(),
		Last_FPS_Chek=0,Chek_Num=0;
	//aimSight changes the size of the center-cross. The lower HorRotSpeed or VertRotSpeed,the faster the camera will rotate in those directions
	public double
		Vrt_Look=-.9,Hor_Look=0,K=0,
		Vrt_Rot_SpEd=2200,Hor_Rot_SpEd=900,K_Rot_SpEd=900;
	//</editor-fold>
	//</editor-fold>

	public List<UpdAtbl> UpdAt_Lisnrg=new ArrayList<>();
		@Override @Neds_Ovrid(NEds=Neds_Ovrid.No) @Finishd(Is_Finishd=false)
		public List<UpdAtbl> Get_UpdAt_Lisnrg()
		{return UpdAt_Lisnrg;}

	public TRgetng_RsOrc TRgetng_RsOrc=new TRgetng_RsOrc(this);

	//<editor-fold desc="OutlIn">
	public int OutlIn_MOd=1;
		public static final int
			No_OutlIn=0,
			Colr_OutlIn=1,
			Blak_OutlIn=2
		;
		@Finishd(Is_Finishd=false)
		public void Cycl_OutlIn_MOd()
		{OutlIn_MOd=(OutlIn_MOd+1)%3;}
		@Finishd(Is_Finishd=false)
		public Color Get_OutlIn_Colr(Color Colr)
		{
			int MOd=OutlIn_MOd;
			if(MOd==Blak_OutlIn)
			{return black;}
			else if(MOd==Colr_OutlIn)
			{return New_Colr(ShAd(Colr.getRGB(),(float)OutlIn_Britns));}
			else
			{return null;}
		}
		@Finishd(Is_Finishd=false)
		public void OutlIn(Filr Filr,Graphics2D Graphcs)
		{
			if(OutlIn_MOd==Blak_OutlIn)
			{
				RsOrc_Filr.Colr_Filr.OutlIn_Colr(Graphcs,black);
			}
			else if(OutlIn_MOd==Colr_OutlIn)
			{Filr.OutlIn(this,Graphcs);}
		}
	//</editor-fold>

	{
		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(@UnUsd ComponentEvent EvNt)
			{Draw_Rsorc.UpdAt_Xtractd_To();}
		});
	}
	public Color Bakground_Colr=
		new Color(0,0,0,(true)?
			255:
			16
		)
//		new Color(140,180,180)
	;
	public List<D3_Projectn> Drawblg=new ArrayList<>();
		@Override @Finishd(Is_Finishd=false)
		public List<D3_Projectn> Get_Drawblg()
		{return Drawblg;}
	public Draw_RsOrc<D3_Drawbl_Atom<D3_Projectn>,D3_Projectn> Draw_Rsorc;
	//<editor-fold desc="Proj">
	public double[]
		Calc_Pos=new double[3],
		VrtX_StOr=new double[3],
		Rang_StOr=new double[2];
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public final double[] Get_VrtX_StOr()
		{return VrtX_StOr;}
	@Finishd(Is_Finishd=false)
	public double P(int LNg,double Focus,double Cord)
	{return (LNg/2F)-Focus+(Cord*Zoom);}
	@Finishd(Is_Finishd=false)
	public void Rectilin(double[] Projectd)
	{
		ABC(Projectd,
			P(getWidth(),Focus_POs[0],VrtX_StOr[0]),
			P(getHeight(),Focus_POs[1],VrtX_StOr[1]),
			VrtX_StOr[2]);
	}
	public List<Projectr> Projectrg=new ArrayList<>();
	{
		Projectrg.add(
			(
				X,Y,Z,
				Projectd)->
			{
				Cam_CalculAtr.Project(
					LOc_Cach,
					VEw_To,
					X,Y,Z,
					VrtX_StOr);
			});
		Projectrg.add(
			(
				X,Y,Z,
				Projectd)->
			{
				Cam_CalculAtr.Project_(
					X,Y,Z,
					-Vrt_Look,-Hor_Look,-K,
					VrtX_StOr);
			});
		Projectrg.add(
			(
				X,Y,Z,
				Projectd)->
			{
				Gom.rotate(
					ABC(X,Y,Z),
					Hor_Look,Vrt_Look,K,
					Projectd);
			});
	}
	public Projectr Projectr=Projectrg.get(0);
		@Override @Finishd(Is_Finishd=false)
		public CC.Encycloped.Abs.Scal.Gom.Projectr Get_Rapd_Projectr()
		{return Projectr;}
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public void Cycl_Projectn_MOd()
		{Projectr=Cycl_Item(Projectrg,Projectr);}
		public boolean Do_Transdim=true;
		@Override @Finishd(Is_Finishd=false)
		public void Project(
			double X,double Y,double Z,
			double[] LOc)
		{
			Arithmetc.Sub(LOc,X,Y,Z,LOc_Cach);
			Cam.super.Project(X,Y,Z,LOc);
			if(Do_Transdim){Rectilin(LOc);}
		}
		@Finishd(Is_Finishd=false)
		public int Projectr_IndX()
		{return Projectrg.indexOf(Projectr);}
	//</editor-fold>
	public int Undrawn,Drawn,Bak_FAc_Culd;
	//<editor-fold desc="TRgetng">
	public Ofsetbl_D2_Drawbl_TMplat VrtX_TMplat=new Al_Ofsetbl_D2_Drawbl_TMplat(
		new Drawbl_Crcl_TMplat(1,new Bound_Colr_Filr(white)),
		new LOc_ShOr(white));
	@Finishd(Is_Finishd=false)
	public void Draw_Vrtices(Graphics2D Graphcs)
	{
		if(TRgetng_RsOrc.TRget_Drawbl instanceof Drawbl_LOcg_Usr LOcg)
		{
			LOcg_Havr LOcg_=LOcg.Get_Rapd_LOcg();
			D2$3_Projectn Projectn=new D2$3<>(VrtX_TMplat).MAk_Projectn();
			for(int IndX=0;
				IndX<LOcg.Get_LOc_Num();
				IndX+=1)
			{VrtX_TMplat.Draw_Projectn(this,Graphcs,Projectn,LOcg_,IndX);}
		}
	}
	//<editor-fold desc="Box">
	public Cub TRget_Box;
		public Atom_Projectn[] Box_Projectn;
		public double[] TRget_Box_Mesrmnt=new double[6];
		public void UpdAt_SLectn_Box()
		{TRget_Box_Mesrmnt=UpdAt_Box(this,TRget_Box,Box_Projectn,TRgetng_RsOrc.Get_TRget_Object(),PlAc_LOc.Get_LOc_CoP_As_ArA());}
	@Finishd(Is_Finishd=false)
	public void Draw_Box(Graphics Graphcs,Object Box_Sorc)
	{
		double[] Box=
			(Box_Sorc instanceof double[] Box_)?Box_:
			(Box_Sorc instanceof Out_Box_Getbl Sorc)?Sorc.Get_Bordr_Out_Box_StRt():
			null;
//		Polyhedron FrAm=new Polyhedron();
//		Draw_Polygon();
	}
		@Finishd(Is_Finishd=false)
		public void Draw_SLectn_Box(Graphics2D Graphcs)
		{
			if(TRgetng_RsOrc.TRget_Drawbl!=null)
			{Draw_Box_Projectn(this,Graphcs,Box_Projectn);}
		}
	//</editor-fold>
	//</editor-fold>
	public byte RNdr_Skip_MOd=0;
		@Finishd(Is_Finishd=false)
		public void Togl_RNdr()
		{RNdr_Skip_MOd=Cyclr.Cycl_Up(RNdr_Skip_MOd,(byte)3);}
	public int RNdr_IndX=0,RNdr_Cycl=2;
		@Finishd(Is_Finishd=false)
		public void Mov_RNdr_Cycl(int Vectr)
		{RNdr_Cycl+=Vectr;}
	@Override @Finishd(Is_Finishd=false)
	public void paintComponent(Graphics Graphcs)
	{
//		Draw_Rsorc.UpdAt_Xtractd_To();

		Physc_SpAc SpAc=Get_SpAc();

		UpdAt_PlAc_LOc();
		Set_CroshAr_LOc();

		Mov_Actn();

		Cam_CalculAtr.Set_PreDtrmind_Info(this);

		if(SpAc.Is_On())
		{
			SpAc.Tik();
				List<D3_Projectn> Atomg=Get_Drawblg();
				UpdAt_Loop(this,Atomg);
				int Atom_Num=Atomg.size();
				Draw_Rsorc.Set_Do_Draw_Num(Atom_Num);
				Draw_Rsorc.Set_Do_Draw_Num(UpdAt_Ordr(Atomg,
					Draw_Rsorc.Draw_Ordr));

//				out.println("Do_Draw "+Draw_Rsorc.Do_Draw_Num+"/"+Atom_Num);
		}
		TRgetng_RsOrc.Set_TRget_Drawbl();
		if(Graphcs instanceof Graphics2D Graphcs_&&Draw_Rsorc.Is_Usbl)
		{
			if(
				(RNdr_Skip_MOd==0)||
				(RNdr_Skip_MOd==1&&Is_Nth(RNdr_IndX,RNdr_Cycl)))
			{
				try
				{
					GUI.Fil(this,Graphcs_,Bakground_Colr);
					switch(Draw_Rsorc.RNdr_MOd)
					{
						case 0->
						{
							Draw_Nd(this,Graphcs_,
								Draw_Rsorc.Draw_Ordr,
								Draw_Rsorc.Do_Draw_Num);
						}
						case 1->
						{
							D2_Drawbl_Atom.Draw_LArg_(this,Graphcs_,
								Draw_Rsorc.LArg);
							Filr.Trip((Graphics2D)Graphcs,getBounds());
						}
						case 2->
						{
							Draw_Rsorc.Get_FrAm(Graphcs_);
						}
						case 3->
						{
							Draw_Rsorc.Get_FrAm(Graphcs_);
							Draw_Rsorc.Draw_PIplIn(Graphcs_,black,white);
						}
					}
				}
				catch(Exception X)
				{
					out.println("Exception while rendering");
					X.printStackTrace();
				}
				Graphcs_.setClip(null);
				switch(Draw_Rsorc.Drawbl_Atom_Box_MOd)
				{
					case 0->{}
					case 1->
					{
						D2_Drawbl_Atom.OutlIn_Boxg(Graphcs_,Draw_Rsorc,
	//						white,
							Set_A(white,64)
						);
					}
				}
				switch(1)
				{
					case 0->{}
					case 1->
					{
						List<Bordr_NOd> TrE=SpAc.Gar_Category("Colisn_TrE");
//						out.println("Bordr_NOd num:"+TrE.size()
//							+","+TrE.get(0).LEfg.size()
//						);
						Draw_Boxg(this,Graphcs_,TRget_Box,Box_Projectn,
							TrE);
					}
				}

				Draw_Vrtices(Graphcs_);
				Graphcs_.setClip(null);
				UpdAt_SLectn_Box();
				Draw_SLectn_Box(Graphcs_);
				Graphcs_.setClip(null);
				if(false)
				{
					Color StR_TXt_Colr=new Color(255,255,255,191);
					Graphcs.setColor(StR_TXt_Colr);
					List<StR> StRg=SpAc.Gar_Category("StR");
					for(StR StR:StRg)
					{
	//					StR.DisplA.UpdAt_Drawbl(this);
						StR.DisplA.UpdAt();
	//					StR.DisplA.Draw(this,Graphcs_);
					}
				}
			}

			Draw_HUD(Graphcs_);
		}

//		RpAnt_TIm=System.currentTimeMillis()-RpAnt_TIm;
//		out.println(RpAnt_TIm);
		RNdr_IndX+=1;
		SlEp_Al_Rfresh();
	}
	@Override @Finishd(Is_Finishd=false)
	public void Tik()
	{}
	public Physc_SpAc ScrEn_SpAc=new Physc_SpAc(true);

	//<editor-fold desc="PlAc">
	public double PlAc_Distnc=(false)?
		16:
		128
	;
	public RL_LOc_Havr PlAc_LOc;
		public SpAc_Object Tool;
			public LIt_SOrc Lit;
			public GraviT_Sorc GraviT;
		public void UpdAt_PlAc_LOc()
		{PlAc_LOc.UpdAt_RL_LOc(Arithmetc.Mul(Arithmetc.Sub(LOc_Cach,VEw_To),PlAc_Distnc));}
	public byte MAk_MOd=
		2
//		(byte)(Object_MAkrg.size()-1)
	;
	//</editor-fold>
	public MAkng_RsOrc MAkng_RsOrc=new MAkng_RsOrc(TRgetng_RsOrc);

	//<editor-fold desc="CroshAr">
	public CroshAr CroshAr_=new CroshAr(4,new Color(255,255,255,191));
		@Finishd(Is_Finishd=false)
		public void Set_CroshAr_LOc()
		{CNtr_CroshAr();}
			@Finishd(Is_Finishd=false)
			public void CNtr_CroshAr()
			{
				double[] Loc=CroshAr_.LOc;
				Loc[0]=getWidth()/2;
				Loc[1]=getHeight()/2;
			}
	//</editor-fold>

	public long RpAnt_TIm=0;
	@Finishd(Is_Finishd=false)
	public void SlEp_Al_Rfresh()
	{
		long TIm_SLU=(long)(currentTimeMillis()-Last_Rfresh);

		Chek_Num+=1;
		if(Chek_Num>=15)
		{
			Draw_FPS=Chek_Num/((currentTimeMillis()-Last_FPS_Chek)/1000);
			Last_FPS_Chek=currentTimeMillis();
			Chek_Num=0;
		}
		if(TIm_SLU<(1000/Max_FPS))
		{
			try
			{sleep((long)((1000/Max_FPS)-TIm_SLU));}
			catch(InterruptedException X)
			{X.printStackTrace();}
		}

		Last_Rfresh=currentTimeMillis();

		repaint();
	}

	public int[]
		X_Axis=GUI.GD_Axis,
		Y_Axis=GUI.RF_Axis,
		Z_Axis=GUI.SpAc_B_Axis;
	public double Object_Mov_SpEd=.1,
		DcLrAtn=.8;
	public byte Movmnt_MOd=0;
	public void Mov_Cam()
	{
		Hyp_Vectr VEw_Vectr=new Hyp_Vectr(
			VEw_To[0]-LOc_Cach[0],
			VEw_To[1]-LOc_Cach[1],
			VEw_To[2]-LOc_Cach[2]);
		double
			Mov_X=0,
			Mov_Y=0,
			Mov_Z=0;
		Hyp_Vectr
			Vrtcl_Vectr=new Hyp_Vectr(0,0,1),
			Horizontl_Vectr=new Hyp_Vectr(1,0,0),
			X_VEw_Vectr=VEw_Vectr.Cros_Product(Vrtcl_Vectr),
			Z_VEw_Vectr=VEw_Vectr.Cros_Product(Horizontl_Vectr);
		boolean Is_Movng=false;

		if(Input_Havr.KE_AccSr.Get(this,Z_Axis[0]).Is_On())
		{
			Mov_Z+=1;
			Is_Movng=true;
		}
		if(Input_Havr.KE_AccSr.Get(this,Z_Axis[1]).Is_On())
		{
			Mov_Z-=1;
			Is_Movng=true;
		}

		if(Input_Havr.KE_AccSr.Get(this,Y_Axis[0]).Is_On())
		{
			Mov_X+=VEw_Vectr.X;
			Mov_Y+=VEw_Vectr.Y;
			Mov_Z+=VEw_Vectr.Z;
			Is_Movng=true;
		}
		if(Input_Havr.KE_AccSr.Get(this,Y_Axis[1]).Is_On())
		{
			Mov_X-=VEw_Vectr.X;
			Mov_Y-=VEw_Vectr.Y;
			Mov_Z-=VEw_Vectr.Z;
			Is_Movng=true;
		}

		if(Input_Havr.KE_AccSr.Get(this,X_Axis[0]).Is_On())
		{
			Mov_X-=X_VEw_Vectr.X;
			Mov_Y-=X_VEw_Vectr.Y;
			Mov_Z-=X_VEw_Vectr.Z;
			Is_Movng=true;
		}
		if(Input_Havr.KE_AccSr.Get(this,X_Axis[1]).Is_On())
		{
			Mov_X+=X_VEw_Vectr.X;
			Mov_Y+=X_VEw_Vectr.Y;
			Mov_Z+=X_VEw_Vectr.Z;
			Is_Movng=true;
		}

		Hyp_Vectr Mov_Vectr=new Hyp_Vectr(Mov_X,Mov_Y,Mov_Z);
		Tik_Tran Tran=Get_Sistr_Physc("Tran");
		Mov_X=Mov_Vectr.X*Mov_SpEd;
		Mov_Y=Mov_Vectr.Y*Mov_SpEd;
		Mov_Z=Mov_Vectr.Z*Mov_SpEd;
		switch(Movmnt_MOd)
		{
			case 0->
			{
				Tran.ScAl(DcLrAtn);
				Tran.AccLrAt(
					Mov_X,
					Mov_Y,
					Mov_Z);
				UpdAt();
			}
			case 1->
			{
				if(Is_Movng)
				{
					Mov_To(
						LOc_Cach[0]+Mov_X,
						LOc_Cach[1]+Mov_Y,
						LOc_Cach[2]+Mov_Z);
					Tran.Halt();
				}
			}
			case 2->
			{
				Tran.AccLrAt(
					Mov_X,
					Mov_Y,
					Mov_Z);
				UpdAt();
			}
		}
	}
	@Finishd(Is_Finishd=false)
	public double CalculAt_Mov(int[] Axis,double Vectr)
	{
		if(Input_Havr.KE_AccSr.Get(this,Axis[0]).Is_On()){Vectr+=Object_Mov_SpEd;}
		if(Input_Havr.KE_AccSr.Get(this,Axis[1]).Is_On()){Vectr-=Object_Mov_SpEd;}

		return Vectr;
	}
		@Finishd(Is_Finishd=false)
		public double CalculAt_Mov(int[] Axis)
		{return CalculAt_Mov(Axis,0);}
	@Finishd(Is_Finishd=false)
	public void Mov_Object()
	{
		if(TRgetng_RsOrc.SLectd instanceof Polyhedron SLectd)
		{
			CalculAt_Mov(Y_Axis);
			CalculAt_Mov(X_Axis);
			RL_LOc_Havr
				Parnt=SLectd.Get_Gom_PArnt(),
				Movbl=
//					(
//						Parnt instanceof Polyhedron||
//						Parnt instanceof SpAc)?
//							SLectd:
							Parnt;
			Movbl.Mov(
				CalculAt_Mov(X_Axis),
				CalculAt_Mov(Y_Axis),
				CalculAt_Mov(Z_Axis));
			Movbl.UpdAt();
		}
	}
	public byte Mov_Actn_COd=0b11;
		public static byte
			Mov_Cam_COd=0b10,
			Mov_Object_COd=0b01;
	@Finishd(Is_Finishd=false)
	public void Mov_Actn()
	{
		if((Mov_Actn_COd&Mov_Cam_COd)!=0){Mov_Cam();}
		if((Mov_Actn_COd&Mov_Object_COd)!=0){Mov_Object();}
	}
	@Finishd(Is_Finishd=false)
	public void Mov_To(double X,double Y,double Z)
	{
		Get_Gom_PArnt().UpdAt_LOc(X,Y,Z);
		UpdAt();
	}
	@Finishd(Is_Finishd=false)
	public void UpdAt_VEw()
	{
		double R=sqrt(1-SqAr(Vrt_Look));
		ABC(VEw_To,
			LOc_Cach[0]+(R*cos(Hor_Look)),
			LOc_Cach[1]+(R*sin(Hor_Look)),
			LOc_Cach[2]+Vrt_Look);
	}

	//<editor-fold desc="Input">
	@Finishd(Is_Finishd=false)
	public Map<String,Onbl> Inputg=new HashMap<>();
		@Lin_DclAr @Neds_Ovrid(NEds=Neds_Ovrid.Yes) @Finishd(Is_Finishd=true)
		public Map<String,Onbl> Get_On_Trnbl_List()
		{return Inputg;}
		public int
			TLeport_To_Origin_KE=VK_BACK_QUOTE,
			TLeport_Bak_KE=VK_1,
			OutlIn_KE=VK_O,
			DlEt_KE=VK_DELETE;
		@Finishd(Is_Finishd=false)
		public void Init_Input()
		{
			Input_Havr.KE_AccSr.Set(this,VK_A,new Task_On_Trnbl_Runbl(()->
			{Movmnt_MOd=Cycl_Mov(Movmnt_MOd,(byte)1,(byte)3);}));
			Tik_Tran Tran=Get_Sistr_Physc("Tran");
			Input_Havr.KE_AccSr.Set(this,VK_N,new Task_On_Trnbl_Runbl(Tran::Togl_Is_In_SpAc));
			Input_Havr.KE_AccSr.Set(this,VK_M,new Task_On_Trnbl_Runbl(Get_SpAc().Sortd_Item_Toglr(Tran,"GraviT_Efectbl")));
//				Magnetsm_Sorc Magnet=Get_Sistr_Physc("Magnetsm_Sorc");
//					Set_KE_Input(VK_COMMA,new Task_Onbl(Get_SpAc().Sortd_Item_Toglr(Magnet,"Magnetsm_Efectbl")));
			Set_Input(
				Prefx_KE(TLeport_To_Origin_KE,TLeport_Bak_KE),
				new Runnable[]
				{
					()->{TLeport(0,0,0);},
					TLeport_ContXt::TLeport_Bak
				});
			Set_Input(
				Prefx_KE(VK_Z,VK_X,VK_W,VK_E),
				MAkng_RsOrc.Ant.Nav_Set());
			Set_Input(
				Prefx_KE(DlEt_KE,VK_ESCAPE),
				new Runnable[]{TRgetng_RsOrc::DlEt_SLectd,Mous_Lokr::Unlok});

			Set_Input(
				Prefx_Mous_Butn(BUTTON1,BUTTON3),
				MAkng_RsOrc.MAk_MIn_PAr());
			Set_Input(
				Prefx_KE(VK_5,VK_ENTER),
				new Object[]
				{
					(Runnable)TRgetng_RsOrc::Togl_TRget_Ny,
					Tool.Physc_Toglr(GraviT)
				});

			Set_Input(new Object[]
				{
					Prefx_Mous_Butn(BUTTON2),(Runnable)TRgetng_RsOrc::Set_SLectd,
					Prefx_KE(VK_U),(Runnable)()->{Halt((List<Tik_Tran>)Get_SpAc().Get_Physc_LMNt_Cast("Tran"));},
					Prefx_KE(VK_P),(Runnable)LOc_Obstructn::Cycl_Mov_MOd
				});
			Set_Input(
				new String[]
				{
					Prefx_KE(VK_T),
					Prefx_KE(VK_Y)
				},
				TRgetng_RsOrc.Transparnt_PAr());

			Task_On_Trnbl_Runbl Lokr=new Task_On_Trnbl_Runbl(
				Mous_Lokr::CNtr_Mous_If_Lokd);
				Set_Input(new Object[]
					{
						Mous_Mov,Lokr,
						Mous_Drag,Lokr
					});

			Input_Havr.KE_AccSr.Set(this,VK_H,new Task_On_Trnbl_Runbl(this::Togl_RNdr));
			Set_Input(
				Prefx_KE(VK_J,VK_K),
				((Int$)this::Mov_RNdr_Cycl).SIn_PAr());
			Set_Input(
				Prefx_KE(VK_Q,VK_9,VK_6,VK_7,VK_8,OutlIn_KE),
				new Runnable[]{
				()->{Singl_Colr_Chek=!Singl_Colr_Chek;},
				()->{Do_Draw_Hud=!Do_Draw_Hud;},
				Draw_Rsorc::Cycl_Drawbl_Atom_Box_MOd,
				this::Cycl_Projectn_MOd,
				()->{Do_Transdim=!Do_Transdim;},
				this::Cycl_OutlIn_MOd});

			Set_Input(
				Prefx_KE(VK_EQUALS,VK_BACK_SLASH),
				new Runnable[]
				{
					MAn::MAk_TSt_SpAc,
					()->{MAn.MAk_Dbug_SpAc(Get_SpAc());}
				});
		}
	//<editor-fold desc="Mous">
	@Override @Finishd(Is_Finishd=false)
	public void mousePressed(MouseEvent EvNt)
	{
		Input_Com.super.mousePressed(EvNt);
		if(!MNU_Is_On.Is_On())
		{Mous_Lokr.Lok();}
	}
		public Mous_Lokr Mous_Lokr=new Mous_Lokr(this);
	public DialAtr Box_DialAtr,SphEr_DialAtr;
	@Override @Finishd(Is_Finishd=false)
	public void mouseWheelMoved(MouseWheelEvent EvNt)
	{
		int Vectr=EvNt.getUnitsToScroll();
		Input_Com.super.mouseWheelMoved(EvNt);
		if(Input_Havr.KE_AccSr.Get(this,VK_CONTROL).Is_On())
		{Mov_SpEd-=Vectr;}
		else if(Input_Havr.KE_AccSr.Get(this,VK_SHIFT).Is_On())
		{PlAc_Distnc-=Vectr;}
		else if(Input_Havr.KE_AccSr.Get(this,VK_N).Is_On())
		{GraviT.StrNgth-=Vectr;}
		else if(Input_Havr.KE_AccSr.Get(this,VK_U).Is_On())
		{Mov_Dr_Rang(-EvNt.getUnitsToScroll()/100F);}
		else if(Input_Havr.KE_AccSr.Get(this,VK_I).Is_On()&&Box_DialAtr!=null)
		{Box_DialAtr.DialAt(-EvNt.getUnitsToScroll());}
		else if(Input_Havr.KE_AccSr.Get(this,VK_O).Is_On()&&SphEr_DialAtr!=null)
		{SphEr_DialAtr.DialAt(-EvNt.getUnitsToScroll());}
		else if(Input_Havr.KE_AccSr.Get(this,VK_OPEN_BRACKET).Is_On())
		{LOc_Obstructn.Mov_Group_Cbrt(-EvNt.getUnitsToScroll());}
		else if(Input_Havr.KE_AccSr.Get(this,VK_ALT).Is_On())
		{Get_SpAc().TIm+=(double)EvNt.getUnitsToScroll()/-48;}
		else
		{Zoom=Cam_CalculAtr.Xtractd_Zoom_Movr(
			Zoom,EvNt.getUnitsToScroll(),
			Min_Zoom,Max_Zoom);
		}
	}
	public double Vrt_Look_Rad=.999;
	@Finishd(Is_Finishd=false)
	public void Mous_Movmnt(
		double New_Mous_X,
		double New_Mous_Y,
		double New_Mous_Z)
	{
		if(Mous_Lokr.Get_Is_Lokd())
		{
			double Rad_X=New_Mous_X-getWidth()/2;
			double Rad_Y=New_Mous_Y-getHeight()/2;
			Rad_Y*=6-abs(Vrt_Look)*5;
			Vrt_Look-=Rad_Y/Vrt_Rot_SpEd;
			Vrt_Look%=360;
			Hor_Look+=Rad_X/Hor_Rot_SpEd;
			Hor_Look%=360;
			K+=New_Mous_Z;
			K%=360;
		}

		if(Projectr_IndX()==0)
		{
			Vrt_Look=ConfIn(Vrt_Look,
				-Vrt_Look_Rad,
				Vrt_Look_Rad);
		}
		UpdAt_VEw();
	}
		@Finishd(Is_Finishd=false)
		public void Mous_Movmnt(MouseEvent EvNt)
		{
			int X=EvNt.getX(),
				Y=EvNt.getY();
			Mous_Movmnt(X,Y,CalculAt_Sign(
				Input_Havr.KE_AccSr.Get(this,VK_ENTER).Is_On(),
				Input_Havr.KE_AccSr.Get(this,VK_BACK_SPACE).Is_On()
			));
			Mous_X=X;
			Mous_Y=Y;
		}
	@Override @Finishd(Is_Finishd=false)
	public void mouseMoved(MouseEvent EvNt)
	{
		Input_Com.super.mouseMoved(EvNt);
		Mous_Movmnt(EvNt);
	}
	@Override @Finishd(Is_Finishd=false)
	public void mouseDragged(MouseEvent EvNt)
	{
		Input_Com.super.mouseDragged(EvNt);
		Mous_Movmnt(EvNt);
	}
	//</editor-fold>

	//<editor-fold desc="HUD">
	@Finishd(Is_Finishd=false)
	public $Point<String> Cam_Info()
	{
		return ()->{return FEld$String(
			"POV",List$String(Lim,LOc_Cach),
			"Look",
			List$String(Lim,VEw_To)+
				ParIs(List$String(Lim,VEw_Vectr.$ArA())),
			"Zoom",Lim_Mantisa(Zoom),
			"I",Lim_Mantisa(Hor_Look),
			"J",Lim_Mantisa(Vrt_Look),
			"K",Lim_Mantisa(K),
			"Dr_Rang",Lim_Mantisa(Dr_Rang));
		};
	}
	public SpAc_Object HUD=new SpAc_Object(ScrEn_SpAc,null);
		@Finishd(Is_Finishd=false)
		public int HUD_Positn=1,X=5,Y=10,Lim=Dfalt_Mantisa_Lim;
		{}
		public Color HUD_Colr=white;
		@Override @Finishd(Is_Finishd=false)
		public void Ad_HUD($Point<String> SOrc,
			int X,
			int Y)
		{
			Polyhedron Graphc=(Polyhedron)HUD.Get_Physc_LMNt("SEn");
			Graphc.Ad_Drawbl_Atom(
				new D2_TMplatd_Atom(Graphc,
					new TXt_At_Point(SOrc,HUD_Colr),X,Y).MAk_Projectn());
		}
			@Override @Finishd(Is_Finishd=true)
			public void Ad_HUD($Point<String> SOrc)
			{
				Ad_HUD(SOrc,X,HUD_Positn*Y);
				HUD_Positn+=1;
			}
				@Finishd(Is_Finishd=false)
				public void Init_HUD()
				{
					Physc_SpAc SpAc=Get_SpAc();

					Polyhedron Graphic=new Polyhedron(HUD,null);
					Graphic.Set_Drawbl_Atomg();
					HUD.Ad_Physc(Graphic);
					Ad_HUD(TRgetng_RsOrc.TRget_HUD());
					Ad_HUD(
						()->{
							Physc_SpAc SpAc_=Get_SpAc();

							return Totl$String(SpAc_.Sortd_Objectg,"Objects")+SpAc_.Get_Physc_Numg(
								"Spring",
								"Lit_Sorc",
//									,"Light source"
								"GraviT_Sorc",
//									,"Gravity source"
								Magnetsm_SOrc_KE,
//									,"Magnetism source"
								LOc_Obstructr_KE
//									,"Obstructr"
							);
						},
						()->{return
							FEld$String(
								"Drawbl",SpAc.Get_Physc_Atomg("SEn").size(),
								"Drawn",Draw_Rsorc.Draw_Ordr.size(),
								"Undrawn",Undrawn,
								"Drawn",Drawn,
								"Bak_FAc_Culd",Bak_FAc_Culd,
								"IntegrAt",IntegrAt_TImr);
						},
						()->{return FEld$String("FPS",(int)Draw_FPS+" (Benchmark)");},
						()->{return FEld$String("Speed",Mov_SpEd);},
						Cam_Info(),
						()->
						{return FEld$String(
							"Tran",Get_Sistr_Physc("Tran")+",Mov_MOd:"+Movmnt_MOd,
							"In",Get_Ing(Get_SpAc().Get_Physc_LMNt_Cast(LOc_Obstructr_KE),Get_LOc_CoP_As_ArA()));
						},
						()->
						{return
							FEld$String("Proj",
								Projectr_IndX()+",Transdim="+Do_Transdim);
						},
						SLectn_Info(MAkng_RsOrc.Ant),
						()->
						{
							return //FEld$String("Sun_Pos",SpAc.Sun_Pos)
							"";
						},
						()->
						{
							return FEld$String("Tool",FEld$String(
								"Box",
								Arrays.toString(TRget_Box_Mesrmnt),
								"Gravity",
								GraviT.StrNgth+ParIs(Bool_To_Onf(Tool.Has_Physc_LMNt("GraviT_Sorc")))));
						},
						()->
						{
							return FEld$String(
								"Render mode",Draw_Rsorc.RNdr_MOd,
								"TIm:",Get_SpAc().TIm,",Skip",RNdr_Skip_MOd+":"+RNdr_Cycl);
						},
						()->{return FEld$String(
							"Mov_MOd",LOc_Obstructn.Mov_MOd,
							"Group_Cbrt:",LOc_Obstructn.Group_Cbrt);
						},
						()->{return FEld$String(
							"Test","");
						}
					);
				}
		public boolean
			Do_Draw_Hud=true,
			HUD_MOd=!true;
		@Finishd(Is_Finishd=false)
		public void Draw_HUD(Graphics2D Graphcs)
		{
			if(Do_Draw_Hud)
			{
				CroshAr_.Draw(this,Graphcs);
				Polyhedron HUD_Polyhedron=(Polyhedron)HUD.Get_Physc_LMNt_Cast("SEn");
				if(HUD_MOd||true)
				{
					Draw(this,Graphcs,HUD_Polyhedron);
				}
				else
				{
					for(Drawbl_Atom Atom:HUD_Polyhedron.Drawbl_Atomg)
					{
						Atom_Projectn Projectn=(Atom_Projectn)Atom.MAk_Projectn();
						Atom.UpdAt_Projectn(this,Projectn);
						out.println(((TXt_At_Point)((TMplatd_Atom)((D2$3_Flat)Atom).D2).Get_TMplat()).String_SOrc.$Point());
					}
				}
				Draw_MNU(Graphcs);
			}
		}
	public JTextField TXt_FEld=new JTextField(20);
		{
			if(false)
			{add(TXt_FEld);}
		}
		@Finishd(Is_Finishd=false)
		public String Get_TXt()
		{return TXt_FEld.getText();}
	//<editor-fold desc="MNU">
	public SpAc_Object MNU=new SpAc_Object(ScrEn_SpAc,null);
		{
			Polyhedron Graphc=new Polyhedron(MNU,null);
			Graphc.Set_Drawbl_Atomg();
			MNU.Ad_Physc(Graphc);

			float LNg=64,BtwEn=16;
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> D3=new Drawbl_D3_Polygon<>(
				new D3_Polygon(new ArA_LOcg(Graphc.Get_Gom_PArnt(),
					new double[]{LNg,LNg,0,0},
					new double[]{0,LNg,LNg,0},
					new double[]{0,0,0,0})),
				Colr.Set_A(white,128));
			D2_Polygon Item_Slot=D3.MAk_Projectn();
			int Diagnl=200;
			Grid Grid=new Grid(ScrEn_SpAc,new LOc(Diagnl,Diagnl,0),Item_Slot,
				LNg,LNg,
				BtwEn,BtwEn);
			Grid.Ad(0,0);
			Grid.Ad(0,1);
			Grid.Ad(0,1);
			D3.UpdAt_Projectn(Item_Slot);
			MNU.Ad_Physc(Grid);
			out.println("Grid:"+Grid.Drawbl_Atomg.length);
		}
		@Lin_DclAr @Neds_Ovrid(NEds=Neds_Ovrid.Ok) @Finishd(Is_Finishd=true)
		public void Open_MNU()
		{
			Get_SpAc().Trn_Of(null);
			Mous_Lokr.Unlok();
		}
		@Lin_DclAr @Neds_Ovrid(NEds=Neds_Ovrid.Ok) @Finishd(Is_Finishd=true)
		public void ClOs_MNU()
		{
			Mous_Lokr.Lok();
			Get_SpAc().Trn_On(null);
		}
		public Task_On_Trnbl_Runbl MNU_Is_On=new Task_On_Trnbl_Runbl(
			this::Open_MNU,
			this::ClOs_MNU);
			{
				Input_Havr.KE_AccSr.Set(this,VK_S,new Task_On_Trnbl_Calbl(()->
																				{return MNU_Is_On.Trn_No(null);}));
			}
		@Finishd(Is_Finishd=false)
		public void Draw_MNU(Graphics2D Graphcs)
		{
			if(MNU_Is_On.Is_On())
			{Draw(this,Graphcs,(Polyhedron)MNU.Get_Physc_LMNt("SEn"));}
		}
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>

	@Override @Finishd(Is_Finishd=false)
	public void UpdAt()
	{
		UpdAt_Loc_Cach();
		UpdAt_VEw();
		Cam.super.UpdAt();
	}

	public static final int Dfalt_PIplIn_Wid=switch(2)
	{
		case 0->64;
		case 1->4;
		case 2->32;
		default->1;
	};

	@Finishd(Is_Finishd=false)
	public ScrEn(RL_LOc_Havr Parnt,Object LOc_SOrc)
	{
		Parnt(Parnt);
		UpdAt_RL_LOc(LOc_SOrc);

		Draw_Rsorc=new Draw_RsOrc(this,64,Get_SpAc().Get_Physc_Atomg("SEn").size(),Dfalt_PIplIn_Wid);

		PlAc_LOc=new RL_LOc_Havr_ConcrEt(Parnt,null);
			Tool=new SpAc_Object(PlAc_LOc,null);
				TRget_Box=new Cub(Get_SpAc(),null,1,white);
					for(D3_Drawbl_Atom Atom:TRget_Box.Drawbl_Atomg)
					{
						Atom.Set_Is_TRgetbl(false);
						Atom.Set_Is_Transparnt(true);
					}
					Box_Projectn=D3_Drawbl_Atom.MAk_Projectng(TRget_Box.Drawbl_Atomg);
				Ad_Lit(Tool,null,.05);
					Lit=(LIt_SOrc)Tool.Get_Physc_LMNt("Lit_Sorc");
				Ad_GraviT(Tool,null,
					1,LOc$Dr_Mag.Hyp,Gom.Invrs_SqAr);
					GraviT=(GraviT_Sorc)Tool.Get_Physc_LMNt("GraviT_Sorc");
					Tool.Rmov_Physc(GraviT);

		Init();
		Init_Input();

		Init_HUD();
	}
}