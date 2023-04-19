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

        //System.out.println("Generated numbers string: " + numString);

        return numString;

    }

    public static synchronized String buildUniqueCharString(int length){

        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        String charString = generator.generate(length);

        //System.out.println("Generated chars string: " + charString);

        return charString;

    }


    public static synchronized String buildUniqueText() {  // генерация таймстампа для уникальности email адресов (генерируемые цифры таймстампа  добавляются впереди адреса)
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String timeStampText = ft.format(dNow);
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return timeStampText;
    }



}
