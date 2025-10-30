package CC.Encycloped.Abs.Scal.Physc.SIt;

public class Primary_Colr
{
	public float R,G,B;
		public void Set_RGB(
			float R,
			float G,
			float B)
		{
			this.R=R;
			this.G=G;
			this.B=B;
		}

	public Primary_Colr(
		float R,
		float G,
		float B)
	{Set_RGB(R,G,B);}

	public static final Primary_Colr
		R_BAs=new Primary_Colr(1,0,0),
		G_BAs=new Primary_Colr(0,1,0),
		B_BAs=new Primary_Colr(0,0,1),
		Y_BAs=new Primary_Colr(.5F,.5F,0),
		Orng_BAs=new Primary_Colr(.5F,0,0),
		Prpl_BAs=new Primary_Colr(.5F,0,.5F)
	;
}