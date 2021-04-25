package jvavancado.Editor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Arquivo {

    public void gravarArquivo(String caminhoDoArquivo, String conteudo) {
        try {
            FileWriter fw = new FileWriter(caminhoDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(conteudo);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar os dados ");
        }
    }
}
