
import com.zkx.item.entity.Item;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.*;


public class FundDataTest {


    private static Logger logger = LoggerFactory.getLogger(FundDataTest.class);

    @Test
    public void getData() throws Exception {
        Item item = new Item();
        Item item1 = new Item(null, null, null, null, null);
        Item item3 = null;
        if (ObjectUtils.isEmpty(item)) {
            System.out.println("item空，1");
        }
        if (ObjectUtils.isEmpty(item1)) {
            System.out.println("item1空，1");
        }
        if (ObjectUtils.isEmpty(item3)) {
            System.out.println("item3空，1");
        }
        if (Objects.isNull(item)) {
            System.out.println("item空，2");
        }
        if (Objects.isNull(item1)) {
            System.out.println("item1空，2");
        }
        if (Objects.isNull(item3)) {
            System.out.println("item3空，2");
        }
        if (item == null) {
            System.out.println("item空，3");
        }
        if (item1 == null) {
            System.out.println("item1空，3");
        }
        if (item3 == null) {
            System.out.println("item3空，3");
        }
        if (isAllFieldNull(item)) {
            System.out.println("item空，4");
        }
        if (isAllFieldNull(item1)) {
            System.out.println("item1空，4");
        }
        if (item.equals(null)) {
            System.out.println("item空，5");
        }
        if (item1.equals(null)) {
            System.out.println("item1空，5");
        }
    }

    @Test
    public void test() {
        Item item = new Item();
        Item item1 = new Item(null, null, null, null, null);
        Item item3 = null;
        List<Item> items = new ArrayList<>();
        List<Item> items1 = new ArrayList<>();
        items1.add(item1);
        List<Item> items2 = new ArrayList<>();
        items2.add(item);
        List<Item> items3 = new ArrayList<>();
        items3.add(item3);
        List<Item> items4 = null;
        if (CollectionUtils.isEmpty(items)) {
            System.out.println("这是个空集合1");
        }
        if (CollectionUtils.isEmpty(items1)) {
            System.out.println("这是个空集合2");
        }
        if (CollectionUtils.isEmpty(items2)) {
            System.out.println("这是个空集合3");
        }
        if (CollectionUtils.isEmpty(items3)) {
            System.out.println("这是个空集合4");
        }
        if (CollectionUtils.isEmpty(items4)) {
            System.out.println("这是个空集合5");
        }
    }

    //判断该对象是否: 返回ture表示所有属性为null  返回false表示不是所有属性都是null
    public static boolean isAllFieldNull(Object obj) throws Exception {
        Class stuCla = (Class) obj.getClass();// 得到类对象
        Field[] fs = stuCla.getDeclaredFields();//得到属性集合
        boolean flag = true;
        for (Field f : fs) {//遍历属性
            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
            Object val = f.get(obj);// 得到此属性的值
            if (val != null) {//只要有1个属性不为空,那么就不是所有的属性值都为空
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Test
    public void testListToArray() {
        List<String> list = new ArrayList<String>(2);
        list.add("test1");
        list.add("test2");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        // 打印输出数组的三种方式：
        // 方式1
        System.out.println(Arrays.toString(array));
        // 方式2
        for (String a : array
        ) {
            System.out.println(a);
        }
        // 方式3
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    @Test
    public void testArrayToList() {
        String[] str = new String[]{"test1", "test2"};
        List list = Arrays.asList(str);
        System.out.println(list.toString());
    }

    @Test
    public void testForEach() {
        List<String> list = new ArrayList<String>(2);
        list.add("test1");
        list.add("test2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("test2".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(list.toString());
    }

    @Test
    public void testHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
    }

    @Test
    public void testSet() {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("d");
        stringSet.add("b");
        stringSet.add("c");
        stringSet.add("a");
        System.out.println(stringSet.toString());
    }

    @Test
    public void testHashSet() {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30) + (1 << 16));
        }
        Iterator<Integer> iterator = intset.iterator();
        while (iterator.hasNext()) {
            System.out.print((iterator.next() - (1 << 16)) + " ");
        }
    }

}
