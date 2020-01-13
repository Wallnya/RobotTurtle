package vue;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CelluleRenderer extends JLabel implements TableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (value.toString().equals("P")){
            ImageIcon fichierImage = new ImageIcon("images/WALL.png");
            Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
		}
		else if (value.toString().equals("G")){
            ImageIcon fichierImage = new ImageIcon("images/ICE.png");
            Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
        }
		else if (value.toString().equals("V") || value.toString().equals("R") || value.toString().equals("B")){
            ImageIcon fichierImage = new ImageIcon("images/RUBY.png");
            Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
        }
		else if (value.toString().equals("1") || value.toString().equals("2") || value.toString().equals("3") || value.toString().equals("4")){
            ImageIcon fichierImage = null;
			if (value.toString().equals("1")){
	            fichierImage = new ImageIcon("images/turtle1.png");
			}
			else if (value.toString().equals("2")){
	            fichierImage = new ImageIcon("images/turtle2.png");
			}
			else if (value.toString().equals("3")){
	            fichierImage = new ImageIcon("images/turtle3.png");
			}
			else if (value.toString().equals("4")){
	            fichierImage = new ImageIcon("images/turtle4.png");
			}
			Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
        }
		else if (value.toString().equals("V") || value.toString().equals("R") || value.toString().equals("B")){
            ImageIcon fichierImage = new ImageIcon("images/RUBY.png");
            Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
        }

        else{ //S'il y a un événement dans la case
            setIcon(null);
        }
        return this;
	}

}
