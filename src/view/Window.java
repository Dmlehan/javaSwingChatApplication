package view;

import controller.Observable;
import controller.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements Observer {
    private JTextField typeHereField;
    private JTextArea receivedMessage;
    private JPanel topPnl;
    private JButton sendBtn;
    private String message;
    private DefaultListModel<MessageSender> l1;
    private JList<MessageSender> list;
    public Window(String title, int x) {
        setTitle(title);
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(x, 150);
        setLayout(new BorderLayout());

        typeHereField = new JTextField();

        typeHereField.setSize(300, 200);
        typeHereField.setFont(new Font("", 1, 30));

        Observable observable=Observable.getInstance();
        l1=new DefaultListModel<>();
        list=new JList<>(l1);

        sendBtn = new JButton("Send");
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = typeHereField.getText();
                String  title= getTitle();
                observable.setMessage(message,title);
                typeHereField.setText("");
            }
        });
        add(new JScrollPane(list));
        add("North", typeHereField);
        add(new JScrollPane(list));
        add("South",sendBtn);
        setVisible(true);
    }


    @Override
    public void update(String message,String title) {

        l1.addElement(new MessageSender(message,title));
    }

}