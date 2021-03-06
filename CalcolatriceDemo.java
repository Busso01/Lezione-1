// Salviamo il tutto nel file CalcolatriceDemo.java

class Calcolatrice { //classe non eseguibile e non pubblica
    // una calcolatrice e' una pila che contiene fino a 100 interi.
    // L'ultimo intero e' il risultato delle operazioni fatte finora
    // e la prossima operazione agisce sugli ultimi due interi a,b
    // e li rimpiazza con a+b (per una addizione) oppure a*b (per una moltiplicazione)

    // stack = pila che contiene fino a 100 interi */
    private int[] stack = new int[100];

    // size = numero di interi introdotti: all'inizio 0
    // le posizioni occupate dell'array hanno indice: 0, 1, ..., size-1
    private int size = 0;


    // push(x): aggiunge un intero x allo stack dopo la parte utilizzata
    // e aumenta di 1 la parte di stack utilizzata (variabile size)
    private void push(int x) {
        stack[size] = x;
        size++;
    }

    // pop(): restituisce l'ultimo intero dello stack
    // e lo "cancella" riducendo di 1 la parte di stack utilizzata (variabize size)
    private int pop() {
        size--;
        return stack[size];
    }

    //stampa(): stampa lunghezza della pila e il suo contenuto
    private void stampa() {
        System.out.println("lo stack ha linghezza: " + size);
        System.out.print("Stack: ");
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // questo e' un metodo pubblico
    public int esegui(String istruzioni) {
        int numeroIstruzioni = istruzioni.length(); //lunghezza
        int pc = 0; // inizio leggendo la prima istruzione, in posizione 0

        while (pc < numeroIstruzioni) { //eseguo le istruzioni in ordine
            char c = istruzioni.charAt(pc); //c = carattere di posto pc

            if (c >= '0' && c <= '9') { //vero se c e' una cifra
                push(c - '0');  //questa formula mi da' il valore della cifra c
            } else if (c == '+') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo + ultimo);
            } else if (c == '*') {
                int ultimo = pop(); //risultato ultimo calcolo
                int penultimo = pop(); //risultato penultimo calcolo
                push(penultimo * ultimo);
            } else if (c == '-') {
                int ultimo = pop();
                int penultimo = pop();
                push(penultimo - ultimo);
            } else if (c == '/'){
                int ultimo = pop();
                int penultimo = pop();
                push(penultimo / ultimo);
            } else if (c == '%'){
                int ultimo = pop();
                int penultimo = pop();
                push(penultimo % ultimo);
            } else if (c == '#') {
                stampa();
            }

            pc++; // passiamo alla prossima istruzione
        }

        return pop(); //alla fine restituisco l'ultimo risultato ottenuto
    }
}

// Un esperimento di uso della classe calcolatrice
// Classe eseguibile pubblica, deve stare in CalcolatriceDemo.java

    public class CalcolatriceDemo {
        public static void main(String[] args) {
            Calcolatrice C = new Calcolatrice();
            String s1 = "2*1+";
            String s2 = "1+2%";

            System.out.println("Eseguo istruzioni 23+ (due piu' tre)");
            System.out.println(C.esegui("23+") + "\n");

            System.out.println("Eseguo istruzioni 23* (due per tre) ");
            System.out.println(C.esegui("23*") + "\n");

            System.out.println("Eseguo istruzioni 23*9+ (due per tre piu' nove) ");
            System.out.println(C.esegui("23*9+") + "\n");

            System.out.println("Eseguo istruzioni 99*9* (nove per nove per nove) ");
            System.out.println(C.esegui("99*9*") + "\n");

            System.out.println("Eseguo istruzioni 99*9*1+ (nove per nove per nove piu' uno) ");
            System.out.println(C.esegui("99*9*1+") + "\n");

            System.out.println("Eseguo istruzioni 96+88++98+* (nove piu'sei piu' otto piu' otto per nove piu' otto) ");
            System.out.println(C.esegui("96+88++98+*") + "\n");

            System.out.println("Eseguo istruzioni 10! ");
            System.out.println(C.esegui("123456789********55+*") + "\n");

            System.out.println("Eseguo istruzioni numero negativo ");
            System.out.println(C.esegui("999999999999***********") + "\n");

            System.out.println("Eseguo istruzioni 23- (2 meno 3)");
            System.out.println(C.esegui("23-") + "\n");

            System.out.println("Eseguo istruzioni 32/ (3 diviso 2)");
            System.out.println(C.esegui("32/") + "\n");

            System.out.println("Eseguo istruzioni 53% (resto della divisione)");
            System.out.println(C.esegui("53%") + "\n");

            System.out.println("Eseguo istruzioni ns (individuo stringa s e calcolo 2n+1)");
            System.out.println(C.esegui("3"+s1) + "\n");

            System.out.println("Eseguo istruzioni ns (individuo stringa s e calcolo 1 se pari, 0 altrimenti)");
            System.out.println(C.esegui("1"+s2) + "\n");

        }
    }
