import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
        private final String animalOfKind;
        private final List<String> expectedOfKind;

        public AnimalParameterizedTest(String animalOfKind, List<String> expectedOfKind) {
            this.animalOfKind = animalOfKind;
            this.expectedOfKind = expectedOfKind;
        }

        @Parameterized.Parameters
        public static Object[][] getFoodData() {
            return new Object[][]{
                    {"Травоядное", List.of("Трава", "Различные растения")}, {"Хищник", List.of("Животные", "Птицы", "Рыба")}};
        }

        @Test
        public void getFood() throws Exception {
            Animal animal = new Animal();
            List<String> list = animal.getFood(animalOfKind);
            assertArrayEquals(expectedOfKind.toArray(),list.toArray());
        }
    }

