import java.io.*;
import java.util.*;
public class forca{
   static Scanner ler = new Scanner(System.in);
   static int erros = 0;
   public static void main(String[] args){
      System.out.println("+++++ JOGO DA FORCA +++++");
      while (true){
         menu();
      }
   }
   public static void menu(){
      char opcao;
      System.out.print("Digite 1 para começar(9 para sair): ");
      opcao = ler.next().charAt(0);
      switch (opcao){
         case 49:
            String palavra[] = getWord();
            desenho(palavra);
            break;
         case 57:
            System.exit(0);
            break;
         default:
            System.out.println("Opçao invalida!");
            menu();
      }
   }
   public static String[] getWord(){
      int num; 
      String palavra;
      String palavras[] = {
         "amor", "fato", "mito", "caos", "esmo", "brio", "como", "vide", "sede", "auge", "pois", "vida", "saga",
         "tolo", "apto", "idem", "medo", "crer", "urge", "veio", "casa", "zelo", "cota", "ruim", "soar", "rude",
         "fase", "pela", "rima", "auto", "mais", "para", "cedo", "onde", "cujo", "tudo", "meio", "logo", "teor",
         "cela", "nojo", "face", "amar", "pose", "numa", "sagaz", "negro", "mexer", "termo", "senso", "nobre",
         "plena", "afeto", "sutil", "vigor", "audaz", "inato", "sanar", "fazer", "desde", "cerne", "ideia", "assim",
         "moral", "poder", "fosse", "torpe", "anexo", "honra", "justo", "muito", "lapso", "etnia", "tange", "sobre",
         "expor", "haver", "posse", "casal", "corja", "pesar", "sonho", "amigo", "ardil", "genro", "prole", "tempo",
         "digno", "causa", "seara", "dizer", "gleba", "dengo", "tenaz", "crivo", "dever", "ceder", "exceto", "mister",
         "vereda", "apogeu", "utopia", "escopo", "casual", "anseio", "pressa", "alheio", "nocivo", "infame", "hostil",
         "idiota", "legado", "gentil", "adorno", "aferir", "astuto", "formal", "difuso", "solene", "limiar", "ocioso",
         "julgar", "outrem", "ensejo", "eficaz", "alento", "dispor", "escusa", "larica", "embora", "empatia", "embuste",
         "prolixo", "verbete", "sublime", "sucinto", "inferir", "recesso", "redimir", "cinismo", "refutar", "estigma",
         "exortar", "cordial", "cultura", "trivial", "virtude", "soberba", "emergir", "imputar", "aspecto", "mitigar",
         "deboche", "candura", "almejar", "excerto", "ademais", "alegria", "sucesso", "oriundo", "contudo", "austero",
         "sensato", "inerente", "peculiar", "denegrir", "genocida", "respeito", "deferido", "prudente", "equidade", "iminente",
         "invasivo", "pandemia", "alienado", "eminente", "abstrato", "premissa", "conceito", "ardiloso", "reiterar", "passível",
         "devaneio", "conserto", "relativo", "apologia", "perspicaz", "retificar", "paradigma", "plenitude", "dicotomia", "essencial",
         "hegemonia", "ratificar", "incidente", "persuadir", "deliberar", "demasiado", "resignado", "esperança", "confiança"
      };
      Random gerador = new Random();
      num = gerador.nextInt(199);
      palavra = palavras[num];
      String [] p = palavra.split("");
      return p;
   }
   public static void desenho(String separada[]){
      erros=0;
      boolean on = true;
      int ganhou = 0;
      int posicao[] = new int[4];
      int cont = 0;
      String letra;
      String[] desenho = new String[6];
      String[] visivel = new String[separada.length];
      String[] erradas = new String[8];
      for(int i=0;i<separada.length;i++){
         visivel[i] = " _ ";
      }
      while(on){
         for(int i=0;i<visivel.length;i++)
            System.out.print(" " + visivel[i]);
         if(erros == 0);
         else if(erros == 1){
            desenho[0] = "   _ ";
            desenho[1] = "  |_| ";
            cont++;
         }else if(erros == 2){
            desenho[2] = "   | ";
            desenho[3] = "   | ";
            desenho[4] = "   | ";
            cont++;
         }else if(erros == 3){
            desenho[3] = "  /| ";
            cont++;
         }else if(erros == 4){
            desenho[3] = "  /|\\ ";
            cont++;
         }else if(erros == 5){
            desenho[5] = "  /  ";
            cont++;
         }else if(erros == 6){
            desenho[5] = "  / \\";
            cont++;
         }else{
            perder(separada); 
         }
         System.out.printf("\n\n");
         for(int i=0;i<desenho.length;i++){
            if(desenho[i] != null){
               System.out.println(desenho[i]);
            }
         }
         System.out.print("\n\nErradas: ");
         for(int i=0;i<erradas.length;i++){
            if(erradas[i] != null){
               System.out.printf(" %s ", erradas[i]);
            }
         }
         if(ganhou == separada.length){
            ganhar();
         }
         System.out.printf("\nDigite a letra: ");
         letra = ler.next();
         posicao = verifica(letra, separada, erradas, cont);
         for(int i=0;i<posicao.length;i++){
            if(posicao[i] != -1){
               visivel[posicao[i]] = letra; ganhou++;
            }
         }
      }
   }
   public static int[] verifica(String letra, String[] separada, String[] erradas, int cont){
      int posicao[] = {-1, -1, -1, -1};
      int contador=0;
      for(int i=0;i<separada.length;i++){
         if(letra.equals(separada[i])){
            posicao[contador] = i;
            contador++;
         }
      }
      if(contador == 0){
         erradas[cont] = letra;
         erros++; cont++;
      }
      return posicao;
   }
   public static void ganhar(){
      String opcao="";
      while(!opcao.equals("s") && !opcao.equals("n")){
         System.out.print("\nParabens, voce ganhou!!\nJogar de novo?(s/n): ");
         opcao = ler.next();
      }
      if(opcao.equals("s")){
         menu();
      }else{
         System.exit(0);
      }
   }
   public static void perder(String[] separada){
      String opcao="";
      System.out.println("\nVoce perdeu!!\nA palavra era: ");
      for(int i=0;i<separada.length;i++){
         System.out.print(separada[i]);
      }
      while(!opcao.equals("s") && !opcao.equals("n")){
         System.out.print("\nJogar de novo?(s/n): ");
         opcao = ler.next();
      }
      if(opcao.equals("s")){
         menu();
      }else{
         System.exit(0);
      }
   }
}