public class Main {
	public static void main(String[] args) {
		if (args.length != 2){
			System.out.println("引数は次の通りにしてください。");
			System.out.println("... <depth.raw> <bg.raw>");
			System.exit(1);
		}

		Setting.init();
		Pic pic = new Pic(args[0]);
		Pic bg = new Pic(args[1]);

		int threshold = 0;
		double fMeasure = 0D;

		for (int i = 0; i <= 255; i = i + 1) {
			double tmp = Pics.FMeasure(pic, bg, i);
			if (fMeasure < tmp) {
				fMeasure = tmp;
				threshold = i;
			}
		}

		System.out.printf("Threshold = %d, FMeasure = %f\n", threshold, fMeasure);
	}
}
