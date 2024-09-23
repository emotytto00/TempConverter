import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.001);
        assertEquals(37.778, converter.fahrenheitToCelsius(100), 0.001);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.001);
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.001);
    }
    @Test
    public void testKelvinToCel() {
        assertEquals(0.0, TemperatureConverter.kelvinToCel(273.15F), 0.001);
    }


    @Test
    public void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-41));
        assertTrue(converter.isExtremeTemperature(51));
        assertFalse(converter.isExtremeTemperature(0));
        assertFalse(converter.isExtremeTemperature(25));
        assertFalse(converter.isExtremeTemperature(-40)); // -40 is not extreme
        assertFalse(converter.isExtremeTemperature(50));  // 50 is not extreme
    }
    @Test
    public void testKelvinToFah() {
        assertEquals(32.0, TemperatureConverter.kelvinToFah(273.15), 0.001);
    }
}
