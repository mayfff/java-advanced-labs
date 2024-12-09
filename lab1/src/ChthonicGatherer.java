import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

/**
 * A custom gatherer that skips a specific number of entities of a given type
 * and collects a fixed number of total entities.
 */
public class ChthonicGatherer implements Gatherer<ChthonicEntity, AtomicInteger, ChthonicEntity> {

    private final String typeToSkip;
    private final int skipCount;
    private int count;  // Tracks how many entities have been collected
    private final int total;  // Total number of entities to collect

    /**
     * Constructor to initialize the gatherer with the type to skip,
     * number of entities to skip, and total entities to collect.
     *
     * @param typeToSkip The type of entities to skip (e.g., "Demon")
     * @param skipCount The number of entities to skip
     * @param total The total number of entities to collect
     */
    public ChthonicGatherer(String typeToSkip, int skipCount, int total) {
        this.typeToSkip = typeToSkip;
        this.skipCount = skipCount;
        this.count = 0;
        this.total = total;
    }

    @Override
    public Supplier<AtomicInteger> initializer() {
        // Initialize a state using AtomicInteger to track skipped entities
        return AtomicInteger::new;
    }

    @Override
    public Integrator<AtomicInteger, ChthonicEntity, ChthonicEntity> integrator() {
        return (state, element, downstream) -> {
            // Skip entities of the specified type if we haven't skipped enough
            if (element.getType().equalsIgnoreCase(typeToSkip) && state.get() < skipCount) {
                state.incrementAndGet(); // Increment skip counter
                return true; // Skip this element
            } else if (count < total) {
                // Collect the entity if total has not been reached
                count += 1;
                return downstream.push(element); // Push to the downstream collector
            }
            return false; // Stop if we've collected enough entities
        };
    }

    @Override
    public BinaryOperator<AtomicInteger> combiner() {
        // Default combiner from Gatherer interface
        return Gatherer.super.combiner();
    }

    @Override
    public BiConsumer<AtomicInteger, Downstream<? super ChthonicEntity>> finisher() {
        // Default finisher from Gatherer interface
        return Gatherer.super.finisher();
    }

    @Override
    public <RR> Gatherer<ChthonicEntity, ?, RR> andThen(Gatherer<? super ChthonicEntity, ?, ? extends RR> that) {
        // Allows chaining another gatherer
        return Gatherer.super.andThen(that);
    }
}
