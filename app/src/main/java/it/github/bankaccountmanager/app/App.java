/*
 * MIT License
 *
 * Copyright (c) 2024 Giuseppe Calabrese
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.github.bankaccountmanager.app;

import it.github.bankaccountmanager.user.Card;
import it.github.bankaccountmanager.user.Client;
import it.github.bankaccountmanager.bank.BankAccount;
import it.github.bankaccountmanager.utilities.Style.Colors;
import it.github.bankaccountmanager.utilities.Time.DateFormat;
import it.github.bankaccountmanager.utilities.Time.SimpleDateFormatImpl;
import java.util.Scanner;

public class App {
  static int pinInserito;
  static int tentativi = 3;
  static Client[] numclienti = new Client[150];
  static BankAccount[] numConto = new BankAccount[150];
  static Card[] numCarte = new Card[372];


  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    FormatDate();

    try {

      // definisco le carte associate ai clienti

      numCarte[0] = new Card(270800, "ITDHB47329N2BG6HSU2D8803MN4");
      numCarte[1] = new Card(210195, "IT372GSVXNZHEIv83nv903OEW22");
      numCarte[2] = new Card(110145, "IT873HDBC63D39D4N30940LZMXH");
      numCarte[3] = new Card(180773, "ITUWB327X9GXNVKDOG830VMS5W2");
      numCarte[4] = new Card(134256, "HD729DBNC6292BDJ293BGF4DI29");
      numCarte[5] = new Card(438761, "IT8328FJ4NV9IABXNMCLOEP3IVN");

      // definisco i clienti

      numclienti[0] = new Client("Giuseppe", "Calabrese", 'M', 2000, numCarte[0]);
      numclienti[1] = new Client("Valentina", "Fede", 'F', 1995, numCarte[1]);
      numclienti[2] = new Client("Gabriele", "Rossi", 'M', 2000, numCarte[2]);
      numclienti[3] = new Client("Vincenza", "Pisciotta", 'F', 1973, numCarte[3]);
      numclienti[4] = new Client("Gabriele", "Calabrese", 'M', 2006, numCarte[4]);
      numclienti[5] = new Client("Nicholas", "Fiorani", 'M', 2003, numCarte[5]);

      // definisco i conto correnti associati ai clienti

      numConto[0] =  new BankAccount(500, numclienti[0], 1092.54);
      numConto[1] =  new BankAccount(762, numclienti[1], 5000);
      numConto[2] =  new BankAccount(950, numclienti[2], 1479.21);
      numConto[3] =  new BankAccount(400, numclienti[3], 450.23);
      numConto[4] =  new BankAccount(5000, numclienti[4], 10.456);
      numConto[5] =  new BankAccount(5000, numclienti[5], 10.456);
      //numConto[6] = new ContoCorrente(-150, numclienti[6], 2451.56);


      // setto il colore per la visualizzazione del pin

      System.out.print(Colors.YELLOW + "Pin: " + Colors.RESET);

      int ciao = 0;

      while(true){
        ciao = keyboard.nextInt();
        break;
      }




      getPin(keyboard);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void ristampaMenu() {
    System.out.println();
    System.out.println("Premere 1 per visualizzare il conto.");
    System.out.println("Premere 2 per depositare contanti.");
    System.out.println("Premere 3 per prelevare contanti.");
    System.out.println("Premere 4 per visualizzare il saldo più alto registrato");
    System.out.println("Premere 5 per visualizzare i propri dati anagrafici.");
    System.out.println("Premere 0 per terminare la procedura");
  }

  public static boolean saluto() {
    Scanner keyboard = new Scanner(System.in);
    System.out.println();
    System.out.println("Arrivederci!");
    boolean bye = false;
    keyboard.close();
    return bye;
  }
  public static int altreOperazioni(int output) {
    // utilizzata per sopprimere un warning specifico generato dal compilatore
    //riguardo alla mancata chiusura di risorse
    @SuppressWarnings("resource")
    Scanner keyboard = new Scanner(System.in);
    System.out.println();
    System.out.println("Digita un numero compreso tra 0 e 4");
    output = keyboard.nextInt();
    return output;
  }
  public static void rispostaPositive() {
    System.out.println();
    System.out.println("Quale altra operazione vuoi effettuare?");
    System.out.println();
  }

  public static void FormatDate() {

    System.out.println("Good morning, welcome to the UniBanca banking system!");

    DateFormat dateFormat = new SimpleDateFormatImpl();

    String TimeFormatted = dateFormat.getCurrentTime();
    System.out.println("Current Time: " + TimeFormatted);

    String FormattedDate = dateFormat.getCurrentDate();
    System.out.println("Current Date: " + FormattedDate);
  }

  public static int dateAnagrafe(int indice) {
    System.out.println("Nome: " + numclienti[indice].getNome());
    System.out.println("Cognome: " + numclienti[indice].getCognome());
    System.out.println("Sesso: " + numclienti[indice].getSesso());
    System.out.println("Data: " + numclienti[indice].getData());
    return indice;
  }

  public static void getPin(Scanner keyboard) {
    while(true) {
      for(int i = 0; i < numclienti.length; i++) {
        if(pinInserito == numCarte[i].pin()) {
          System.out.println();
          System.out.println(Colors.GREEN + "Accesso effettuato!" + Colors.RESET);
          System.out.println("Benvenuto! " + numclienti[i].getNome() + " " + numclienti[i].getCognome());

          ristampaMenu();

          int input = keyboard.nextInt();

          boolean flag = true;   // vera fino a quando viene richiesta un'operazione
          String risposta = "";  // catturo la risposta dell'utente

          do {

            switch (input) {

              case 0:
                System.out.println();
                System.out.println("Grazie per essere stato con noi!");
                System.out.println("A presto!");
                flag = false;
                break;

              case 1:
                System.out.println();
                System.out.println("Saldo corrente: " + numConto[i].get_saldo() + " €");
                System.out.println();
                System.out.println("Desideri effettuare altre operazioni?");
                risposta = keyboard.next();
                if(risposta.equals("no")) {
                  saluto();
                  return;
                }

                else {
                  risposta.equals("si");
                  rispostaPositive();
                  System.out.println("Se vuoi visualizare di nuovo il menu digita 'ristampa', altrimenti digita 'operazioni'");
                  risposta = keyboard.next();
                  if(risposta.equals("ristampa")) {
                    ristampaMenu();

                    System.out.println();
                    System.out.println();
                    System.out.println("Desideri effettuare altre operazioni?");
                    risposta = keyboard.next();
                    if(risposta.equals("no")) {
                      saluto();
                      return;
                    }
                    else {
                      risposta.equals("si");
                      rispostaPositive();
                      input = keyboard.nextInt();

                    }

                  }
                  else if (risposta.equals("operazioni")){
                    input = altreOperazioni(input);
                  }

                }
                break;

              case 2:
                System.out.println();
                System.out.println("Quanto desideri depositare?");
                int depositoCredito = keyboard.nextInt();
                System.out.println();
                System.out.println("Deposito credito: " + numConto[i].set_deposita(depositoCredito) + " €");
                System.out.println("Saldo corrente: " + numConto[i].depositoTOT() + " €");
                System.out.println();
                System.out.println("Desideri effettuare altre operazioni?");
                risposta = keyboard.next();
                if(risposta.equals("no")) {
                  saluto();
                  return;
                }
                else {
                  risposta.equals("si");
                  rispostaPositive();
                  System.out.println("Se vuoi visualizare di nuovo il menu digita 'ristampa', altrimenti digita 'operazioni'");
                  risposta = keyboard.next();
                  if(risposta.equals("ristampa")) {
                    ristampaMenu();

                    System.out.println();
                    System.out.println();
                    System.out.println("Desideri effettuare altre operazioni?");
                    risposta = keyboard.next();
                    if(risposta.equals("no")) {
                      saluto();
                      return;
                    }
                    else {
                      risposta.equals("si");
                      rispostaPositive();
                      input = keyboard.nextInt();

                    }

                  }
                  else if (risposta.equals("operazioni")){
                    input = altreOperazioni(input);
                  }
                }

                break;

              case 3:
                System.out.println();
                System.out.println("Quanto desideri prelevare?");
                int prelievoCredito = keyboard.nextInt();
                System.out.println();
                System.out.println("Prelievo di: " + numConto[i].set_prelievo(prelievoCredito) + " €");
                System.out.println("Saldo contabile: " + numConto[i].prelievo_Aggiornato() + " €");
                System.out.println();
                System.out.println("Desideri effettuare altre operazioni?");
                risposta = keyboard.next();
                if(risposta.equals("no")) {
                  saluto();
                  return;
                }
                else {
                  risposta.equals("si");
                  rispostaPositive();
                  System.out.println("Se vuoi visualizare di nuovo il menu digita 'ristampa', altrimenti digita 'operazioni'");
                  risposta = keyboard.next();
                  if(risposta.equals("ristampa")) {
                    ristampaMenu();

                    System.out.println();
                    System.out.println();
                    System.out.println("Desideri effettuare altre operazioni?");
                    risposta = keyboard.next();
                    if(risposta.equals("no")) {
                      saluto();
                      return;
                    }
                    else {
                      risposta.equals("si");
                      rispostaPositive();
                      input = keyboard.nextInt();

                    }

                  }
                  else if (risposta.equals("operazioni")){
                    input = altreOperazioni(input);
                  }
                }
                break;

              case 4:
                System.out.println();
                System.out.println("Saldo più alto: " + numConto[i].get_saldo_massimo() + " €");
                System.out.println();
                System.out.println("Desideri effettuare altre operazioni?");
                risposta = keyboard.next();
                if(risposta.equals("no")) {
                  saluto();
                  return;
                }
                else {
                  risposta.equals("si");
                  rispostaPositive();
                  System.out.println("Se vuoi visualizare di nuovo il menu digita 'ristampa', altrimenti digita 'operazioni'");
                  risposta = keyboard.next();
                  if(risposta.equals("ristampa")) {
                    ristampaMenu();

                    System.out.println();
                    System.out.println();
                    System.out.println("Desideri effettuare altre operazioni?");
                    risposta = keyboard.next();
                    if(risposta.equals("no")) {
                      saluto();
                      return;
                    }
                    else {
                      risposta.equals("si");
                      rispostaPositive();
                      input = keyboard.nextInt();

                    }

                  }
                  else if (risposta.equals("operazioni")){
                    input = altreOperazioni(input);
                  }
                }
                break;

              case 5:
                System.out.println();
                dateAnagrafe(i);
                System.out.println();
                System.out.println("Desideri effettuare altre operazioni?");
                risposta = keyboard.next();
                if(risposta.equals("no")) {
                  saluto();
                  return;
                }
                else {
                  risposta.equals("si");
                  rispostaPositive();
                  System.out.println("Se vuoi visualizare di nuovo il menu digita 'ristampa', altrimenti"
                    + "digiita  'operazioni'");
                  risposta = keyboard.next();
                  if(risposta.equals("ristampa")) {
                    ristampaMenu();

                    System.out.println();
                    System.out.println();
                    System.out.println("Desideri effettuare altre operazioni?");
                    risposta = keyboard.next();
                    if(risposta.equals("no")) {
                      saluto();
                      return;
                    }
                    else {
                      risposta.equals("si");
                      rispostaPositive();
                      input = keyboard.nextInt();

                    }

                  }
                  else if (risposta.equals("operazioni")){
                    input = altreOperazioni(input);
                  }
                }
                break;

              default:
                System.out.println();
                System.out.println("Operazione non andata a buon fine.");
                System.out.println("Digitare un numero compreso tra 0 e 5.");
                input = keyboard.nextInt();
                if(input == 0) {
                  System.out.println("Arrivederci!");
                  flag = false;
                }

            }

          } while(flag);

          if(input == 0) return;
        }
        else {
          System.out.println();
          if(tentativi == 0) {
            System.out.println();
            // Colors
            System.out.println(Colors.RED_BRIGHT + "Tentativi falliti!" + "\n" + "contattare il sistema"
              + "bancario per "
              + "delucidazioni" + Colors.RESET);
            return;
          }
          System.out.println("Inserire nuovamente il pin." + "\n" + "Tentativi rimasti: " + tentativi--);
          pinInserito = keyboard.nextInt();
        }
      }
    }
  }

}
