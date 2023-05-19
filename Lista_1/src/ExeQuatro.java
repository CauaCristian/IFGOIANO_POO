/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author caual
 */
import java.util.Scanner;

public class ExeQuatro {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("digite o numero do seu cartão: ");
        
        String numero = scan.nextLine();
        
        scan.close();
        
        String numeroSemEspaço = numero.replace(" ", "");
        
        String vetorNumero[] = numeroSemEspaço.split("");
        
        boolean Erro = false;
        
        for (int i = 0; i < numeroSemEspaço.length(); i++) {
            
            if (!Character.isDigit(numeroSemEspaço.charAt(i))) {
                
                Erro = true;
                
                break;
                
            }
            
        }
        
        if (Erro) {
            
            System.out.println("Erro: Não é permitido letras no numero do cartão, digite novamente");
        
        }
        
        else{
            
            if (vetorNumero.length <= 1){
                
                System.out.println("Erro: Numero digitado é muito pequeno, digite novamente ");
            
            }
            
            else{
                
                int vetorNumeroInteiro[] = new int[vetorNumero.length];
                
                for (int i =0; i < vetorNumero.length; i++){
                    
                    vetorNumeroInteiro[i] = Integer.parseInt(vetorNumero[i]);
                    
                } 
                
                for (int i = 0; i < vetorNumeroInteiro.length; i += 2) {
                    
                    vetorNumeroInteiro[i] = (int)(vetorNumeroInteiro[i]*2);
                    
                    if(vetorNumeroInteiro[i] > 9) {
                        
                        vetorNumeroInteiro[i] = (int)(vetorNumeroInteiro[i]-9);
                    
                    } 
                
                }
                
                int soma = 0;
                
                for(int i = 0; i < vetorNumeroInteiro.length; i++){
                    
                    soma = (int)(soma +  vetorNumeroInteiro[i]);
                    
                }
                
                String validação = "";
                
                if (soma % 10 == 0 ){
                    
                    validação = "O numero de cartão digitado é valido";
                
                }
                
                else {
                    
                    validação = "O numero de cartão digitado não é valido";
                
                }
                
                System.out.println(validação);
                
            }
            
        }
        
    }
    
}
