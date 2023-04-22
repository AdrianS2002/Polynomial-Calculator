package Graphical.User.Interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Interfata extends JFrame{
    private JTextField txtPrimulPolinom = new JTextField();
    private JTextField txtAlDoileaPolinom = new JTextField();

   private JTextField txtRezultat =new JTextField();

    private JButton btnAdunare = new JButton("Adunare");

    private JButton btnScadere = new JButton("Scadere");

    private JButton btnInmultire = new JButton("Inmultire");

    private JButton btnImpartire = new JButton("Impartire");

    private JButton btnRest= new JButton("Restul impartirii");

    private JButton btnDerivare = new JButton("Derivare");

    private JButton btnIntegrare = new JButton("Integrare");

    private JLabel lblNume=new JLabel("Calculator Polinomial");

    private JLabel lblPrimulPolinom = new JLabel("Primul polinom:");

    private JLabel lblAlDoileaPolinom = new JLabel("Al doilea polinom:");

    private JLabel lblRezultat = new JLabel("Rezultat:");

    public Interfata() throws HeadlessException {
        this.setTitle("Calculator polinomial");
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        panel.setBackground(Color.decode("#F5DD90"));

        btnAdunare.setBackground(Color.decode("#F76C5E"));
        btnAdunare.setForeground(Color.decode("#324376"));
        btnAdunare.setFont(new Font("Arial",Font.BOLD,18));
        btnAdunare.setBounds(72,445,130,50);
        panel.setLayout(null);
        panel.add(btnAdunare);

        btnScadere.setBackground(Color.decode("#F76C5E"));
        btnScadere.setForeground(Color.decode("#324376"));
        btnScadere.setFont(new Font("Arial",Font.BOLD,18));
        btnScadere.setBounds(72,515,130,50);
        panel.setLayout(null);
        panel.add(btnScadere);

        btnInmultire.setBackground(Color.decode("#F76C5E"));
        btnInmultire.setForeground(Color.decode("#324376"));
        btnInmultire.setFont(new Font("Arial",Font.BOLD,18));
        btnInmultire.setBounds(72,585,130,50);
        panel.setLayout(null);
        panel.add(btnInmultire);

        btnRest.setBackground(Color.decode("#F76C5E"));
        btnRest.setForeground(Color.decode("#324376"));
        btnRest.setFont(new Font("Arial",Font.BOLD,18));
        btnRest.setBounds(280,515,200,50);
        panel.setLayout(null);
        panel.add(btnRest);


        btnImpartire.setBackground(Color.decode("#F76C5E"));
        btnImpartire.setForeground(Color.decode("#324376"));
        btnImpartire.setFont(new Font("Arial",Font.BOLD,18));
        btnImpartire.setBounds(544,445,130,50);
        panel.setLayout(null);
        panel.add(btnImpartire);

        btnDerivare.setBackground(Color.decode("#F76C5E"));
        btnDerivare.setForeground(Color.decode("#324376"));
        btnDerivare.setFont(new Font("Arial",Font.BOLD,18));
        btnDerivare.setBounds(544,515,130,50);
        panel.setLayout(null);
        panel.add(btnDerivare);

        btnIntegrare.setBackground(Color.decode("#F76C5E"));
        btnIntegrare.setForeground(Color.decode("#324376"));
        btnIntegrare.setFont(new Font("Arial",Font.BOLD,18));
        btnIntegrare.setBounds(544,585,130,50);
        panel.setLayout(null);
        panel.add(btnIntegrare);

        lblNume.setForeground(Color.decode("#324376"));
        lblNume.setFont(new Font("Arial",Font.BOLD,30));
        lblNume.setBounds(230,15,500,50);
        panel.setLayout(null);
        panel.add(lblNume);

        lblPrimulPolinom.setForeground(Color.decode("#324376"));
        lblPrimulPolinom.setFont(new Font("Arial",Font.BOLD,18));
        lblPrimulPolinom.setBounds(69,141,141,50); //y=85
        panel.setLayout(null);
        panel.add(lblPrimulPolinom);


        lblAlDoileaPolinom.setForeground(Color.decode("#324376"));
        lblAlDoileaPolinom.setFont(new Font("Arial",Font.BOLD,18));
        lblAlDoileaPolinom.setBounds(69,211,160,50);
        panel.setLayout(null);
        panel.add(lblAlDoileaPolinom);

        lblRezultat.setForeground(Color.decode("#324376"));
        lblRezultat.setFont(new Font("Arial",Font.BOLD,18));
        lblRezultat.setBounds(69,281,141,50);
        panel.setLayout(null);
        panel.add(lblRezultat);

        txtPrimulPolinom.setForeground(Color.decode("#324376"));
        txtPrimulPolinom.setBackground(Color.decode("#DDDCDD"));
        txtPrimulPolinom.setFont(new Font("Arial",Font.BOLD,18));
        txtPrimulPolinom.setBounds(230,140,500,50);
        panel.setLayout(null);
        panel.add(txtPrimulPolinom);

        txtAlDoileaPolinom.setForeground(Color.decode("#324376"));
        txtAlDoileaPolinom.setBackground(Color.decode("#DDDCDD")); //#B9AB87
        txtAlDoileaPolinom.setFont(new Font("Arial",Font.BOLD,18));
        txtAlDoileaPolinom.setBounds(230,210,500,50);
        panel.setLayout(null);
        panel.add(txtAlDoileaPolinom);

        txtRezultat.setForeground(Color.decode("#324376"));
        txtRezultat.setBackground(Color.decode("#DDDCDD"));
        txtRezultat.setFont(new Font("Arial",Font.BOLD,18));
        txtRezultat.setBounds(230,280,500,50);
        panel.add(txtRezultat);

        this.setContentPane(panel);
    }

    public  static void main(String[] args)
    {

        Interfata frame = new Interfata();

        ActionController c=new ActionController(frame);
        frame.setResizable(false);

        frame.setVisible(true);


    }

    public void setAddListener(ActionListener x)
    {
        btnAdunare.addActionListener(x);
    }

    public void setSubListener(ActionListener x)
    {
        btnScadere.addActionListener(x);
    }

    public void setMulListener(ActionListener x)
    {
        btnInmultire.addActionListener(x);
    }

    public  void  setDivListener(ActionListener x)
    {
        btnImpartire.addActionListener(x);
    }

    public void setDerivListener(ActionListener x)
    {
        btnDerivare.addActionListener(x);
    }

    public void setIntegListener(ActionListener x)
    {
        btnIntegrare.addActionListener(x);
    }
    public  void setRestListener(ActionListener x)
    {
        btnRest.addActionListener(x);
    }
    public String getP1(){
        return txtPrimulPolinom.getText();
    }

    public String getP2(){
        return txtAlDoileaPolinom.getText();
    }
    public void setRezultat(String s)
    {
        txtRezultat.setText(s);
    }
}