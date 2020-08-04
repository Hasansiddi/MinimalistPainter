import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) throws  Exception{
        /*
         * TODO: Now that I've figured out what I'm using for input and outputs of the image I need to make a loop
         *  where I get the rgb values. Stop when I reach a rgb value that isn't in range, calculate the average of
         *  the current values and update everything upto where I have stopped to be the average color. Then I do that
         *  till I reach the last pixel! :)
         *
         * TODO: Bring that horrible horrible runtime down somehow. Use them CPSC 320 skills
         */
        File in = new File("D:\\IntelliJ_Projects\\MinimalistPainter\\src\\image.png");
        File out = new File("D:\\IntelliJ_Projects\\MinimalistPainter\\src\\output.png");
        BufferedImage img = ImageIO.read(in);
        ImageIO.write(img, "png", out);
    }
}
