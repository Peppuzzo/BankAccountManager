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

package it.github.bankaccountmanager.user;

/**
 * Questa classe ha lo scopo principale di gestire i dati del client.
 *
 * @author Giuseppe Calabrese
 */

public class Client {

  private final String nome;
  private final String cognome;
  private final char sesso;
  private final int annoDiNascita;
  private final Card carta;

  public Client(String nome, String cognome, char sesso, int annoDiNascita, Card carta) throws InvalidClientException{
    validateFieldsClient(nome, cognome, sesso, annoDiNascita, carta);
    this.nome = nome;
    this.cognome = cognome;
    this.sesso = sesso;
    this.annoDiNascita = annoDiNascita;
    this.carta = carta;
  }

  public String getNome() {
    return this.nome;
  }

  public String getCognome() {
    return this.cognome;
  }

  public char getSesso() {
    return this.sesso;
  }

  public int getData() {
    return this.annoDiNascita;
  }

  public Card getCard(){
    return this.carta;
  }

  /**
   * Questo metodo ha il semplice scopo di verificare l'integrità dei
   * dati passati al costruttore.
   *
   * @param nome del client da convalidare
   * @param cognome del client da convalidare
   * @param sesso del client da convalidare
   * @param annoDiNascita del client da convalidare
   * @param carta del client da convalidare
   */
  public static void validateFieldsClient(String nome, String cognome, char sesso,
                                          int annoDiNascita, Card carta){
    if(nome == null || nome.length() < 2){
      throw new InvalidClientException("Nome del client non valido.");
    }
    if(cognome == null || cognome.length() < 2){
      throw new InvalidClientException("Cognome del client non valido.");
    }
    if(sesso != 'M' && sesso != 'F'){
      throw new InvalidClientException("Digitare" + "'M' " + "o" + "'F' " +
        "per il sesso corretto.");
    }
    if (annoDiNascita < 1930 || annoDiNascita > 2005) {
      throw new InvalidClientException("L'anno di nascita deve essere tra 1930 e 2005.");
    }
    if(carta == null) {
      throw new InvalidClientException("Impossibile associare la carta al client.");
    }
  }

  @Override
  public String toString(){
    return "Nome: " + getNome() + "\n" +
           "Cognome: " + getCognome() + "\n" +
           "Sesso: " + getSesso() + "\n" +
           "Data di Nascita: " + getData();
  }
}
