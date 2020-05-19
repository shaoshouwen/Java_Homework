package src.club.banyuan;
import club.banyuan.Measurer;
import club.banyuan.Rectangle;

public class RectangleMeasurer implements Measurer<Rectangle> {

  @Override
  public double measure(Rectangle anObject) {
    if (anObject != null) {
      return  anObject.width *  anObject.height;
    }
    throw new IllegalArgumentException("不是矩形类");
  }
}