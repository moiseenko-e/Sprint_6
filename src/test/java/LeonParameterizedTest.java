import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LeonParameterizedTest {
    private final boolean expectedSex;
    private final String sex;

    @Mock
     Feline feline;

    public LeonParameterizedTest(String sex, boolean expectedSex) {
        this.sex = sex;
        this.expectedSex = expectedSex;
    }
    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{{"Самец", true}, {"Самка", false}};
    }
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(1, lion.getKittens());
    }
    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(expectedSex, lion.doesHaveMane());
    }
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
    @Test
    public void doesHaveManeExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "Неизвестен"));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}

