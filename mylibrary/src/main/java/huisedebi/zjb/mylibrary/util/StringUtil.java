package huisedebi.zjb.mylibrary.util;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zjb on 2016/4/6.
 */
public class StringUtil {
    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        /*
        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		联通：130、131、132、152、155、156、185、186
		电信：133、153、180、189、（1349卫通）
		总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		*/
        String telRegex = "[1][0123456789]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
            return mobiles.matches(telRegex);
        }
    }

    /**
     * 密码必须大于6位，且由字母及数字组合
     *
     * @param password
     * @return
     */
    public static boolean isPassword(String password,int length) {
        String pass = "^(?=.*?[a-zA-Z])(?=.*?[0-9])[a-zA-Z0-9]{"+length+",}$";
        if (TextUtils.isEmpty(password)) {
            return false;
        } else {
            return password.matches(pass);
        }
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证合法字符
     *
     * @return
     */
    public static boolean checkCharacter(String character) {
        boolean flag = false;
        try {
            String check = "[a-zA-Z0-9_]{4,16}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(character);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean isCarID(String carId) {
        String telRegex = "[\\u4e00-\\u9fa5|WJ]{1}[A-Z0-9]{6}";
        if (TextUtils.isEmpty(carId)) {
            return false;
        } else {
            return carId.matches(telRegex);
        }
    }

    private static Pattern p = Pattern.compile("[\u4e00-\u9fa5]*");

    /**
     * 验证姓名
     */
    public static boolean checkChineseName(String name) {
        boolean flag = false;
        try {
            Matcher matcher = p.matcher(name);
            flag = matcher.matches();
            if (name.length() < 2 || name.length() > 15) {
                flag = false;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 提取出城市或者县
     *
     * @param city
     * @param district
     * @return
     */
    public static String extractLocation(final String city, final String district) {
        return district.contains("县") ? district.substring(0, district.length() - 1) : city.substring(0, city.length() - 1);
    }

    private static Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式


    //金额验证
    public static boolean isAmount(String str) {
        Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * des： 秒数转换时分秒
     * author： ZhangJieBo
     * date： 2017/9/26 0026 下午 8:08
     */
    public static String TimeFormat(int progress) {
        int hour = progress / 3600;
        int min = progress % 3600 / 60;
        int sec = progress % 60;
        //设置整数的输出格式：  %02d  d代表int  2代码位数    0代表位数不够时前面补0
        String time = String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
        return time;
    }


    /**
     * des： 隐藏电话号码
     * author： ZhangJieBo
     * date： 2017/10/19 0019 下午 2:05
     */
    public static String hidePhone(String phone) {
        String substring01 = phone.substring(0, 3);
        String substring02 = phone.substring(7, phone.length());
        return substring01 + "****" + substring02;
    }
}
