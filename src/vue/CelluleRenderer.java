package vue;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import modele.Tortue;

public class CelluleRenderer extends JLabel implements TableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		//Pour un mur
		if (value.toString().equals("P")){
            ImageIcon fichierImage = new ImageIcon("images/WALL.png");
            Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
		}
		//Pour un mur de glace
		else if (value.toString().equals("G")){
            ImageIcon fichierImage = new ImageIcon("images/ICE.png");
            Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
        }
		//Pour un joyau
		else if (value.toString().equals("V") || value.toString().equals("R") || value.toString().equals("B")){
            ImageIcon fichierImage = new ImageIcon("images/RUBY.png");
            Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
		}
		//Pour une tortue
		else if (value.toString().equals("1") || value.toString().equals("2") || value.toString().equals("3") || value.toString().equals("4")){
            ImageIcon fichierImage = null;

            //Formation du sens des tortues pour les images
            String chaine = "_";
            switch(((Tortue) value).getSens()){
            case SUD:
            	chaine +="S";
            	break;
            case NORD:
            	chaine +="N";
            	break;
            case EST:
            	chaine +="E";
            	break;
            case OUEST:
            	chaine +="O";
            	break;
            }
			if (value.toString().equals("1")){
	            fichierImage = new ImageIcon("images/turtle1"+chaine+".png");
	            
			}
			else if (value.toString().equals("2")){
	            fichierImage = new ImageIcon("images/turtle2"+chaine+".png");
			}
			else if (value.toString().equals("3")){
	            fichierImage = new ImageIcon("images/turtle3"+chaine+".png");
			}
			else if (value.toString().equals("4")){
	            fichierImage = new ImageIcon("images/turtle4"+chaine+".png");
			}
			Image image = fichierImage.getImage();
            Image imageBonneDimension = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            fichierImage = new ImageIcon(imageBonneDimension);
            this.setIcon(fichierImage);
        }
        else{ //S'il y a pas d'événement dans la case
            setIcon(null);
        }
        return this;
	}
}
