
import java.util.ArrayList;
import java.util.List;


/**
 *
 * Represents billing information for healthcare appointments.
 * 
 * This class encapsulates details such as appointment ID, treatment IDs, recommendations,
 * date, fee, and treatment total.
 * @author Sandun Chandrasiri (K2322528 / E119775)
 */
public class BillingInfo {
    private int appointmentID;
    private List<Integer> treatmentID; 
    private String recomendations,date;
    private int fee;
    private int treatmentTotal;


    /**
     * Default constructor for BillingInfo class.
     * Initializes some fields with default values.
     */
    public BillingInfo() {
        this.appointmentID = 0;
        this.treatmentID = new ArrayList<>();
        this.recomendations = "";
        this.date = "";
        this.fee = 0;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public List<Integer> getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(List<Integer> treatmentID) {
        this.treatmentID = treatmentID;
    }
    
    public String getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(String recomendations) {
        this.recomendations = recomendations;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getTreatmentTotal() {
        return treatmentTotal;
    }

    public void setTreatmentTotal(int treatmentTotal) {
        this.treatmentTotal = treatmentTotal;
    }
    
}
