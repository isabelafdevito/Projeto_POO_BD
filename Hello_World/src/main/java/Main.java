
import java.util.Scanner;
import View.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int op = 0;


        while(flag){
            System.out.println("------------------------------------------------");
            System.out.println("Defina sua funcao");
            System.out.println("1 - Presidente");
            System.out.println("2 - Medico");
            System.out.println("3 - Paciente");
            System.out.println("4 - Sair");
            System.out.println("------------------------------------------------");
           op = sc.nextInt();
            switch (op){
                case 1:
                    Presidente pre1 = new Presidente();
                    pre1.informativo();
                    break;

                case 2:
                    Medico med1 = new Medico();
                    med1.informativo();
                    break;
                case 3:
                    Paciente pac1 = new Paciente();
                    pac1.informativo();
                    break;
                case 4:
                    flag = false;
                    break;

            }

        }
    }
}
