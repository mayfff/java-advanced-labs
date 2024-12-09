import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * The ChthonicGenerator class is responsible for generating an infinite stream of
 * random ChthonicEntity objects. Each entity has a randomly assigned name, type,
 * first mention date, and attack power.
 */
public class ChthonicGenerator {

    // Array of possible entity types: Demon, Spirit, Vampire
    private static final String[] TYPES = {"Demon", "Spirit", "Vampire"};

    // Random instance for generating random values
    private static final Random RANDOM = new Random();

    /**
     * Generates an infinite stream of ChthonicEntity objects with random attributes.
     * The generated entities have:
     * - A random name in the format "Entity#X", where X is a random number.
     * - A random type chosen from the predefined TYPES array ("Demon", "Spirit", "Vampire").
     * - A random first mention date, which is between 1000 and 2000 years ago from the current date.
     * - A random attack power ranging from 0 to 100.
     *
     * @return A stream of randomly generated ChthonicEntity objects.
     */
    public static Stream<ChthonicEntity> generate() {
        return Stream.generate(() -> new ChthonicEntity(
                "Entity#" + (RANDOM.nextInt(999) + 1),  // Random entity name
                TYPES[RANDOM.nextInt(TYPES.length)],   // Random type
                LocalDate.now().minusYears(RANDOM.nextInt(1000) + 1000), // Random date from 1000 to 2000 years ago
                RANDOM.nextDouble() * 100  // Random attack power between 0 and 100
        ));
    }
}
