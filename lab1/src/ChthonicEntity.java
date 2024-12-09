import java.time.LocalDate;

/**
 * The ChthonicEntity class represents a mythical entity with specific attributes.
 * These entities are characterized by their name, type, first mention date, and attack power.
 * This class provides methods to access these attributes.
 */
public class ChthonicEntity {

    private String name;
    private String type;
    private LocalDate firstMentionDate;
    private double attackPower;

    /**
     * Constructs a new ChthonicEntity with the specified attributes.
     *
     * @param name The name of the entity (e.g., "Vampire", "Demon").
     * @param type The type of the entity (e.g., "Demon", "Vampire", etc.).
     * @param firstMentionDate The date when the entity was first mentioned in literature.
     * @param attackPower The attack power of the entity, representing its strength.
     */
    public ChthonicEntity(String name, String type, LocalDate firstMentionDate, double attackPower) {
        this.name = name;
        this.type = type;
        this.firstMentionDate = firstMentionDate;
        this.attackPower = attackPower;
    }

    /**
     * Returns the name of the entity.
     *
     * @return The name of the entity.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the entity.
     *
     * @return The type of the entity.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the first mention date of the entity.
     *
     * @return The first mention date of the entity.
     */
    public LocalDate getFirstMentionDate() {
        return firstMentionDate;
    }

    /**
     * Returns the attack power of the entity.
     *
     * @return The attack power of the entity.
     */
    public double getAttackPower() {
        return attackPower;
    }

    /**
     * Returns a string representation of the ChthonicEntity object.
     * The string contains the name, type, first mention date, and attack power of the entity.
     *
     * @return A string representation of the ChthonicEntity object.
     */
    @Override
    public String toString() {
        return String.format("ChthonicEntity{name='%s', type='%s', firstMentionDate=%s, attackPower=%.2f}",
                name, type, firstMentionDate, attackPower);
    }
}

