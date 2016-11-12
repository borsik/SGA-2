import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

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

    public static Terrain convertTo2D(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        Terrain cityMap = new Terrain(width,height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (bufferedImage.getRGB(i, j)){
                    case -16777216:
                        cityMap.getTerrain()[i][j] = new Place(1,0.0);
                        break;
                    case -32985:
                        cityMap.getTerrain()[i][j] = new Place(2,0.0);
                        cityMap.getSourcesOfRadiation().addLast(new Point(i,j));
                        break;
                    cityMap.getTerrain()[i][j] = new Place(0,0.0);
                    case -1237980:
                        cityMap.getTerrain()[i][j].setStart(true);
                        cityMap.setStart(new Point(i,j));
                        break;
                    case -14503604:
                        cityMap.getTerrain()[i][j].setFinish(true);
                        cityMap.setFinish(new Point(i,j));
                        break;
                    default:
                }
            }
        }

        return cityMap;
    }




    public static void main(String [] args) {
        String path = "map.png";
        BufferedImage map = ImageConvert.loadImage(path);
        Terrain cityMap = ImageConvert.convertTo2D(map);


    }
}
