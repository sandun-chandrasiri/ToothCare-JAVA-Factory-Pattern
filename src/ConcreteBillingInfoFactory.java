import java.util.List;

/**
 *A concrete implementation of BillingInfoFactory interface.
 * This class provides a specific way of creating BillingInfo objects.
 * @author ASUS
 */
public class ConcreteBillingInfoFactory implements BillingInfoFactory {
    
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
    @Override
    public BillingInfo createBillingInfo(int appointmentID, int fee, String recomendations, String date, List<Integer> treatmentID) {
        
        // Create a new BillingInfo object
        BillingInfo billingInfo = new BillingInfo();
        
        // Set the properties of the BillingInfo object
        billingInfo.setAppointmentID(appointmentID);
        billingInfo.setFee(fee);
        billingInfo.setRecomendations(recomendations);
        billingInfo.setDate(date);
        billingInfo.setTreatmentID(treatmentID);
        
        // Return the created BillingInfo object
        return billingInfo;
    }
    
}
