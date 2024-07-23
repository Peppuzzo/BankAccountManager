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
 * @lastModified 25-01-2024 - Code fixing.
 */

/** this class is responsible for creating a card with a pin and an IBAN code. */

public class Card {

  /**
   * @param pin the pin code of the card
   * @param IBAN the IBAN code of the card
   * @throws Exception if lenght of IBAN is not 27
   *
   * The IBAN code of the card. Must be a string of 27 alphanumeric characters.
   */
  private final String IBAN;
  private final Pin pin;

  public Card(int pinCarta, String IBAN) throws InvalidIBANException {
    new IbanValidationImpl().validateIBAN(IBAN);
    this.IBAN = IBAN;
    this.pin = new Pin(pinCarta);
  }

  public int getPin() { return pin.pin(); }

}

