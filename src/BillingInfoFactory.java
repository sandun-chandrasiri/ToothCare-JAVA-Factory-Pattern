
import java.util.List;

/**
 *An interface for creating BillingInfo objects.
 * 
 * This interface defines a method for creating BillingInfo instances with specified parameters.
 * Implementing classes must provide their own implementation of the createBillingInfo method.
 * @author ASUS
 */
public interface BillingInfoFactory {
    
    /**
     * Creates a BillingInfo object with the provided parameters.
     * 
     * @param appointmentID The ID of the appointment associated with the billing.
     * @param fee The fee associated with the billing.
     * @param recomendations Recommendations related to the billing.
     * @param date The date of the billing.
     * @param treatmentID List of treatment IDs associated with the billing.
     * @return A BillingInfo object created with the given parameters.
     */
    BillingInfo createBillingInfo(int appointmentID, int fee, String recomendations, String date, List<Integer> treatmentID);
}


