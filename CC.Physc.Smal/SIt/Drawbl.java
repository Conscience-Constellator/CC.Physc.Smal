package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import java.awt.*;
import java.util.List;
import static DDDTutorial_Modd.D3.D3_Drawbl_Atom.MAk_Projectng;

public interface Drawbl extends Efectg_Havr
{
	@Lin_DclAr @Finishd(Is_Finishd=true)
	void Draw(ScrEn ScrEn,Graphics2D Graphcs);
		@Finishd(Is_Finishd=true)
		static <Typ extends Drawbl>void Draw(ScrEn ScrEn,Graphics2D Graphcs,
			Typ... List)
		{
			for(Typ Drawbl:List)
			{Drawbl.Draw(ScrEn,Graphcs);}
		}
			@Finishd(Is_Finishd=true)
			static void Draw(ScrEn ScrEn,Graphics2D Graphcs,
				Polyhedron Polyhedron)
			{Draw(ScrEn,Graphcs,MAk_Projectng(Polyhedron.Drawbl_Atomg));}
		@Finishd(Is_Finishd=true)
		static <Typ extends Drawbl>void Draw(ScrEn ScrEn,Graphics2D Graphcs,
			List<Typ> List)
		{
			for(Typ Drawbl:List)
			{Drawbl.Draw(ScrEn,Graphcs);}
		}
}
