import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void getFamilyAnimalTest() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }

    @Test
    public void getFoodExceptionTest() {
        Animal animal = new Animal();
        String expectedErrorMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

        Exception exception = assertThrows(Exception.class, () -> { animal.getFood("");
        });
        assertEquals(expectedErrorMessage, exception.getMessage());
    }
}

