/*
import com.zkx.item.entity.Item;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }

    @Test
    public void testHashCode() {
        Item item1 = new Item(Long.parseLong("1"), "水果", "ftp://192.168.0.1", "苹果", Long.parseLong("10"));
        Item item2 = new Item(Long.parseLong("2"), "水果", "ftp://192.168.0.2", "梨", Long.parseLong("3"));
        Item item3 = new Item(Long.parseLong("3"), "水果", "ftp://192.168.0.3", "香蕉", Long.parseLong("4"));
        Item item4 = new Item(Long.parseLong("4"), "水果", "ftp://192.168.0.4", "桃", Long.parseLong("5"));
        Map<Object, String> map = new HashMap<>();
        map.put(item1, "value1");
        map.put(item2, "value2");
        map.put(item3, "value3");
        map.put(item4, "value4");
        System.out.println(map.get(item1));
        System.out.println(map.get(item2));
        System.out.println("-----------------");
    }

    @Test
    public void testGetClass() throws ClassNotFoundException {
        */
/**
         * 方式一：
         * 使用Object中的getClass方法来获取class对象
         * 使用这方式必须有具体的类，并创建对象
         * 这种方式使用的少，一般是传的是Object，不知道类型时才使用
         *//*

        Object obj = new Item();
        Class clazz1=obj.getClass();
        System.out.println("通过getClass():"+clazz1);
        */
/**
         * 方式二：
         * 直接通过 类名.class来获取class对象
         * 任何类型中都具有隐含的静态成员变量class 使用简单，但扩展性不足
         *//*

        Class clazz2=Item.class;
        System.out.println("通过类名.class："+clazz2);
        */
/**
         * 方式三：
         * 通过class对象的forName()静态方法来获取class对象
         * 使用最多，通过类的全限定名，但可能抛出 ClassNotFoundException 异常
         *//*

        Class clazz3=Class.forName("com.zkx.item.entity.Item");
        System.out.println("通过类的全限定名："+clazz3);

        //比较三种方式，判断是否是相同实例
        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);
        System.out.println(clazz2==clazz3);
    }

    public void testNewInstance(){

    }
}
*/
