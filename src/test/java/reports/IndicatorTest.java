package reports;

import biorhytms.Biorhythm;
import lombok.val;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class IndicatorTest {

    @Test
    @Disabled
    void Test() {

//        val indicator = new Indicator(Biorhythm.Physical.new Value(1));
//        System.out.printf("-|%s|-%n", indicator);
//        System.out.printf("-|%14s|-%n", indicator);
//        System.out.printf("-|%-30.1s|-%n", indicator);
    }

    @Test
    void splitText() {
        val text = "abc aa dd fgh asa klsa asd asa aqa";
        System.out.println(text.replaceAll("(.{1,6}) ", "$1#"));
    }
}