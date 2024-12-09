import java.util.*;
import java.util.stream.Collectors;

/**
 * The Statistics class is responsible for calculating and displaying various statistics
 * based on the list of Chthonic entities.
 * It calculates attack power statistics (average, min, max, IQR) and the frequency of different entity types.
 */
public class Statistics {
    private final List<ChthonicEntity> entities;

    /**
     * Constructor for the Statistics class.
     *
     * @param entities A list of ChthonicEntity objects for which statistics will be calculated.
     */
    public Statistics(List<ChthonicEntity> entities) {
        this.entities = entities;
    }

    /**
     * Calculates and prints the following statistics based on the attack power of the entities:
     * - Average attack power
     * - Minimum attack power
     * - Maximum attack power
     * - Interquartile Range (IQR) of attack power
     *
     * Additionally, it calculates and prints the frequency of different entity types (grouped by type).
     */
    public void calculate() {
        // Calculate basic statistics (average, min, max) for attack power
        DoubleSummaryStatistics stats = entities.stream()
                .mapToDouble(ChthonicEntity::getAttackPower)
                .summaryStatistics();

        double average = stats.getAverage();
        double min = stats.getMin();
        double max = stats.getMax();

        // Calculate the Interquartile Range (IQR)
        List<ChthonicEntity> sortedEntities = new ArrayList<>(entities);
        sortedEntities.sort(Comparator.comparingDouble(ChthonicEntity::getAttackPower));
        double IQR = sortedEntities.get((int) (sortedEntities.size() * 0.75 - 1)).getAttackPower()
                - sortedEntities.get((int) (sortedEntities.size() * 0.25 - 1)).getAttackPower();

        // Output the calculated statistics
        System.out.printf(
                "Statistics based on entity's attack power:%n" +
                        "{%n\t average: %.2f,%n\t min: %.2f,%n\t max: %.2f,%n\t IQR: %.2f%n}%n",
                average, min, max, IQR
        );

        // Calculate and display the frequency of different entity types
        Map<String, Long> frequency = entities.stream()
                .collect(Collectors.groupingBy(ChthonicEntity::getType, Collectors.counting()));
        System.out.println("Number of different entities:");
        System.out.println(frequency);
    }
}
