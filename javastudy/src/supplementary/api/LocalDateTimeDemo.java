package supplementary.api;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class LocalDateTimeDemo {
    public static void main(String[] args) {

        //ZoneID ����ʱ����
        //��ȡ������ص�ʱ����š�
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println(availableZoneId);
        }

        System.out.println("=====================");
        //��ȡϵͳ��Ĭ��ʱ�����
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        //��ȡ�������ҵ�����
        LocalDateTime now = LocalDateTime.now();
        //��ȡָ��ʱ��������ʱ��
        ZoneId zoneId1 = ZoneId.of("Europe/Monaco");
        ZonedDateTime zonedDateTime = now.atZone(zoneId1);  //���ָ��ʱ���ĵ�ǰʱ��
        System.out.println(zonedDateTime);

        System.out.println("=====================");
        //����ʱ������ȡ�õ���������
        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("America/Phoenix"));  //���ָ��ʱ���ĵ�ǰʱ�䣨����ʱ����Ϣ��
        System.out.println(now1);


        /*
        //����ʱ��ļ��
        Instant start = Instant.now();
        for (int i = 0; i < 150; i++) {
            System.out.println(i);
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        long l = duration.toNanos();

        //�����ʱ��
        System.out.println("ѭ����ʱ��"+l+"����");


        /*
        //����תLocalDateTime
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

        //����ʱ���ַ���
        String ss = "2020-09-04 12:11:31";
        //��ʱ���ַ�������ģ�����ΪLocalDateTime
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

        //��ȡ��ʱ����ʱ��
        LocalDateTime tokey = LocalDateTime.now(ZoneOffset.of("+9"));
        System.out.println("����ʱ�䣺"+now);
        System.out.println("����ʱ�䣺"+tokey);
        System.out.println(now.format(dt));
        System.out.println(dt.format(tokey));


        //��ȡ����
        long second = LocalDateTime.now(ZoneOffset.of("+9")).toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second);
        //��ȡ������
        long milissecond = LocalDateTime.now(ZoneOffset.of("+9")).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milissecond);
        System.out.println(now.withYear(2010));
        */
    }


}
