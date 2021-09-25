package dominio;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;


public class EventTextFiel implements MouseListener{
	
	private JTextField txt;
	
	public EventTextFiel(JTextField txt)
	{
		this.setTxt(txt);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		txt.setBackground(Color.white);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public JTextField getTxt() {
		return txt;
	}


	public void setTxt(JTextField txt) {
		this.txt = txt;
	}

	

	
}
