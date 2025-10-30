package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D2.D2_Drawbl_TMplat.D2_Drawbl_TMplat_Projectn;
import DDDTutorial_Modd.D2.D2_Projectn;
import DDDTutorial_Modd.D3.Drawbl_LOcg_Usr.Drawbl_LOcg_Usr_Projectn;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Physc.SIt.TMplatd_Atom.TMplatd_Projectn;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import java.awt.*;
import static CC.List.ArA_X.Max;
import static java.lang.Math.min;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.Integer.MAX_VALUE;

public interface Polygon_Projectn<
	Atom_Typ extends Drawbl_Polygon,LOcg_Typ extends LOcg_Havr<Physc_SpAc>>
	extends AWT_ShAp_Projectn<Atom_Typ,Polygon>,
	Drawbl_LOcg_Usr_Projectn<LOcg_Typ,Atom_Typ>
//	,D2_Drawbl_TMplat<D2_Projectn>
{
//	@Override
	default int Get_LOc_Num()
	{return Get_Projectd().Get_LOc_Num();}
		@Lin_DclAr
		default void Set_Polygon_VrtX_Num(int Num)
		{
			Polygon Polygon=Get_AWT_ShAp();
			Polygon.xpoints=Max(Polygon.xpoints,Num);
			Polygon.ypoints=Max(Polygon.ypoints,Num);
			Polygon.npoints=Num;
		}
		@Lin_DclAr
		default int[] Get_VrtX_Int(int IndX)
		{
			Polygon Polygon=Get_AWT_ShAp();

			return new int[]{
				Polygon.xpoints[IndX],
				Polygon.ypoints[IndX]};
		}
//	@Override
	default void Get_Box(double[] Box,LOcg_Havr Locg)
	{Get_Box_CoP(Box);}

	abstract class Polygon_Projectn_ConcrEt<
		Atom_Typ extends Drawbl_Polygon,LOcg_Typ extends LOcg_Havr<Physc_SpAc>>
		extends Drawbl_LOcg_Usr_Projectn_ConcrEt<LOcg_Typ,Atom_Typ>
		implements Polygon_Projectn<Atom_Typ,LOcg_Typ>
	{
		private Polygon AWT_ShAp;
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public Polygon Get_AWT_ShAp()
			{return AWT_ShAp;}
			@Override @Finishd(Is_Finishd=true)
			public void Set_AWT_ShAp(Polygon Polygon)
			{AWT_ShAp=Polygon;}

		@Override
		public int Get_LOc_Num()
		{return Polygon_Projectn.super.Get_LOc_Num();}

		public Rectangle CalculAt_Box(
			int[] Xg,
			int[] Yg,
			int N)
		{
			int boundsMinX=MAX_VALUE;
			int boundsMinY=MAX_VALUE;
			int boundsMaxX=MIN_VALUE;
			int boundsMaxY=MIN_VALUE;

			for(int i=0;i<N;i+=1)
			{
				int x=Xg[i];
				boundsMinX=min(boundsMinX,x);
				boundsMaxX=max(boundsMaxX,x);
				int y=Yg[i];
				boundsMinY=min(boundsMinY,y);
				boundsMaxY=max(boundsMaxY,y);
			}

			return new Rectangle(boundsMinX,boundsMinY,
				boundsMaxX-boundsMinX,
				boundsMaxY-boundsMinY);
		}
		//<editor-fold desc="Is_In">
		public boolean Is_In(
			int[] Xg,int[] Yg,
			double x,double y,
		int N)
		{
			if(N<=2||!CalculAt_Box(Xg,Yg,N).contains(x,y))
			{return false;}
			int hits=0;

			int lastx=Xg[N-1];
			int lasty=Yg[N-1];
			int curx,cury;

			for(int i=0;
				i<N;
				lastx=curx,lasty=cury,i+=1)
			{
				curx=Xg[i];
				cury=Yg[i];

				if(cury==lasty)
				{continue;}

				int leftx;
				if(curx<lastx)
				{
					if(x>=lastx)
					{continue;}
					leftx=curx;
				}else{
					if(x>=curx)
					{continue;}
					leftx=lastx;
				}

				double test1,test2;
				if(cury<lasty)
				{
					if (y < cury || y >= lasty) {
						continue;
					}
					if (x < leftx) {
						hits++;
						continue;
					}
					test1 = x - curx;
					test2 = y - cury;
				}else
				{
					if(y<lasty||y>=cury)
					{continue;}
					if(x<leftx)
					{
						hits+=1;
						continue;
					}
					test1=x-lastx;
					test2=y-lasty;
				}

				if (test1 < (test2 / (lasty - cury) * (lastx - curx)))
				{hits+=1;}
			}

			return ((hits&1)!=0);
		}
//			@Override
			public boolean Is_In(
				int X,int Y,
				TMplatd_Projectn<?,?,? extends D2_Drawbl_TMplat_Projectn> Locg)
			{
				double[] Loc=Get_LOc(0);

				return Is_In(
					(int)(X-Loc[0]),
					(int)(Y-Loc[1]));
			}
		//</editor-fold>

		@Override @Finishd(Is_Finishd=true)
		public Trand_Inbl Get_ShAp()
		{return null;}
		@Override
		public void Draw_Projectn(
			ScrEn ScrEn,Graphics2D Graphcs,
			D2_Projectn Locg)
		{
//			if(Locg instanceof D2_Polygon VrtXg)
//			{
//				Polygon Polygon=this.Get_AWT_ShAp();
//				int
//					X=(int)Locg.X[0],
//					Y=(int)Locg.Y[0],
//					N=Polygon.npoints;
//				int[]
//					Xg=new int[N],
//					Yg=new int[N];
//				double[] VrtX=new double[3];
//				for(int IndX=0;
//					IndX<N;
//					IndX+=1)
//				{
//					Locg.Get_Loc(IndX,VrtX);
//					Xg[IndX]=(int)(VrtX[0]+X);
//					Yg[IndX]=(int)(VrtX[1]+Y);
//				}
//			}
	//		Draw_ShAp(
	//			ScrEn,Graphcs,
	//			new Polygon(Xg,Yg,N),null);
		}
//		@Override
		public void Draw(ScrEn ScrEn,Graphics2D Graphcs,
			TMplatd_Projectn<?,?,? extends D2_Drawbl_TMplat_Projectn> Projectn)
		{}

		@Finishd(Is_Finishd=true)
		public Polygon_Projectn_ConcrEt(Atom_Typ Atom)
		{
			super(Atom);
				AWT_ShAp=new Polygon();
				Set_Polygon_VrtX_Num(Get_LOc_Num());
		}
	}
}
