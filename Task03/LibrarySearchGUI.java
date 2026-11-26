import javax.swing.*; import java.awt.*;
public class LibrarySearchGUI extends JFrame {
  private final JTextField search = new JTextField(18);
  private final JComboBox<String> category = new JComboBox<>(new String[]{"All","Science","Computing","Literature"});
  private final DefaultListModel<String> model = new DefaultListModel<>();
  private final JLabel status = new JLabel("Ready");
  public LibrarySearchGUI(){
    super("Campus Library Search"); setDefaultCloseOperation(EXIT_ON_CLOSE); setLayout(new BorderLayout(8,8));
    JPanel north=new JPanel(new BorderLayout()); JLabel title=new JLabel("Library Search",SwingConstants.CENTER);
    title.setFont(new Font("SansSerif",Font.BOLD,20)); north.add(title,BorderLayout.NORTH);
    JPanel top=new JPanel(new FlowLayout()); top.add(search); top.add(category); JButton go=new JButton("Search"); top.add(go);
    north.add(top,BorderLayout.SOUTH); add(north,BorderLayout.NORTH);
    model.addElement("Java Programming — Computing"); model.addElement("Discrete Mathematics — Science");
    model.addElement("The Alchemist — Literature"); add(new JScrollPane(new JList<>(model)),BorderLayout.CENTER);
    JPanel bottom=new JPanel(new FlowLayout()); bottom.add(new JButton("Prev")); bottom.add(new JButton("Next"));
    bottom.add(new JButton("Reserve")); bottom.add(status); add(bottom,BorderLayout.SOUTH);
    go.addActionListener(e->status.setText("Search: "+search.getText()+" | "+category.getSelectedItem()));
    setSize(650,420); setLocationRelativeTo(null);
  }
  public static void main(String[] a){SwingUtilities.invokeLater(()->new LibrarySearchGUI().setVisible(true));}
}
