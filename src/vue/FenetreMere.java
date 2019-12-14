package vue;

import javax.swing.JFrame;
import java.awt.Frame;


public class FenetreMere extends JFrame{
	private static final long serialVersionUID = 1L;
	PanelNombresJoueurs contentPane;
	
	public FenetreMere (){
		contentPane = new PanelNombresJoueurs();
		this.add(contentPane);
		this.setVisible(true);
	
		// On fait en sorte que cela s'affiche sur l'écran en entier
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.pack();
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
	
}
