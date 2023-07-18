package controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import model.*;
import view.*;

public class Controller {
    private static Controller controller = null;
    private Facade facade;
    private TelaTabuleiro telaTabuleiro;
    private TelaInicial telaInicial;

    private Controller() {}

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
    
	public void init() {
		telaInicial = new TelaInicial();
		telaInicial.setVisible(true);
	}

    public void iniciarNovaPartida() {
    	telaInicial.setVisible(false);
        facade = new Facade();
        telaTabuleiro = new TelaTabuleiro();
        telaTabuleiro.setVisible(true);
    }

    public int handleRolarDado() {
        return facade.rolarDado();
    }

    public void moverPeao() {
        int index = 1;
        boolean moveSuccess = facade.moverPeao(index);
        if (moveSuccess) {
            // Se o movimento foi bem sucedido, passe a vez para o próximo jogador
            facade.proximaVez();
            //telaTabuleiro.setTurn(facade.getVez());
        } else {
            // Se o movimento falhou, mostre uma mensagem de erro
            telaTabuleiro.showErrorMessage("Movimento inválido!");
        }
    }
}
