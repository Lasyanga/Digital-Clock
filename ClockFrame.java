package DigitalClock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class ClockFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel clocklbl, datelbl, daylbl;
	private SimpleDateFormat timeFormat, dayFormat, dateFormat;
	private String time, day, datetxt;

	public ClockFrame() {
		initialized();
	}
	
	private void initialized() {
		Border border = BorderFactory.createLineBorder(Color.green, 1);
		this.setTitle("Digital Clock");
		this.setSize(new Dimension(300, 180));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		clocklbl = new JLabel();
		clocklbl.setFont(new Font("Orbitron", Font.PLAIN, 24));
		clocklbl.setForeground(Color.green);
		clocklbl.setBackground(Color.black);
		clocklbl.setOpaque(true);
		clocklbl.setLocation(new Point(0, 0));
		clocklbl.setSize(new Dimension(300, 30));
		clocklbl.setHorizontalAlignment(JLabel.CENTER);		
		
		daylbl = new JLabel();
		daylbl.setFont(new Font("Orbitron", Font.PLAIN, 26));
		daylbl.setSize(new Dimension(300, 30));
		daylbl.setLocation(new Point(0, 50));
		daylbl.setHorizontalAlignment(JLabel.CENTER);
		daylbl.setForeground(Color.black);
		//daylbl.setBorder(border);
		
		datelbl = new JLabel();
		datelbl.setFont(new Font("Verdana", Font.ITALIC, 20));
		datelbl.setForeground(Color.black);
		datelbl.setSize(new Dimension(300, 30));
		datelbl.setLocation(new Point(0, 100));
		datelbl.setHorizontalAlignment(JLabel.CENTER);
		datelbl.setOpaque(true);
		datelbl.setBackground(Color.decode("#ffff4d"));
		//datelbl.setBorder(border);
		
		this.add(clocklbl);
		this.add(daylbl);
		this.add(datelbl);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		tickClock();
	}
	
	private void tickClock() {
		while(true) {
			timeFormat = new SimpleDateFormat("hh:mm:ss a");		
			time = timeFormat.format(Calendar.getInstance().getTime());
			clocklbl.setText(time);
			
			dayFormat = new SimpleDateFormat("EEEE");
			day = dayFormat.format(Calendar.getInstance().getTime());
			daylbl.setText(day);
			
			dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
			datetxt = dateFormat.format(Calendar.getInstance().getTime());
			datelbl.setText(datetxt);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
