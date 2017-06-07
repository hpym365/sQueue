import org.springframework.transaction.annotation.Transactional;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-1 下午9:36
 */
public class Demo {
    @Transactional
    public static void main(String[] args) {

        String a="hello";
        String b="hello";

        String c = a+b;

        System.out.println(a==b);

        System.out.println(a=="hello");

        System.out.println(c=="hellohello");

        String s1 = "java";
        String s2 = new String("java");

        System.out.println(s1==s2);
    }
}




