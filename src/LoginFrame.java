
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JLabel jLabelID =new JLabel("ID");
    private JLabel jLabelPw =new JLabel("PASSWORD");
    private JTextField jtfID=new JTextField();
    //private JTextField jtfPW=new JTextField();
    private JPasswordField jpsf=new JPasswordField();
    private JButton jbExit=new JButton("Exit");
    private JButton jbLog =new JButton("Log");
    private Container cp;
    private Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=300,frmH=150,screenW,screenH;
    public LoginFrame(){
        initCamp();
    }
    private void initCamp(){
        screenW=dim.width;
        screenH=dim.height;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        jLabelID.setHorizontalAlignment(JLabel.RIGHT);
        jLabelPw.setHorizontalAlignment(JLabel.RIGHT);
        jbLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtfID.getText().equals("01") &&
                        (new String(jpsf.getPassword())).equals("01")){

                    MainFrame mainFrame=new MainFrame();
                    mainFrame.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR");
                    System.out.println("NO"+jtfID.getText()+"\tpw");
                }
            }
        });
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cp.add(jLabelID);
        cp.add(jLabelPw);
        cp.add(jtfID);
        cp.add(jpsf);
        cp.add(jbExit);
        cp.add(jbLog);


    }
}
