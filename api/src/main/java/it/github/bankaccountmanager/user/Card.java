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

/** this class is responsible for creating a card with a pin and an IBAN code.
 *
 * @author Giuseppe Calabrese
 */

public record Card(int pin, String IBAN) {

  public Card(int pin, String IBAN) {
    if(IBAN.length() != 27) {
      throw new IndexOutOfBoundsException("L'IBAN deve contenere esattamente 27 caratteri.");
    }
    if(!(pin >= 100000 && pin <= 999999)){
      throw new IndexOutOfBoundsException("Il pin deve essere di 6 cifre.");
    }
    this.IBAN = IBAN;
    this.pin = pin;
  }
}

