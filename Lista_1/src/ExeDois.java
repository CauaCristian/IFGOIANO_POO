/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author caual
 */
import java.util.Scanner;

public class ExeDois {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Qual o seu salario: ");
        
        int salario = scan.nextInt();

        System.out.println("Quantas faltas teve esse mês: "); 
        
        int faltas = scan.nextInt();

        System.out.println("Vendeu quantos produtos esse mês: "); 
        
        int vendas = scan.nextInt();

        scan.close();

        if (faltas > 5){
            
            salario = (int) (salario - salario * 0.15) ;
            
        }
        if (vendas <= 20){
            
            salario = (int) (salario + vendas*10);
            
        }
        if (vendas > 20){
            
            salario = (int) (salario + vendas*13);
            
        }

        System.out.println("Você recebera: " + salario); 
        
    }
    
}
