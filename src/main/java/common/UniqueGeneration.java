package common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.text.RandomStringGenerator;

public class UniqueGeneration {

    public static synchronized String getGuid() {
        return java.util.UUID.randomUUID().toString();
    }

    public static synchronized String buildUniqueNumberString(int length){

        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', '9').build();
        String numString = generator.generate(length);
        System.out.println("Generated number: " + numString);
        return numString;

    }

    public static synchronized String buildUniqueCharString(int length){

        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        String charString = generator.generate(length);

        return charString;

    }

    public static synchronized String buildUniqueTextByPrefix(String prefix) {
        return buildUniqueText(prefix, "", "");
    }

    public static synchronized String buildUniqueTextByPrefix(String prefix, String separator) {
        return buildUniqueText(prefix, "", separator);
    }

    public static synchronized String buildUniqueTextBySuffix(String suffix) {
        return buildUniqueText("", suffix, "");
    }

    public static synchronized String buildUniqueTextBySuffix(String suffix, String separator) {
        return buildUniqueText("", suffix, separator);
    }

    public static synchronized String buildUniqueText(String prefix, String suffix, String separator) {  // генерация таймстампа для уникальности email адресов (генерируемые цифры таймстампа  добавляются впереди адреса)
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String datetime = ft.format(dNow);
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prefix + separator + datetime + separator + suffix;  //TODO: слишком сложно и не подойдет на все случаи - сделать попроще и чтобы цифры быле не после .com
    }



}
