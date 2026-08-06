import java.awt.event.*;
public class Controller implements ActionListener{
    Model cm;
    Views cv;
    public Controller(Model cm,Views cv){
        this.cm = cm;
        this.cv = cv;

        cv.add.addActionListener(this);
        cv.sub.addActionListener(this);
        cv.mul.addActionListener(this);
        cv.div.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(cv.txta.getText());
        double b = Double.parseDouble(cv.txtb.getText());
        double result=0;
        if(e.getSource()==cv.add)
            result=cm.add(a,b);
        else if (e.getSource()==cv.sub)
            result=cm.sub(a,b);
        else if (e.getSource()==cv.mul)
            result=cm.mul(a,b);
        else if(e.getSource()==cv.div)
            result = cm.div(a,b);
        cv.txtresult.setText(String.valueOf(result));
    }
    
}