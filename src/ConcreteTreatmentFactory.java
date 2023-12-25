
/**
 * A concrete implementation of the TreatmentFactory interface.
 * This class provides a specific way of creating Treatment objects.
 * 
 * @author Sandun Chandrasiri (K2322528 / E119775)
 */
public class ConcreteTreatmentFactory implements TreatmentFactory{
    
    /**
     * Creates a Treatment object with the provided parameters.
     * 
     * @param id The ID of the treatment.
     * @param sellingPrice The selling price of the treatment.
     * @param name The name of the treatment.
     * @param description The description of the treatment.
     * @return A Treatment object created with the given parameters.
     */
    @Override
    public Treatment createTreatment(int id, int sellingPrice, String name, String description) {
        // Create a new Treatment object
        return new Treatment(id, sellingPrice, name, description);
    }
    
}
