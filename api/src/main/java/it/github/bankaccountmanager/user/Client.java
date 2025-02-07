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

import java.util.Objects;

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
  private int annoDiNascita;

  public Client(String nome, String cognome, char sesso, int annoDiNascita, Card carta) throws Exception{
    if(Objects.equals(nome, "") || nome.length() <= 1 || cognome.length() <= 1
      || sesso != 'M' && sesso != 'F' || !(annoDiNascita >= 1930 && annoDiNascita <= 2005)) {
      throw new Exception("Impossibile inizializzare campi per il client!");
    }
    this.nome = nome;
    this.cognome = cognome;
    this.sesso = sesso;
    this.annoDiNascita = annoDiNascita;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public char getSesso() {
    return sesso;
  }

  public int getData() {
    return annoDiNascita;
  }

}
