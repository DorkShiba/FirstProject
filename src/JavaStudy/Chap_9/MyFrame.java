package JavaStudy.Chap_9;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("MyFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(new Button("Hello"));

        setSize(100, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
