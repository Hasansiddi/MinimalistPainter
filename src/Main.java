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

        int width = img.getWidth();
        int height = img.getHeight();
        int currPixel = 0;
        int total  = 0;
        int count = 0;
        int prevPixel = 0;
        int startHeight = 0;
        int startWidth = 0;

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(prevPixel > 0 && (currPixel - prevPixel) >= 10){
                    SetAllPrev(count, total, i, j,startHeight,startWidth, img);
                    count = 0;
                    total = 0;
                    startWidth = i;
                    startHeight = j;
                }
                prevPixel = currPixel;
                currPixel = img.getRGB(i, j);
                total = total + currPixel;
                count++;
            }
        }

        ImageIO.write(img, "png", out);
        System.out.println("Task completed!");

    }

    public static void SetAllPrev(int count, int total, int i, int j, int sH, int sW, BufferedImage img){
        int avg = total/count;
        for(int x = sW; x < i; i++) {
            for (int y = sH; y < j; j++) {
                img.setRGB(x, y, avg);
            }
        }
    }
}
