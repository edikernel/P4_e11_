/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4_e11_muñozg;
import java.util.Scanner;
/**
 *
 * @author emunoz
 */
public class P4_e11_MuñozG {

    /**
     * @param args the command line arguments
     */
    private static final int NOIA = 1;
    private static final String S_NOIA = "Noia";
    private static final int NOI = 2;
    private static final String S_NOI = "Noi";
    private static final int INF = 1;
    private static final String S_INF = "Infantil";
    private static final int JUN = 2;
    private static final String S_JUN = "Junior";
    private static final int SEN = 3;
    private static final String S_SEN = "Senior";
    private static final int ID_MIN = 1;
    private static final int ID_MAX = 2000;
    private static final int ANY_MIN = 1900;
    private static final int ANY_MAX = 2100;
    private static final int MES_MIN = 1;
    private static final int MES_MAX = 12;
    private static final int DIA_MIN = 1;
    private static final int DIA_MAX = 31;
    private static final int PUNT_MIN = 2;
    private static final int PUNT_MAX = 30;
    private static final int MAL_MAX = 3; //valor estatic, contador máxim per fer control de preguntes
    private static final int RESP_SI = 1; //valor correcte de la resposta si vol tornar a inscriure altre participant
    private static final int RESP_NO = 2; //valor correcte de la resposta si vol finalitzar l'inscripció dels participants
    private static final int USER_MAX = 10; //valor correcte de la resposta si vol finalitzar l'inscripció dels participants
    public static void main(String[] args) {
        //////////////
        //VARIABLES//
        ////////////
        
        Scanner teclado = new Scanner(System.in); //variable per invocar l'eina de lectura de dades del teclat
        boolean repeat, tipOK, respOK, totOK;
        repeat = true;//valor inicial, repetició del programa?
        respOK = false;//la resposta es l'esperada?
        totOK = true;//tot el programa es OK.
        int[] id = new int[USER_MAX]; //contindrá els identificadors creats per l'usuari, màxim 10 usuaris.
        int[] any = new int[USER_MAX]; //contindrá els anys creats per l'usuari, màxim 10 anys.
        int[] mes = new int[USER_MAX]; //contindrá els mesos creats per l'usuari, màxim 10 messos.
        int[] dia = new int[USER_MAX]; //contindrá els dies creats per l'usuari, màxim 10 dies.
        int[] genere = new int[USER_MAX]; //contindrá el genere de l'usuari, màxim 10 generes.
        int[] categoria = new int[USER_MAX]; //contindrá el genere de l'usuari, màxim 10 generes.
        int[] puntuacio = new int[USER_MAX]; //contindrá el genere de l'usuari, màxim 10 generes.
        int respRepeat; //la resposta de l'usuari, 1 o 0, repeteix o no
        int respOrdre; //la resposta de l'usuari, 1 o 0, repeteix o no
        int contMal = 0; //contador de respostes malament
        int contRegistre = 1; //contador per número de registrats.
        int auxPunt; //auxiliar per l'ordenació
        int auxId; //auxiliar per l'ordenació
        int auxAny; //auxiliar per l'ordenació
        int auxMes; //auxiliar per l'ordenació
        int auxDia; //auxiliar per l'ordenació
        int auxGenere; //auxiliar per l'ordenació
        int auxCategoria; //auxiliar per l'ordenació
        int contador = 0; //contador de les posicions
        String genereString = null;
        String categoriaString = null;
        
        ////////////////////////////////
        //PREGUNTES I GESTIÓ D'ERRORS//
        //////////////////////////////
        do {
            if (totOK) { //si totes les respostes han sigut correctes
                totOK = false; //torna a deixar el valor per defecte  
                repeat = false; //torna a deixa el valor per defecte
                do {

                    /////////////////////
                    //PRIMERA PREGUNTA//
                    ///////////////////

                    System.out.println("Quin és el número identificatiu del participant? (1 - 2000)");
                    tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                    if (tipOK) { //si la resposta ha sigut tipus int...
                        id[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                        teclado.nextLine();//neteja memòria buffer
                        if (id[contador] >= ID_MIN && id[contador] <= ID_MAX) {//si compleix amb les condicions bàsiques...
                            respOK = true;//la resposta es correcte
                        }
                        else {
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;//la resposta no es correcte
                            System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                        }
                    }
                    else {
                        teclado.nextLine();//neteja memòria buffer
                        contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                        respOK = false;
                        System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                        System.out.println("_________________________________________________________________");
                    }
                } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...

                ////////////////////
                //SEGONA PREGUNTA//
                //////////////////

                if (contMal < MAL_MAX) {
                    do {
                        //Pregunta pel número identificatiu de l'inscriptor
                        System.out.println("Data de naixement");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        System.out.println("    any?: ");
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            any[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (any[contador] >= ANY_MIN && any[contador] <= ANY_MAX) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...
                }   


                /////////////////////
                //TERCERA PREGUNTA//    
                ///////////////////

                if (contMal < MAL_MAX) {
                    //Tercera pregunta...
                    do {
                        //Pregunta pel número identificatiu de l'inscriptor
                        System.out.println("    mes? (1-12): ");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            mes[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (mes[contador] >= MES_MIN && mes[contador] <= MES_MAX) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }


                ////////////////////
                //CUARTA PREGUNTA//
                //////////////////


                if (contMal < MAL_MAX) {
                    do {
                        //Pregunta pel número identificatiu de l'inscriptor
                        System.out.println("    dia? (1-30): ");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            dia[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (dia[contador] >= DIA_MIN && dia[contador]<= DIA_MAX) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }

                ////////////////////
                //QUINTA PREGUNTA//
                //////////////////

                if (contMal < MAL_MAX) {
                    do {
                        //Pregunta si es noia o noi
                        System.out.println("És noia(1) o noi(2)?");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            genere[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (genere[contador] == NOIA || genere[contador] == NOI) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                                if (genere[contador] == NOIA) {//Si el valor de array genere es igual a 1 ...
                                    genereString = "noia";
                                }
                                else if (genere[contador] == NOI) {//Si el valor de array genere es igual a 2 ...
                                    genereString = "noi";
                                }
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }


                ///////////////////
                //SEXTA PREGUNTA//
                /////////////////

                if (contMal < MAL_MAX) {
                    do {
                        System.out.println("En quina categoria competirà el participant?");
                        System.out.println("Infantil (1)");
                        System.out.println("Junior (2)");
                        System.out.println("Senior (3)");
                        //Pregunta per categoria
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            categoria[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (categoria[contador] >= INF && categoria[contador] <= SEN) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }

                /////////////////////
                //SEPTIMA PREGUNTA//
                ///////////////////

                if (contMal < MAL_MAX) {
                    do {
                        //Pregunta si es noia o noi
                        System.out.println("Quina és la puntuació del participant(2-30)?");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            puntuacio[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (puntuacio[contador] >= PUNT_MIN && puntuacio[contador] <= PUNT_MAX) {//si compleix amb les condicions bàsiques...
                                totOK = true; //Totes les respostes fins ara han sigut correctes.
                                respOK = true;//la resposta es correcte
                                contador++;//Augmentem una posició a les array.
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }


                ////////////////
                //TOT ESTÁ OK//
                //////////////



                if (totOK) {
                    System.out.println("Vols inscriure altre participant? 1:Si / 2:no");
                    do {
                        tipOK = teclado.hasNextInt();//es tipus int?
                        if (tipOK) { //si es tipus int ...
                            respRepeat = teclado.nextInt(); //assigna el valor introduït a aquesta variable.
                            teclado.nextLine(); //Neteja memòria buffer
                            if (respRepeat == RESP_SI || respRepeat == RESP_NO) {//si respRepeat es igual a 1 o 2...
                                respOK = true;//La resposta es l'esperada i sortira del bucle de la pregunta
                                if (respRepeat == RESP_SI) { // si respRepeat es igual a 1 ...
                                    repeat = true; //torna a inscriure altre usuari
                                    contRegistre++; //Augmenta aquest comtador, vol dir que hi ha altre participant
                                }
                                else if (respRepeat == RESP_NO) { // ales hores si respRepeat es igual a 2 ...
                                    repeat = false; //S'acabat el registre, no es vol registrar més usuaris.
                                }
                            }
                            else {
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                                respOK = false;//la resposta no es l'esperada i torna a executar el bucle de la pregunta
                            }
                        }
                        else {//si no es tipus int ...
                            teclado.nextLine();//Neteja memòria buffer.
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX);//mentre respostaOK sigui false ...
                }

                ///////////////////////
                //RESUM DE LES DADES//
                /////////////////////


                if (totOK && !repeat) { //si totOk es true i repeat es false ...
                    System.out.println("·······································");
                    System.out.println("         RESUM DE LES DADES");
                    System.out.println("Hi han " +contRegistre +" participants en aquest registre");
                    for (int x = 0; x < contador; x++) { /**utilitza x com a comptador per el control de mostrar totes les dades
                     * si x es mes petit que el contador dels registrats ...
                     * Cada volta augmenta el contador global x...
                     */
                        switch (genere[x]) {//evaluem el valor de la array
                            case NOIA: //en aquest cas..
                                genereString = S_NOIA; //modifica el valor d'aquesta variable per un valor String
                                break;
                            case NOI:
                                genereString = S_NOI;
                                break;
                        }
                        switch (categoria[x]) { //evalua el valor de la array ...
                            case INF: //si es 1 ....
                                categoriaString = S_INF; //modifica el valor string
                                break;
                            case JUN://si es 2 ...
                                categoriaString = S_JUN;
                                break;
                            case SEN: //si es 3 ...
                                categoriaString = S_SEN;
                                break;
                        }
                        System.out.println("Les dades introduïdes són:");
                        System.out.println("ID"+"\t"+"data de naixement"+"\t"+"genere"+"\t"+"Categoria"+"\t"+"puntuació");
                        System.out.println(id[x] +"\t"+dia[x] +"/" +mes[x] +"/" +any[x] +"\t"+"\t"+genereString +"\t"+categoriaString +"\t"+"\t"+puntuacio[x]);
                        System.out.println("_____________________________________________________________________________");   
                    }
                }

                //////////////////////
                //ORDENAR LES DADES//
                ////////////////////

                if (totOK && !repeat) {
                    System.out.println("Vols ordenar les dades? 1:Si / 2:no");
                    do {
                        tipOK = teclado.hasNextInt();//es tipus int?
                        if (tipOK) { //si es tipus int ...
                            respOrdre = teclado.nextInt(); //assigna el valor introduït a aquesta variable.
                            teclado.nextLine(); //Neteja memòria buffer
                            if (respOrdre == RESP_SI || respOrdre == RESP_NO) {//si respRepeat es igual a 1 o 2...
                                respOK = true;//La resposta es l'esperada i sortira del bucle de la pregunta
                                if (respOrdre == RESP_SI) { // si respRepeat es igual a 1 ...
                                    for (int z = 0; z < contador - 1; z++) { //mentres el contador o sigui mes petit que conPunt -1...
                                        for (int y = z + 1; y < contador; y++) {//y es igual al contador x pero amb una posició per davant, mentre y sigui més petit que contador...
                                            if (puntuacio[z] < puntuacio[y]) { //si la posició x es més gran que la posició y ... (Per ordenar les dades.)
                                                //Ordena identificador
                                                auxId = id[z];
                                                id[z] = id[y];
                                                id[y] = auxId;
                                                
                                                //ordendar dates: any, mes, dia
                                                auxAny = any[z];
                                                any[z] = any[y];
                                                any[y] = auxAny;
                                                /////////////////
                                                auxMes = mes[z];
                                                mes[z] = mes[y];
                                                mes[y] = auxAny;
                                                /////////////////
                                                auxDia = dia[z];
                                                dia[z] = dia[y];
                                                dia[y] = auxDia;
                                                //ordenar genere
                                                auxGenere = genere[z];
                                                genere[z] = genere[y];
                                                genere[y] = auxGenere;
                                                
                                                //ordenar categoria
                                                auxCategoria = categoria[z];
                                                categoria[z] = categoria[y];
                                                categoria[y] = auxCategoria;
                                                
                                                //Ordenar Les dades per puntuació
                                                auxPunt = puntuacio[z];
                                                puntuacio[z] = puntuacio[y];
                                                puntuacio[y] = auxPunt;
                                            }
                                        }
                                    }
                                    //Mostrar les dades ordenades
                                    for (int x = 0; x < contador; x++) { /**utilitza x com a comptador per el control de mostrar totes les dades
                                     * si x es mes petit que el contador dels registrats ...
                                     * Cada volta augmenta el contador global x...
                                     */
                                        switch (genere[x]) {//evaluem el valor de la array
                                            case NOIA: //en aquest cas..
                                                genereString = S_NOIA; //modifica el valor d'aquesta variable
                                                break;
                                            case NOI:
                                                genereString = S_NOI;
                                                break;
                                        }
                                        switch (categoria[x]) { //evalua el valor de la array ...
                                            case INF: //si es 1 ....
                                                categoriaString = S_INF; //modifica el valor string
                                                break;
                                            case JUN://si es 2 ...
                                                categoriaString = S_JUN;
                                                break;
                                            case SEN: //si es 3 ...
                                                categoriaString = S_SEN;
                                                break;
                                        }
                                        System.out.println("Les dades ordenades són:");
                                        System.out.println("ID"+"\t"+"data de naixement"+"\t"+"genere"+"\t"+"Categoria"+"\t"+"puntuació");
                                        System.out.println(id[x] +"\t"+dia[x] +"/" +mes[x] +"/" +any[x] +"\t"+"\t"+genereString +"\t"+categoriaString +"\t"+"\t"+puntuacio[x]);
                                        System.out.println("_____________________________________________________________________________");   
                                    }
                                }
                                else if (respOrdre == RESP_NO) { // ales hores si respRepeat es igual a 2 ...
                                    respOK = true; //La resposta es correcta i surt del bucle
                                }
                            }
                            else {
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                                respOK = false;//la resposta no es l'esperada i torna a executar el bucle de la pregunta
                            }
                        }
                        else {//si no es tipus int ...
                            teclado.nextLine();//Neteja memòria buffer.
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX);//mentre respostaOK sigui false ...
                }    
            }
        } while (repeat);//mentre repeat sigui true...
        if (contMal >= MAL_MAX) {
            System.out.println("........................................................");
            System.out.println("________________________________________________________");
            System.out.println("Has executat malament el programa, torna-ho ha intentar.");
        }
    }
}
        int[] id = new int[USER_MAX]; //contindrá els identificadors creats per l'usuari, màxim 10 usuaris.
        int[] any = new int[USER_MAX]; //contindrá els anys creats per l'usuari, màxim 10 anys.
        int[] mes = new int[USER_MAX]; //contindrá els mesos creats per l'usuari, màxim 10 messos.
        int[] dia = new int[USER_MAX]; //contindrá els dies creats per l'usuari, màxim 10 dies.
        int[] genere = new int[USER_MAX]; //contindrá el genere de l'usuari, màxim 10 generes.
        int[] categoria = new int[USER_MAX]; //contindrá el genere de l'usuari, màxim 10 generes.
        int[] puntuacio = new int[USER_MAX]; //contindrá el genere de l'usuari, màxim 10 generes.
        int respRepeat; //la resposta de l'usuari, 1 o 0, repeteix o no
        int respOrdre; //la resposta de l'usuari, 1 o 0, repeteix o no
        int contMal = 0; //contador de respostes malament
        int contRegistre = 1; //contador per número de registrats.
        int auxPunt; //auxiliar per l'ordenació
        int auxId; //auxiliar per l'ordenació
        int auxAny; //auxiliar per l'ordenació
        int auxMes; //auxiliar per l'ordenació
        int auxGenere; //auxiliar per l'ordenació
        int auxCategoria; //auxiliar per l'ordenació
        int contador = 0; //contador de les posicions
        String genereString = null;
        String categoriaString = null;
        
        ////////////////////////////////
        //PREGUNTES I GESTIÓ D'ERRORS//
        //////////////////////////////
        do {
            if (totOK) { //si totes les respostes han sigut correctes
                totOK = false; //torna a deixar el valor per defecte  
                repeat = false; //torna a deixa el valor per defecte
                do {

                    /////////////////////
                    //PRIMERA PREGUNTA//
                    ///////////////////

                    System.out.println("Quin és el número identificatiu del participant? (1 - 2000)");
                    tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                    if (tipOK) { //si la resposta ha sigut tipus int...
                        id[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                        teclado.nextLine();//neteja memòria buffer
                        if (id[contador] >= ID_MIN && id[contador] <= ID_MAX) {//si compleix amb les condicions bàsiques...
                            respOK = true;//la resposta es correcte
                        }
                        else {
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;//la resposta no es correcte
                            System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                        }
                    }
                    else {
                        teclado.nextLine();//neteja memòria buffer
                        contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                        respOK = false;
                        System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                        System.out.println("_________________________________________________________________");
                    }
                } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...

                ////////////////////
                //SEGONA PREGUNTA//
                //////////////////

                if (contMal < MAL_MAX) {
                    do {
                        //Pregunta pel número identificatiu de l'inscriptor
                        System.out.println("Data de naixement");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        System.out.println("    any?: ");
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            any[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (any[contador] >= ANY_MIN && any[contador] <= ANY_MAX) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...
                }   


                /////////////////////
                //TERCERA PREGUNTA//    
                ///////////////////

                if (contMal < MAL_MAX) {
                    //Tercera pregunta...
                    do {
                        //Pregunta pel número identificatiu de l'inscriptor
                        System.out.println("    mes? (1-12): ");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            mes[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (mes[contador] >= MES_MIN && mes[contador] <= MES_MAX) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }


                ////////////////////
                //CUARTA PREGUNTA//
                //////////////////


                if (contMal < MAL_MAX) {
                    do {
                        //Pregunta pel número identificatiu de l'inscriptor
                        System.out.println("    dia? (1-30): ");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            dia[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (dia[contador] >= DIA_MIN && dia[contador]<= DIA_MAX) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }

                ////////////////////
                //QUINTA PREGUNTA//
                //////////////////

                if (contMal < MAL_MAX) {
                    do {
                        //Pregunta si es noia o noi
                        System.out.println("És noia(1) o noi(2)?");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            genere[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (genere[contador] == NOIA || genere[contador] == NOI) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                                if (genere[contador] == NOIA) {//Si el valor de array genere es igual a 1 ...
                                    genereString = "noia";
                                }
                                else if (genere[contador] == NOI) {//Si el valor de array genere es igual a 2 ...
                                    genereString = "noi";
                                }
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }


                ///////////////////
                //SEXTA PREGUNTA//
                /////////////////

                if (contMal < MAL_MAX) {
                    do {
                        System.out.println("En quina categoria competirà el participant?");
                        System.out.println("Infantil (1)");
                        System.out.println("Junior (2)");
                        System.out.println("Senior (3)");
                        //Pregunta per categoria
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            categoria[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (categoria[contador] >= INF && categoria[contador] <= SEN) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }

                /////////////////////
                //SEPTIMA PREGUNTA//
                ///////////////////

                if (contMal < MAL_MAX) {
                    do {
                        //Pregunta si es noia o noi
                        System.out.println("Quina és la puntuació del participant(2-30)?");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            puntuacio[contador] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (puntuacio[contador] >= PUNT_MIN && puntuacio[contador] <= PUNT_MAX) {//si compleix amb les condicions bàsiques...
                                totOK = true; //Totes les respostes fins ara han sigut correctes.
                                respOK = true;//la resposta es correcte
                                contador++;//Augmentem una posició a les array.
                            }
                            else {
                                contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                                respOK = false;//la resposta no es correcte
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                            }
                        }
                        else {
                            teclado.nextLine();//neteja memòria buffer
                            contMal++;//la resposta ha sigut incorrecte i augmenta el contador...
                            respOK = false;
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX); //torna a executar si la variable es false...  
                }


                ////////////////
                //TOT ESTÁ OK//
                //////////////



                if (totOK) {
                    System.out.println("Vols inscriure altre participant? 1:Si / 2:no");
                    do {
                        tipOK = teclado.hasNextInt();//es tipus int?
                        if (tipOK) { //si es tipus int ...
                            respRepeat = teclado.nextInt(); //assigna el valor introduït a aquesta variable.
                            teclado.nextLine(); //Neteja memòria buffer
                            if (respRepeat == RESP_SI || respRepeat == RESP_NO) {//si respRepeat es igual a 1 o 2...
                                respOK = true;//La resposta es l'esperada i sortira del bucle de la pregunta
                                if (respRepeat == RESP_SI) { // si respRepeat es igual a 1 ...
                                    repeat = true; //torna a inscriure altre usuari
                                    contRegistre++; //Augmenta aquest comtador, vol dir que hi ha altre participant
                                }
                                else if (respRepeat == RESP_NO) { // ales hores si respRepeat es igual a 2 ...
                                    repeat = false; //S'acabat el registre, no es vol registrar més usuaris.
                                }
                            }
                            else {
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                                respOK = false;//la resposta no es l'esperada i torna a executar el bucle de la pregunta
                            }
                        }
                        else {//si no es tipus int ...
                            teclado.nextLine();//Neteja memòria buffer.
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX);//mentre respostaOK sigui false ...
                }

                ///////////////////////
                //RESUM DE LES DADES//
                /////////////////////


                if (totOK && !repeat) { //si totOk es true i repeat es false ...
                    System.out.println("·······································");
                    System.out.println("         RESUM DE LES DADES");
                    System.out.println("Hi han " +contRegistre +" participants en aquest registre");
                    for (int x = 0; x < contador; x++) { /**utilitza x com a comptador per el control de mostrar totes les dades
                     * si x es mes petit que el contador dels registrats ...
                     * Cada volta augmenta el contador global x...
                     */
                        switch (genere[x]) {//evaluem el valor de la array
                            case NOIA: //en aquest cas..
                                genereString = S_NOIA; //modifica el valor d'aquesta variable
                                break;
                            case NOI:
                                genereString = S_NOI;
                                break;
                        }
                        switch (categoria[x]) { //evalua el valor de la array ...
                            case INF: //si es 1 ....
                                categoriaString = S_INF; //modifica el valor string
                                break;
                            case JUN://si es 2 ...
                                categoriaString = S_JUN;
                                break;
                            case SEN: //si es 3 ...
                                categoriaString = S_SEN;
                                break;
                        }
                        System.out.println("Les dades introduïdes són:");
                        System.out.println("ID"+"\t"+"data de naixement"+"\t"+"genere"+"\t"+"Categoria"+"\t"+"puntuació");
                        System.out.println(id[x] +"\t"+dia[x] +"/" +mes[x] +"/" +any[x] +"\t"+"\t"+genereString +"\t"+categoriaString +"\t"+"\t"+puntuacio[x]);
                        System.out.println("_____________________________________________________________________________");   
                    }
                }

                //////////////////////
                //ORDENAR LES DADES//
                ////////////////////

                if (totOK && !repeat) {
                    System.out.println("Vols ordenar les dades? 1:Si / 2:no");
                    do {
                        tipOK = teclado.hasNextInt();//es tipus int?
                        if (tipOK) { //si es tipus int ...
                            respOrdre = teclado.nextInt(); //assigna el valor introduït a aquesta variable.
                            teclado.nextLine(); //Neteja memòria buffer
                            if (respOrdre == RESP_SI || respOrdre == RESP_NO) {//si respRepeat es igual a 1 o 2...
                                respOK = true;//La resposta es l'esperada i sortira del bucle de la pregunta
                                if (respOrdre == RESP_SI) { // si respRepeat es igual a 1 ...
                                    for (int z = 0; z < contador - 1; z++) { //mentres el contador o sigui mes petit que conPunt -1...
                                        for (int y = z + 1; y < contador; y++) {//y es igual al contador x pero amb una posició per davant, mentre y sigui més petit que contador...
                                            if (puntuacio[z] < puntuacio[y]) { //si la posició x es més gran que la posició y
                                                //Ordena identificador
                                                
                                                
                                                //ordendar dates: any, mes, dia
                                                
                                                //ordenar genere
                                                
                                                //ordenar categoria
                                                
                                                
                                                //Ordenar Les dades per puntuació
                                                auxPunt = puntuacio[z];
                                                puntuacio[z] = puntuacio[y];
                                                puntuacio[y] = auxPunt;
                                            }
                                        }
                                    }
                                    //Mostrar les dades ordenades
                                    for (int x = 0; x < contador; x++) { /**utilitza x com a comptador per el control de mostrar totes les dades
                                     * si x es mes petit que el contador dels registrats ...
                                     * Cada volta augmenta el contador global x...
                                     */
                                        switch (genere[x]) {//evaluem el valor de la array
                                            case NOIA: //en aquest cas..
                                                genereString = S_NOIA; //modifica el valor d'aquesta variable
                                                break;
                                            case NOI:
                                                genereString = S_NOI;
                                                break;
                                        }
                                        switch (categoria[x]) { //evalua el valor de la array ...
                                            case INF: //si es 1 ....
                                                categoriaString = S_INF; //modifica el valor string
                                                break;
                                            case JUN://si es 2 ...
                                                categoriaString = S_JUN;
                                                break;
                                            case SEN: //si es 3 ...
                                                categoriaString = S_SEN;
                                                break;
                                        }
                                        System.out.println("Les dades ordenades són:");
                                        System.out.println("ID"+"\t"+"data de naixement"+"\t"+"genere"+"\t"+"Categoria"+"\t"+"puntuació");
                                        System.out.println(id[x] +"\t"+dia[x] +"/" +mes[x] +"/" +any[x] +"\t"+"\t"+genereString +"\t"+categoriaString +"\t"+"\t"+puntuacio[x]);
                                        System.out.println("_____________________________________________________________________________");   
                                    }
                                }
                                else if (respOrdre == RESP_NO) { // ales hores si respRepeat es igual a 2 ...
                                    respOK = true; //La resposta es correcta i surt del bucle
                                }
                            }
                            else {
                                System.out.println("La resposta no es correcte, torna a respondre la pregunta");
                                respOK = false;//la resposta no es l'esperada i torna a executar el bucle de la pregunta
                            }
                        }
                        else {//si no es tipus int ...
                            teclado.nextLine();//Neteja memòria buffer.
                            System.out.println("El tipus de dada no es correcte, contesta amb les dades demanades");
                            System.out.println("_________________________________________________________________");
                        }
                    } while (!respOK && contMal < MAL_MAX);//mentre respostaOK sigui false ...
                }    
            }
        } while (repeat);//mentre repeat sigui true...
        if (contMal >= MAL_MAX) {
            System.out.println("........................................................");
            System.out.println("________________________________________________________");
            System.out.println("Has executat malament el programa, torna-ho ha intentar.");
        }
    }
}
