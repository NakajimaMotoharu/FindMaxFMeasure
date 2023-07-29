import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Pic {
	public int[][] data;

	public Pic(String file) {
		Path path = Paths.get(file);
		if (!Files.exists(path)) {
			System.out.println("ファイルが見つかりません。");
			return;
		}
		if (!((Setting.w > 0) && (Setting.h > 0))) {
			System.out.println("Setting.init()が実行されていません。");
			return;
		}
		data = new int[Setting.h][Setting.w];
		try {
			byte[] list = Files.readAllBytes(path);
			for (int i = 0; i < Setting.h * Setting.w; i = i + 1) {
				setData(i % Setting.w, i / Setting.w, list[i] & 0xff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Pic() {
		if (!((Setting.w > 0) && (Setting.h > 0))) {
			System.out.println("Setting.init()が実行されていません。");
			return;
		}
		data = new int[Setting.h][Setting.w];
		for (int i = 0; i < Setting.h; i = i + 1) {
			Arrays.fill(data[i], 0);
		}
	}

	public boolean isInRange(int x, int y) {
		return (((x >= 0) && (x < Setting.w)) && (y >= 0) && (y < Setting.h));
	}

	public void setData(int x, int y, int input) {
		if (isInRange(x, y)) {
			data[y][x] = input;
		}
	}

	public int getData(int x, int y) {
		if (isInRange(x, y)) {
			return data[y][x];
		}
		return -1;
	}
}
