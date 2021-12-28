
package Graphique;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyGraphic extends JFrame {

    //properities
        private JButton btn1;
        private JButton btn2;
        private JLabel lbl;
        private JPanel p1;
        private JPanel p2;
        
    public MyGraphic() {
        // About my frame
       this.setTitle("Hello");
       this.setSize(400,300);
       this.setLocationRelativeTo(null);
       
       //
       p1 = new JPanel(new FlowLayout());
       p2 = new JPanel(new FlowLayout());
       
       lbl = new JLabel("hello");
//       this.getContentPane().setLayout(new GridLayout(2,2));
       btn1 = new JButton("save");
       btn2 = new JButton("cancel");
       
       p1.add(btn1);
       p1.add(btn2);
       
       this.add(p1);
      
      //make the frame visible
      this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       new MyGraphic();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
