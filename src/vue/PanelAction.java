package vue;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelAction extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelAction(){
		JPanel panelInstructions = new JPanel();
		JLabel instruction = new JLabel("Action");

		// ce panel est divisé en 2
		this.setLayout(new BorderLayout());

		panelInstructions.setLayout(new BorderLayout(20, 20));
		instruction.setFont(new Font(Font.SERIF, 20, 30));
		panelInstructions.add(instruction, BorderLayout.CENTER);
		this.add(panelInstructions, BorderLayout.CENTER);
	}
}
