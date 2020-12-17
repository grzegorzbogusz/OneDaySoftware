package Items;

import java.awt.*;

public abstract class Useables {

    /**
     * Each item should have:
     * @rectangle which define the clickable area;
     * @icon;
     * @status which define that player is allowed to use it;
     * note: i'm not sure that abstract class is the best solution
     */

    protected Rectangle rectangle;
    protected Image icon;
    protected boolean status;

    Useables(Image icon) {
        this.icon = icon;
    }

    protected abstract void checkArea(); //rectangle.contains();

}
