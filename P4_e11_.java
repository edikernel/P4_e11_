/**
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
    private static final int POS_ID = 0; //valor de la posició que determina la posició que determina el sexe.
    private static final int POS_ANY = 1; //valor de la posició que determina la posició que determina el sexe.
    private static final int POS_MES = 2; //valor de la posició que determina la posició que determina el sexe.
    private static final int POS_DIA = 3; //valor de la posició que determina la posició que determina el sexe.
    private static final int POS_SEX = 4; //valor de la posició que determina la posició que determina el sexe.
    private static final int POS_CAT = 5; //valor de la posició que determina la posició de categoria
    private static final int POS_PUNT = 6; //valor de la posició que determina la posició de categoria
    private static final int COLUM = 7; //valor màxim de les columnes.
    public static void main(String[] args) {
        //////////////
        //VARIABLES//
        ////////////
        
        Scanner teclado = new Scanner(System.in); //variable per invocar l'eina de lectura de dades del teclat
        boolean repeat, tipOK, respOK, totOK;
        repeat = true;//valor inicial, repetició del programa?
        respOK = false;//la resposta es l'esperada?
        totOK = true;//tot el programa es OK.
        int registre[][] = new int [USER_MAX][COLUM]; //mesura de la array
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
        int contInf = 0; //contador per la categoria infantil
        int contJun = 0;//contador per la categoria junior
        int contSen = 0;//contador per la categoria senior
        String genereString = null; //contindra el string del genere
        String categoriaString = null; //contindra el string de la categoria
        
        ////////////////////////////////
        //PREGUNTES I GESTIÓ D'ERRORS//
        //////////////////////////////
    
        for (int i = 0; i < registre.length && repeat; i++) {//si i es més petit que la mesura de la array i repeat es true...
            if (totOK) { //si totes les respostes han sigut correctes
                totOK = false; //torna a deixar el valor per defecte  
                repeat = false; //torna a deixa el valor per defecte
                do {//fes..

                    /////////////////////
                    //PRIMERA PREGUNTA//
                    ///////////////////

                    System.out.println("Quin és el número identificatiu del participant? (1 - 2000)");
                    tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                    if (tipOK) { //si la resposta ha sigut tipus int...
                        registre[i][POS_ID] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                        teclado.nextLine();//neteja memòria buffer
                        if (registre[i][POS_ID] >= ID_MIN && registre[i][POS_ID] <= ID_MAX) {//si compleix amb les condicions bàsiques...
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

                if (contMal < MAL_MAX) { //si contador d'errades es més petit que les errades máximes...
                    do { //fes...
                        //Pregunta pel número identificatiu de l'inscriptor
                        System.out.println("Data de naixement");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        System.out.println("    any?: ");
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            registre[i][POS_ANY] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (registre[i][POS_ANY] >= ANY_MIN && registre[i][POS_ANY] <= ANY_MAX) {//si compleix amb les condicions bàsiques...
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

                if (contMal < MAL_MAX) { //si no ha arribat el máxim d'errades...
                    //Tercera pregunta...
                    do {
                        //Pregunta pel número identificatiu de l'inscriptor
                        System.out.println("    mes? (1-12): ");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            registre[i][POS_MES] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (registre[i][POS_MES] >= MES_MIN && registre[i][POS_MES] <= MES_MAX) {//si compleix amb les condicions bàsiques...
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
                        System.out.println("    dia? (1-31): ");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            registre[i][POS_DIA] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (registre[i][POS_DIA] >= DIA_MIN && registre[i][POS_DIA] <= DIA_MAX) {//si compleix amb les condicions bàsiques...
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

                if (contMal < MAL_MAX) { //si contador malament es més petit que el máxim d'errades...
                    do {
                        //Pregunta si es noia o noi
                        System.out.println("És noia(1) o noi(2)?");
                        //Pregunta per l'any, la resposta s'afegirá al costat de la pregunta
                        tipOK = teclado.hasNextInt(); //la resposta es del tipus int?
                        if (tipOK) { //si la resposta ha sigut tipus int...
                            registre[i][POS_SEX] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (registre[i][POS_SEX] == NOIA || registre[i][POS_SEX] == NOI) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                                if (registre[i][POS_SEX] == NOIA) {//Si el valor de array genere es igual a 1 ...
                                    genereString = "noia";
                                }
                                else if (registre[i][POS_SEX] == NOI) {//Si el valor de array genere es igual a 2 ...
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
                            registre[i][POS_CAT] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (registre[i][POS_CAT] >= INF && registre[i][POS_CAT] <= SEN) {//si compleix amb les condicions bàsiques...
                                respOK = true;//la resposta es correcte
                                switch (registre[i][POS_CAT]) { //evalua aquesta posició de la array
                                    //Depen del cas augmenta el contador de les categories
                                    case INF:
                                        contInf++;
                                        break;
                                    case JUN:
                                        contJun++;
                                        break;
                                    case SEN:
                                        contSen++;
                                        break;
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
                            registre[i][POS_PUNT] = teclado.nextInt();//guarda el valor en la posició corresponent de la array
                            teclado.nextLine();//neteja memòria buffer
                            if (registre[i][POS_PUNT] >= PUNT_MIN && registre[i][POS_PUNT] <= PUNT_MAX) {//si compleix amb les condicions bàsiques...
                                totOK = true; //Totes les respostes fins ara han sigut correctes.
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
                                    contRegistre++; //Augmenta aquest contador, vol dir que hi ha altre participant
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
                    for (int q = 0; q < contRegistre; q++) {

                        switch (registre[q][POS_SEX]) {//evaluem el valor de la array
                            case NOIA: //en aquest cas..
                                genereString = S_NOIA; //modifica el valor d'aquesta variable per un valor String
                                break;
                            case NOI:
                                genereString = S_NOI;
                                break;
                        }
                        switch (registre[q][POS_CAT]) { //evalua el valor de la array ...
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
                        System.out.println(registre[q][POS_ID]+"\t"+registre[q][POS_DIA]+"/"+registre[q][POS_MES]+"/"+registre[q][POS_ANY]+"\t"+"\t"+genereString +"\t"+categoriaString+"\t"+"\t"+registre[q][POS_PUNT]);
                        System.out.println("_____________________________________________________________________________");   
                    }
                }
            }

            //////////////////////
            //ORDENAR LES DADES//
            ////////////////////

            if (totOK && !repeat) {
                System.out.println("Vols ordenar les dades per puntuació? 1:Si / 2:no");
                do {
                    tipOK = teclado.hasNextInt();//es tipus int?
                    if (tipOK) { //si es tipus int ...
                        respOrdre = teclado.nextInt(); //assigna el valor introduït a aquesta variable.
                        teclado.nextLine(); //Neteja memòria buffer
                        if (respOrdre == RESP_SI || respOrdre == RESP_NO) {//si respRepeat es igual a 1 o 2...
                            respOK = true;//La resposta es l'esperada i sortira del bucle de la pregunta
                            if (respOrdre == RESP_SI) { // si respRepeat es igual a 1 ...
                                for (int z = 0; z < contRegistre; z++) { //mentres el contador o sigui mes petit que conPunt -1...
                                    for (int y = z + 1; y < contRegistre; y++) {//y es igual al contador x pero amb una posició per davant, mentre y sigui més petit que contador...    
                                        if (registre[z][POS_PUNT] < registre[y][POS_PUNT]) { //si la posició x es més gran que la posició y ... (Per ordenar les dades.)
                                            //Ordena identificador
                                            auxId = registre[z][POS_ID];
                                            registre[z][POS_ID] = registre[y][POS_ID];
                                            registre[y][POS_ID] = auxId;

                                            //ordendar dates: any, mes, dia
                                            auxAny = registre[z][POS_ANY];
                                            registre[z][POS_ANY] = registre[y][POS_ANY];
                                            registre[y][POS_ANY] = auxAny;
                                            /////////////////
                                            auxMes = registre[z][POS_MES];
                                            registre[z][POS_MES] = registre[y][POS_MES];
                                            registre[y][POS_MES] = auxMes;
                                            /////////////////
                                            auxDia = registre[z][POS_DIA];
                                            registre[z][POS_DIA] = registre[y][POS_DIA];
                                            registre[y][POS_DIA] = auxDia;
                                            //ordenar genere
                                            auxGenere = registre[z][POS_SEX];
                                            registre[z][POS_SEX] = registre[y][POS_SEX];
                                            registre[y][POS_SEX] = auxGenere;

                                            //ordenar categoria
                                            auxCategoria = registre[z][POS_CAT];
                                            registre[z][POS_CAT] = registre[y][POS_CAT];
                                            registre[y][POS_CAT] = auxCategoria;

                                            //Ordenar Les dades per puntuació
                                            auxPunt = registre[z][POS_PUNT];
                                            registre[z][POS_PUNT] = registre[y][POS_PUNT];
                                            registre[y][POS_PUNT] = auxPunt;
                                        }
                                    }
                                }
                                //Mostrar les dades ordenades
                                for (int z = 0; z < contRegistre; z++) {  //utilitza z com contador de files, mentre z sigui més petit que el total de registrats 
                                    switch (registre[z][POS_SEX]) {//evaluem el valor de la array
                                        case NOIA: //en aquest cas..
                                            genereString = S_NOIA; //modifica el valor d'aquesta variable
                                            break;
                                        case NOI:
                                            genereString = S_NOI;
                                            break;
                                    }
                                    switch (registre[z][POS_CAT]) { //evalua el valor de la array ...
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
                                    System.out.println("Les dades ordenades per puntuació són:");
                                    System.out.println("ID"+"\t"+"data de naixement"+"\t"+"genere"+"\t"+"Categoria"+"\t"+"puntuació");
                                    System.out.println(registre[z][POS_ID]+"\t"+registre[z][POS_DIA]+"/"+registre[z][POS_MES]+"/"+registre[z][POS_ANY]+"\t"+"\t"+genereString +"\t"+categoriaString +"\t"+"\t"+registre[z][POS_PUNT]);
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
            if (totOK && !repeat) { //SI tot a estat correcte i no es vol torna a executar el programa...
                ///////////////////////
                /////////////
                //Pregunta ordre categoria:
                System.out.println("");
                System.out.println("...................................................................");
                System.out.println("Vols ordenar les dades per categoria? 1:Si / 2:no");
                do {
                    tipOK = teclado.hasNextInt();//es tipus int?
                    if (tipOK) { //si es tipus int ...
                        respOrdre = teclado.nextInt(); //assigna el valor introduït a aquesta variable.
                        teclado.nextLine(); //Neteja memòria buffer
                        if (respOrdre == RESP_SI || respOrdre == RESP_NO) {//si respRepeat es igual a 1 o 2...
                            respOK = true;//La resposta es l'esperada i sortira del bucle de la pregunta
                            if (respOrdre == RESP_SI) { // si respRepeat es igual a 1 ...
                                for (int w = 0; w < contRegistre; w++) { //mentres el contador o sigui mes petit que conPunt -1...
                                    for (int y = w + 1; y < contRegistre; y++) {//y es igual al contador x pero amb una posició per davant, mentre y sigui més petit que contador...
                                        if (registre[w][POS_CAT] > registre[y][POS_CAT]) { //si la posició x es més gran que la posició y ... (Per ordenar les dades.)
                                            //Ordena identificador
                                            auxId = registre[w][POS_ID];
                                            registre[w][POS_ID] = registre[y][POS_ID];
                                            registre[y][POS_ID] = auxId;

                                            //ordendar dates: any, mes, dia
                                            auxAny = registre[w][POS_ANY];
                                            registre[w][POS_ANY] = registre[y][POS_ANY];
                                            registre[y][POS_ANY] = auxAny;
                                            /////////////////
                                            auxMes = registre[w][POS_MES];
                                            registre[w][POS_MES] = registre[y][POS_MES];
                                            registre[y][POS_MES] = auxMes;
                                            /////////////////
                                            auxDia = registre[w][POS_DIA];
                                            registre[w][POS_DIA] = registre[y][POS_DIA];
                                            registre[y][POS_DIA] = auxDia;
                                            //ordenar genere
                                            auxGenere = registre[w][POS_SEX];
                                            registre[w][POS_SEX] = registre[y][POS_SEX];
                                            registre[y][POS_SEX] = auxGenere;

                                            //ordenar categoria
                                            auxCategoria = registre[w][POS_CAT];
                                            registre[w][POS_CAT] = registre[y][POS_CAT];
                                            registre[y][POS_CAT] = auxCategoria;

                                            //Ordenar Les dades per puntuació
                                            auxPunt = registre[w][POS_PUNT];
                                            registre[w][POS_PUNT] = registre[y][POS_PUNT];
                                            registre[y][POS_PUNT] = auxPunt;
                                        }
                                    }
                                }
                                //Mostrar les dades ordenades
                                for (int w = 0; w < contRegistre; w++) { //utilitza w com a contador de files, si w és més petit que el número de registrats...
                                    switch (registre[w][POS_SEX]) {//evaluem el valor de la array
                                        case NOIA: //en aquest cas..
                                            genereString = S_NOIA; //modifica el valor d'aquesta variable, es tracta d'un string
                                            break;
                                        case NOI:
                                            genereString = S_NOI;
                                            break;
                                    }
                                    switch (registre[w][POS_CAT]) { //evalua el valor de la array ...
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
                                    System.out.println("");
                                    System.out.println("Les dades ordenades per categoria són:");
                                    System.out.println("");
                                    System.out.println("ID"+"\t"+"data de naixement"+"\t"+"genere"+"\t"+"Categoria"+"\t"+"puntuació");
                                    System.out.println(registre[w][POS_ID]+"\t"+registre[w][POS_DIA]+"/"+registre[w][POS_MES]+"/"+registre[w][POS_ANY]+"\t"+"\t"+genereString +"\t"+categoriaString +"\t"+"\t"+registre[w][POS_PUNT]);
                                    System.out.println("_____________________________________________________________________________");   
                                }
                                System.out.println("Total de registrats en la categoria infantil: " +contInf);
                                System.out.println("Total de registrats en la categoria junior: " +contJun);
                                System.out.println("Total de registrats en la categoria senior: " +contSen);
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
                } while (!respOK && contMal < MAL_MAX);//mentre respostaOK sigui false ..
                
            }
            
        }     
        if (contMal >= MAL_MAX) {
            System.out.println("........................................................");
            System.out.println("________________________________________________________");
            System.out.println("Has executat malament el programa, torna-ho ha intentar.");
        }
    }
}
