import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by olzhas on 12.11.2016.
 */
public class ImageConvert {
    public static BufferedImage loadImage(String path) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    public static int[][] convertTo2D(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int[][] result = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = bufferedImage.getRGB(i, j); // -1 white, -16777216 black, -32985 orange
            }
        }
        return result;
    }




    public static void main(String [] args) {
        String path = "map.png";
        BufferedImage bi = ImageConvert.loadImage(path);
        int[][] arr = ImageConvert.convertTo2D(bi);
        Graph g = new Graph(arr);

    }
}
