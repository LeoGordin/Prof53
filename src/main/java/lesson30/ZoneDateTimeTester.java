package lesson30;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTimeTester {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println(zonedDateTime);


        System.out.println(
                zonedDateTime.toInstant().atZone(ZoneId.of("Pacific/Midway"))
        );

        System.out.println(
                ZoneId.getAvailableZoneIds()
        );

    }
}
