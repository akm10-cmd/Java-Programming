import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  

class DiceRoll extends JFrame implements ActionListener{

	JLabel lbl1, lbl2;
	JButton rollbtn, exitbtn;
	ImageIcon imageIcon;
	
	public static void main(String aa[]){
		new DiceRoll("Dice Roll");
	}
	
	DiceRoll(String title){
		super(title);
		setLayout(null);
		setResizable(false);
		
		lbl1 = new JLabel();
		lbl2 = new JLabel();
		lbl1.setBounds(50,50,150,150);
		lbl2.setBounds(240,50,150,150);
		
		rollbtn = new JButton("Click to Roll Dice");
		rollbtn.setBounds(160, 230, 130,50 );
		rollbtn.setBackground(new Color(0, 102, 0));
		rollbtn.setForeground(Color.white);
		rollbtn.addActionListener(this);
		
		exitbtn = new JButton("Close");
		exitbtn.setBounds(185, 300, 80,30 );
		exitbtn.setBackground(Color.red);
		exitbtn.setForeground(Color.white);
		exitbtn.addActionListener(this);
		
		add(lbl1);
		add(lbl2);
		add(rollbtn);
		add(exitbtn);
		
		getContentPane().setBackground( Color.black );
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450,400);
		setVisible(true);
		
	}
	
	public void roll(JLabel lbl) {
		int dieNo = (int)(1+ 6 * Math.random());
		imageIcon = new ImageIcon(new ImageIcon("image/dice-"+dieNo+".png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		lbl.setIcon(imageIcon);
	}
	
	public void clear(JLabel lbl) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rollbtn){
			this.roll(lbl1);
			this.roll(lbl2);
		}
		if(e.getSource() == exitbtn){
			System.exit(0);
		}
	}
	
	
}