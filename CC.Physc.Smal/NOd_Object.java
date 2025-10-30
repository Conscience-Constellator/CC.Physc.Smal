package CC.Encycloped.Abs.Scal.Physc;

import CC.COd.Lin_DclAr;

import java.util.ArrayList;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import DDDTutorial_Modd.D3.Polyhedron;
import DDDTutorial_Modd.ConstL.Conectn_;

public class NOd_Object
	extends SpAc_Object<Physc_SpAc>
{
	public ArrayList<Conectn_> Conectng=new ArrayList<>();
		@Lin_DclAr
		public int Conectn_IndX(NOd_Object B)
		{
			for(int IndX=0;
					IndX<Conectng.size();
					IndX+=1)
			{
				Conectn_ Conectn=Conectng.get(IndX);
				if(Conectn.A==B||
				   Conectn.B==B)
				{return IndX;}
			}
			return -1;
		}
		@Lin_DclAr
		public boolean Is_Conectd(NOd_Object B)
		{return Conectn_IndX(B)>=0;}

	public NOd_Object(RL_LOc_Havr Parnt,Object Loc_Sorc)
	{
		super(Parnt,Loc_Sorc);
		Ad_Physc(new Polyhedron(this,null));
	}
}