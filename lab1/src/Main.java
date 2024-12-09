import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The Main class provides functionality to filter and process a list of Chthonic entities.
 * It allows the user to discard a specific number of entities of a given type and then filter
 * the resulting list by year and group them by type.
 * It also calculates and outputs various statistics based on the entities.
 */
public class Main {

    /**
     * The main method is the entry point of the program.
     * It interacts with the user to input the number and type of entities to discard,
     * then processes the list of Chthonic entities by filtering, grouping, and calculating statistics.
     *
     * @param args Command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {

        // Create a scanner object for reading user input
        Scanner sc = new Scanner(System.in);

        // Ask the user for the number of entities to discard
        System.out.print("Enter the number of entities to discard (N): ");
        final int N = sc.nextInt();
        sc.nextLine();  // Consume newline character

        // Ask the user for the type of entities to discard
        System.out.print("Enter the type of entities to discard (Demon, Vampire, Spirit): ");
        final String type = sc.nextLine();
        sc.close();

        // Generate and filter the Chthonic entities based on user input
        List<ChthonicEntity> entities = ChthonicGenerator.generate()
                .gather(new ChthonicGatherer(type, N, 500)) // Apply gathering criteria
                .toList();

        // Define the range of years for filtering entities
        int startYear = 230;
        int endYear = 250;

        // Filter entities based on the range of years and group them by type
        System.out.println("Entities filtered by year and sorted by type: ");
        Map<String, List<ChthonicEntity>> filteredEntities = entities.stream()
                .filter(entity -> {
                    // Get the year of the first mention of the entity
                    int yearsSinceAppearance = entity.getFirstMentionDate().getYear();
                    // Check if the entity falls within the specified year range
                    return (yearsSinceAppearance >= startYear) && (yearsSinceAppearance <= endYear);
                })
                .collect(Collectors.groupingBy(ChthonicEntity::getType));

        // Output the filtered and grouped entities
        System.out.println(filteredEntities + "\n");

        // Calculate and display statistics on the entities
        Statistics statistics = new Statistics(entities);
        statistics.calculate();
    }
}
