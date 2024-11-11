/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medinovahealthcare;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FinanceHomeP extends javax.swing.JFrame {

    private DataBase database = new DataBase();
    private File selectedFile; 
    private byte[] imageBytes;
    public FinanceHomeP() {
        initComponents(); 
        display();
    }

    private void display() {
    // Set up the main panel with a fixed layout and dimensions
    PaneliMeImazhe.setLayout(new GridLayout(0, 4, 10, 10)); // Display 4 items per row

    ImageIcon editIcon = new ImageIcon("C:\\Users\\User\\Downloads\\pencil_1972600.png");
    ImageIcon deleteIcon = new ImageIcon("C:\\Users\\User\\Downloads\\delete_2550213.png");


        
    try (Connection conn = database.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT Name, Amount, Cost, Image FROM supply")) {

        while (rs.next()) {
            String name = rs.getString("Name");
            int amount = rs.getInt("Amount");
            double cost = rs.getDouble("Cost");
            byte[] imgBytes = rs.getBytes("Image");

            if (imgBytes != null && imgBytes.length > 0) {
                // Convert image bytes to ImageIcon
                ImageIcon imageIcon = new ImageIcon(imgBytes);
                Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);

                // Create the panel for each product
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical arrangement
                panel.setPreferredSize(new Dimension(400, 450)); // Set fixed size for each item panel
                panel.setBackground(new Color(252, 250, 237));

                // Create JLabel for the image
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                // Create JLabel for the name
                JLabel nameLabel = new JLabel(name);
                nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));

                // Create JLabel for the price
                JLabel priceLabel = new JLabel("Çmimi: " + cost + " leke");
                priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                priceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));

                // Create JLabel for the amount
                JLabel amountLabel = new JLabel("Sasia: " + amount);
                amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                amountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));


                JButton editButton = new JButton(editIcon);
                editButton.setToolTipText("Edito");
                editButton.setPreferredSize(new Dimension(40, 40));
                editButton.setBackground(new Color(242, 145, 61));
                editButton.addActionListener(e -> {
                    openEditItemDialog(name, amount, cost, priceLabel, amountLabel);
                        });

                JButton deleteButton = new JButton(deleteIcon);
                deleteButton.setToolTipText("Fshi");
                deleteButton.setPreferredSize(new Dimension(40, 40));
                deleteButton.setBackground(new Color(235, 42, 21));
                deleteButton.addActionListener(e -> {
                    int response = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete " + name + "?",
                            "Confirm Deletion",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        deleteItem(name);
                        PaneliMeImazhe.remove(panel);
                        PaneliMeImazhe.revalidate();
                        PaneliMeImazhe.repaint();
                    } else {
                        System.out.println("Deletion canceled.");
                    }
                });


                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
                buttonPanel.add(editButton);
                buttonPanel.add(deleteButton);
                buttonPanel.setOpaque(false);

                panel.add(imageLabel, BorderLayout.NORTH);
                panel.add(nameLabel, BorderLayout.CENTER);
                panel.add(priceLabel, BorderLayout.SOUTH);
                panel.add(amountLabel, BorderLayout.AFTER_LAST_LINE);
                panel.add(buttonPanel, BorderLayout.PAGE_END);

                // Add the product panel to the container panel
                PaneliMeImazhe.add(panel);
            } else {
                System.out.println("No image found for: " + name);
            }
        }

        // Refresh PaneliMeImazhe after adding all the content
        PaneliMeImazhe.revalidate();
        PaneliMeImazhe.repaint();
    } catch (SQLException e) {
        System.out.println("Error with database connection or query execution.");
        e.printStackTrace();
    } catch (Exception e) {
        System.out.println("Error during image processing or panel creation.");
        e.printStackTrace();
    }

}
    
    private BufferedImage getImageFromBytes(byte[] imageData) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData)) {
            return ImageIO.read(bais);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
// Add the scroll pane with the product panel to your existing frame
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logOut = new javax.swing.JLabel();
        HomeF = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        shtoje = new medinovahealthcare.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        stoku = new medinovahealthcare.PanelRound();
        stok = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PaneliMeImazhe = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        shtoDoktor = new javax.swing.JButton();
        backButtonTabelD1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        emri = new javax.swing.JTextField();
        sasi = new javax.swing.JTextField();
        cmim = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fileChoserImazh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setLayout(null);

        header.setBackground(new java.awt.Color(48, 56, 103));
        header.setPreferredSize(new java.awt.Dimension(1920, 200));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\left-arrow.png")); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medinovahealthcare/Screenshot__87_-removebg-preview.png"))); // NOI18N

        logOut.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\logout.png")); // NOI18N
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1143, Short.MAX_VALUE)
                .addComponent(logOut)
                .addGap(24, 24, 24))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(header);
        header.setBounds(0, 0, 1920, 200);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\health-finance.jpg")); // NOI18N

        shtoje.setBackground(new java.awt.Color(48, 56, 103));
        shtoje.setPreferredSize(new java.awt.Dimension(610, 128));
        shtoje.setRoundBottomLeft(70);
        shtoje.setRoundBottomRight(70);
        shtoje.setRoundTopLeft(70);
        shtoje.setRoundTopRight(70);
        shtoje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shtojeMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Shto stok");

        javax.swing.GroupLayout shtojeLayout = new javax.swing.GroupLayout(shtoje);
        shtoje.setLayout(shtojeLayout);
        shtojeLayout.setHorizontalGroup(
            shtojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shtojeLayout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(198, 198, 198))
        );
        shtojeLayout.setVerticalGroup(
            shtojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shtojeLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        stoku.setBackground(new java.awt.Color(48, 56, 103));
        stoku.setPreferredSize(new java.awt.Dimension(610, 128));
        stoku.setRoundBottomLeft(70);
        stoku.setRoundBottomRight(70);
        stoku.setRoundTopLeft(70);
        stoku.setRoundTopRight(70);
        stoku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stokuMouseClicked(evt);
            }
        });

        stok.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        stok.setForeground(new java.awt.Color(255, 255, 255));
        stok.setText("Stoku");

        javax.swing.GroupLayout stokuLayout = new javax.swing.GroupLayout(stoku);
        stoku.setLayout(stokuLayout);
        stokuLayout.setHorizontalGroup(
            stokuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stokuLayout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(stok)
                .addGap(230, 230, 230))
        );
        stokuLayout.setVerticalGroup(
            stokuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stokuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(stok)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stoku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shtoje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(201, 201, 201))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(stoku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(shtoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel3)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        HomeF.addTab("tab3", jPanel3);

        PaneliMeImazhe.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PaneliMeImazheLayout = new javax.swing.GroupLayout(PaneliMeImazhe);
        PaneliMeImazhe.setLayout(PaneliMeImazheLayout);
        PaneliMeImazheLayout.setHorizontalGroup(
            PaneliMeImazheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1928, Short.MAX_VALUE)
        );
        PaneliMeImazheLayout.setVerticalGroup(
            PaneliMeImazheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(PaneliMeImazhe);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1924, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );

        HomeF.addTab("tab1", jPanel6);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\nkl.png")); // NOI18N

        shtoDoktor.setBackground(new java.awt.Color(0, 153, 51));
        shtoDoktor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        shtoDoktor.setForeground(new java.awt.Color(255, 255, 255));
        shtoDoktor.setText("Shto");
        shtoDoktor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shtoDoktorMouseClicked(evt);
            }
        });

        backButtonTabelD1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\back-button.png")); // NOI18N
        backButtonTabelD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonTabelD1MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel8.setText("Çmimi");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel9.setText("Sasia");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel10.setText("Emri");

        emri.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N

        sasi.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N

        cmim.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel11.setText("Imazhi");

        fileChoserImazh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        fileChoserImazh.setText("Zgjidhni një skedar");
        fileChoserImazh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChoserImazhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButtonTabelD1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(emri, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                            .addComponent(sasi)
                                            .addComponent(cmim)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(fileChoserImazh)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(shtoDoktor)))
                .addGap(94, 94, 94))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(backButtonTabelD1)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(emri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileChoserImazh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(shtoDoktor)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        HomeF.addTab("tab2", jPanel1);

        jPanel5.add(HomeF);
        HomeF.setBounds(0, 170, 1920, 810);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        this.setVisible(false);
        new Users().setVisible(true);
    }//GEN-LAST:event_logOutMouseClicked

    private void shtojeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shtojeMouseClicked
        HomeF.setSelectedIndex(2);
    }//GEN-LAST:event_shtojeMouseClicked

    private void stokuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stokuMouseClicked
        HomeF.setSelectedIndex(1);
    }//GEN-LAST:event_stokuMouseClicked

    private void backButtonTabelD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonTabelD1MouseClicked
        HomeF.setSelectedIndex(0);
    }//GEN-LAST:event_backButtonTabelD1MouseClicked

    private void shtoDoktorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shtoDoktorMouseClicked
    String name = emri.getText().trim();
    String amount = sasi.getText().trim();
    String price = cmim.getText().trim();
    
    if (name.isEmpty() || amount.isEmpty() || price.isEmpty() || imageBytes == null) {
        JOptionPane.showMessageDialog(this, "Please fill out all fields and select an image before adding the supply.");
        clearfields(); // Clear the text fields
        return; // Exit the method if any field is empty
    }
    
    DataBase db = new DataBase();
    
    String sql = "INSERT INTO supply (Name, Amount, Cost, Image) " +
                 "VALUES (?, ?, ?, ?)";
    
    try (Connection conn = db.getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);  
        pstmt.setString(2, amount);  
        pstmt.setDouble(3, Double.parseDouble(price));   
        pstmt.setBytes(4, imageBytes);  // Set the image bytes as BLOB

        pstmt.executeUpdate();
    
        // Notify the user that the supply was successfully added
        JOptionPane.showMessageDialog(this, "Supply successfully added.");
        
        clearfields(); // Clear the text fields after successful insertion
        imageBytes = null; // Reset imageBytes after insertion
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while adding the supply. Please try again.");
    }                                      
    }//GEN-LAST:event_shtoDoktorMouseClicked

    private void fileChoserImazhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChoserImazhActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Choose an Image File");

    // Allow only image files to be selected
    fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg", "gif"));

    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        selectedFile = fileChooser.getSelectedFile();
        
        // Convert the selected image to a byte array
        try {
            imageBytes = Files.readAllBytes(selectedFile.toPath());
            JOptionPane.showMessageDialog(this, "Image selected successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while loading the image.");
        }
    }
    }//GEN-LAST:event_fileChoserImazhActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        HomeF.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void clearfields(){
        emri.setText("");
        sasi.setText("");
        cmim.setText("");
        selectedFile = null; 
        imageBytes = null; 
    }
    private void openEditItemDialog(String name, int amount, double cost, JLabel priceLabel, JLabel amountLabel) {
        
    JTextField stockField = new JTextField(String.valueOf(amount), 10);
    JTextField priceField = new JTextField(String.valueOf(cost), 10);

    JPanel panel = new JPanel(new GridLayout(2, 2));
    panel.add(new JLabel("Sasia:"));
    panel.add(stockField);
    panel.add(new JLabel("Çmimi:"));
    panel.add(priceField);

    int option = JOptionPane.showConfirmDialog(null, panel, 
        "Edit Item Details", JOptionPane.OK_CANCEL_OPTION, 
        JOptionPane.QUESTION_MESSAGE);

    if (option == JOptionPane.OK_OPTION) {
        try {
            int stock = Integer.parseInt(stockField.getText());
            double price = Double.parseDouble(priceField.getText());

            try (Connection conn = database.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement("UPDATE supply SET Amount = ?, Cost = ? WHERE Name = ?")) {
                pstmt.setInt(1, stock);
                pstmt.setDouble(2, price);
                pstmt.setString(3, name);
                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Item updated successfully.");
                    priceLabel.setText("Çmimi: " + price + " leke");
                    amountLabel.setText("Sasia: " + stock);
                    PaneliMeImazhe.revalidate();
                    PaneliMeImazhe.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Item not found.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while updating the item.");
        }
    } else {
        System.out.println("Edit canceled.");
    }
}

 
    private void deleteItem(String name) {
    try (Connection conn = database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM supply WHERE Name = ?")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, name + " has been deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while deleting " + name);
        }
   }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinanceHomeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinanceHomeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinanceHomeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinanceHomeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinanceHomeP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane HomeF;
    private javax.swing.JPanel PaneliMeImazhe;
    private javax.swing.JLabel backButtonTabelD1;
    private javax.swing.JTextField cmim;
    private javax.swing.JTextField emri;
    private javax.swing.JButton fileChoserImazh;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logOut;
    private javax.swing.JTextField sasi;
    private javax.swing.JButton shtoDoktor;
    private medinovahealthcare.PanelRound shtoje;
    private javax.swing.JLabel stok;
    private medinovahealthcare.PanelRound stoku;
    // End of variables declaration//GEN-END:variables
}
