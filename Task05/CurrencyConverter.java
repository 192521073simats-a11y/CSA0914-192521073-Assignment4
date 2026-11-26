import javax.swing.*; import java.awt.*; import java.awt.event.*;
public class CurrencyConverter extends JFrame implements ActionListener {
  JTextField amount=new JTextField(10);
  JComboBox<String> from=new JComboBox<>(new String[]{"INR","USD","EUR"});
  JComboBox<String> to=new JComboBox<>(new String[]{"USD","INR","EUR"});
  JLabel result=new JLabel("Result: ");
  CurrencyConverter(){
    super("Currency Converter"); setDefaultCloseOperation(EXIT_ON_CLOSE); setLayout(new FlowLayout());
    add(new JLabel("Amount:")); add(amount); add(from); add(new JLabel("to")); add(to);
    JButton convert=new JButton("Convert"); convert.addActionListener(this); add(convert); add(result);
    amount.addActionListener(e->convert());
    addWindowListener(new WindowAdapter(){@Override public void windowClosing(WindowEvent e){dispose();}});
    setSize(420,160); setLocationRelativeTo(null);
  }
  public void actionPerformed(ActionEvent e){convert();}
  void convert(){try{
    double val=Double.parseDouble(amount.getText()); if(val<0)throw new IllegalArgumentException();
    double inr=val*rate((String)from.getSelectedItem()); double out=inr/rate((String)to.getSelectedItem());
    result.setText(String.format("Result: %.2f %s",out,to.getSelectedItem()));
    JOptionPane.showMessageDialog(this,result.getText());
  }catch(Exception ex){result.setText("Enter a valid positive amount");
    JOptionPane.showMessageDialog(this,"Invalid amount","Error",JOptionPane.ERROR_MESSAGE);}}
  double rate(String c){return switch(c){case "INR"->1;case "USD"->83.0;case "EUR"->90.0;default->1;};}
  public static void main(String[]a){SwingUtilities.invokeLater(()->new CurrencyConverter().setVisible(true));}
}
