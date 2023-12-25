
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author Sandun Chandrasiri (K2322528 / E119775)
 */
public class Billing extends javax.swing.JFrame {
    
    ArrayList<Treatment> allTreatments = new ArrayList<>();
    ArrayList<Appointment> allAppointments = new ArrayList<>();
    ArrayList<BillingInfo> record = new ArrayList<>();
    
    private final BillingInfoFactory billingInfoFactory;

    /**
     * Creates new form Billing
     */

    // Constructor accepting a BillingInfoFactory
    public Billing(BillingInfoFactory billingInfoFactory) {
        initComponents();

        // Initialization
        this.billingInfoFactory = billingInfoFactory;
        
        readAllPData();
        readAllMData();
        loadTreatments();
    }
    
    void loadTreatments(){
        showTreatments.removeAllItems();
        
        for (int i=0;i<allTreatments.size();i++){
            showTreatments.addItem(allTreatments.get(i).getId()+";"+allTreatments.get(i).getName());
        }
    }
    
    void readAllPData(){
        try {
            File pfile = new File("pdata.txt");
            Scanner scanner =new Scanner(pfile);
            
            while (scanner.hasNextLine()) {
                
                String data = scanner.nextLine();
                String[] curData = data.split(";");
                Appointment appointment = new Appointment();
                
                appointment.setId(Integer.parseInt(curData[0]));
                appointment.setName(curData[1]);
                appointment.setAge(Integer.parseInt(curData[2]));
                appointment.setGender(curData[3]);
                appointment.setAddress(curData[4]);
                appointment.setContact(curData[5]);
                
                allAppointments.add(appointment);               
            }
            
            scanner.close();
            
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly, print the stack trace for debugging
        }
    }
    
    void readAllMData(){
        try {
            File pfile = new File("mdata.txt");
            Scanner scanner =new Scanner(pfile);
            
            while (scanner.hasNextLine()) {
                
                String data = scanner.nextLine();
                String[] curData = data.split(";");
                Treatment treatments = new Treatment();
                
                treatments.setId(Integer.parseInt(curData[0]));
                treatments.setName(curData[1]);
                treatments.setSellingPrice(Integer.parseInt(curData[2]));
                treatments.setDescription(curData[3]);
                
                allTreatments.add(treatments);               
            }
            
            scanner.close();
            
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly, print the stack trace for debugging
        }
    }
    
    
    void saveAllMData(){
        try {
            FileWriter filewriter = new FileWriter("mdata.txt");
            
            for (int i=0;i<allTreatments.size();i++){
                filewriter.write(allTreatments.get(i).getId()+";"
            +allTreatments.get(i).getName()+";"
            +allTreatments.get(i).getSellingPrice()+";"
            +allTreatments.get(i).getDescription()+ "\n");
            }
            filewriter.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly, print the stack trace for debugging
        }
    }
    
    void saveAllRData(){
        try {
            FileWriter filewriter = new FileWriter("record.txt");
            
            for (int i=0;i<record.size();i++){
                filewriter.append(record.get(i).getAppointmentID()+";"
            +record.get(i).getFee()+";"
            +record.get(i).getRecomendations()+";"
            +record.get(i).getDate()+";"
            +record.get(i).getTreatmentTotal()+";");
            
                List<Integer> tmp = record.get(i).getTreatmentID();
                for(int j=0;j<tmp.size();j++){
                    filewriter.append(tmp.get(j)+";");
                }
                int total = record.get(i).getFee() + record.get(i).getTreatmentTotal();
                filewriter.append(total + ";");
                
                filewriter.append("\n");  // Add a new line after each record
            }
            filewriter.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly, print the stack trace for debugging
        }
    }
    
    boolean checkExisting(){
        for(int i=0;i<allAppointments.size();i++){
            if(id.getText().equals(allAppointments.get(i).getId()+"")){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fee = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        showTreatments = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recomendation = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        treatmentList = new javax.swing.JTextArea();
        addTreatmentButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        paymentPaid = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo 4.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setText("Billing Menu");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tooth Care Management System");

        homeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeButton.setForeground(new java.awt.Color(0, 204, 51));
        homeButton.setText("HOME");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                        .addComponent(homeButton)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(homeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Appointment ID");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Counsultant Fee");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Treatments");

        showTreatments.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Recomendation");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Treatment List");

        recomendation.setColumns(20);
        recomendation.setRows(5);
        jScrollPane1.setViewportView(recomendation);

        treatmentList.setColumns(20);
        treatmentList.setRows(5);
        jScrollPane2.setViewportView(treatmentList);

        addTreatmentButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addTreatmentButton.setForeground(new java.awt.Color(0, 204, 51));
        addTreatmentButton.setText("Add Treatments");
        addTreatmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTreatmentButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 204, 51));
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Quantity");

