package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import java.awt.*;

public interface AWT_ShAp_Projectn<
	Atom_Typ extends Drawbl_Atom,ShAp_Typ extends Shape>
	extends Drawbl_Atom.Atom_Projectn<Atom_Typ>
{
	@Lin_DclAr @Finishd(Is_Finishd=true)
	ShAp_Typ Get_AWT_ShAp();
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Set_AWT_ShAp(ShAp_Typ ShAp);

	@Lin_DclAr
	default void CalculAt_Box(double[] Box)
	{
		Rectangle R=Get_AWT_ShAp().getBounds();
			int X=R.x,Y=R.y;
			Box[0]=X;
			Box[1]=X+R.width;
			Box[2]=Y;
			Box[3]=Y+R.height;
	}
	@Lin_DclAr @Neds_Ovrid(NEds=No)
	default void Get_Box_CoP(Rectangle Box)
	{
		double[] Box_=Get_Box_CoP();
		double
			Bot=Box_[0],
			LFt=Box_[2];
		Box.setBounds(
			(int)Bot,(int)LFt,
			(int)(Box_[1]-Bot),(int)(Box_[3]-LFt));
		Box.setBounds(Get_AWT_ShAp().getBounds());
	}
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	default boolean Is_In(int X,int Y)
	{return Get_AWT_ShAp().contains(X,Y);}
}