import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ActionBar extends JLayeredPane{
    private JPanel glassPanel= new JPanel();

    public ActionBar(JComponent myPanel){
        glassPanel.setOpaque(false);
        glassPanel.setVisible(true);
        //glassPanel.addMouseListener(new MouseAdapter() {});
        glassPanel.setFocusable(true);
        glassPanel.setBackground(Color.white);

        myPanel.setSize(myPanel.getPreferredSize());
        glassPanel.setSize(myPanel.getPreferredSize());
        setPreferredSize(myPanel.getPreferredSize());

    }

    public void activateGP(Boolean active){
        glassPanel.setVisible(active);
        if (active){
            glassPanel.requestFocusInWindow();
            glassPanel.setFocusTraversalKeysEnabled(false);
        }
    }
}
