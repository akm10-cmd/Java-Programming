import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  

class DiceRoll extends JFrame implements ActionListener{

	JLabel lbl1, lbl2, lbl3;
	JButton rollbtn, exitbtn, clearbtn;
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
		lbl3 = new JLabel("",SwingConstants.CENTER);
		
		lbl1.setBounds(50,50,150,150);
		lbl1.setOpaque(true);
		lbl1.setBackground(Color.black);
		
		lbl2.setBounds(240,50,150,150);
		lbl2.setOpaque(true);
		lbl2.setBackground(Color.black);
		
		lbl3.setBounds(202,115,36,36);
		lbl3.setFont(new Font("Serif", Font.BOLD, 24));
		lbl3.setForeground(Color.orange);
		lbl3.setOpaque(true);
		lbl3.setBackground(Color.black);
		
		
		rollbtn = new JButton("Click to Roll Dice");
		rollbtn.setBounds(160, 230, 130,50 );
		rollbtn.setBackground(new Color(0, 102, 0));
		rollbtn.setForeground(Color.white);
		rollbtn.addActionListener(this);
		
		exitbtn = new JButton("Close");
		exitbtn.setBounds(240, 300, 70,30 );
		exitbtn.setBackground(Color.red);
		exitbtn.setForeground(Color.white);
		exitbtn.addActionListener(this);
		
		clearbtn = new JButton("Stop");
		clearbtn.setBounds(140, 300, 70,30 );
		clearbtn.setBackground(Color.red);
		clearbtn.setForeground(Color.white);
		clearbtn.addActionListener(this);
		
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(rollbtn);
		add(exitbtn);
		add(clearbtn);
		
		getContentPane().setBackground( Color.black );
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450,400);
		setVisible(true);
		
	}
	int dieNo;
	public void roll(JLabel lbl) {
		dieNo = (int)(1+ 6 * Math.random());
		imageIcon = new ImageIcon(new ImageIcon("image/dice-"+dieNo+".png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		lbl.setIcon(imageIcon);
	}
	
	public void clear() {
		lbl1.setIcon(null);
		lbl2.setIcon(null);
		lbl3.setText(" ");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rollbtn){
			
			this.roll(lbl1);
			int die1Val=dieNo;
			this.roll(lbl2);
			int die2Val=dieNo;
			int sum = die1Val+die2Val;
			lbl3.setText(Integer.toString(sum));
		}
		if(e.getSource() == clearbtn){
			this.clear();
		}
		if(e.getSource() == exitbtn){
			System.exit(0);
		}	
	}
}
