package battleship.GUI;

    import javax.swing.*;  
    import java.awt.*;  
    public class TestApp extends JFrame {  
      public TestApp() {  
        super("LayeredPane Example");  
        setSize(400, 400);  
        JLayeredPane pane = getLayeredPane();  
        //creating buttons  
        JButton top = new JButton();  
        top.setBackground(Color.white);  
        top.setBounds(20, 20, 150, 150);  
        JButton middle = new JButton();  
        middle.setBackground(Color.red);  
        middle.setBounds(40, 40, 50, 50);  
        JButton bottom = new JButton();  
        bottom.setBackground(Color.cyan);  
        bottom.setBounds(60, 60, 50, 50);  
        //adding buttons on pane  
        pane.add(bottom, new Integer(1));  
        pane.add(middle, new Integer(3));  
        pane.add(top, new Integer(1));  
      }  
      public static void main(String[] args) {  
          TestApp panel = new  TestApp();  
          panel.setVisible(true);  
      }  
    }  