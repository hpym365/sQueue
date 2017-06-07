import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-5-20 上午1:26
 */
public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
//        for (String temp : a) {
//            if("2".equals(temp)){
//                a.remove(temp);
//            }
//        }
        for(int i=0;i<a.size();i++){
            String s = a.get(i);

            if("1".equals(s)){
                a.remove(i);
            }
        }
        LongAdder i = new LongAdder();
        i.add(1);

//        Iterator<String> it = a.iterator();
//        while(it.hasNext()){
//            String temp =
//                    it.next();
//            if("1".equals(temp)){
//                it.remove();
//            }
//        }


        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                iterator.remove();
        }



        System.out.println(a);
    }
}
