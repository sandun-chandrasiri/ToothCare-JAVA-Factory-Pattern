/**
 *
 * @author Sandun Chandrasiri (K2322528 / E119775)
 */

/**
 * Appointment class represents a dental appointment in the system.
 * Includes attributes such as ID, age, name, gender, address, and contact.
 */
public class Appointment {
    
    // Attributes
    private int id,age;
    private String name,gender,address,contact;
    
    // Default constructor initializes attributes to default values
    public Appointment(){
        this.id = 0;
        this.age = 0;
        this.name = "";
        this.gender = "";
        this.address = "";
        this.contact = ""; 
    }
    
    // Parameterized constructor for creating an appointment with specified values
    public Appointment(int id, int age, String name, String gender, String address, String contact) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
    }
    
    // Constructor that accepts an AppointmentFactory for flexibility in object creation
    public Appointment(AppointmentFactory factory) {
        
        // Use the factory to create an instance of Appointment
        Appointment appointment = factory.createAppointment();

        // Copy the values from the created instance to the current instance
        this.id = appointment.getId();
        this.age = appointment.getAge();
        this.name = appointment.getName();
        this.gender = appointment.getGender();
        this.address = appointment.getAddress();
        this.contact = appointment.getContact();
    }

    // Getter and setter methods for each attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", age=" + age + ", name=" + name + ", gender=" + gender + ", address=" + address + ", contact=" + contact + '}';
    }
    
    
    
}
