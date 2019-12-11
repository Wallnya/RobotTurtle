package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelMain extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;

	public PanelMain() throws IOException{
		JPanel panelInstructions = new JPanel();
		JLabel instruction = new JLabel("Main");

		/*image = ImageIO.read(new File("images/ICE.png"));*/

		// ce panel est divisé en 2
		this.setLayout(new BorderLayout());

		panelInstructions.setLayout(new BorderLayout(20, 20));
		instruction.setFont(new Font(Font.SERIF, 20, 30));
		panelInstructions.add(instruction, BorderLayout.CENTER);
		this.add(panelInstructions, BorderLayout.SOUTH);
	}
}
