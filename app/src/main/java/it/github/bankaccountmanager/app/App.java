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

import it.github.bankaccountmanager.bank.BankAccount;
import it.github.bankaccountmanager.user.Card;
import it.github.bankaccountmanager.user.Client;
import it.github.bankaccountmanager.utilities.Style.Colors;
import it.github.bankaccountmanager.utilities.Time.DateFormat;
import it.github.bankaccountmanager.utilities.Time.SimpleDateFormatImpl;

import java.util.Scanner;

public class App {
  private static final int MAX_CLIENTI = 150;
  private static final int MAX_CARTE = 372;
  private static Client[] clienti = new Client[MAX_CLIENTI];
  private static BankAccount[] conti = new BankAccount[MAX_CLIENTI];
  private static Card[] carte = new Card[MAX_CARTE];
  private static int tentativi = 3;

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    mostraBenvenuto();
    setupClientiEConti();
    verificaAccesso(keyboard);
  }

  private static void mostraBenvenuto() {
    System.out.println("Good morning, welcome to the UniBanca banking system!");
    DateFormat dateFormat = new SimpleDateFormatImpl();
    System.out.println("Current Time: " + dateFormat.getCurrentTime());
    System.out.println("Current Date: " + dateFormat.getCurrentDate());
  }

  private static void setupClientiEConti() throws Exception {
    carte[0] = new Card(270800, "ITDHB47329N2BG6HSU2D8803MN4");
    clienti[0] = new Client("Giuseppe", "Calabrese", 'M', 2000, carte[0]);
    conti[0] = new BankAccount(500, clienti[0], 1092.54);
    carte[1] = new Card(123456, "ITDHB47329N2BG6HSU2D8803MN4");
    clienti[1] = new Client("Rodolfo", "Lavandino", 'M', 2000, carte[1]);
    conti[1] = new BankAccount(500, clienti[1], 1092.54);
    // Aggiungere altri clienti, carte e conti...
  }

  private static void verificaAccesso(Scanner keyboard) {
    System.out.print(Colors.YELLOW + "Inserisci il PIN: " + Colors.RESET);
    int pinInserito = keyboard.nextInt();

    for (int i = 0; i < clienti.length; i++) {
      if (clienti[i] != null && carte[i].pin() == pinInserito) {
        System.out.println(Colors.GREEN + "Accesso effettuato!" + Colors.RESET);
        System.out.println("Benvenuto " + clienti[i].getNome() + " " + clienti[i].getCognome());
        gestisciOperazione(keyboard, i);
        return;
      }
    }
    System.out.println(Colors.RED_BRIGHT + "PIN errato. Tentativi rimasti: " + --tentativi + Colors.RESET);
    if (tentativi > 0) {
      verificaAccesso(keyboard);
    } else {
      System.out.println("Blocco account. Contattare la banca.");
    }
  }

  private static void mostraMenu() {
    System.out.println("1. Visualizza il conto");
    System.out.println("2. Deposita contanti");
    System.out.println("3. Preleva contanti");
    System.out.println("4. Saldo massimo registrato");
    System.out.println("5. Informazioni Personali");
    System.out.println("0. Esci");
  }

  private static void gestisciOperazione(Scanner keyboard, int indice) {
    boolean attivo = true;
    while (attivo) {
      mostraMenu();
      int scelta = keyboard.nextInt();
      switch (scelta) {
        case 0 -> attivo = false;
        case 1 -> System.out.println("Saldo: " + conti[indice].get_saldo() + " €");
        case 2 -> processaDeposito(keyboard, indice);
        case 3 -> processaPrelievo(keyboard, indice);
        case 4 -> System.out.println("Saldo massimo: " + conti[indice].get_saldo_massimo() + " €");
        case 5 -> mostraDatiClient(indice);
        default -> System.out.println("Scelta non valida.");
      }
      if (scelta != 0) attivo = chiediConferma(keyboard);
    }
    System.out.println("Grazie per aver usato UniBanca. Arrivederci!");
  }

  private static void processaDeposito(Scanner keyboard, int indice) {
    System.out.println("Quanto desideri depositare?");
    int deposito = keyboard.nextInt();
    conti[indice].set_deposita(deposito);
    System.out.println("Nuovo saldo: " + conti[indice].get_saldo() + " €");
  }

  private static void processaPrelievo(Scanner keyboard, int indice) {
    System.out.println("Quanto desideri prelevare?");
    int prelievo = keyboard.nextInt();
    conti[indice].set_prelievo(prelievo);
    System.out.println("Nuovo saldo: " + conti[indice].get_saldo() + " €");
  }

  private static void mostraDatiClient(int indice) {
    System.out.println("Nome: " + clienti[indice].getNome());
    System.out.println("Cognome: " + clienti[indice].getCognome());
    System.out.println("Sesso: " + clienti[indice].getSesso());
    System.out.println("Anno di nascita: " + clienti[indice].getData());
    System.out.println("carta associata: " + clienti[indice].getCard());
  }

  private static boolean chiediConferma(Scanner keyboard) {
    System.out.println("Vuoi effettuare altre operazioni? (si/no)");
    return keyboard.next().equalsIgnoreCase("si");
  }
}
