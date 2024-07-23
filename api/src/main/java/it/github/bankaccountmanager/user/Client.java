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

/**
 * @author Giuseppe Calabrese
 */

package it.github.bankaccountmanager.user;

public class Client {

  /**
   * @param nome il nome del cliente
   * @param cognome il cognome del cliente
   * @param sesso il sesso del cliente
   * @param annoDiNascita l'anno di nascita del cliente
   * @param carta la carta associata al cliente
   */
  private String nome;
  private String cognome;
  private char sesso;
  private final int annoDiNascita;

  public Client(String nome, String cognome, char sesso, int annoDiNascita, Card carta) throws Exception{
    if(nome == "") {
      System.out.println();
      throw new Exception("Impossibile memorizzare Clienti con nomi vuoti!");
    }
    else if(nome.length() <= 1) {
      System.out.println();
      throw new Exception("Impossibile memorizzare Clienti con nomi corti di 1 carattere!");
    }
    this.nome = nome;
    if(cognome == "") {
      System.out.println();
      throw new Exception("Impossibile creare Clienti con cognomi vuoti!");
    }
    else if(cognome.length() <= 1) {
      System.out.println();
      throw new Exception("Impossibile memorizzare Clienti con cognomi corti di 1 carattere!");
    }
    this.cognome = cognome;
    if(sesso == '\0') { /* '\0' campo vuoto di tipo char */
      System.out.println();
      throw new Exception("Il campo sesso non può essere privo di alcun valore!");
    }
    else if(sesso != 'M' && sesso != 'F') {
      System.out.println();
      throw new Exception("Impossibile impostare il sesso diverso da M o F");
    }
    this.sesso = sesso;
    if(annoDiNascita <= 18) {
      System.out.println();
      throw new Exception("Impossibile impostare una data di nascita minore di 18!");
    }
    else if(annoDiNascita < 1909) {
      System.out.println();
      throw new Exception("Impossiible impostare una data di nascita minore di 1909!");
    }
    this.annoDiNascita = annoDiNascita;
  }

  public String getNome(){return nome;}

  public String getCognome() {return cognome;}

  public char getSesso() {return sesso;}

  public int getData() {return annoDiNascita;}

}
