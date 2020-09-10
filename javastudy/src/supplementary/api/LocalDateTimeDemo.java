package supplementary.api;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class LocalDateTimeDemo {
    public static void main(String[] args) {

        //ZoneID 世界时区类
        //获取世界各地的时区编号。
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println(availableZoneId);
        }

        System.out.println("=====================");
        //获取系统的默认时区编号
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        //获取其他国家的日期
        LocalDateTime now = LocalDateTime.now();
        //获取指定时区的日期时间
        ZoneId zoneId1 = ZoneId.of("Europe/Monaco");
        ZonedDateTime zonedDateTime = now.atZone(zoneId1);  //获得指定时区的当前时间
        System.out.println(zonedDateTime);

        System.out.println("=====================");
        //根据时区，获取该地区的日期
        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("America/Phoenix"));  //获得指定时区的当前时间（不带时区信息）
        System.out.println(now1);


        /*
        //计算时间的间隔
        Instant start = Instant.now();
        for (int i = 0; i < 150; i++) {
            System.out.println(i);
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        long l = duration.toNanos();

        //间隔的时间
        System.out.println("循环耗时："+l+"纳秒");


        /*
        //日期转LocalDateTime
        Date d = new Date();
        LocalDateTime l1 = d.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        System.out.println(d);
        System.out.println(l1);
        LocalDateTime l = LocalDateTime.now();
        Date dd = Date.from(l.toInstant(ZoneOffset.of("+8")));

        /*
        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        /*
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = dt.format(now);
        System.out.println(s);

        //定义时间字符串
        String ss = "2020-09-04 12:11:31";
        //将时间字符串根据模板解析为LocalDateTime
        LocalDateTime parse = LocalDateTime.parse(ss,dt);
        System.out.println(parse);

        System.out.println(parse.isAfter(now));
        System.out.println(parse.isBefore(now));
        System.out.println(parse.isEqual(now));


        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        LocalTime lt = LocalTime.now();
        System.out.println(lt);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        System.out.println(now.getYear());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getMonth());
        System.out.println(now.getMonthValue());

        //获取带时区的时间
        LocalDateTime tokey = LocalDateTime.now(ZoneOffset.of("+9"));
        System.out.println("北京时间："+now);
        System.out.println("东京时间："+tokey);
        System.out.println(now.format(dt));
        System.out.println(dt.format(tokey));


        //获取秒数
        long second = LocalDateTime.now(ZoneOffset.of("+9")).toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second);
        //获取毫秒数
        long milissecond = LocalDateTime.now(ZoneOffset.of("+9")).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milissecond);
        System.out.println(now.withYear(2010));
        */
    }


}
