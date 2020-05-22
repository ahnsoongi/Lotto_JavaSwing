import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.json.simple.JSONObject;
import org.junit.Test;



class Cal{
	int sum(int a, int b) {
		return a+b;
	}
	double vid (int a, int b) {
		return (double)a/b;
	}
	public double div(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class Lotto extends JFrame implements MouseListener, KeyListener{
	MyButton[] mbt = new MyButton[7];
	int[] a = new int[7];
	
	JButton checkBtn = new JButton("해당회차로");
	JTextField turnTxt = new JTextField();
	
	JLabel titleLbl = new JLabel("로또번호");
	JLabel turnLbl = new JLabel("");
	
	JLabel turnDt = new JLabel("");
	
	JLabel turnFirstAcc = new JLabel("");
	
	JLabel turnFirstPrzCo = new JLabel("");
	
	JLabel plusLbl = new JLabel(new ImageIcon(new ImageIcon("images/plus.png")
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); 
	
	
	@Test
	public void JReader() throws Exception {
		JsonReader jReader = new JsonReader();
		JSONObject jObj = jReader.connectionUrlToJSON("100");
		assertEquals("fail", jObj.get("returnValue"), 0);
//			if(String.valueOf(jObj.get("returnValue")).equals("fail")) {
//				turnLbl.setText("회차정보가 없습니다.");
//				return;
//			}
	}
	
	@Test
	public void JSum() throws Exception {
		Cal c = new Cal();
		int a = c.sum(50, 60);
		assertEquals(110, a);
		double d = c.div(50, 60);
		assertEquals((double)50/60, d);
//			if(String.valueOf(jObj.get("returnValue")).equals("fail")) {
//				turnLbl.setText("회차정보가 없습니다.");
//				return;
//			}
	}
	
	
	public void init() {
		//TODO
		getContentPane().setLayout(null);
		
		
		
		for(int i=0; i<mbt.length-1; i++) {
			mbt[i] = new MyButton(""+ (i+1));
			
			int wn=70;
			
			mbt[i].setBounds(10+wn*i, 60+80, 55, 55);
			getContentPane().add(mbt[i]);
		}
		plusLbl.setBounds(10+70*6, 60+80, 55, 55);
		getContentPane().add(plusLbl);
		
		mbt[6] = new MyButton(""+ 7);
		mbt[6].setBounds(10+70*7, 60+80, 55, 55);
		getContentPane().add(mbt[6]);
		
		titleLbl.setBounds(20, 10+80, 150, 30);
		getContentPane().add(titleLbl);

		turnLbl.setBounds(20, 20, 150, 50);
		getContentPane().add(turnLbl);
		turnLbl.setFont(turnLbl.getFont().deriveFont(20f));
		
		
		turnTxt.setColumns(10);
		turnTxt.setBounds(100, (50+60+30+80), 150, 50);
		getContentPane().add(turnTxt);
		
		checkBtn.setBounds((100+150+20), (50+60+30+80), 100, 50);
		getContentPane().add(checkBtn);
		
		turnDt.setBounds(20, 50, 150, 30);
		getContentPane().add(turnDt);
		
		turnFirstPrzCo.setBounds(340, 65, 250, 50);
		getContentPane().add(turnFirstPrzCo);
		
		
		turnFirstAcc.setBounds(340, 85, 250, 50);
		getContentPane().add(turnFirstAcc);
		turnFirstAcc.setFont(turnFirstAcc.getFont().deriveFont(20f));
		
		
	}
	
	public void event() {
		checkBtn.addMouseListener(this);
		mbt[0].addMouseListener(this);
		turnTxt.addKeyListener(this);
		
	}
	
	void showResult() {
		String turnNum = turnTxt.getText();
		try{
			int a = Integer.parseInt(turnNum);
			System.out.println(a);
		}catch(Exception e) {
			System.out.println("번호 다시 입력해주세요.");
			return;
		}
		
		
		try {
			JsonReader jr = new JsonReader();
			JSONObject jo = jr.connectionUrlToJSON(turnTxt.getText());
			if(jo==null) {
				turnLbl.setText("접속에 실패하였습니다. 다시 시도해주세요.");
				return;
			}
			
			if(jo.get("returnValue").equals("fail")){
				turnLbl.setBounds(20, 20, 150, 50);
				turnLbl.setText("회차정보가 없습니다.");
				clearNumber();
				return;
			}
			
			
			for(int i = 0; i < a.length-1; i++) {
				a[i] = Integer.parseInt(String.valueOf(jo.get("drwtNo"+(i+1))));
				int b = Integer.parseInt(String.valueOf(jo.get("bnusNo")));
				if(a[i]>40) {
					
					mbt[i].setBgColor(Color.green);
					
				}else if(a[i]>30) {
					
						mbt[i].setBgColor(Color.gray);
					
				}else if(a[i]>20){
					
						mbt[i].setBgColor(Color.red);
						
				}else if(a[i]>10) {
					
						mbt[i].setBgColor(Color.blue);
						
				}else {
					
						mbt[i].setBgColor(Color.yellow);
						
				}
			}
			
			
			for(int i =0; i<mbt.length-1; i++) {
				mbt[i].setText(String.valueOf(jo.get("drwtNo"+(i+1))));
				System.out.println(jo.get("drwtNo"+(i+1)));
			}
			mbt[6].setText(String.valueOf(jo.get("bnusNo")));
			System.out.println(jo.get("bnusNo"));
			
			Object s = jo.get("drwNoDate");
			turnDt.setText(String.valueOf(((String) s).substring(0, 4) + "년 " + ((String) s).substring(5, 7)
					+ "월 " + ((String) s).substring(8) + "일"));
			System.out.println(jo.get("drwNoDate"));
			
			turnFirstAcc.setText(String.valueOf("1등 : " + jo.get("firstAccumamnt")+"원"));
			System.out.println(jo.get("firstAccumamnt"));
			
			turnFirstPrzCo.setText(String.valueOf("총 " + jo.get("firstPrzwnerCo") + "명 당첨"));
			
			turnLbl.setText(turnTxt.getText() + "회차");
			
		}catch (Exception e) {
			e.printStackTrace();
			turnLbl.setText("예기치 못한 오류가 발생했습니다. 다시 시도해주세요.");
		}
	}
	
	void clearNumber() {
		for(int i = 0; i<mbt.length; i++) {
			mbt[i].setText("");
		}
	}

	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while(keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if(value instanceof FontUIResource)
				UIManager.put(key, f);
		}
		
	}
	
	Lotto(){
		super("로또번호 조회");
		//화면구성 component들을 초기화
		init();
		//event를 초기화 
		event();
		
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) throws Exception {
		String fType = "Jua-Regular.ttf";
		Font f1;

		f1 = Font.createFont(Font.TRUETYPE_FONT, new File(fType)); //Exception 발생소지가 있으므로 try catch로 묶어주거나 내 메소드에 throws를 추가
		
		setUIFont(new FontUIResource(f1.deriveFont(15f)));
		
//		System.out.printf("%f\n", 25f);
		new Lotto();
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			//회차 결과를 버튼 1-7에 보여주기
			
			showResult();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE) {
			clearNumber();
			clearTurnLbl();
			clearTurnTxt();
		}
	}

	public void clearTurnTxt() {
		turnTxt.setText("");
	}

	public void clearTurnLbl() {
		turnLbl.setText("");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked");
		if(e.getSource()==checkBtn) {
			showResult();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			//마우스 커서 올리면
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
			//마우스 커서 내리면
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	
}
