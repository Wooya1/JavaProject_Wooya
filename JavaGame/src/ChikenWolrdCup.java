import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ChikenWolrdCup {
// 전체적으로 사용할 매개변수를 생성 static 으로 시작하고 있기에 static 이 아니면 접근이 불가능 하기에 static 으로 매개변수를 생성. (5)
	static JPanel panelNorth;
	//위쪽에 들어갈 패널. (6)
	static JPanel panelCenter;
	//가운데에 들어갈 패널. (7)
	static JLabel labelMessage;
	//타이틀 문구를 표현해줄 레이블. (8)
	static JLabel labelVs;
	//중간에 vs문구를 넣기위한 레이블. (9)
	static JButton buttonLeft;
	//왼쪽 이미지에 들어갈 버튼. (10)
	static JButton buttonRight;
	//오른쪽 이미지에 들어갈 버튼. (11)
	static String[] images = {
	// 게임 실행시 사용 될 이미지 문구를 String[] images 로 정의함. (12)
	    "BHC 맛초킹.jpg", "BHC 뿌링클.jpg", "BHC 핫후라이드.jpg", "교촌 레드콤보.jpg", "교촌 허니콤보.jpg",
	    "굽네 고추바사삭.jpg", "굽네 오리지널.jpg", "네네 스노윙.jpg", "네네 오리엔탈파닭.jpg", "맥시칸 닭강정.jpg",
		"비비큐 자메이카통다리.jpg", "비비큐 황금올리브.jpg", "지코바 숯불양념치킨.jpg", "처갓집 슈프림양념.jpg",
		"페리카나 양념치킨.jpg", "푸라닭 블랙알리오.jpg"
	// 현재 폴더 안에 있는 이미지들을 가리킴. (13)	
    };
	static int imageIndex = 2; 
	//처음 두 장은 표현이 되기에 3번째 이미지 를 가리킴. (14)
	static ImageIcon changeImage(String filename) {
	//이미지파일을 버튼으로 사용하기 위해 ImageIcon 형태로 반환되는 객체를 생성 changeImage 로 버튼 클릭시 이미지 변경. (15)
		ImageIcon icon =   new ImageIcon("./"+filename);
	//이미지 파일이 현재 src폴더가 아니라 프로젝트 기본 경로에 있기에 ("./"+filename) 으로 경로 안에 파일을 찾아옴. (16)	
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
	//이미지 파일 크기 변경 Image.SCALE_SMOOTH 함수로 이미지를 부드럽게 변경. (17)	
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	//새 icon 을 만들어서 가져온 변경된 이미지를 리턴. (18)	
	}
	
	static class MyFrame extends JFrame implements ActionListener{  
	//MyFrame 클래스를 static 내부클래스로 생성 JFrame상속받음. (2)
		
	//버튼 액션을 위해 추상 메서드 생성 implements ActionListener 인터페이스를 구현. (19)
	//MyFrame 의 unimplemented methods 를 클릭해 자동으로 오버라이딩 해서 인터페이스 요소들을 정의할수 있게 함. (20)
		public MyFrame(String title) {
			
		//생성자 함수가 없기에 오류가뜸 생성자인 MyFrame 을 public으로 접근 할수 있게하고 (String title) 로 생성자의 매개변수를 타이틀로 받게 함. (3)
			
			super( title ); 
			
			// super 이용해 생성자인 MyFrame을 호출 ( title ) 로 JFrame에 타이틀을 넘겨줌. (4)
			
			//ui 초기화. (22)
			this.setSize(450, 250);
			//전체 윈도우의 사이즈를 조절. (23).
			this.setVisible(true);
			//setVisible 을 (true) 하여 윈도우가 보이게 함. (24)
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//윈도우창을 종료하기 위해 EXIT_ON_CLOSE 사용. (25)
			
			panelNorth = new JPanel();
			labelMessage = new JLabel("Find Your Chicken!");
			//Find Your Chicken! 문구 출력. (26)
			labelMessage.setFont(new Font("Arial", Font.BOLD, 20));
			//setFont로 문구 폰트속성 변경 Font.BOLD 로 폰트 굵게함. (27)
			panelNorth.add(labelMessage);
			this.add( "North", panelNorth );
			//this.add 로 지금까지 만들어진 문구 생성 panelNorth로 윗쪽에 배치. (28)
			
			panelCenter = new JPanel();
			//패널 중앙 부분 생성. (29)
			labelVs = new JLabel("vs");
			labelVs.setFont( new Font("Arial", Font.BOLD, 40));
			buttonLeft = new JButton("LeftButton");
			buttonLeft.setIcon(changeImage("BHC 맛초킹.jpg"));
			//왼쪽버튼에 이미지 삽입 1번째 출력될 이미지를 지정. (30)
			buttonLeft.setPreferredSize(new Dimension(300,300));
			//setSize 로 이미지 사이즈를 변경할려고 했으나 안먹혀서 setPreferredSize 로 변경 뭐가다른지 아직 모르겠음. (31)
			buttonRight = new JButton("RightButton");
			buttonRight.setIcon(changeImage("BHC 뿌링클.jpg"));
			//오른쪽버튼에 이미지 삽입 2번째 출력될 이미지를 지정. (32)
			buttonRight.setPreferredSize(new Dimension(300,300));
			//여기도 setPreferredSize 로 이미지 크기 변경. (33)
			//이미지 클릭하면 이벤트 발생.
			buttonLeft.addActionListener(this);
			buttonRight.addActionListener(this);
			//이벤트를 버튼자신이 받아야해서 this로 지정. (34)
			panelCenter.add(buttonLeft);
			panelCenter.add(labelVs);
			panelCenter.add(buttonRight);
			this.add( "Center", panelCenter );
			//this.add 로 지금까지 만들어진 패널 생성 panelCenter로 중앙에 배치. (35)
			
			this.pack();
			//pack으로 패널 빈공간 제거. (36)
			
		}
		// ActionListener는 버튼 클릭 이벤트를 받기위한 것 버튼을 누르면 들어오는 Callback 함수를 actionPerformed 가 담당하게 함. (21)
		@Override
		public void actionPerformed(ActionEvent e) {
		//버튼 액션 추가. (34)
		if( imageIndex == 16) {
		//이미지가 16장이 끝이라 16장을 안넘어가게 함. (42)
				//마지막 치킨.
				labelMessage.setText("Found Your Chicken!");
				//마지막 이미지 하나.
			if(e.getActionCommand().equals("LeftButton")) {
				//왼쪽버튼을 눌렀을때. 
				buttonRight.hide();
				//마지막에 왼쪽 버튼을 눌렀을때 오른쪽버튼이 사라지게함. (43)
		        labelVs.hide();
				//VS문구도 사라지게함. (44)
			}else {
			    //오른쪽버튼을 눌렀을때.
				buttonLeft.hide();
				//마지막에 오른쪽 버튼을 눌렀을때 왼쪽버튼이 사라지게함. (45)
			    labelVs.hide();
			}
				
		}else {
			if(e.getActionCommand().equals("LeftButton") ) {
			//getActionCommand 를 사용하면 이벤트를 발생시킨 객체의 문자열을 String 문자열로 가져옴 equals 로 가져올곳의 객체의 주솟값이 맞는지 비교하게함. (37) 
				//왼쪽버튼 클릭.
				buttonRight.setIcon(changeImage(images[imageIndex]));
				//왼쪽이미지버튼을 눌렀을 때 오른쪽의 이미지가 바뀌도록함. (38)
				//첫번째와 두번쨰 이미지버튼은 이미 있기에 imageIndex 를 가져와 3번째 이미지부터 출력. (39)
				imageIndex++;
				//imageIndex 에 ++ 해서 이미지 순서를 넘어가도록 함. (40)
			}else {
				//오른쪽버튼 클릭.
				buttonLeft.setIcon(changeImage(images[imageIndex]));
				//오른쪽이미지버튼을 눌렀을 때 왼쪽의 이미지가 바뀌도록함. (41)
				imageIndex++;
			}
			
		}
	}
}		
	
	public static void main(String[] args) { 
	//클래스 생성 MyFrame. (1)
		new MyFrame("Chiken Wolrd Cup"); 
	}

} 