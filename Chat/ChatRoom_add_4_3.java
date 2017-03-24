/**
 * �汾4.3
 * �Ѿ�ʵ���˿����ж��ظ���½�����⣬�����Խ����ע������
 * 
 * ��������Ӻ��ѣ����Ǻ��ѹ�ϵ�Ĳ���˽��
 * �ᷢ�ͺ���������Ϣ���Է�ͬ��󻹻���ʾ��ͨ���󼴽������ѹ�ϵ
 * ����ѡ��ɾ�����ѣ����������Ҽ�����˵���������ѡ��˽��
 * 
 * ��ζ԰�ť��Ӽ��̼����أ�
 * ���س����ɵ�½�����س����ɷ�����Ϣ����Esc�ر����촰
 */
package ChatRoom_add_4_3;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChatRoom_add_4_3 extends JFrame{
	
	JFrame logFrame = new JFrame();
	JFrame addFriendFrame = null;
	JFrame groupChatFrame = null;
	JFrame personalChatFrame = null;
	JFrame regFrame = new JFrame();
	JFrame launchFrame = new JFrame();
	JFrame applyFriendFrame = null;
	JTextArea showGroupMessageArea = new JTextArea();
	JTextArea sendGroupMessageArea = new JTextArea();
	JTextArea showPersonalMessageArea = new JTextArea();
	JTextArea sendPersonalMessageArea = new JTextArea();
	JTextField loginText = new JTextField();
	JPasswordField loginPassword = new JPasswordField();
	JTextField regText = new JTextField();
	JPasswordField regPassword = new JPasswordField();
	JTextArea onLineIDArea = new JTextArea();//���ߵ���
	JTextField targetIDText = new JTextField();//˽��Ŀ��id
	JLabel idLabel = new JLabel();//��ǰ�û��ĵ�½id
	JLabel idLabelGroup = new JLabel();//��ǰ�û��ĵ�½id
	JLabel idLabelPersonal = new JLabel();
	JLabel applyLabel = new JLabel();
	JCheckBox check = null;
	JLabel warn = new JLabel();
	public Vector<String> globalID = new Vector<String>();//�����Ƕ������У����纬��ͼƬ���ַ����Ķ���
	public Vector<String> friendsID = new Vector<String>();
	public JList friendList = new JList(friendsID);//�����б�
	public JList onlineList = new JList(globalID);//����id�б�
	ChatListener listen = new ChatListener(this,idLabel);
	FriendsListListener friendListListen = new FriendsListListener(this,friendList);
	OnlineListListener onlineListListen = new OnlineListListener(this,onlineList);
	public boolean flag = true;
	String applyID = "";
	
	public static void main(String[] args){
		ChatRoom_add_4_3 chat = new ChatRoom_add_4_3();
		chat.launchFrame();
	}
	
	public void loginFrame(){
		logFrame.setTitle("Me");
		logFrame.setSize(400,600);
		logFrame.setLocationRelativeTo(null);
		logFrame.setDefaultCloseOperation(3);
		logFrame.setResizable(false);
		logFrame.setLayout(null);
		
		idLabel.setBounds(10,10,180,30);
		check = new JCheckBox("������Ϣ�Զ�����");
		check.setBounds(220,50,180,30);
		
		JLabel label1 = new JLabel("Friend Client ID:");
		label1.setBounds(5,50,180,30);
		friendList.setBounds(5,90,380,400);
		friendList.addMouseListener(friendListListen);
		
		JButton button1 = new JButton("Ⱥ��");
		button1.setBounds(10,510,120,30);
		button1.addActionListener(listen);
		JButton button3 = new JButton("��Ӻ���");
		button3.setBounds(140,510,120,30);
		button3.addActionListener(listen);
		JButton button2 = new JButton("ˢ��ID�б�");
		button2.setBounds(270,510,120,30);
		button2.addActionListener(listen);
		
		logFrame.add(idLabel);
		logFrame.add(label1);//��ʾ���ߵ�friend id
		logFrame.add(check);
		logFrame.add(friendList);//friend id list
		logFrame.add(button1);
		logFrame.add(button3);
		logFrame.add(button2);
		logFrame.setVisible(true);
	}
	
	public void addFriend(){
		addFriendFrame = new JFrame();
		addFriendFrame.setTitle("Add Friend");
		addFriendFrame.setSize(300, 500);
		addFriendFrame.setLocationRelativeTo(null);
		addFriendFrame.setDefaultCloseOperation(2);
		addFriendFrame.setResizable(false);
		addFriendFrame.setLayout(null);
		
		onlineList.setBounds(5, 10, 280, 400);
		onlineList.addMouseListener(onlineListListen);
		JButton button = new JButton("���");
		button.setBounds(100, 420, 100, 30);
		button.addActionListener(listen);
		
		addFriendFrame.add(onlineList);
		addFriendFrame.add(button);
		addFriendFrame.setVisible(true);
	}
	
	public void applyFriend(){
		applyFriendFrame = new JFrame();
		applyFriendFrame.setTitle("Apply");
		applyFriendFrame.setSize(300, 200);
		applyFriendFrame.setLocationRelativeTo(null);
		applyFriendFrame.setDefaultCloseOperation(2);
		applyFriendFrame.setResizable(false);
		applyFriendFrame.setLayout(null);
		
		applyLabel.setBounds(20, 30, 260, 30);
		JButton button1 = new JButton("ȷ�����");
		button1.setBounds(40,100,100,30);
		JButton button2 = new JButton("�ܾ����");
		button2.setBounds(160,100,100,30);
		button1.addActionListener(listen);
		button2.addActionListener(listen);
		
		applyFriendFrame.add(applyLabel);
		applyFriendFrame.add(button1);
		applyFriendFrame.add(button2);
		applyFriendFrame.setVisible(true);
	}
	
	public void registerFrame(){
		regFrame.setTitle("Register");
		regFrame.setSize(400,300);
		regFrame.setDefaultCloseOperation(3);
		regFrame.setResizable(false);
		regFrame.setLocationRelativeTo(null);
		regFrame.setLayout(null);
		//������������ʽ���֣���Ȼ���׵����������
		Dimension dim = new Dimension(320,30);
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		label1.setBounds(50,50,50,30);
		label2.setBounds(50,100,50,30);
		label1.setText("�˺ţ�");
		label2.setText("���룺");

		regText.setBounds(100,50,250,30);
		regText.setPreferredSize(dim);
		
		regPassword.setPreferredSize(dim);
		regPassword.setBounds(100,100,250,30);
		
		warn.setBounds(80,120,250,60);
		JButton button = new JButton("ȷ��");
		button.setBounds(150, 170, 130, 40);
		
		button.addActionListener(listen);
		
		regFrame.add(label1);
		regFrame.add(regText);
		regFrame.add(label2);
		regFrame.add(regPassword);
		regFrame.add(warn);
		regFrame.add(button);
		
		regFrame.setVisible(true);
	}
	
	public void startGroupChat(){
		groupChatFrame = new JFrame();//����رպ���Ҫ����ʵ�����ö��󣬷�����������ʾ
		groupChatFrame.setTitle("Group Chat");
		groupChatFrame.setSize(600,450);
		groupChatFrame.setDefaultCloseOperation(2);//���ó�2����ֻ�ǵ����Ĺرմ���
		groupChatFrame.setResizable(false);
		groupChatFrame.setLocationRelativeTo(null);
		//��Ĭ�ϵ���ʽ���ֹص�
		groupChatFrame.setLayout(null);
		idLabelGroup.setText("Group Chat");
		idLabelGroup.setBounds(10,10,280,30);
	
		//��������TextArea�л�����
		JScrollPane showPane  = new JScrollPane(showGroupMessageArea);
		showPane.setBounds(10,50,580,200);//������Ҫ���ô�С
		JScrollPane sendPane = new JScrollPane(sendGroupMessageArea);
		sendPane.setBounds(10,260,580,80);
		
		JButton button = new JButton("����Ⱥ����Ϣ");
		button.setBounds(400, 350, 150, 50);
		button.addActionListener(listen);

		groupChatFrame.add(idLabelGroup);
		groupChatFrame.add(showPane);
		groupChatFrame.add(sendPane);
		groupChatFrame.add(button);
		
		groupChatFrame.setVisible(true);
	}
	
	public void startPersonalChat(){
		personalChatFrame = new JFrame();
		personalChatFrame.setTitle("Personal Chat");
		personalChatFrame.setSize(600,450);
		personalChatFrame.setDefaultCloseOperation(2);
		personalChatFrame.setResizable(false);
		personalChatFrame.setLocationRelativeTo(null);
		//��Ĭ�ϵ���ʽ���ֹص�
		personalChatFrame.setLayout(null);
		idLabelPersonal.setBounds(10,10,280,30);
		
		//��������TextArea�л�����
		JScrollPane showPane  = new JScrollPane(showPersonalMessageArea);
		showPane.setBounds(10,50,580,200);//������Ҫ���ô�С
		JScrollPane sendPane = new JScrollPane(sendPersonalMessageArea);
		sendPane.setBounds(10,260,580,80);
		
		JButton button = new JButton("����˽����Ϣ");
		button.setBounds(400, 350, 150, 50);
		button.addActionListener(listen);
		
		personalChatFrame.add(idLabelPersonal);
		personalChatFrame.add(showPane);
		personalChatFrame.add(sendPane);
		personalChatFrame.add(button);
		
		personalChatFrame.setVisible(true);
	}
	
	public void launchFrame(){
		launchFrame.setTitle("Login");
		launchFrame.setSize(400,300);
		launchFrame.setDefaultCloseOperation(3);;
		launchFrame.setResizable(false);
		launchFrame.setLocationRelativeTo(null);
		launchFrame.setLayout(null);
		//������������ʽ���֣���Ȼ���׵����������
		Dimension dim = new Dimension(320,30);
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		label1.setBounds(50,50,50,30);
		label2.setBounds(50,100,50,30);
		label1.setText("�˺ţ�");
		label2.setText("���룺");

		loginText.setBounds(100,50,250,30);
		loginText.setPreferredSize(dim);
		
		loginPassword.setPreferredSize(dim);
		loginPassword.setBounds(100,100,250,30);
		
		warn.setBounds(80,120,250,60);
		JButton button1 = new JButton("ע��");
		button1.setBounds(80, 170, 130, 40);
		button1.addActionListener(listen);
		JButton button2 = new JButton("��½");
		button2.setBounds(220, 170, 130, 40);
		button2.addActionListener(listen);
		
		
		launchFrame.add(label1);
		launchFrame.add(loginText);
		launchFrame.add(label2);
		launchFrame.add(loginPassword);
		launchFrame.add(warn);
		launchFrame.add(button1);
		launchFrame.add(button2);
		
		launchFrame.setVisible(true);
		
	}
}
