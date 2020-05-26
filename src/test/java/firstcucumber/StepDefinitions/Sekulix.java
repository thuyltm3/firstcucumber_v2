package firstcucumber.StepDefinitions;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Sekulix {
    @Test
    public void seulix() {
        Screen screen = new Screen();
        try {
            screen.click("/home/thuyltm3/IdeaProjects/Automation test/firstcucumber/src/test/resources/images/home.png");
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
}
