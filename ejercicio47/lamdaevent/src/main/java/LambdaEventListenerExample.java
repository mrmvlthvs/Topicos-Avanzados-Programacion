/*tomado de: https://hevodata.com/learn/what-are-java-lambda-expressions/*/

import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JTextField;  

public class LambdaEventListenerExample {  
    public static void main(String[] args) {  
        JTextField tf=new JTextField();  
        JButton b=new JButton("click");
        JFrame f=new JFrame();  
        
        tf.setBounds(50, 50,150,20);  
        b.setBounds(80,100,70,30);           
        // lambda expression implementing here.  
        b.addActionListener(e-> {tf.setText("hello swing");});  
        f.add(tf);f.add(b);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setLayout(null);  
        f.setSize(300, 200);  
        f.setVisible(true);  
    }  
}
