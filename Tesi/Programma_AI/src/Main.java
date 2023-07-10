import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

class AI extends Canvas {
    static double x = 0;
    static double y = 0;
    static double b = 0;
    static double h = 0;
    static String A, B, C, D;
    static boolean rectangle;
    static double width = 0;
    static double height = 0;
    static JFrame frame = new JFrame("Figure");


    public static void main(String[] args) throws Exception {
        int i=0;
        int k=0;
        double precisions=0.0;

        while (i<20) { //
            //accedi ai file per salvare i dati 
            FileWriter file = new FileWriter("Dataset.arff", true);
            BufferedWriter fileout = new BufferedWriter(file);
            FileWriter test = new FileWriter("Test.arff", true);
            BufferedWriter testout = new BufferedWriter(test);


            //Disegna la figura 
            SwingUtilities.invokeAndWait(new Runnable(){
                public void run() {
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.add(new JPanel() {

                        @Override
                        public void paintComponent(Graphics g) {
                            // Disegna un rettangolo usando la classe Rectangle2D 
                            Graphics2D g2 = (Graphics2D) g;
                            g2.setColor(Color.BLACK);

                            int random = (int) (Math.random() * 200 + 50);
                            if (random % 2 == 0) {
                                b = random;
                                h = random;
                                rectangle = false;

                            } else {
                                b = random;
                                h = (int) (Math.random() * 100 + 20);
                                rectangle = true;
                            }

                            width = x + b;
                            height = y + h;
                            // Disegna il rettangolo 
                            g2.draw(new Rectangle2D.Double(x, y, width, height));

                        }
                    }, BorderLayout.CENTER);


                }
                });

            frame.setVisible(true);
            frame.setSize(new Dimension(500, 400));
            String str = "";
            Scanner input = new Scanner(System.in);

            //trova i 4 vertici 
            A = x + "," + y;
            B = width + "," + y;
            C = x + "," + height;
            D = width + "," + height;

            //prendi i 4 vertici per far sì che l'AI faccia la previsione
            str=A + "," + B + "," + C + "," + D;
            String str1=str+",?";
            testout.write(str1);
            testout.write('\n');

            testout.flush();
            testout.close();


            // chiedi all'utente di riconoscere se che figura sta guardando 
            System.out.println("La figura è un Rettangolo o un Quadrato?");
            System.out.println("Premi 1 per Rettangolo o 2 per Quadrato");

            //chiama weka
            Weka testing=new Weka();
            testing.Call();
            String a=testing.prediction;

            //Prendi la risposta dall'utente  
            String answer = input.nextLine();

            //Salva sul datset i vertici e la risposta dell'utente
            if (answer.equals("1")) {
                str = str + "," + "Rectangle";
                fileout.write(str);
                fileout.write('\n');

            } else if (answer.equals("2")) {
                str = str+ "," + "Square";
                fileout.write(str);
                fileout.write('\n');
            }

            //pulisce l'applet, mostra la prossima figura
            frame.getContentPane().removeAll();
            frame.repaint();
            i++;

            fileout.flush();
            fileout.close();

        }


    }

}