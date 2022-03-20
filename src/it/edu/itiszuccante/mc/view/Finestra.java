package it.edu.itiszuccante.mc.view;

import java.awt.*;
import javax.swing.*;

// import model.scacchiera.Scacchiera;
public class Finestra {

    // private Scacchiera sca;

    private JFrame frame;
    private JPanel mainPanel;
    private final Font mainFont = new Font("Sogoe print", Font.BOLD, 18);

    // public Finestra(Scacchiera sca) {
    public Finestra() {
        // this.sca = sca;

        frame = new JFrame();
        setupUI();
        frame.getContentPane().add(mainPanel);
        frame.setTitle("Progetto MC");
        frame.setMinimumSize(new Dimension(600, 700));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }

    private void setupUI(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        /** 
         * * Pannello Statistiche 
         */
        JLabel firstPlayer = new JLabel();
        firstPlayer.setFont(mainFont);
        firstPlayer.setText("Primo giocatore");

        JLabel secondPlayer = new JLabel();
        secondPlayer.setFont(mainFont);
        secondPlayer.setText("Secondo giocatore");

        JLabel thirdPlayer = new JLabel();
        thirdPlayer.setFont(mainFont);
        thirdPlayer.setText("Terzo giocatore");

        JPanel classifica = new JPanel();
        classifica.setLayout(new GridLayout(3, 1, 5, 5));
        classifica.add(firstPlayer);
        classifica.add(secondPlayer);
        classifica.add(thirdPlayer);

        JLabel turni = new JLabel();
        turni.setFont(mainFont);
        turni.setText("Numero di turni");

        JToolBar.Separator toolBar$Separator1 = new JToolBar.Separator();

        JPanel statisticsPanel = new JPanel();
        statisticsPanel.setLayout(new GridLayout(1, 3, 5, 5));
        statisticsPanel.add(classifica);
        statisticsPanel.add(toolBar$Separator1);
        statisticsPanel.add(turni);
        JPanel scacc = new JPanel();

        /*
        int h = 30, w = 30;
        JPanel scacc = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                ImageIcon img;
                
                int x = 0;
                for(int i = 0; i < (sca.getLenx()*h); i+=h){
                    int y =0;
                    for(int j = 0; j < (sca.getLeny()*w); j+=w){
                        g.setColor(Color.BLACK);
                        g.fillRect(i, j, h, w);
                        if(sca.getCasella(x, y).getInfo().equals("vuota")){
                            g.setColor(new Color(255,255,255));
                            g.fillRect(i, j, h-1, w-1);
                        }else if(sca.getCasella(x, y).getInfo().contains("Seta")){
                            img = new ImageIcon(".\\src\\view\\seta1.png");
                            g.drawImage( img.getImage(), i, j, h-1, w-1, null);    
                        }else if(sca.getCasella(x, y).getInfo().contains("Energia")){
                            img = new ImageIcon(".\\src\\view\\energia1.png");
                            g.drawImage( img.getImage(), i, j, h-1, w-1, null);    
                        }else{
                            img = new ImageIcon(".\\src\\view\\agente1.png");
                            g.drawImage( img.getImage(), i, j, h-1, w-1, null);
                        }
                        y++;
                    }
                    x++;
                }
            }
        };
        scacc.setPreferredSize(new Dimension((sca.getLenx()*h)+1, (sca.getLeny()*w)+1));
        
        JTextArea OutPut = new JTextArea();
        OutPut.append(sca.toString());
        OutPut.setEditable(false);
        */
        JScrollPane scrollPane1 = new JScrollPane(scacc);
        scrollPane1.setAutoscrolls(true);
        scrollPane1.setViewportBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
 
        mainPanel.add(statisticsPanel, BorderLayout.PAGE_END);
        mainPanel.add(scrollPane1);
    }
}