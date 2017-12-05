package cc.noharry.vanillahelper.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * @author NoHarry
 * @date 2017/12/04
 */

public class OrcItem {


  /**
   * log_id : 9127286292687481043
   * direction : 0
   * words_result_num : 1
   * words_result : [{"chars":[{"char":"s","location":{"width":18,"top":206,"height":26,"left":155}},{"char":"l","location":{"width":23,"top":206,"height":26,"left":169}},{"char":"a","location":{"width":27,"top":206,"height":26,"left":206}},{"char":"t","location":{"width":25,"top":206,"height":26,"left":229}},{"char":"e","location":{"width":25,"top":206,"height":26,"left":251}},{"char":"r","location":{"width":16,"top":206,"height":26,"left":272}}],"location":{"width":141,"top":204,"height":30,"left":147},"words":" slater","vertexes_location":[{"y":204,"x":147},{"y":204,"x":287},{"y":233,"x":287},{"y":233,"x":147}]}]
   */

  private long log_id;
  private int direction;
  private int words_result_num;
  /**
   * chars : [{"char":"s","location":{"width":18,"top":206,"height":26,"left":155}},{"char":"l","location":{"width":23,"top":206,"height":26,"left":169}},{"char":"a","location":{"width":27,"top":206,"height":26,"left":206}},{"char":"t","location":{"width":25,"top":206,"height":26,"left":229}},{"char":"e","location":{"width":25,"top":206,"height":26,"left":251}},{"char":"r","location":{"width":16,"top":206,"height":26,"left":272}}]
   * location : {"width":141,"top":204,"height":30,"left":147}
   * words :  slater
   * vertexes_location : [{"y":204,"x":147},{"y":204,"x":287},{"y":233,"x":287},{"y":233,"x":147}]
   */

  private List<WordsResultBean> words_result;

  public long getLog_id() {
    return log_id;
  }

  public void setLog_id(long log_id) {
    this.log_id = log_id;
  }

  public int getDirection() {
    return direction;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }

  public int getWords_result_num() {
    return words_result_num;
  }

  public void setWords_result_num(int words_result_num) {
    this.words_result_num = words_result_num;
  }

  public List<WordsResultBean> getWords_result() {
    return words_result;
  }

  public void setWords_result(List<WordsResultBean> words_result) {
    this.words_result = words_result;
  }

  public static class WordsResultBean {

    /**
     * width : 141
     * top : 204
     * height : 30
     * left : 147
     */

    private LocationBean location;
    private String words;
    /**
     * char : s
     * location : {"width":18,"top":206,"height":26,"left":155}
     */

    private List<CharsBean> chars;
    /**
     * y : 204
     * x : 147
     */

    private List<VertexesLocationBean> vertexes_location;

    public LocationBean getLocation() {
      return location;
    }

    public void setLocation(LocationBean location) {
      this.location = location;
    }

    public String getWords() {
      return words;
    }

    public void setWords(String words) {
      this.words = words;
    }

    public List<CharsBean> getChars() {
      return chars;
    }

    public void setChars(List<CharsBean> chars) {
      this.chars = chars;
    }

    public List<VertexesLocationBean> getVertexes_location() {
      return vertexes_location;
    }

    public void setVertexes_location(List<VertexesLocationBean> vertexes_location) {
      this.vertexes_location = vertexes_location;
    }

    public static class LocationBean {

      private int width;
      private int top;
      private int height;
      private int left;

      public int getWidth() {
        return width;
      }

      public void setWidth(int width) {
        this.width = width;
      }

      public int getTop() {
        return top;
      }

      public void setTop(int top) {
        this.top = top;
      }

      public int getHeight() {
        return height;
      }

      public void setHeight(int height) {
        this.height = height;
      }

      public int getLeft() {
        return left;
      }

      public void setLeft(int left) {
        this.left = left;
      }
    }

    public static class CharsBean {

      @SerializedName("char")
      private String charX;
      /**
       * width : 18
       * top : 206
       * height : 26
       * left : 155
       */

      private LocationBean location;

      public String getCharX() {
        return charX;
      }

      public void setCharX(String charX) {
        this.charX = charX;
      }

      public LocationBean getLocation() {
        return location;
      }

      public void setLocation(LocationBean location) {
        this.location = location;
      }

      public static class LocationBean {

        private int width;
        private int top;
        private int height;
        private int left;

        public int getWidth() {
          return width;
        }

        public void setWidth(int width) {
          this.width = width;
        }

        public int getTop() {
          return top;
        }

        public void setTop(int top) {
          this.top = top;
        }

        public int getHeight() {
          return height;
        }

        public void setHeight(int height) {
          this.height = height;
        }

        public int getLeft() {
          return left;
        }

        public void setLeft(int left) {
          this.left = left;
        }
      }
    }

    public static class VertexesLocationBean {

      private int y;
      private int x;

      public int getY() {
        return y;
      }

      public void setY(int y) {
        this.y = y;
      }

      public int getX() {
        return x;
      }

      public void setX(int x) {
        this.x = x;
      }
    }
  }

  @Override
  public String toString() {
    return "OrcItem{" +
        "log_id=" + log_id +
        ", direction=" + direction +
        ", words_result_num=" + words_result_num +
        ", words_result=" + words_result +
        '}';
  }
}
