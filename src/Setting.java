import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Setting {
	public static int w = -1, h = -1;

	public static void init() {
		Path path = Paths.get("config");
		if (!Files.exists(path)) {
			System.out.println("コンフィグファイルが見つかりません。");
			System.exit(1);
		}

		try {
			List<String> list = Files.readAllLines(path);
			w = Integer.parseInt(list.get(0));
			h = Integer.parseInt(list.get(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
