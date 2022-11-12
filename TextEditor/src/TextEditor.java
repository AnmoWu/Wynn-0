import java.io.*;
import java.awt.event.*;
import javax.swing.*;


public class TextEditor extends Editor {
    private File file;
    protected JFileChooser fchooser;

    public TextEditor(File file) {
        super();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.fchooser = new JFileChooser(new File("吴欣怡打字打累了",""));
        this.fchooser.setFileFilter(new ExtensionFileFilter("文本文件（*.txt）","txt"));
        this.file = file;
        if(file == null)
            this.file = new File("");
        this.readFrom(this.file,this.text);
        this.setTitle("文本编辑器 "+this.file.getName());
    }

    /*public TextEditor(){
        this(new File(""));
    }*/

    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        actionMenuItem(event);
    }

    public void actionMenuItem(ActionEvent event) {
        String mitem = event.getActionCommand();
        if(mitem.equals("新建")){
            this.file = new File("");
            this.setTitle("文本编辑器 ");
            this.text.setText("");
            return;
        }
        if(mitem.equals("打开")&&fchooser.showOpenDialog(this)==0){
            this.file = fchooser.getSelectedFile();
            this.readFrom(this.file,this.text);
            this.setTitle("文本编辑器 "+this.file.getName());
            return;
        }
        if(mitem.equals("保存") && !this.file.getName().equals(""))
            this.writeTo(this.file,this.text);
        else if((mitem.equals("保存") && this.file.getName().equals("")||mitem.equals("另存为"))
        && fchooser.showSaveDialog(this)==0){
            this.file = fchooser.getSelectedFile();
            if(!file.getName().endsWith(".txt"))
                this.file = new File(this.file.getAbsolutePath()+".txt");
            this.writeTo(this.file,this.text);
            this.setTitle("文本编辑器 "+this.file.getName());
        }
    }

    public void readFrom(File file, JTextArea text){
        try{
            Reader reader = new FileReader(file.getName());
            BufferedReader reader2 = new BufferedReader(reader);
            text.setText("");
            String line;
            while((line=reader2.readLine()) != null)
                text.append(line+"\r\n");
            reader2.close();
            reader.close();
        }
        catch(FileNotFoundException ex){
            if(!file.exists())
                JOptionPane.showMessageDialog(null,"文件不存在。");
        }
        catch(IOException ex){}
    }

    public void writeTo(File file,JTextArea text){
        try{
            Writer writer = new FileWriter(file.getName());
            writer.write(text.getText());
            writer.close();
        }
        catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null,"文件不存在。");
        }
        catch(IOException ex){}
    }

    public static void main(String[] args) {
        new TextEditor(new File("D:\\桌面文件\\大学课程\\JAVA语言程序设计\\课程设计\\test.txt"));
    }
}
