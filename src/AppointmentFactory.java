/**
 *
 * @author Sandun Chandrasiri (K2322528 / E119775)
 */

/**
 * AppointmentFactory interface defines a contract for creating instances of the Appointment class.
 */
public interface AppointmentFactory {
    
    /**
     * Create and return an Appointment object.
     * The implementation of this method is provided by classes that implement this interface.
     *
     * @return Appointment object created by the factory.
     */
    Appointment createAppointment();
    
}
