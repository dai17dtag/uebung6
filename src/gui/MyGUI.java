package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class MyGUI extends Frame
{
    public MyGUI()
    {
        setTitle("Uebung 6");

        setSize(800, 600);
        setLayout(null);

        final TextArea TXTAREA = new TextArea();
        TXTAREA.setName("TXTAREA");
        TXTAREA.setBounds(300, 290, 200, 40);
        TXTAREA.setText("enter text here");

        Button BTN_TOLOWER = new Button();
        BTN_TOLOWER.setName("BTN_TOLOWER");
        BTN_TOLOWER.setBounds(80, 500, 100, 40);
        BTN_TOLOWER.setLabel("To lower");
        BTN_TOLOWER.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String text = TXTAREA.getText();
                TXTAREA.setText(text.toLowerCase());
            }
        });

        Button BTN_TOUPPER = new Button();
        BTN_TOUPPER.setName("BTN_TOUPPER");
        BTN_TOUPPER.setBounds(280, 500, 100, 40);
        BTN_TOUPPER.setLabel("To upper");
        BTN_TOUPPER.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String text = TXTAREA.getText();
                TXTAREA.setText(text.toUpperCase());
            }
        });

        Button BTN_SWAP = new Button();
        BTN_SWAP.setName("BTN_SWAP");
        BTN_SWAP.setBounds(480, 500, 100, 40);
        BTN_SWAP.setLabel("Swap");
        BTN_SWAP.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String text = TXTAREA.getText();
                char[] textArray = text.toCharArray();

                for (int i = 0; i < textArray.length; i++)
                {
                    if (Character.isLowerCase(textArray[i])) { textArray[i] = Character.toUpperCase(textArray[i]); }
                    else if (Character.isUpperCase(textArray[i])) { textArray[i] = Character.toLowerCase(textArray[i]); }
                }

                TXTAREA.setText(new String(textArray));
            }
        });

        add(TXTAREA);
        add(BTN_TOLOWER);
        add(BTN_TOUPPER);
        add(BTN_SWAP);

        addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent windowEvent) { }

            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent windowEvent)
            {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) { }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) { }

            @Override
            public void windowActivated(WindowEvent windowEvent) { }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) { }
        });



        setVisible(true);
    }

    public MyGUI(final List<String> blacklist)
    {
        setTitle("Uebung 6");
        setSize(800, 600);
        setLayout(null);

        final List<String> blacklistConst;
        if (blacklist == null)
        {
            blacklistConst = new ArrayList<>();
        }
        else
        {
            blacklistConst = blacklist;
        }

        final TextArea TXTAREA = new TextArea();
        TXTAREA.setName("TXTAREA");
        TXTAREA.setBounds(300, 290, 200, 40);
        TXTAREA.setText("enter text here");

        Button BTN_TOLOWER = new Button();
        BTN_TOLOWER.setName("BTN_TOLOWER");
        BTN_TOLOWER.setBounds(80, 500, 100, 40);
        BTN_TOLOWER.setLabel("To lower");
        BTN_TOLOWER.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String text = TXTAREA.getText();
                TXTAREA.setText(text.toLowerCase());
            }
        });

        Button BTN_TOUPPER = new Button();
        BTN_TOUPPER.setName("BTN_TOUPPER");
        BTN_TOUPPER.setBounds(260, 500, 100, 40);
        BTN_TOUPPER.setLabel("To upper");
        BTN_TOUPPER.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String text = TXTAREA.getText();
                TXTAREA.setText(text.toUpperCase());
            }
        });

        Button BTN_SWAP = new Button();
        BTN_SWAP.setName("BTN_SWAP");
        BTN_SWAP.setBounds(440, 500, 100, 40);
        BTN_SWAP.setLabel("Swap");
        BTN_SWAP.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String text = TXTAREA.getText();
                char[] textArray = text.toCharArray();

                for (int i = 0; i < textArray.length; i++)
                {
                    if (Character.isLowerCase(textArray[i])) { textArray[i] = Character.toUpperCase(textArray[i]); }
                    else if (Character.isUpperCase(textArray[i])) { textArray[i] = Character.toLowerCase(textArray[i]); }
                }

                TXTAREA.setText(new String(textArray));
            }
        });

        Button BTN_CENSOR = new Button();
        BTN_CENSOR.setName("BTN_CENSOR");
        BTN_CENSOR.setBounds(520, 500, 100, 40);
        BTN_CENSOR.setLabel("Censor");
        BTN_CENSOR.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String text = TXTAREA.getText();

                for (String reference : blacklistConst)
                {
                    char[] textArr = new char[reference.length()];
                    for (int i = 0; i < textArr.length; i++)
                    {
                        textArr[i] = 'x';
                    }

                    text = text.replaceAll("(?i)"+reference, new String(textArr));
                }

                TXTAREA.setText(text);
            }
        });


        add(TXTAREA);
        add(BTN_TOLOWER);
        add(BTN_TOUPPER);
        add(BTN_SWAP);
        add(BTN_CENSOR);

        addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent windowEvent) { }

            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent windowEvent)
            {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) { }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) { }

            @Override
            public void windowActivated(WindowEvent windowEvent) { }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) { }
        });



        setVisible(true);
    }



}
