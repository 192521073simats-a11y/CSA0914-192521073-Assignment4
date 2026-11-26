import javax.swing.*; import java.awt.*; import java.awt.event.*; import java.util.*;
public class DrawPad extends JFrame {
  private final java.util.List<Point> points=new ArrayList<>();
  private final JLabel count=new JLabel("Clicks: 0");
  private final JPanel canvas=new JPanel(){
    protected void paintComponent(Graphics g){super.paintComponent(g); g.setColor(Color.BLUE);
      for(Point p:points)g.fillOval(p.x-4,p.y-4,8,8);}
  };
  public DrawPad(){
    super("Click Drawing Pad"); setDefaultCloseOperation(EXIT_ON_CLOSE); canvas.setBackground(Color.WHITE);
    canvas.addMouseListener(new MouseAdapter(){@Override public void mouseClicked(MouseEvent e){
      points.add(e.getPoint()); count.setText("Clicks: "+points.size()); canvas.repaint();}});
    add(canvas,BorderLayout.CENTER); add(count,BorderLayout.SOUTH); setSize(500,350); setLocationRelativeTo(null);
  }
  public static void main(String[] a){SwingUtilities.invokeLater(()->new DrawPad().setVisible(true));}
}
