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
 * @author Giuseppe Calabrese
 */

public class Card {

  /**
   * @param pin il codice pin della carta
   * @param IBAN il codice IBAN della carta
   */
  private final String IBAN; // 27 cifre totali
  private final int pin;

  public Card(int pinCarta, String IBAN) throws Exception {
    pin = pinCarta;
    if(IBAN.length() <= 26 || IBAN.length() >= 28) {
      System.out.println();
      throw new Exception("Le cifre alfanumeriche dell'IBAN devono essere corrispondenti a 27");
    }
    this.IBAN = IBAN;
  }

  public int getPin() { return pin; }
  public String getIBAN() { return IBAN; }
}

