import java.awt.BasicStroke;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Searchplus extends JPanel {
    //static ArrayList<String > name=new ArrayList<String>();
    static JLabel label = new JLabel();
    static JButton assave = new JButton("save");

    public static void main(String args[]) {
        MakePanel frame4 = new MakePanel();
        frame4.setBounds(10, 10, 1000, 1000);
        Searchplus app = new Searchplus();
        frame4.getContentPane().add(app);
        frame4.add(app, BorderLayout.CENTER);
        frame4.setVisible(true);
        frame4.repaint();
    }

    private void makeStateSpace() {

    }

    public void paintComponent(Graphics g) {
        GraphFrame aaa = new GraphFrame();

        Graphics2D g2 = (Graphics2D) g;
        ArrayList tableforkstate = GraphFrame.tableforkstate;
        ArrayList rightstate = GraphFrame.rightstate;
        ArrayList leftstate = GraphFrame.leftstate;
        ArrayList eatstate = GraphFrame.eatstate;
        ArrayList<ArrayList<String>> namelist = Planner.namelist;
        Graphics2D g3 = (Graphics2D) g;
        Font font2 = new Font("Arial", Font.BOLD, 45);
        Graphics2D g4 = (Graphics2D) g;

        Font font = new Font("Arial", Font.BOLD, 30);
        g4.setFont(font);
        g3.setFont(font);
//		  g3.setFont(font);

//		System.out.println(Planner.namelist);
//		System.out.println(Planner.name);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke wideStroke = new BasicStroke(4.0f);
        g2.setStroke(wideStroke);
        g2.drawOval(500, 200, 500, 500); // テーブル
        int At = 700;
        int Ay = 100;
        int Bt = 950;
        int By = 250;
        int Ct = 850;
        int Cy = 700;
        int Dt = 550;
        int Dy = 700;
        int Et = 450;
        int Ey = 250;

        int philosopherNum = GraphFrame.philosopherNum; // 哲学者の人数を取得
//        philosopherNum = 10;
        
        // 哲学者の配置
        for (int i = 0; i < philosopherNum; i++) {
            double philosopherX = 710 + 320 * Math.cos(Math.toRadians((360 * i) / philosopherNum - 90));
            double philosopherY = 410 + 320 * Math.sin(Math.toRadians((360 * i) / philosopherNum - 90));
            g2.drawOval((int) philosopherX, (int) philosopherY, 80, 80);
            
            // 哲学者の名前も同様に描画
        }
        
        // フォークの配置


//        g2.drawOval(At, Ay, 80, 80);
//        g2.drawOval(Bt, By, 80, 80);
//        g2.drawOval(Ct, Cy, 80, 80);
//        g2.drawOval(Dt, Dy, 80, 80);
//        g2.drawOval(Et, Ey, 80, 80);
        g2.drawString("A", At, Ay);
        g2.drawString("B", Bt, By);
        g2.drawString("C", Ct, Cy);
        g2.drawString("D", Dt, Dy);
        g2.drawString("E", Et, Ey);

        int i = 0;
//		System.out.println(tableforkstate);
        for (Object s : tableforkstate) {
            String t = (String)s;
            int tableforknumber = Integer.parseInt(t);
            
            g4.drawString("Ψ",20 * Math.cos((360*tableforknumber)/philosopherNum + 90) + 300 * Math.cos((360*tableforknumber)/philosopherNum)+500,20 * Math.sin((360*tableforknumber)/philosopherNum + 90) + 300 * Math.sin((360*tableforknumber)/philosopherNum)+250);

            switch (Integer.parseInt(t)) {
                case 1:
                    g4.drawString("ψ", 800, 300);
                    break;
                case 2:
                    g4.drawString("ψ", 850, 450);
                    break;
                case 3:
                    g4.drawString("ψ", 700, 600);
                    break;
                case 4:
                    g4.drawString("ψ", 600, 450);
                    break;
                case 5:
                    g4.drawString("ψ", 650, 300);
                    break;
            }
        }
        for (Object s : rightstate) {
            String t = (String) s;
            if (t.equals("A")) g3.drawString("ψ", At - 20, Ay + 100);
            if (t.equals("B")) g3.drawString("ψ", Bt - 10, By + 40);
            if (t.equals("C")) g3.drawString("ψ", Ct + 20, Cy - 10);
            if (t.equals("D")) g3.drawString("ψ", Dt + 60, Dy + 10);
            if (t.equals("E")) g3.drawString("ψ", Et + 50, Ey + 70);

			/*
            if(t.equals("A"))			g2.drawOval(At-20,Ay,20,20);
			if(t.equals("B"))			g2.drawOval(Bt-10,By-10,20,20);
			if(t.equals("C"))        g2.drawOval(Ct+10,Cy-10,20,20);
			if(t.equals("D"))g2.drawOval(Dt+10,Dt+10,20,20);
			if(t.equals("E"))g2.drawOval(Et+10,Ey-10,20,20);
			*/
        }

        for (Object s : leftstate) {
            String t = (String) s;

            if (t.equals("A")) g3.drawString("ψ", At + 60, Ay + 100);
            if (t.equals("B")) g3.drawString("ψ", Bt + 25, By + 70);
            if (t.equals("C")) g3.drawString("ψ", Ct - 20, Cy + 10);
            if (t.equals("D")) g3.drawString("ψ", Dt - 10, Dy - 10);
            if (t.equals("E")) g3.drawString("ψ", Et + 60, Ey + 40);
        }

        g4.setFont(font2);
        for (Object s : eatstate) {
            String t = (String) s;

            if (t.equals("A")) g3.drawString("♨", At + 20, Ay + 150);
            if (t.equals("B")) g3.drawString("♨", Bt - 80, By + 100);
            if (t.equals("C")) g3.drawString("♨", Ct - 50, Cy - 50);
            if (t.equals("D")) g3.drawString("♨", Dt + 50, Dy - 50);
            if (t.equals("E")) g3.drawString("♨", Et + 100, Ey + 100);
        }
        /*
        Font font = new Font("Arial", Font.BOLD, 25);
		g2.setFont(font);
		for (int j = 0; j < i; j++) {
			ArrayList<String> nameline = namelist.get(j);
//			System.out.println(nameline);
			int y = 90;
			int high = 0;
			for (String s : nameline) {
				g2.draw(new Rectangle2D.Double(j * 300.0d, (Planner.name.size() * 190.0 - x) * 1.0 - (y * high) * 1.0d,
						160.0d, 90.0d));
				g2.drawString(s, j * 300 + 70, Planner.name.size() * 190 - x + 40 - high * 90);
				high++;
			}
		}
		g2.draw(new Rectangle2D.Double(300.0d, (Planner.name.size() * 190.0-x + 130) * 1.0d, 160.0d, 90.0d));
		g2.drawString("holding", 300, (Planner.name.size() * 190 -x + 120) * 1);

		if (!Planner.hold.equals("")) {
			g2.drawString(Planner.hold, 300 + 50, (Planner.name.size() * 190 -x+170) * 1);
		}

		g2.draw(new Line2D.Double(0.0d, Planner.name.size() * 190.0d-x+90.0d, Planner.name.size() * 300.0d,
				Planner.name.size() * 190.0d-x+90.0d));
*/
    }


    public Dimension getPreferredSize() {

        return new Dimension(1500, 1000);
    }
}

class MakePanel extends JFrame {
    MakePanel() {
        setBounds(100, 100, 300, 300);

    }
}
