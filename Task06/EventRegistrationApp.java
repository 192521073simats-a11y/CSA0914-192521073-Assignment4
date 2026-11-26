import javax.swing.*; import java.awt.*; import java.util.*;
public class EventRegistrationApp extends JFrame {
  private final JTextField name=new JTextField(14), email=new JTextField(14);
  private final JComboBox<String> event=new JComboBox<>(new String[]{"Tech Fest","Sports Day","Cultural Night"});
  private final DefaultListModel<String> registrations=new DefaultListModel<>(); private final Set<String> keys=new HashSet<>();
  EventRegistrationApp(){
    super("Campus Event Registration"); setDefaultCloseOperation(EXIT_ON_CLOSE); setLayout(new BorderLayout(8,8));
    JMenuBar bar=new JMenuBar(); JMenu menu=new JMenu("File"); JMenuItem export=new JMenuItem("Export Preview");
    export.addActionListener(e->JOptionPane.showMessageDialog(this,registrations.isEmpty()?"No registrations":String.join("\n",Collections.list(registrations.elements()))));
    menu.add(export); bar.add(menu); setJMenuBar(bar);
    JPanel form=new JPanel(new GridLayout(3,2,6,6)); form.add(new JLabel("Student name")); form.add(name);
    form.add(new JLabel("Email")); form.add(email); form.add(new JLabel("Event")); form.add(event); add(form,BorderLayout.NORTH);
    add(new JScrollPane(new JList<>(registrations)),BorderLayout.CENTER); JButton register=new JButton("Register");
    register.addActionListener(e->register()); add(register,BorderLayout.SOUTH); setSize(480,320); setLocationRelativeTo(null);
  }
  void register(){String n=name.getText().trim(), em=email.getText().trim(), ev=(String)event.getSelectedItem();
    if(n.isEmpty()||!em.matches("[^@]+@[^@]+\\.[^@]+")){JOptionPane.showMessageDialog(this,"Enter name and valid email");return;}
    String key=em.toLowerCase()+"|"+ev; if(!keys.add(key)){JOptionPane.showMessageDialog(this,"Already registered for this event");return;}
    registrations.addElement(n+" | "+em+" | "+ev); JOptionPane.showMessageDialog(this,"Registration successful");
  }
  public static void main(String[]a){SwingUtilities.invokeLater(()->new EventRegistrationApp().setVisible(true));}
}
