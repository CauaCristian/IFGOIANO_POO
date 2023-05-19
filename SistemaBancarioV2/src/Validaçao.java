public class Validaçao {
    boolean cpf(String cpf){
        String cpfSemEspaço = cpf.replace(" ", "");
        String cpfSemPonto = cpfSemEspaço.replace(".", "");
        String cpfTratado = cpfSemPonto.replace("-", "");
        String vetorCpf[] = cpfTratado.split("");
        boolean erro = false;
        for (int i = 0; i < vetorCpf.length; i++) {

            if (!Character.isDigit(cpfTratado.charAt(i))) {

                erro = true;

                break;

            }
        }
        if (erro){
            System.out.println();
            System.out.println("Não pode conter letras");
            return true;
        }
        else {
            if (vetorCpf.length > 11 ){
                System.out.println();
                System.out.println("cpf invalido, numero muito grande, use o formato 000.000.000-00");
                return true;
            }
            if (vetorCpf.length < 11){
                System.out.println();
                System.out.println("cpf invalido, numero muito pequeno, use o formato 000.000.000-00");
                return true;
            }
            if (vetorCpf.length == 11){
                return false;
            }
        }
        return true;
    }
    boolean agencia(String agencia){

        String vetorAgencia[] = agencia.split("");
        boolean erro = false;
        for (int i = 0; i < vetorAgencia.length; i++) {

            if (!Character.isDigit(agencia.charAt(i))) {

                erro = true;

                break;

            }
        }
        if (erro){
            System.out.println();
            System.out.println("Não pode conter letras");
            return true;
        }
        else{
            if (vetorAgencia.length > 4 ){
                System.out.println();
                System.out.println("Agência invalida, numero muito grande, formato recomendado 0000");
                return true;
            }
            if (vetorAgencia.length < 4){
                System.out.println();
                System.out.println("Agência invalido, numero muito pequeno, formato recomendado 0000");
                return true;
            }
            if (vetorAgencia.length == 4){
                return false;
            }
        }
        return true;
    }
    boolean senha(String senha){
        String vetorSenha[] = senha.split("");
        boolean erro = false;
        for (int i = 0; i < vetorSenha.length; i++) {

            if (!Character.isDigit(senha.charAt(i))) {

                erro = true;

                break;

            }
        }
        if (erro){
            System.out.println();
            System.out.println("Não pode conter letras");
            return true;
        }
        else {
            return false;
        }
    }
}

