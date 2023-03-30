import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final boolean expectedSex;
    private final String sex;

    @Mock
     Feline feline;

    public LionParameterizedTest(String sex, boolean expectedSex) {
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
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(expectedSex, lion.doesHaveMane());
    }

}

