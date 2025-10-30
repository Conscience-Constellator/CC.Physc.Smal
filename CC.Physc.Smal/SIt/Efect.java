package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;

import static CC.COd.Neds_Ovrid.*;

import java.awt.image.BufferedImageOp;
import java.util.List;

public interface Efect
{
	@Lin_DclAr
	BufferedImageOp Get_Op(Drawbl_Atom.Atom_Projectn Projectn);
		static void Ad_Opg_From_Efectg(
			List<BufferedImageOp> List,Drawbl_Atom.Atom_Projectn Projectn,
			List<Efect> Sorcg)
		{
			for(Efect Sorc:Sorcg)
			{List.add(Sorc.Get_Op(Projectn));}
		}

	class Op_Rapr implements Efect
	{
		private BufferedImageOp Rapd_Op;
			@Override @Neds_Ovrid(NEds=No)
			public BufferedImageOp Get_Op(Drawbl_Atom.Atom_Projectn Projectn)
			{return Rapd_Op;}
			public void Set_Op(BufferedImageOp Op)
			{Rapd_Op=Op;}

		public Op_Rapr(BufferedImageOp Op)
		{Set_Op(Op);}
	}
}