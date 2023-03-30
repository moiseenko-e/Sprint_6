import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самец");
        Assert.assertEquals(1, lion.getKittens());
    }
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
    @Test
    public void doesHaveManeExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "Неизвестен"));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}
