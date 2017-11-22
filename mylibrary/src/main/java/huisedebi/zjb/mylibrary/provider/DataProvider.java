package huisedebi.zjb.mylibrary.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Jude on 2016/1/6.
 */
public class DataProvider {
    public static List<Integer> getPersonList(int page) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (page == 4) {
            return arr;
        }
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(3);
        arr.add(1);
        arr.add(0);
        arr.add(0);
        arr.add(1);
        return arr;
    }

    public static List<Boolean> getShouYi(int page) {
        ArrayList<Boolean> arr = new ArrayList<>();
        if (page == 4) {
            return arr;
        }
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        arr.add(false);
        return arr;
    }

}
