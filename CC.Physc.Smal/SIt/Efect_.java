package CC.Encycloped.Abs.Scal.Physc.SIt;

import CC.$.Q$Q.Int1$1;
import java.awt.*;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.*;

public interface Efect_ extends Int1$1
{
	class Tran_Ovr implements Efect_
	{
		public Color Fro;
			@Override
			public int Int1$1(int Bak)
			{return Tran__(
				Bak,
				Fro.getRGB());
			}

		public Tran_Ovr(Color Fro)
		{this.Fro=Fro;}
	}
	class Tran_Ovr_ extends Tran_Ovr
	{
		public int Proportn;
			@Override
			public int Int1$1(int Bak)
			{return Tran___(
				Bak,
				Fro.getRGB(),
				Proportn);
			}

		public Tran_Ovr_(Color Fro,int Proportn)
		{
			super(Fro);
			this.Proportn=Proportn;
		}
	}
	class Int1$1_Efect implements Efect_
	{
		public Int1$1 Mod;
			@Override
			public int Int1$1(int Colr)
			{return Mod.Int1$1(Colr);}

		public Int1$1_Efect(Int1$1 Mod)
		{this.Mod=Mod;}
	}
}