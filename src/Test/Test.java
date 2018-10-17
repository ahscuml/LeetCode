package Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * 接口D
 * */
interface D {
    // 默认是常量
    int NORTH = 0;

    int getA();

    void setA(int a);
}

interface E extends D {

}

/**
 * @author ahscuml
 * @date 2018/10/9
 * @time 15:08
 */
public class Test {
    /**
     * static 语句会在类第一次被加载时执行
     * forName是静态方法，可以获得类名对应的Class对象
     */
    public static void main(String[] args) {

        Employee Tom = new Employee(20,"Tom");
        Employee Jam = new Employee(10,"Jam");
        Employee Bom = new Employee(30,"Bom");
        Employee[] array = new Employee[3];
        array[0] = Tom;
        array[1] = Jam;
        array[2] = Bom;
        Arrays.sort(array,Comparator.comparing(Employee::getAge));
        System.out.println(Arrays.toString(array));
        List<Employee> employee = Arrays.asList(array);
        // 使用双冒号操作符
        employee.forEach(System.out::println);
        // 断言
        assert array != null;
        // lambda表达式
        employee.forEach((employee1) -> System.out.println(employee1));
        // 日志
        Logger.getGlobal().info("Hahaha");

        System.out.println(2 ^ 3);
    }
}

/**
 * 雇员类
 * */
class Employee {
    private int age = 0;
    private String name = "";

    Employee() {
    }

    Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name + age;
    }
}
