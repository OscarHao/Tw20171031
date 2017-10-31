import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private JMenuItem JMenuItemFE = new JMenuItem("Exit");
    private JMenuItem JMenuItemGL = new JMenuItem("Lotto");
    private JDesktopPane jdp = new JDesktopPane();
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmu01 = new JMenu("File");
    private JMenu jmu02 = new JMenu("Set");
    private JMenu jmu03 = new JMenu("Game");
    private JMenu jmu04 = new JMenu("About");
    private JMenuItem jmisetFont = new JMenuItem("Font");

    private JInternalFrame jif = new JInternalFrame();
    private Container jifCP;
    private JPanel jpn = new JPanel(new GridLayout(1, 6, 5, 5));
    private JPanel jpn1 = new JPanel(new GridLayout(1, 2, 5, 5));
    private JLabel jlbs[] = new JLabel[6];
    private JButton jbtClose = new JButton("CLOSE");
    private JButton jbtRegen = new JButton("GENERATE");
    private int data[] = new int[6];
    private Random rnd = new Random(System.currentTimeMillis());
    private LoginFrame loginFrame;

    private int frmW = 500, frmH = 450;
    public MainFrame(LoginFrame frm){
        loginFrame=frm;
        initComp();
    }

    private void initComp() {
        this.setBounds(screenW / 2 - frmW / 2, screenH / 2 - frmH / 2, frmW, frmH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setJMenuBar(jmb);
        this.setContentPane(jdp);
        jmb.add(jmu01);
        jmb.add(jmu02);
        jmb.add(jmu03);
        jmb.add(jmu04);
        jmu01.add(JMenuItemFE);
        jmu03.add(JMenuItemGL);
        JMenuItemGL.setAccelerator(KeyStroke.getKeyStroke('L', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jif.setBounds(0, 0, 300, 150);
        jifCP = jif.getContentPane();
        jifCP.setLayout(new BorderLayout(5, 5));
        jifCP.add(jpn, BorderLayout.CENTER);
        jifCP.add(jpn1, BorderLayout.SOUTH);
        jpn1.add(jbtClose);
        jpn1.add(jbtRegen);
        for (int i = 0; i < 6; i++) {
            jlbs[i] = new JLabel();
            jlbs[i].setFont(new Font(null, Font.PLAIN, 22));
            jlbs[i].setOpaque(true);
            jlbs[i].setBackground(new Color(255, 228, 128));
            jlbs[i].setHorizontalAlignment(JLabel.CENTER);
            jpn.add(jlbs[i]);
        }
        lotoGenerate();
        JMenuItemGL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jif);
                jif.setVisible(true);
            }
        });
        JMenuItemFE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });

        JMenuItemFE.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
    }

}

