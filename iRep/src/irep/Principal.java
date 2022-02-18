/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep;

import irep.controlador.ContaController;

import irep.visao.TelaInicial;

public class Principal {
    public static void main(String[] args) {
        TelaInicial tela = new TelaInicial();
        ContaController contaController = new ContaController();
        
        tela.mostrar(contaController);
    }
}