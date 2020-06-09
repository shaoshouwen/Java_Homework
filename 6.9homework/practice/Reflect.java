import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import org.w3c.dom.ls.LSOutput;

public class Reflect {

  public static void main(String[] args) {
    printInfo(0);
  }

  public static void printInfo(Object object) {
    Class<?> aClass = object.getClass();
    Field[] declaredFields = aClass.getDeclaredFields();
    Arrays.sort(declaredFields, Comparator.comparing(o -> o.getName().toLowerCase()));
    Method[] declaredMethods = aClass.getDeclaredMethods();
    Arrays.sort(declaredMethods,Comparator.comparing(o -> o.getName().toLowerCase()));
    for(Field declared : declaredFields)
    System.out.println(declared);
    for (Method method : declaredMethods) {
      System.out.println(method);
    }
  }

}
