
/**
 * A default implementation of the AppointmentFactory interface.
 * This class provides a standard way of creating Appointment objects.
 * 
 * @author Sandun Chandrasiri (K2322528 / E119775)
 */
public class DefaultAppointmentFactory implements AppointmentFactory{
    
    /**
     * Creates a new instance of the Appointment class.
     * 
     * @return A new Appointment object.
     */
    @Override
    public Appointment createAppointment(){
        // Create a new Appointment object using the default constructor
        return new Appointment();
    }
    
}
