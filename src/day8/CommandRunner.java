package day8;

import java.util.List;

public class CommandRunner {

	Screen screen;

	public CommandRunner(Screen screen) {
		this.screen = screen;
	}

	public Screen getScreen() {
		return screen;
	}

	public void run(List<String> commands) {

		for (String command : commands) {
			String[] elements = command.split(" ");

			if (elements[0].equals("rect")) {
				String[] coordinates = elements[1].split("x");
				screen.rect(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
			}

			if (elements[0].equals("rotate")) {

				if (elements[1].equals("column")) {
					String[] xAssignmentParts = elements[2].split("=");
					screen.rotateColumn(Integer.parseInt(xAssignmentParts[1]), Integer.parseInt(elements[4]));
				} else {
					String[] yAssignmentParts = elements[2].split("=");
					screen.rotateRow(Integer.parseInt(yAssignmentParts[1]), Integer.parseInt(elements[4]));
				}
			}
		}
	}
}
