public class Pics {
	public static Pic MakeMask(Pic origin, int threshold) {
		Pic mask = new Pic();

		for (int y = 0; y < Setting.h; y = y + 1) {
			for (int x = 0; x < Setting.w; x = x + 1) {
				if (origin.getData(x, y) <= threshold) {
					mask.setData(x, y, 0);
				} else {
					mask.setData(x, y, 255);
				}
			}
		}

		return mask;
	}

	public static double FMeasure(Pic Origin, Pic bg, int threshold) {
		Pic mask = MakeMask(Origin, threshold);
		double p, r;

		int pd = 0, pn = 0;
		for (int y = 0; y < Setting.h; y = y + 1) {
			for (int x = 0; x < Setting.w; x = x + 1) {
				if (mask.getData(x, y) == 0) {
					pd = pd + 1;
					if (bg.getData(x, y) == 0) {
						pn = pn + 1;
					}
				}
			}
		}
		p = (double) pn / pd;

		int rd = 0, rn = 0;
		for (int y = 0; y < Setting.h; y = y + 1) {
			for (int x = 0; x < Setting.w; x = x + 1) {
				if (bg.getData(x, y) == 0) {
					rd = rd + 1;
					if (mask.getData(x, y) == 0) {
						rn = rn + 1;
					}
				}
			}
		}

		r = (double) rn / rd;

		return 2 * ((p * r) / (p + r));
	}
}
