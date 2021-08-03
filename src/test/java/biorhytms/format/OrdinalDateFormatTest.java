package biorhytms.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.Format;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class OrdinalDateFormatTest {

    @Mock
    private Format ordinalDayFormat;

    @InjectMocks
    private OrdinalDateFormat ordinalDateFormat;

    @BeforeEach
    void setUp() {
    }


    @Test
    void throwWhenNull() {
        doThrow(new NullPointerException()).when(ordinalDayFormat).format(null);

        assertThrows(NullPointerException.class, () -> ordinalDateFormat.format(null));
    }
}