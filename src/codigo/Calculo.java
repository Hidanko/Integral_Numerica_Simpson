package codigo;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Nemeth
 */
public class Calculo {

    int i, j;
    double h;
    int loop;
    double meio = 0;
    double ultimoResultado = 0;
    double resultado = 0;
    double TAXA_ERRO = 0.01; 

    public Calculo() {
        /* Por algum motivo o programa não considerou a atribuição global */
        ultimoResultado = 0;
    }

    /* Alterar para a formula pedida */
    public double formula(double valor) {
        return valor * 2;

    }

    public void calculo() {

        /* Alterar limites superiores e inferiores */
        double limSuperior = 2.0;
        double limInferior = 1.0;
        loop = 2;

        do {
            h = (limSuperior - limInferior) / loop;
            System.out.println("LOOP:" + loop);
            System.out.println("h = " + h);

            /* Gerar o array */
            double array[] = new double[loop + 1];
            for (j = 0; j < loop + 1; j++) {
                array[j] = limInferior + (h * j);
            }
            
            for (double b : array) {
                System.out.println(b);
            }

            //Calcular o meio da formula 
            // Se o loop for igual a 1, ele vai ignorar o FOR e depois irá multiplicar 2 por 0 
            meio = 0.0;
            for (int k = 0; k < loop - 1; k++) {
                // Se o valor for par: multiplica por 4
                // Se o valor for impar: multiplica por 2
                double temp = formula(array[k + 2]) * 2;
                if (loop % 2 == 0){
                    temp *= 2;
                }
                meio += temp;
            }
            /* Multiplicar por 2 */
            meio *= 2;

            /* Resolver */
            System.out.println("ArrayLength = " + array.length);
            resultado = (h / 3.0);
            resultado *= (formula(array[0]) + meio + formula(array[array.length - 1]));
            System.out.println("Resultado do loop " + loop + " foi de: " + resultado);

            array = null;
            loop++;
        } while (erro(resultado) > TAXA_ERRO);
        JOptionPane.showMessageDialog(null, "Resultado: "+resultado);
    }

    /* Arrumar */
    private double erro(double resultadoFuncao) {

        double E = (resultadoFuncao - ultimoResultado) / resultadoFuncao;
        ultimoResultado = resultadoFuncao;
        return E;
    }
}