        paymentPaid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        paymentPaid.setText("Payment Paid in Full");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paymentPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(showTreatments, 0, 247, Short.MAX_VALUE)
                                    .addComponent(quantity)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addTreatmentButton)
                .addGap(160, 160, 160))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showTreatments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addTreatmentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paymentPaid, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(888, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    
    private void addTreatmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTreatmentButtonActionPerformed
        if (quantity.getText().equals("")||showTreatments.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a treatment or Enter quantity !");    
        }
        else{
            treatmentList.append(showTreatments.getSelectedItem()+";"+quantity.getText()+"\n");
            quantity.setText("");
        }
    }//GEN-LAST:event_addTreatmentButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (id.getText().equals("")||fee.getText().equals("")||recomendation.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "All Fields are Required !");
        }
        else if(checkExisting()){
            JOptionPane.showMessageDialog(null, "Appointment ID does not Exist !");
        }
        else{

            // Check if the paymentPaid checkbox is selected
            if (!paymentPaid.isSelected()) {
                JOptionPane.showMessageDialog(null, "Payment should be paid in full before saving the new Record!");
                return; // Don't proceed further if paymentPaid is not selected
            }
            
            // Get the selected treatments from the treatmentList and convert them to a List<Integer>
            List<Integer> treatmentIDList = extractTreatmentIDsFromList();

            // Use the factory to create BillingInfo
            BillingInfoFactory billingInfoFactory = new ConcreteBillingInfoFactory();
            BillingInfo billingInfo = billingInfoFactory.createBillingInfo(
                    Integer.parseInt(id.getText()),
                    Integer.parseInt(fee.getText()),
                    recomendation.getText(),
                    currentDateAsString(),
                    treatmentIDList
            );
            
            String Bill="";
            int total=0;
            
            billingInfo.setAppointmentID(Integer.parseInt(id.getText()));
            billingInfo.setFee(Integer.parseInt(fee.getText()));
            String[] Mdata = treatmentList.getText().split("\n");
            
            for(int i=0;i<Mdata.length;i++){
                billingInfo.setTreatmentID(Collections.singletonList(Integer.parseInt(Mdata[i].split(";")[0])));
                int currentQuantity = Integer.parseInt(Mdata[i].split(";")[2]);
                int currentID = Integer.parseInt(Mdata[i].split(";")[0]);
                
                for (int j = 0; j < allTreatments.size(); j++) {
                    if (allTreatments.get(j).getId() == currentID) {
                        int treatmentTotal = allTreatments.get(j).getSellingPrice() * currentQuantity;
                        Bill += allTreatments.get(j).getName() + "  =   " + treatmentTotal + "\n";
                        total += treatmentTotal;
                        
                        billingInfo.setTreatmentTotal(treatmentTotal);
                    }
                }

            }
            
            billingInfo.setRecomendations(recomendation.getText());
            DateFormat cDateFormat = new SimpleDateFormat("dd:MM:yyyy");
            Date currentDate = new Date();
            billingInfo.setDate(cDateFormat.format(currentDate));
            
            record.add(billingInfo);
            
            saveAllMData();
            saveAllRData();
            
            Bill+="\nTotal Treatment Cost= "+total;
            Bill+="\nDoctor Fee= "+fee.getText();
            Bill+="\nTotal = "+(total+Integer.parseInt(fee.getText()));   
            
            JOptionPane.showMessageDialog(null, "Your Bill \n"+Bill);
            id.setText("");
            fee.setText("");
            recomendation.setText("");
            treatmentList.setText("");
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    
    // This helper method to extract treatment IDs from the treatmentList
    private List<Integer> extractTreatmentIDsFromList() {
        List<Integer> treatmentIDList = new ArrayList<>();
        String[] Mdata = treatmentList.getText().split("\n");

        for (String data : Mdata) {
            // Add a check to ensure that the data can be parsed as an integer
            try {
                int currentTreatmentID = Integer.parseInt(data.split(";")[0]);
                treatmentIDList.add(currentTreatmentID);
            } catch (NumberFormatException e) {
                // Handle the case where the data is not a valid integer
                System.err.println("Skipping invalid treatment ID: " + data.split(";")[0]);
            }
        }

        return treatmentIDList;
    }

    // This helper method to get the current date as a formatted string
    private String currentDateAsString() {
        DateFormat cDateFormat = new SimpleDateFormat("dd:MM:yyyy");
        Date currentDate = new Date();
        return cDateFormat.format(currentDate);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        // Use the ConcreteBillingInfoFactory to create an instance of BillingInfoFactory
        BillingInfoFactory billingInfoFactory = new ConcreteBillingInfoFactory();

        // Create an instance of Billing and provide the factory instance
        Billing billingInstance = new Billing(billingInfoFactory);

        // Set the visibility of the created Billing instance
        billingInstance.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTreatmentButton;
    private javax.swing.JTextField fee;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox paymentPaid;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextArea recomendation;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> showTreatments;
    private javax.swing.JTextArea treatmentList;
    // End of variables declaration//GEN-END:variables
}
