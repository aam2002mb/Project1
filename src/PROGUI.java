import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class PROGUI {
    Control c;
    Interface i;
    private Travelers[] alltravelers;
    private Flights[] allflights;

    private JPanel MainPanel;
    private JButton addTripButton;
    private JButton viewTripButton;
    private JButton searchTripButton;
    private JButton travelerButton;
    private JButton deleteTripButton;
    private JButton editTripButton;
    private JButton exitButton;
    private JButton saveButton;
    private JPanel AllCards;
    private JPanel c1;
    private JPanel c2;
    private JPanel c3;
    private JPanel c4;
    private JPanel c5;
    private JPanel c6;
    private JPanel c7;
    private JPanel c8;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JButton addTripButton1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton searchButton;
    private JTextArea textArea2;
    private JTextField textField2;
    private JButton nextButton;
    private JButton nextButton1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton editButton;
    private JButton addTravelerButton;
    private JButton viewTravelerButton;
    private JButton searchTravelerButton;
    private JButton editTravelerButton;
    private JButton backButton;
    private JButton deleteTravelerButton;
    private JButton saveButton1;
    private JPanel TravelerCards;
    private JPanel C1;
    private JPanel C2;
    private JPanel C3;
    private JPanel C4;
    private JPanel C5;
    private JPanel C6;
    private JPanel C7;
    private JTextField t9;
    private JTextField t10;
    private JTextField t11;
    private JTextField t12;
    private JButton addTravelerButton1;
    private JTextArea textArea3;
    private JTextField textField9;
    private JButton searchButton1;
    private JTextArea textArea4;
    private JTextField textField10;
    private JButton editButton1;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JButton deletedButton;
    private JTextField textField16;
    private JButton deletedButton1;
    private JTextArea textArea5;
    private JTextField t7;
    private JTextField textField17;

    public PROGUI() throws FileNotFoundException {
        c=new Control();
        i=new Interface();
        c.readFlightsFiles();
        c.readTravelersFiles();

        addTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c1);
                AllCards.repaint();
                AllCards.revalidate();
            }
        });
        viewTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c2);
                AllCards.repaint();
                AllCards.revalidate();
                String s="";
                Flights[] all=c.viewtheflights();
                for (Flights x:all) {
                    if (x!=null)
                    s=s+x+"\n";
                }
                textArea1.setText(s);
            }
        });
        searchTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c3);
                AllCards.repaint();
                AllCards.revalidate();
            }
        });
        editTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c4);
                AllCards.repaint();
                AllCards.revalidate();
            }
        });
        deleteTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c5);
                AllCards.repaint();
                AllCards.revalidate();
            }
        });
        travelerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c6);
                AllCards.repaint();
                AllCards.revalidate();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c7);
                AllCards.repaint();
                AllCards.revalidate();
                try {
                    c.readFlightsFiles();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    c.readTravelersFiles();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c8);
                AllCards.repaint();
                AllCards.revalidate();
                String s="";
                Flights[] all=c.viewRecepit();
                for (Flights x:all) {
                    for (int j = 0; j < all.length; j++) {
                        s=s+x+"\n";
                    }

                }
                String w="";
                Travelers[] alle=c.viewRecepit2();
                for (Travelers n:alle){
                    for (int j = 0; j < alle.length; j++) {
                        w=w+n+"\n";

                    }

                }

                textArea5.setText(s +"\n"+w );
            }
        });
        addTripButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1=t1.getText();
                String s2=t2.getText();
                String s3=t3.getText();
                String s4=t4.getText();
                int n =Integer.parseInt(t5.getText());
                int p =Integer.parseInt(t6.getText());
               boolean added= c.addflight(s1,s2,s3,s4, n,p, c.toString());
               if (added) {
                   JOptionPane.showMessageDialog(null, "Added Successfully");
                   t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");
               }
                   else JOptionPane.showMessageDialog(null,"Something Wrong");
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int t=Integer.parseInt(textField2.getText());
                Flights editedd =c.searchflight(t);
               // FlightVip edited= (FlightVip) c.searchflight(t);
                if (editedd!=null)
                {
                String s1=textField3.getText();
                String s2=textField4.getText();
                String s3=textField5.getText();
                String s4=textField6.getText();
                int n =Integer.parseInt(textField7.getText());
                int p =Integer.parseInt(textField8.getText());
                String d=textField17.getText();
                editedd.setFrom(s1);editedd.setTo(s2);editedd.setDep_date(s3);editedd.setArv_date(s4);editedd.setNumTrip(n);editedd.setTravelersprice(p);
                boolean added=true;
                if (added) {
                    JOptionPane.showMessageDialog(null, "Edited Successfully");
                    t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");
                }
                else JOptionPane.showMessageDialog(null,"Something Wrong");
            }}
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int s= Integer.parseInt(textField1.getText());
                Flights f= c.searchflight(s);
                if (f!=null)
                    textArea2.setText(f.toString());
                else textArea2.setText("Not found ");
            }
        });
        addTravelerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TravelerCards.removeAll();
                TravelerCards.add(C1);
                TravelerCards.repaint();
                TravelerCards.revalidate();
            }
        });
        viewTravelerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TravelerCards.removeAll();
                TravelerCards.add(C2);
                TravelerCards.repaint();
                TravelerCards.revalidate();
                String s1 ="";
                Travelers[] all1 =c.viewthetravelers();
                for (Travelers x: all1) {
                    if (x!=null)
                        s1 = s1 +x+"\n";
                }
                textArea3.setText(s1);
            }
        });
        searchTravelerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TravelerCards.removeAll();
                TravelerCards.add(C3);
                TravelerCards.repaint();
                TravelerCards.revalidate();
            }
        });
        editTravelerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TravelerCards.removeAll();
                TravelerCards.add(C4);
                TravelerCards.repaint();
                TravelerCards.revalidate();
            }
        });
        deleteTravelerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TravelerCards.removeAll();
                TravelerCards.add(C5);
                TravelerCards.repaint();
                TravelerCards.revalidate();
            }
        });
     /*   backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TravelerCards.removeAll();
                TravelerCards.add(C6);
                TravelerCards.repaint();
                TravelerCards.revalidate();
            }
        });*/
        saveButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TravelerCards.removeAll();
                TravelerCards.add(C7);
                TravelerCards.repaint();
                TravelerCards.revalidate();
            }
        });
        addTravelerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p=Integer.parseInt(t9.getText());
                String n=t10.getText();
                int h=Integer.parseInt(t11.getText());
                String o= t12.getText();
               boolean added= c.addtravelers(p,n,h,o);
               if (added)JOptionPane.showMessageDialog(null,"Added Successfully");
               else JOptionPane.showMessageDialog(null,"Try Again");
            }
        });
        searchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int s= Integer.parseInt(textField9.getText());
                Travelers t= c.searchtravelers(s);
                if (t!=null)
                    textArea4.setText(t.toString());
                else textArea4.setText("Not found ");
            }
        });
        editButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int t=Integer.parseInt(textField10.getText());
                Travelers edited =c.searchtravelers(t);
                if (edited!=null)
                {

                    int s1=Integer.parseInt(textField11.getText());
                    String s2=textField12.getText();
                    int n =Integer.parseInt(textField13.getText());
                    String l=textField14.getText();
                    edited.setNumpassport(s1);edited.setFullname(s2);edited.setNumphone(n);edited.setCountry(l);
                    boolean added=true;
                    if (added) {
                        JOptionPane.showMessageDialog(null, "Edited Successfully");
                        textField11.setText("");textField12.setText("");textField13.setText("");textField14.setText("");

                    }
                    else JOptionPane.showMessageDialog(null,"Something Wrong");
                }
            }
        });
        deletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int t=Integer.parseInt(textField15.getText());
               Travelers delete =c.searchtravelers(t);
                if (delete !=null)
                {
                    boolean del=c.deletetraveler(t);
                    if (del)
                    {
                    JOptionPane.showMessageDialog(null,"Deleted");
                    }
                    else JOptionPane.showMessageDialog(null,"not fond");
                }

            }
        });
        deletedButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int t=Integer.parseInt(textField15.getText());
                Flights delete =c.searchflight(t);
                if (delete !=null)
                {
                    boolean del=c.deleteflight(t);
                    if (del)
                    {
                        JOptionPane.showMessageDialog(null,"Deleted");
                    }
                    else JOptionPane.showMessageDialog(null,"not fond");
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.readFlightsFiles();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("PROGUI");
        frame.setContentPane(new PROGUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.pack();
        frame.setSize(700,700);
        frame.setVisible(true);
    }

}
