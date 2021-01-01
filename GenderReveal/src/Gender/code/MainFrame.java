package Gender.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener
{
    // Declaring all the JComponents required
    JButton submit;
    GenderResource g;
    JLabel label;

    JPanel bottom;
    JPanel top;
    JPanel right;
    JPanel left;
    JPanel center;

    String maleUrl;
    String femaleUrl;
    JLabel labelM;
    JLabel labelF;
    ImageIcon femaleImage;
    ImageIcon maleImage;

    ImageIcon softWareImage;
    JTextField inputAnimal;
    String animal = "";

    MainFrame()
    {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gender Of Species");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        if (animal.equals("")){
            animal = "human";
        }
        screen();
    }
    public void screen()
    {
        label = new JLabel();
        g = new GenderResource(animal);
//          "YOUR FILE LOCATION WHERE IMAGES ALL THE ANIMALS ARE LOCATED ENDING WITH (Animals\\)";
//          E.G. C:\Users\John Doe\Desktop\GenderReveal\src\Gender\Animals\
//        do not forget that strings use escape characters therefore actual url will
//        look like this C:\\Users\\John Doe\\Desktop\\GenderReveal\\src\\Gender\\Animals\\

        String imageFilelocation =   "";  //"ADD LOCATION HERE"
        maleUrl = imageFilelocation.concat(g.getMalePic());
        femaleUrl = imageFilelocation.concat(g.getFemalePic());
        maleImage = new ImageIcon(maleUrl);
        femaleImage = new ImageIcon(femaleUrl);

//      Male and female Label will be added in a CENTER JPanel

        labelM = new JLabel();
        labelM.setIcon(maleImage);
        labelM.setText(g.getMale());
        labelM.setVerticalTextPosition(JLabel.BOTTOM);
        labelM.setHorizontalTextPosition(JLabel.CENTER);
        labelM.setHorizontalAlignment(JLabel.CENTER);
        labelM.setForeground(new Color(0x118ab2));
        labelM.setFont(new Font("MV Boli",Font.PLAIN,20));

        labelF = new JLabel();
        labelF.setIcon(femaleImage);
        labelF.setText(g.getFemale());
//        labelF.(Color.GREEN);
        labelF.setVerticalTextPosition(JLabel.BOTTOM);
        labelF.setHorizontalTextPosition(JLabel.CENTER);
        labelF.setHorizontalAlignment(JLabel.CENTER);
        labelF.setForeground(new Color(0xf28482));
        labelF.setFont(new Font("MV Boli",Font.PLAIN,20));


//        Input field and Submit button are added to Top JPane for user input and submission
        inputAnimal = new JTextField();
        inputAnimal.setPreferredSize(new Dimension(150,25));
        inputAnimal.setFont(new Font("Consolas",Font.PLAIN,10));

        submit = new JButton();
        submit.setText("Submit");
        submit.setBackground(new Color(0xd6e2e9));
        submit.addActionListener(this);

        left = new JPanel();
        right = new JPanel();
        top = new JPanel();
        bottom = new JPanel();
        top.setPreferredSize(new Dimension(50,50));
        top.setBackground(new Color(0x81b29a));
        top.add(inputAnimal);
        top.add(submit);

        bottom.setPreferredSize(new Dimension(50,50));
        bottom.setBackground(new Color(0x81b29a));

        left.setPreferredSize(new Dimension(50,50));
        left.setBackground(new Color(0x81b29a));

        right.setPreferredSize(new Dimension(50,50));
        right.setBackground(new Color(0x81b29a));

        center = new JPanel();
        center.setBackground(new Color(0x136f63));
        center.setLayout(new GridLayout());
        center.add(labelM);
        center.add(labelF);
//        System.out.println(g.getMale()+" "+g.getMalePic()+" "+g.getFemale()+" "+g.getFemalePic());

//          "YOUR FILE LOCATION WHERE IMAGES ALL THE ANIMALS ARE LOCATED ENDING WITH (Animals\\)";
//          E.G. C:\Users\John Doe\Desktop\GenderReveal\src\Gender\
//        do not forget that strings use escape characters therefore actual url will
//        look like this C:\\Users\\John Doe\\Desktop\\GenderReveal\\src\\Gender\\G.png
        String softwareIcon = "";//"YOUR ICON ABSOLUTE PATH"
        softWareImage = new ImageIcon(softwareIcon);


        this.add(center,BorderLayout.CENTER);
        this.add(left,BorderLayout.EAST);
        this.add(right,BorderLayout.WEST);
        this.add(top,BorderLayout.NORTH);
        this.add(bottom,BorderLayout.SOUTH);
        this.setIconImage(softWareImage.getImage());
        this.setVisible(true);
    }

    public void removeComponents(){
//        this.remove(center);
//        this.remove(left);
//        this.remove(right);
        this.remove(top);
//        this.remove(bottom);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit){
            this.animal = inputAnimal.getText().toLowerCase().trim();
//            System.out.println(this.animal);
            removeComponents();
            screen();

        }
    }
}
